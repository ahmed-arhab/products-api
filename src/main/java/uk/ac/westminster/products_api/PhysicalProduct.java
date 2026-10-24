// A PhysicalProduct IS-A Product because it represents a tangible, physical good in the catalogue that has an id, name, and price and can be sold.
// In contrast, ShoppingCart is NOT a Product because a ShoppingCart HAS-A collection of products (composition) rather than being an individual product itself.

package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product {
    private double weightKg;
    private String dimensions;

    // (a) empty no-arg constructor for Jackson
    public PhysicalProduct() {
    }

    // (b) full constructor
    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    // (c) getters
    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}
