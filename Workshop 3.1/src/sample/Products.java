package sample;

public class Products {

    private Integer ProductId;
    private  String ProdName;

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }

    public String getProdName() {
        return ProdName;
    }

    public void setProdName(String prodName) {
        ProdName = prodName;
    }

    @Override
    public String toString() {
        return "Products{" +
                "ProductId='" + ProductId + '\'' +
                ", ProdName='" + ProdName + '\'' +
                '}';
    }

    public Products(Integer productId, String prodName) {
        ProductId = productId;
        ProdName = prodName;
    }
}
