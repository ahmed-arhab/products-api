// Question: Is BundleProduct really an IS-A Product, or have you just found a HAS-A hiding inside an extends?
// Answer & Argument:
// IS-A perspective: BundleProduct genuinely is a Product in the shop's catalogue because it has an id, a name,
// and a bundle price. Customers browse it and buy it as a single product unit just like any other Product.
// HAS-A perspective: Under the hood, BundleProduct contains a List<Product> items (composition / HAS-A).
// It acts as a composite wrapper (the Composite Pattern). Therefore, it is a hybrid design: it is a Product externally (IS-A)
// to satisfy polymorphism and catalogue consistency, while internally containing multiple Products (HAS-A).

package uk.ac.westminster.products_api;

import java.util.ArrayList;
import java.util.List;

public class BundleProduct extends Product {
    private List<Product> items = new ArrayList<>();

    // No-arg constructor for Jackson deserialisation
    public BundleProduct() {
    }

    public BundleProduct(Long id, String name, double price, List<Product> items) {
        super(id, name, price);
        this.items = items != null ? items : new ArrayList<>();
    }

    public List<Product> getItems() {
        return items;
    }

    public void setItems(List<Product> items) {
        this.items = items;
    }

    public void addItem(Product product) {
        if (this.items == null) {
            this.items = new ArrayList<>();
        }
        this.items.add(product);
    }
}
