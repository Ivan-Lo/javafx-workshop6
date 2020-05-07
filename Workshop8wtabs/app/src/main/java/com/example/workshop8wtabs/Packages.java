package com.example.workshop8wtabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class Packages extends Fragment implements Serializable {

    public Packages() {
        // Required empty public constructor
    }

    private static final long serialVersionUID = 1L;

    private int packageId;

    private String pkgName;

    private String pkgStartDate = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

    private String pkgEndDate = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

    private String pkgDesc;

    private int pkgBasePrice;

    private int pkgAgencyCommission;

    public Packages(int packageId, String pkgName, String pkgStartDate, String pkgEndDate,
                  String pkgDesc, int pkgBasePrice, int pkgAgencyCommission) {
        this.packageId = packageId;
        this.pkgName = pkgName;
        this.pkgStartDate = pkgStartDate;
        this.pkgEndDate = pkgEndDate;
        this.pkgDesc = pkgDesc;
        this.pkgBasePrice = pkgBasePrice;
        this.pkgAgencyCommission = pkgAgencyCommission;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    public String getPkgName() {
        return pkgName;
    }

    public void setPkgName(String pkgName) {
        this.pkgName = pkgName;
    }

    public String getPkgStartDate() {
        return pkgStartDate;
    }

    public void setPkgStartDate(String pkgStartDate) {
        this.pkgStartDate = pkgStartDate;
    }

    public String getPkgEndDate() {
        return pkgEndDate;
    }

    public void setPkgEndDate(String pkgEndDate) {
        this.pkgEndDate = pkgEndDate;
    }

    public String getPkgDesc() {
        return pkgDesc;
    }

    public void setPkgDesc(String pkgDesc) {
        this.pkgDesc = pkgDesc;
    }

    public int getPkgBasePrice() {
        return pkgBasePrice;
    }

    public void setPkgBasePrice(int pkgBasePrice) {
        this.pkgBasePrice = pkgBasePrice;
    }

    public int getPkgAgencyCommission() {
        return pkgAgencyCommission;
    }

    public void setPkgAgencyCommission(int pkgAgencyCommission) {
        this.pkgAgencyCommission = pkgAgencyCommission;
    }


    @Override
    public String toString() {
        return pkgName + ' ' + pkgDesc;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_packages, container, false);
    }
}
