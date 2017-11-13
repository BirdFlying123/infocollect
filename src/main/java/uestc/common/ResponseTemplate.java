package uestc.common;

import java.io.Serializable;

//返回json数据的模板
public class ResponseTemplate<T> implements Serializable {
    private int status;
    private String msg;
    private T data;

    public ResponseTemplate() {
    }

    public ResponseTemplate(int status, String msg, T data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResponseTemplate{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

}
