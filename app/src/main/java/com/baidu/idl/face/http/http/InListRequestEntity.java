package com.baidu.idl.face.http.http;

public class InListRequestEntity {


    private String collectionPerson;
    private String hospitalCode;
    public String getCollectionPerson() {
        return collectionPerson;
    }
    public void setCollectionPerson(String collectionPerson) {
        this.collectionPerson = collectionPerson;
    }

    public String getHospitalCode() {
        return hospitalCode;
    }

    public void setHospitalCode(String hospitalCode) {
        this.hospitalCode = hospitalCode;
    }

    public InListRequestEntity(String collectionPerson, String hospitalCode) {
        this.collectionPerson = collectionPerson;
        this.hospitalCode = hospitalCode;
    }
}
