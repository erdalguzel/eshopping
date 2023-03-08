package dev.springboot.eshopping.util;

public enum ProductAttributes {
    PRODUCT_NAME("PRODUCT_NAME"),
    RATING("RATING"),
    SELLER("SELLER"),
    BRAND("BRAND");

    private final String value;

    ProductAttributes(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
