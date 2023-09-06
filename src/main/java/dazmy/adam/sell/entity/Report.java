package dazmy.adam.sell.entity;

import java.sql.Timestamp;

public class Report {
    private int id;
    private int product_id;
    private int many_product;
    private int left_product;
    private Integer money;
    private Timestamp created_at;
    private Timestamp updated_at;

    public Report() {
    }

    public Report(int product_id, int many_product, int left_product, Integer money, Timestamp created_at, Timestamp updated_at) {
        this.product_id = product_id;
        this.many_product = many_product;
        this.left_product = left_product;
        this.money = money;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Report(int id, int product_id, int many_product, int left_product, Integer money, Timestamp created_at, Timestamp updated_at) {
        this.id = id;
        this.product_id = product_id;
        this.many_product = many_product;
        this.left_product = left_product;
        this.money = money;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }

    public int getMany_product() {
        return many_product;
    }

    public void setMany_product(int many_product) {
        this.many_product = many_product;
    }

    public int getLeft_product() {
        return left_product;
    }

    public void setLeft_product(int left_product) {
        this.left_product = left_product;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Timestamp getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Timestamp updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Report report = (Report) o;

        if (id != report.id) return false;
        if (product_id != report.product_id) return false;
        if (many_product != report.many_product) return false;
        if (left_product != report.left_product) return false;
        if (!money.equals(report.money)) return false;
        if (!created_at.equals(report.created_at)) return false;
        return updated_at.equals(report.updated_at);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + product_id;
        result = 31 * result + many_product;
        result = 31 * result + left_product;
        result = 31 * result + money.hashCode();
        result = 31 * result + created_at.hashCode();
        result = 31 * result + updated_at.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", product_id=" + product_id +
                ", many_product=" + many_product +
                ", left_product=" + left_product +
                ", money=" + money +
                ", created_at=" + created_at +
                ", updated_at=" + updated_at +
                '}';
    }
}
