package com.baidu.idl.face.http.http;

/**
 * Create by 赵思琦 on 2022/3/11
 * email zsqandzyr@gmail.com
 */
public class Base64ImageEntity {
    private String base64;

    public Base64ImageEntity(String base64) {
        this.base64 = base64;
    }

    public String getBase64() {
        return base64;
    }

    public void setBase64(String base64) {
        this.base64 = base64;
    }

    @Override
    public String toString() {
        return "Base64ImageEntity{" +
                "base64='" + base64 + '\'' +
                '}';
    }
}
