package sample;

import java.math.BigDecimal;
import java.sql.Timestamp;

public class Package{
    public Integer PackageId;
    public String PackageName;
    public Timestamp PackageStart;
    public Timestamp PackageEnd;
    public String PackageDesc;
    public BigDecimal PackagePrice;
    public BigDecimal PackageCommission;

    public Package(Integer packageId, String packageName, Timestamp packageStart, Timestamp packageEnd, String packageDesc, BigDecimal packagePrice, BigDecimal packageCommission) {
        PackageId = packageId;
        PackageName = packageName;
        PackageStart = packageStart;
        PackageEnd = packageEnd;
        PackageDesc = packageDesc;
        PackagePrice = packagePrice;
        PackageCommission = packageCommission;
    }

    public Integer getPackageId() {
        return PackageId;
    }

    public void setPackageId(Integer packageId) {
        PackageId = packageId;
    }

    public String getPackageName() {
        return PackageName;
    }

    public void setPackageName(String packageName) {
        PackageName = packageName;
    }

    public Timestamp getPackageStart() {
        return PackageStart;
    }

    public void setPackageStart(Timestamp packageStart) {
        PackageStart = packageStart;
    }

    public Timestamp getPackageEnd() {
        return PackageEnd;
    }

    public void setPackageEnd(Timestamp packageEnd) {
        PackageEnd = packageEnd;
    }

    public String getPackageDesc() {
        return PackageDesc;
    }

    public void setPackageDesc(String packageDesc) {
        PackageDesc = packageDesc;
    }

    public BigDecimal getPackagePrice() {
        return PackagePrice;
    }

    public void setPackagePrice(BigDecimal packagePrice) {
        PackagePrice = packagePrice;
    }

    public BigDecimal getPackageCommission() {
        return PackageCommission;
    }

    public void setPackageCommission(BigDecimal packageCommission) {
        PackageCommission = packageCommission;
    }
}