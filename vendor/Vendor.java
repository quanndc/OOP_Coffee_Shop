package OOP_Coffee_Shop.vendor;

import OOP_Coffee_Shop.ingredients.Ingredients;

public abstract class Vendor {
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public abstract WarehouseItem supply(double quantity, Ingredients ingredient) throws Exception;

}
