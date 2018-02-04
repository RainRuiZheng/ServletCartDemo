package com.myself.domain; 

/**
 * 购物车项，包含id，货品名，数量
 * @author Jungor
 *
 */
public class CarItem {
    private String id;
    private String product;
    private Integer number;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}