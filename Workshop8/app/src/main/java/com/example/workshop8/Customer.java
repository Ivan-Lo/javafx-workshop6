package com.example.workshop8;

import java.io.Serializable;

/**
 * The persistent class for the customers database table.
 *
 */
public class Customer implements Serializable {
    private static final long serialVersionUID = 1L;

    private int customerId;

    private int agentId;

    private String custAddress;

    private String custBusPhone;

    private String custCity;

    private String custCountry;

    private String custEmail;

    private String custFirstName;

    private String custHomePhone;

    private String custLastName;

    private String custPostal;

    private String custProv;

    public Customer() {
    }

    public Customer(int customerId, int agentId, String custAddress, String custBusPhone,
                    String custCity, String custCountry, String custEmail,
                    String custFirstName, String custHomePhone, String custLastName,
                    String custPostal, String custProv) {
        this.customerId = customerId;
        this.agentId = agentId;
        this.custAddress = custAddress;
        this.custBusPhone = custBusPhone;
        this.custCity = custCity;
        this.custCountry = custCountry;
        this.custEmail = custEmail;
        this.custFirstName = custFirstName;
        this.custHomePhone = custHomePhone;
        this.custLastName = custLastName;
        this.custPostal = custPostal;
        this.custProv = custProv;
    }

    public int getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getAgentId() {
        return this.agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getCustAddress() {
        return this.custAddress;
    }

    public void setCustAddress(String custAddress) {
        this.custAddress = custAddress;
    }

    public String getCustBusPhone() {
        return this.custBusPhone;
    }

    public void setCustBusPhone(String custBusPhone) {
        this.custBusPhone = custBusPhone;
    }

    public String getCustCity() {
        return this.custCity;
    }

    public void setCustCity(String custCity) {
        this.custCity = custCity;
    }

    public String getCustCountry() {
        return this.custCountry;
    }

    public void setCustCountry(String custCountry) {
        this.custCountry = custCountry;
    }

    public String getCustEmail() {
        return this.custEmail;
    }

    public void setCustEmail(String custEmail) {
        this.custEmail = custEmail;
    }

    public String getCustFirstName() {
        return this.custFirstName;
    }

    public void setCustFirstName(String custFirstName) {
        this.custFirstName = custFirstName;
    }

    public String getCustHomePhone() {
        return this.custHomePhone;
    }

    public void setCustHomePhone(String custHomePhone) {
        this.custHomePhone = custHomePhone;
    }

    public String getCustLastName() {
        return this.custLastName;
    }

    public void setCustLastName(String custLastName) {
        this.custLastName = custLastName;
    }

    public String getCustPostal() {
        return this.custPostal;
    }

    public void setCustPostal(String custPostal) {
        this.custPostal = custPostal;
    }

    public String getCustProv() {
        return this.custProv;
    }

    public void setCustProv(String custProv) {
        this.custProv = custProv;
    }

    @Override
    public String toString() {
        return custFirstName + ' ' + custLastName;
    }
}