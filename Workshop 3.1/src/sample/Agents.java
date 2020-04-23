package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Agents {

    private final IntegerProperty AgentId;
    private final StringProperty AgtFirstName;
    private final StringProperty AgtMiddleInitial;
    private final StringProperty AgtLastName;
    private final StringProperty AgtBusPhone;
    private final StringProperty AgtEmail;
    private final StringProperty AgtPosition;
    private final IntegerProperty AgencyId;

    public Agents(int agentId, String agtFirstName, String agtMiddleInitial, String agtLastName, String agtBusPhone, String agtEmail, String agtPosition,int agencyId) {

        this.AgentId = new SimpleIntegerProperty(agentId);
        this.AgtFirstName = new SimpleStringProperty(agtFirstName);
        this.AgtMiddleInitial = new SimpleStringProperty(agtMiddleInitial);
        this.AgtLastName = new SimpleStringProperty(agtLastName);
        this.AgtBusPhone = new SimpleStringProperty(agtBusPhone);
        this.AgtEmail = new SimpleStringProperty(agtEmail);
        this.AgtPosition = new SimpleStringProperty(agtPosition);
        this.AgencyId = new SimpleIntegerProperty(agencyId);
    }

    //Getters
    public int getAgentId(){
        return AgentId.get();}
    public String getAgtFirstName(){return AgtFirstName.get();}
    public String getAgtMiddleInitial(){return AgtMiddleInitial.get();}
    public String getAgtLastName(){return AgtLastName.get();}
    public String getAgtBusPhone(){return AgtBusPhone.get();}
    public String getAgtEmail(){return AgtEmail.get();}
    public String getAgtPosition(){return AgtPosition.get();}
    public int getAgencyId(){return AgencyId.get();}

    //Setters
    public void setAgentId(int value){
        AgentId.set(value);
    }
    public void setAgtFirstName(String value){AgtFirstName.set(value);}
    public void setAgtMiddleInitial(String value){
        AgtMiddleInitial.set(value);
    }
    public void setAgtLastName(String value){ AgtLastName.set(value);}
    public void setAgtBusPhone(String value){
        AgtEmail.set(value);
    }
    public void setAgtPosition (String value){
        AgtPosition.set(value);
    }
    public void setAgencyId(int value){
        AgencyId.set(value);
    }


    //Property values
    public IntegerProperty AgentIdProperty(){return AgentId;}
    public StringProperty AgtFirstNameProperty(){return AgtFirstName;}
    public StringProperty AgtLastNameProperty(){return AgtLastName;}
    public StringProperty AgtMiddleInitialProperty(){return AgtMiddleInitial;}
    public StringProperty AgtEmailProperty(){return AgtEmail;}
    public StringProperty AgtBusPhoneProperty(){return AgtBusPhone;}
    public StringProperty AgtPositionProperty(){return AgtPosition;}
    public IntegerProperty AgencyIdProperty(){return AgencyId;}
}


