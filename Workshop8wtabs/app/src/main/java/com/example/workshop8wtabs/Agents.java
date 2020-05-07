package com.example.workshop8wtabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;


/**
 * A simple {@link Fragment} subclass.
 */
public class Agents extends Fragment implements Serializable {

    public Agents() {
        // Required empty public constructor
    }

    private static final long serialVersionUID = 1L;

    private int agentID;

    private int agencyID;

    private String agtFirstName;

    private String agtMiddleName;

    private String agtLastName;

    private String agtBusPhone;

    private String agtEmail;

    private String agtPosition;

    public int getAgentID() {
        return agentID;
    }

    public void setAgentID(int agentID) {
        this.agentID = agentID;
    }

    public int getAgencyID() {
        return agencyID;
    }

    public void setAgencyID(int agencyID) {
        this.agencyID = agencyID;
    }

    public String getAgtFirstName() {
        return agtFirstName;
    }

    public void setAgtFirstName(String agtFirstName) {
        this.agtFirstName = agtFirstName;
    }

    public String getAgtMiddleName() {
        return agtMiddleName;
    }

    public void setAgtMiddleName(String agtMiddleName) {
        this.agtMiddleName = agtMiddleName;
    }

    public String getAgtLastName() {
        return agtLastName;
    }

    public void setAgtLastName(String agtLastName) {
        this.agtLastName = agtLastName;
    }

    public String getAgtBusPhone() {
        return agtBusPhone;
    }

    public void setAgtBusPhone(String agtBusPhone) {
        this.agtBusPhone = agtBusPhone;
    }

    public String getAgtEmail() {
        return agtEmail;
    }

    public void setAgtEmail(String agtEmail) {
        this.agtEmail = agtEmail;
    }

    public String getAgtPosition() {
        return agtPosition;
    }

    public void setAgtPosition(String agtPosition) {
        this.agtPosition = agtPosition;
    }

    public Agents(int agentID, int agencyID, String agtFirstName, String agtMiddleName,
                  String agtLastName, String agtBusPhone, String agtEmail,
                  String agtPosition) {
        this.agentID = agentID;
        this.agencyID = agencyID;
        this.agtFirstName = agtFirstName;
        this.agtMiddleName = agtMiddleName;
        this.agtLastName = agtLastName;
        this.agtBusPhone = agtBusPhone;
        this.agtEmail = agtEmail;
        this.agtPosition = agtPosition;



    }

    @Override
    public String toString() {
        return agtFirstName + ' ' + agtLastName;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_agents, container, false);
    }
}
