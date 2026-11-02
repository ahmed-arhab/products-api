// A PhysicalProduct IS-A Product because it represents a tangible, physical good in the catalogue that has an id, name, and price and can be sold.
// In contrast, ShoppingCart is NOT a Product because a ShoppingCart HAS-A collection of products (composition) rather than being an individual product itself.

package uk.ac.westminster.products_api;

public class PhysicalProduct extends Product implements Discountable {
    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    // (a) empty no-arg constructor for Jackson
    public PhysicalProduct() {
    }

    // (b) full constructor
    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions) {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
        this.discountedPrice = price;
    }

    @Override
    public String getSummary() {
        return "Physical: " + getName() + " | Weight: " + weightKg + "kg";
    }

    @Override
    public void applyDiscount(double rate) {
        // A physical product still has to be shipped, so the discount is capped at 20%
        double capped = Math.min(rate, 0.20);
        this.discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }

    // (c) getters
    public double getWeightKg() {
        return weightKg;
    }

    public String getDimensions() {
        return dimensions;
    }
}
