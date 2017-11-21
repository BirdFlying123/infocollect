package uestc.common;

public enum Message {
    SUCCESSLOGIN("SUCCESSLOGIN"),
    LOGINMESSAGE("用户名或密码错误");

    private String desc;

    private Message(String desc){
        this.desc=desc;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
