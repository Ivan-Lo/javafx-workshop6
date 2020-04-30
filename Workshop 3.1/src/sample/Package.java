package sample;

public class Package{
    public int PackageId;
    public String PackageName;
    public String PackageStart;
    public String PackageEnd;
    public String PackageDesc;
    public String PackagePrice;
    public String PackageCommission;

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

    public String getPackageCommission() {
        return PackageCommission;
    }

    public void setPackageCommission(String packageCommission) {
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