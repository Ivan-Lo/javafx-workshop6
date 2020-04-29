package sample;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Packages{
    public int PackageId;
    public String PackageName;
    public String PackageStart;
    public String PackageEnd;
    public String PackageDesc;
    public String PackagePrice;
    public Stirng PackageCommission;

    public int getPackageId() {
        return PackageId;
    }

    public void setPackageId(int packageId) {
        PackageId = packageId;
    }

    public String getPackageName() {
        return PackageName;
    }

    public void setPackageName(String packageName) {
        PackageName = packageName;
    }

    public String getPackageStart() {
        return PackageStart;
    }

    public void setPackageStart(String packageStart) {
        PackageStart = packageStart;
    }

    public String getPackageEnd() {
        return PackageEnd;
    }

    public void setPackageEnd(String packageEnd) {
        PackageEnd = packageEnd;
    }

    public String getPackageDesc() {
        return PackageDesc;
    }

    public void setPackageDesc(String packageDesc) {
        PackageDesc = packageDesc;
    }

    public String getPackagePrice() {
        return PackagePrice;
    }

    public void setPackagePrice(String packagePrice) {
        PackagePrice = packagePrice;
    }

    public Stirng getPackageCommission() {
        return PackageCommission;
    }

    public void setPackageCommission(Stirng packageCommission) {
        PackageCommission = packageCommission;
    }

    public Packages(int packageId, String packageName, String packageStart, String packageEnd, String packageDesc, String packagePrice, Stirng packageCommission) {
        PackageId = packageId;
        PackageName = packageName;
        PackageStart = packageStart;
        PackageEnd = packageEnd;
        PackageDesc = packageDesc;
        PackagePrice = packagePrice;
        PackageCommission = packageCommission;
    }

    @Override
    public String toString() {
        return "Packages{" +
                "PackageId=" + PackageId +
                ", PackageName='" + PackageName + '\'' +
                ", PackageStart='" + PackageStart + '\'' +
                ", PackageEnd='" + PackageEnd + '\'' +
                ", PackageDesc='" + PackageDesc + '\'' +
                ", PackagePrice='" + PackagePrice + '\'' +
                ", PackageCommission=" + PackageCommission +
                '}';
    }
}