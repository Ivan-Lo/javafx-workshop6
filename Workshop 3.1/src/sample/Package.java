package sample;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Package{
    public Integer PackageId;
    public String PkgName;
    public Timestamp PkgStartDate;
   public Timestamp PkgEndDate;
   public String PkgDesc;
    public BigDecimal PkgBasePrice;
    public BigDecimal PkgAgencyCommission;

    public Package(Integer packageId, String packageName, Timestamp packageStart, Timestamp packageEnd, String packageDesc, BigDecimal packagePrice, BigDecimal packageCommission) {
        PackageId = packageId;
        PkgName = packageName;
        PkgStartDate= packageStart;
        PkgEndDate = packageEnd;
        PkgDesc = packageDesc;
        PkgBasePrice = packagePrice;
        PkgAgencyCommission = packageCommission;
    }

    public Integer getPackageId() {
        return PackageId;
    }

    public void setPackageId(Integer packageId) {
        PackageId = packageId;
    }

    public String getPkgName() {
        return PkgName;
    }

    public void setPkgName(String packageName) {
        PkgName = packageName;
    }

    public Timestamp getPkgStartDate() {
        return PkgStartDate;
    }

    public void setPkgStartDate(Timestamp packageStart) {
        PkgStartDate = packageStart;
    }

    public Timestamp getPkgEndDate() {
        return PkgEndDate;
    }

    public void setPkgEndDate(Timestamp packageEnd) {
        PkgEndDate = packageEnd;
    }

    public String getPkgDesc() {
        return PkgDesc;
    }

    public void setPkgDesc(String packageDesc) {
        PkgDesc = packageDesc;
    }

    public BigDecimal getPkgBasePrice() {
        return PkgBasePrice;
    }

    public void setPkgBasePrice(BigDecimal packagePrice) {
        PkgBasePrice = packagePrice;
    }

    public BigDecimal getPkgAgencyCommission() {
        return PkgAgencyCommission;
    }

    public void setPkgAgencyCommission(BigDecimal packageCommission) {
        PkgAgencyCommission = packageCommission;
    }
}