package com.ht.scada.common.tag.util;

public enum DataType {

    BOOL("布尔型"),
    BYTE_H("高字节"),
    BYTE_L("低字节"),
    INT32("整型32位"),
    INT16("整型16位"),
    BCD("BCD码"),
    MOD10000("MOD10000"),
    FLOAT("浮点型32位"),
    DOUBLE("双浮点型64位"),
    /* 遥测数组  */
    INT16_ARRAY("双字节数组"),
    ASCII("ASCII码"),
    /* 高字节乘以1000加上低字节 */
    MOD1000("变频器用电量");

    private String value;

    private DataType(String value) {
        this.value = value;
    }

    private DataType() {
        this(null);
    }

    public String getValue() {
        return value;
    }

    public static DataType getByValue(String value) {
        for (DataType type : DataType.values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return super.toString();    //To change body of overridden methods use File | Settings | File Templates.
    }
}
