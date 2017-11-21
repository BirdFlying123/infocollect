package uestc.common;

public enum ResponseCode {
    ERROR(0, "ERROR"),
    SUCCESS(0, "SUCCESS");

    private final int code;
    private final String desc;

    private ResponseCode(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
