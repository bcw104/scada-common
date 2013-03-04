package com.ht.scada.common.middleware.alarm;

public interface AlarmListener<T> {
	public void alarmCatched(T alarm);
}
