package org.joann.ordermanagmentsystem.dto;

import java.util.List;

public class OrderRequest {

    private List<String> productNames;  // List of product names (or IDs)
    private Double totalPrice;

    // Getters and setters
    public List<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(List<String> productNames) {
        this.productNames = productNames;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
