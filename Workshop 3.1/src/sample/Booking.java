package sample;

import java.sql.Timestamp;
import java.util.Date;

public class Booking {

    private Integer BookingId;
    private Timestamp BookingDate;
    private String BookingNo;
    private Integer TravelerCount;
    private Integer CustomerId;
    private String TripTypeId;
    private Integer PackageId;

    @Override
    public String toString() {
        return "Booking{" +
                "BookingId=" + BookingId +
                ", BookingDate=" + BookingDate +
                ", BookingNo='" + BookingNo + '\'' +
                ", TravelerCount=" + TravelerCount +
                ", CustomerId=" + CustomerId +
                ", TripTypeId='" + TripTypeId + '\'' +
                ", PackageId=" + PackageId +
                '}';
    }

    public Integer getBookingId() {
        return BookingId;
    }

    public void setBookingId(Integer bookingId) {
        BookingId = bookingId;
    }

    public Timestamp getBookingDate() {
        return BookingDate;
    }

    public void setBookingDate(Timestamp bookingDate) {
        BookingDate = bookingDate;
    }

    public String getBookingNo() {
        return BookingNo;
    }

    public void setBookingNo(String bookingNo) {
        BookingNo = bookingNo;
    }

    public Integer getTravelerCount() {
        return TravelerCount;
    }

    public void setTravelerCount(Integer travelerCount) {
        TravelerCount = travelerCount;
    }

    public Integer getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(Integer customerId) {
        CustomerId = customerId;
    }

    public String getTripTypeId() {
        return TripTypeId;
    }

    public void setTripTypeId(String tripTypeId) {
        TripTypeId = tripTypeId;
    }

    public Integer getPackageId() {
        return PackageId;
    }

    public void setPackageId(Integer packageId) {
        PackageId = packageId;
    }

    public Booking(Integer bookingId, Timestamp bookingDate, String bookingNo, Integer travelerCount, Integer customerId, String tripTypeId, Integer packageId) {
        BookingId = bookingId;
        BookingDate = bookingDate;
        BookingNo = bookingNo;
        TravelerCount = travelerCount;
        CustomerId = customerId;
        TripTypeId = tripTypeId;
        PackageId = packageId;
    }
}
