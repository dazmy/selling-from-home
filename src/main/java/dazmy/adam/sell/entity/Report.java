package dazmy.adam.sell.entity;

import java.sql.Timestamp;

public class Report {
    private int id;
    private int productId;
    private int manyProduct;
    private int leftProduct;
    private Integer money;
    private Timestamp createdAt;
    private Timestamp updatedAt;

    public Report() {
    }

    public Report(int productId, int manyProduct, int leftProduct, Integer money, Timestamp createdAt, Timestamp updatedAt) {
        this.productId = productId;
        this.manyProduct = manyProduct;
        this.leftProduct = leftProduct;
        this.money = money;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Report(int id, int productId, int manyProduct, int leftProduct, Integer money, Timestamp createdAt, Timestamp updatedAt) {
        this.id = id;
        this.productId = productId;
        this.manyProduct = manyProduct;
        this.leftProduct = leftProduct;
        this.money = money;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getManyProduct() {
        return manyProduct;
    }

    public void setManyProduct(int manyProduct) {
        this.manyProduct = manyProduct;
    }

    public int getLeftProduct() {
        return leftProduct;
    }

    public void setLeftProduct(int leftProduct) {
        this.leftProduct = leftProduct;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        if (id != report.id) return false;
        if (productId != report.productId) return false;
        if (manyProduct != report.manyProduct) return false;
        if (leftProduct != report.leftProduct) return false;
        if (!money.equals(report.money)) return false;
        if (!createdAt.equals(report.createdAt)) return false;
        return updatedAt.equals(report.updatedAt);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + productId;
        result = 31 * result + manyProduct;
        result = 31 * result + leftProduct;
        result = 31 * result + money.hashCode();
        result = 31 * result + createdAt.hashCode();
        result = 31 * result + updatedAt.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", productId=" + productId +
                ", manyProduct=" + manyProduct +
                ", leftProduct=" + leftProduct +
                ", money=" + money +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
