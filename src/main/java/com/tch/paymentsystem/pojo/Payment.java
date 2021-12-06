package com.tch.paymentsystem.pojo;

import com.opencsv.bean.CsvBindByPosition;

public class Payment {
    @CsvBindByPosition(position = 0)
    private String id;
    @CsvBindByPosition(position = 1)
    private String bankName;
    @CsvBindByPosition(position = 2)
    private String type;
    @CsvBindByPosition(position = 3)
    private String city;
    @CsvBindByPosition(position = 4)
    private String state;
    @CsvBindByPosition(position = 5)
    private String zipCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public boolean isKeywordExist(String keyword) {
        keyword=keyword.toLowerCase();
        return bankName.toLowerCase().contains(keyword) ||
                type.toLowerCase().contains(keyword) ||
                city.toLowerCase().contains(keyword) ||
                state.toLowerCase().contains(keyword) ||
                zipCode.toLowerCase().contains(keyword);
    }
}
