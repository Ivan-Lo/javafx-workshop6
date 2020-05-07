package com.example.workshop8wtabs;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class Bookings extends Fragment implements Serializable {

    public Bookings() {
        // Required empty public constructor
    }

    private static final long serialVersionUID = 1L;

    private int bookingId;

    private String bookingDate = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

    private String bookingNo;

    private int travelerCount;

    private int customerId;

    private String tripTypeId;

    private int packageId;

    public Bookings(int bookingId, int travelerCount, int customerId, int packageId,
                    String bookingDate, String bookingNo, String tripTypeId) {
        this.bookingId = bookingId;
        this.travelerCount = travelerCount;
        this.customerId = customerId;
        this.packageId = packageId;
        this.bookingDate = bookingDate;
        this.bookingNo = bookingNo;
        this.tripTypeId = tripTypeId;

    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getBookingNo() {
        return bookingNo;
    }

    public void setBookingNo(String bookingNo) {
        this.bookingNo = bookingNo;
    }

    public int getTravelerCount() {
        return travelerCount;
    }

    public void setTravelerCount(int travelerCount) {
        this.travelerCount = travelerCount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getTripTypeId() {
        return tripTypeId;
    }

    public void setTripTypeId(String tripTypeId) {
        this.tripTypeId = tripTypeId;
    }

    public int getPackageId() {
        return packageId;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
    }

    @Override
    public String toString() {
        return bookingId + ' ' + bookingNo;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bookings, container, false);
    }
}
