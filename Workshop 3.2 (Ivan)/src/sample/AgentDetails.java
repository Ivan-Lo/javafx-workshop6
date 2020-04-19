package sample;

import javafx.beans.property.StringProperty;

public class AgentDetails {
    private final StringProperty fname;
    private final StringProperty lname;
    private final StringProperty bphone;
    private final StringProperty email;
    private final StringProperty position;
    private final StringProperty aId;

    public AgentDetails(StringProperty fname, StringProperty lname, StringProperty bphone, StringProperty email, StringProperty position, StringProperty aId) {
        this.fname = fname;
        this.lname = lname;
        this.bphone = bphone;
        this.email = email;
        this.position = position;
        this.aId = aId;
    }

    public String getFname() {
        return fname.get();
    }

    public StringProperty fnameProperty() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname.set(fname);
    }

    public String getLname() {
        return lname.get();
    }

    public StringProperty lnameProperty() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname.set(lname);
    }

    public String getBphone() {
        return bphone.get();
    }

    public StringProperty bphoneProperty() {
        return bphone;
    }

    public void setBphone(String bphone) {
        this.bphone.set(bphone);
    }

    public String getEmail() {
        return email.get();
    }

    public StringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getPosition() {
        return position.get();
    }

    public StringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public String getaId() {
        return aId.get();
    }

    public StringProperty aIdProperty() {
        return aId;
    }

    public void setaId(String aId) {
        this.aId.set(aId);
    }



}
