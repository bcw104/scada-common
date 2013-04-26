package com.ht.scada.common.data.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import oracle.kv.Key;
import redis.clients.jedis.BinaryJedis;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.Response;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPipeline;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.util.Hashing;
import redis.clients.util.Sharded;

import com.ht.scada.common.data.service.RealtimeDataService;

/**
 * @author 薄成文
 *
 */
public class RealtimeDataServiceImpl implements RealtimeDataService {
	//private JedisPool pool;
	private ShardedJedisPool pool;
	
	@PostConstruct
	public void init() throws Exception {
		JedisPoolConfig config =new JedisPoolConfig();//Jedis池配置
		config.setMaxActive(20);// 最大活动的对象个数
		config.setMaxIdle(1000 * 60);// 对象最大空闲时间
		config.setMaxWait(1000 * 10);// 获取对象时最大等待时间
		//config.setTestOnBorrow(true);
	          
//		pool = new JedisPool(config, "localhost");
		
		List<JedisShardInfo> jdsInfoList = new ArrayList<JedisShardInfo>(2);

		String hostA = "127.0.0.1";
		int portA = 6379;
		JedisShardInfo infoA = new JedisShardInfo(hostA, portA);
		// infoA.setPassword("redis.360buy");
		jdsInfoList.add(infoA);

		String hostB = "192.168.1.80";
		int portB = 6380;
		JedisShardInfo infoB = new JedisShardInfo(hostB, portB);
		// infoB.setPassword("redis.360buy");
		//jdsInfoList.add(infoB);

		pool = new ShardedJedisPool(config, jdsInfoList, Hashing.MURMUR_HASH,

		Sharded.DEFAULT_KEY_TAG_PATTERN);
	}
	
	public double[] getBatchNumValue(String code, String[] name) {
		ShardedJedis jedis = pool.getResource();
		double[] value = new double[name.length];
		try {
			ShardedJedisPipeline pipeline = jedis.pipelined();
			Response<String>[] response = new Response[name.length];
			for (int i = 0; i < name.length; i++) {
				response[i] = pipeline.get(Key.createKey(Arrays.asList(code, name[i])).toString());
			}
			pipeline.sync();
			
			for (int i = 0; i < value.length; i++) {
				Response<String> resp = response[i];
				String s = resp.get();
				if ( s != null) {
					value[i] = Double.longBitsToDouble(Long.parseLong(s, 16));
				}
			}
		} finally {
		  pool.returnResource(jedis);
		}
		return value;
	}
	
	public double getNumValue(String code, String name) {
		ShardedJedis jedis = pool.getResource();
		double value = 0;
		try {
			String readBuffer = jedis.get(Key.createKey(Arrays.asList(code, name)).toString());
			if (readBuffer != null) {
				//value = byteArrayToDouble(readBuffer);
				value = Double.longBitsToDouble(Long.parseLong(readBuffer, 16));
			}
		} finally {
		  pool.returnResource(jedis);
		}
		return value;
	}
	
	public void putBatchValue(String code, String[] name, String[] value) {
		ShardedJedis jedis = pool.getResource();
		if (name.length != value.length) {
			throw new IllegalArgumentException("name数量与value数量不匹配");
		}
		try {
			ShardedJedisPipeline pipeline = jedis.pipelined();
			for (int i = 0; i < name.length; i++) {
				pipeline.set(Key.createKey(Arrays.asList(code, name[i])).toString(), value[i]);
			}
			pipeline.sync();
		} finally {
		  pool.returnResource(jedis);
		}
	}
	
	@Override
	public void putBatchValue(Map<String, String> kvMap) {
		ShardedJedis jedis = pool.getResource();
		try {
			ShardedJedisPipeline pipeline = jedis.pipelined();
			for (Entry<String, String> entry : kvMap.entrySet()) {
				pipeline.set(entry.getKey(), entry.getValue());
			}
			pipeline.sync();
		} finally {
		  pool.returnResource(jedis);
		}
	}

