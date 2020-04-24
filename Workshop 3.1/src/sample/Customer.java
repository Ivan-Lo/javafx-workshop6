package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Customer {

    private final IntegerProperty CustomerId;
    private final StringProperty CustFirstName;
    private final StringProperty CustLastName;
    private final StringProperty CustAddress;
    private final StringProperty CustCity;
    private final StringProperty CustProv;
    private final StringProperty CustPostal;
    private final StringProperty CustCountry;
    private final StringProperty CustHomePhone;
    private final StringProperty CustBusPhone;
    private final StringProperty CustEmail;
    private final IntegerProperty AgentId;

    public Customer(int customerId, String custFirstName, String custLastName, String custAddress, String custCity, String custProv, String custPostal, String custCountry, String custHomePhone, String custBusPhone, String custEmail, int agentId) {

        this.CustomerId = new SimpleIntegerProperty(customerId);
        this.CustFirstName = new SimpleStringProperty(custFirstName);
        this.CustLastName = new SimpleStringProperty(custLastName);
        this.CustAddress = new SimpleStringProperty(custAddress);
        this.CustCity = new SimpleStringProperty(custCity);
        this.CustProv = new SimpleStringProperty(custProv);
        this.CustPostal = new SimpleStringProperty(custPostal);
        this.CustCountry = new SimpleStringProperty(custCountry);
        this.CustHomePhone = new SimpleStringProperty(custHomePhone);
        this.CustBusPhone = new SimpleStringProperty(custBusPhone);
        this.CustEmail = new SimpleStringProperty(custEmail);
        this.AgentId = new SimpleIntegerProperty(agentId);
    }

    //Getters
    public int getCustomerId(){
        return CustomerId.get();}
    public String CustFirstName(){return CustFirstName.get();}
    public String CustLastName(){return CustLastName.get();}
    public String CustAddress(){return CustAddress.get();}
    public String CustCity(){return CustCity.get();}
    public String CustProv(){return CustProv.get();}
    public String CustPostal(){return CustPostal.get();}
    public String CustCountry(){return CustCountry.get();}
    public String CustHomePhone(){return CustHomePhone.get();}
    public String CustBusPhone(){return CustBusPhone.get();}
    public String CustEmail(){return CustEmail.get();}
    public int AgentId(){return AgentId.get();}

    //Setters
    public void setCustomerId(int value){
        CustomerId.set(value);
    }
    public void setCustFirstName(String value){CustFirstName.set(value);}
    public void setCustLastName(String value){
        CustLastName.set(value);
    }
    public void setCustAddress(String value){ CustAddress.set(value);}
    public void setCustCity(String value){
        CustCity.set(value);
    }
    public void setCustProv (String value){
        CustProv.set(value);
    }
    public void setCustPostal (String value){
        CustPostal.set(value);
    }
    public void setCustCountry (String value){
        CustCountry.set(value);
    }
    public void setCustHomePhone (String value){
        CustHomePhone.set(value);
    }
    public void setCustBusPhone (String value){
        CustBusPhone.set(value);
    }
    public void setCustEmail(String value){
        CustEmail.set(value);
    }
    public void setAgentId(int value){
        AgentId.set(value);
    }

    //Property values
    public IntegerProperty CustomerIdProperty(){return CustomerId;}
    public StringProperty CustFirstNameProperty(){return CustFirstName;}
    public StringProperty CustLastNameProperty(){return CustLastName;}
    public StringProperty CustAddressProperty(){return CustAddress;}
    public StringProperty CustCityProperty(){return CustCity;}
    public StringProperty CustProvProperty(){return CustProv;}
    public StringProperty CustPostalProperty(){return CustPostal;}
    public StringProperty CustCountryProperty(){return CustCountry;}
    public StringProperty CustHomePhoneProperty(){return CustHomePhone;}
    public StringProperty CustBusPhoneProperty(){return CustBusPhone;}
    public StringProperty CustEmailProperty(){return CustEmail;}
    public IntegerProperty AgentIdProperty(){return AgentId;}
}
