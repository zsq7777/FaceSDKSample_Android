package com.baidu.idl.face.http;

import java.util.List;

/**
 * Create by 赵思琦 on 2022/3/11
 * email zsqandzyr@gmail.com
 */
public class DataEntity {

    private int code;
    private Data data;
    private String msg;
    private String result;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public static class Data {
        private String address;
        private int age;
        private String createBy;
        private String createTime;
        private String expireDate;
        private int expireStatus;
        private double faceScore;
        private String faceToken;
        private String fileIds;
        private int fileType;
        private List<?> files;
        private String issueDate;
        private String lastModifyBy;
        private String lastModifyTime;
        private int limit;
        private String name;
        private String orgId;
        private String orgName;
        private int page;
        private String photo;
        private String pkEmp;
        private String profession;
        private String remark;
        private String serialNo;
        private int sex;
        private int status;
        private String supplyId;
        private int type;
        private String version;
        private int visible;

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getCreateBy() {
            return createBy;
        }

        public void setCreateBy(String createBy) {
            this.createBy = createBy;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public String getExpireDate() {
            return expireDate;
        }

        public void setExpireDate(String expireDate) {
            this.expireDate = expireDate;
        }

        public int getExpireStatus() {
            return expireStatus;
        }

        public void setExpireStatus(int expireStatus) {
            this.expireStatus = expireStatus;
        }

        public double getFaceScore() {
            return faceScore;
        }

        public void setFaceScore(double faceScore) {
            this.faceScore = faceScore;
        }

        public String getFaceToken() {
            return faceToken;
        }

        public void setFaceToken(String faceToken) {
            this.faceToken = faceToken;
        }

        public String getFileIds() {
            return fileIds;
        }

        public void setFileIds(String fileIds) {
            this.fileIds = fileIds;
        }

        public int getFileType() {
            return fileType;
        }

        public void setFileType(int fileType) {
            this.fileType = fileType;
        }

        public List<?> getFiles() {
            return files;
        }

        public void setFiles(List<?> files) {
            this.files = files;
        }

        public String getIssueDate() {
            return issueDate;
        }

        public void setIssueDate(String issueDate) {
            this.issueDate = issueDate;
        }

        public String getLastModifyBy() {
            return lastModifyBy;
        }

        public void setLastModifyBy(String lastModifyBy) {
            this.lastModifyBy = lastModifyBy;
        }

        public String getLastModifyTime() {
            return lastModifyTime;
        }

        public void setLastModifyTime(String lastModifyTime) {
            this.lastModifyTime = lastModifyTime;
        }

        public int getLimit() {
            return limit;
        }

        public void setLimit(int limit) {
            this.limit = limit;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getOrgId() {
            return orgId;
        }

        public void setOrgId(String orgId) {
            this.orgId = orgId;
        }

        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public String getPhoto() {
            return photo;
        }

        public void setPhoto(String photo) {
            this.photo = photo;
        }

        public String getPkEmp() {
            return pkEmp;
        }

        public void setPkEmp(String pkEmp) {
            this.pkEmp = pkEmp;
        }

        public String getProfession() {
            return profession;
        }

        public void setProfession(String profession) {
            this.profession = profession;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getSerialNo() {
            return serialNo;
        }

        public void setSerialNo(String serialNo) {
            this.serialNo = serialNo;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getSupplyId() {
            return supplyId;
        }

        public void setSupplyId(String supplyId) {
            this.supplyId = supplyId;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public String getVersion() {
            return version;
        }

        public void setVersion(String version) {
            this.version = version;
        }

        public int getVisible() {
            return visible;
        }

        public void setVisible(int visible) {
            this.visible = visible;
        }
    }
}