	public void putBatchValue(String code, String[] name, double[] value) {
		ShardedJedis jedis = pool.getResource();
		if (name.length != value.length) {
			throw new IllegalArgumentException("name数量与value数量不匹配");
		}
		try {
			ShardedJedisPipeline pipeline = jedis.pipelined();
			for (int i = 0; i < name.length; i++) {
				pipeline.set(Key.createKey(Arrays.asList(code, name[i])).toString(), Long.toHexString(Double.doubleToLongBits(value[i])));
			}
			pipeline.sync();
		} finally {
		  pool.returnResource(jedis);
		}
	}
	
	public void putValue(String code, String name, double value) {
		ShardedJedis jedis = pool.getResource();
		try {
			jedis.set(Key.createKey(Arrays.asList(code, name)).toString(), Long.toHexString(Double.doubleToLongBits(value)));
		} finally {
		  pool.returnResource(jedis);
		}
	}
	
	/**
	 * @param readBuffer
	 * @return
	 */
	private double byteArrayToDouble(byte[] readBuffer) {
		double value;
		long v = (((long)readBuffer[0] << 56) +
		    ((long)(readBuffer[1] & 255) << 48) +
		    ((long)(readBuffer[2] & 255) << 40) +
		    ((long)(readBuffer[3] & 255) << 32) +
		    ((long)(readBuffer[4] & 255) << 24) +
		    ((readBuffer[5] & 255) << 16) +
		    ((readBuffer[6] & 255) <<  8) +
		    ((readBuffer[7] & 255) <<  0));
		value = Double.longBitsToDouble(v);
		return value;
	}

	/**
	 * @param value
	 * @return
	 */
	private byte[] doubleToByteArray(double value) {
		byte[] writeBuffer = new byte[8];
		long v = Double.doubleToLongBits(value);
		writeBuffer[0] = (byte)(v >>> 56);
		writeBuffer[1] = (byte)(v >>> 48);
		writeBuffer[2] = (byte)(v >>> 40);
		writeBuffer[3] = (byte)(v >>> 32);
		writeBuffer[4] = (byte)(v >>> 24);
		writeBuffer[5] = (byte)(v >>> 16);
		writeBuffer[6] = (byte)(v >>>  8);
		writeBuffer[7] = (byte)(v >>>  0);
		return writeBuffer;
	}
	
	public boolean[] getBatchBoolValue(String code, String[] name) {
		ShardedJedis jedis = pool.getResource();
		
		boolean[] value = new boolean[name.length];
		try {
			ShardedJedisPipeline pipeline = jedis.pipelined();
			Response<String>[] response = new Response[name.length];
			for (int i = 0; i < name.length; i++) {
				response[i] = pipeline.get(Key.createKey(Arrays.asList(code, name[i])).toString());
			}
			pipeline.sync();
			
			for (int i = 0; i < value.length; i++) {
				Response<String> resp = response[i];
				String s = resp.get();
				if ( s != null) {
					value[i] = Boolean.parseBoolean(s);
				}
			}
		} finally {
		  pool.returnResource(jedis);
		}
		return value;
	}
	
	public boolean getBoolValue(String code, String name) {
		ShardedJedis jedis = pool.getResource();
		boolean value = false;
		try {
			String v = jedis.get(Key.createKey(Arrays.asList(code, name)).toString());
			value = Boolean.parseBoolean(v);
		} finally {
		  pool.returnResource(jedis);
		}
		return value;
	}
	
	public void putBatchValue(String code, String[] name, boolean[] value) {
		ShardedJedis jedis = pool.getResource();
		if (name.length != value.length) {
			throw new IllegalArgumentException("name数量与value数量不匹配");
		}
		try {
			ShardedJedisPipeline pipeline = jedis.pipelined();
			for (int i = 0; i < name.length; i++) {
				pipeline.set(Key.createKey(Arrays.asList(code, name[i])).toString(), Boolean.toString(value[i]));
			}
			pipeline.sync();
		} finally {
		  pool.returnResource(jedis);
		}
	}
	
	public void putValue(String code, String name, boolean value) {
		ShardedJedis jedis = pool.getResource();
		try {
        	jedis.set(Key.createKey(Arrays.asList(code, name)).toString(), Boolean.toString(value));
		} finally {
		  pool.returnResource(jedis);
		}
	}
	
	@PreDestroy
	public void destroy() {
		pool.destroy();
	}
}
