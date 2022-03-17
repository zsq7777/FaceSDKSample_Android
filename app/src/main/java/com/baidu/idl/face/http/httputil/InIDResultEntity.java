package com.baidu.idl.face.http.httputil;

public class InIDResultEntity {

    private int status;
    private String message;
    private DataDTO data;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DataDTO getData() {
        return data;
    }

    public void setData(DataDTO data) {
        this.data = data;
    }

    public static class DataDTO {
        private Object data;
        private Object count;
        private String timestamp;

        public Object getData() {
            return data;
        }

        public void setData(Object data) {
            this.data = data;
        }

        public Object getCount() {
            return count;
        }

        public void setCount(Object count) {
            this.count = count;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
    }
}
