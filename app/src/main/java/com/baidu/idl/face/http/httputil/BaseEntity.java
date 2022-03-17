package com.baidu.idl.face.http.httputil;

public class BaseEntity<T> {
    private int status;
    private String message;
    private T data;

    @Override
    public String toString() {
        return "BaseEntity{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
