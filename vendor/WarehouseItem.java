package OOP_Coffee_Shop.vendor;

import java.util.Date;

import OOP_Coffee_Shop.ingredients.Ingredients;

public class WarehouseItem {
    private Ingredients ingredient;

    public Ingredients getIngredient() {
        return ingredient;
    }

    public WarehouseItem setIngredient(Ingredients ingredient) {
        this.ingredient = ingredient;
        return this;
    }
    
    private Units units = Units.kg;

    public WarehouseItem setUnit(Units units) {
        this.units = units;
        return this;
    }

    public Units getUnits() {
        return this.units;
    }

    private double remaining;

    public WarehouseItem setRemaining(double remaining) {
        this.remaining = remaining;
        return this;
    }

    public double getRemaining() {
        return this.remaining;
    }



    private double capacity;

    public WarehouseItem setCapacity(double total) {
        this.capacity = total;
        return this;
    }

    public double getCapacity() {
        return this.capacity;
    }

    public double getTotalPrice() {
        return this.remaining * this.ingredient.getPrice();
    }

    public double getRemainingCapacity() {
        return this.capacity - this.remaining;
    }

    private Vendor vendor;
    public Vendor getVendor() {
        return vendor;
    }
    public WarehouseItem setVendor(Vendor vendor) {
        this.vendor = vendor;
        return this;
    }

    private Date updateDate;
    public WarehouseItem setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
        return this;
    }

    public Date getUpdateDate() {
        return this.updateDate;
    }

    public WarehouseItem setStock(double value){
        this.remaining = value;
        return this;
    }

    public WarehouseItem addStocks(double value) throws Exception {
        if ((value + remaining) > capacity) {
            throw new Exception("Overload value");
        }
        this.remaining += value;
        setUpdateDate(new Date(System.currentTimeMillis()));
        return this;
    }

    public void consume(double value) throws Exception {
        if((remaining - value) < 0) {
            throw new Exception("Not enough inventory");
        }
        this.remaining -= value;
        if(remaining < (capacity*0.1)){
            this.merge(this.vendor.supply(capacity-remaining, this.ingredient));

        }
    }

    private void merge(WarehouseItem item){
        this.remaining+=item.remaining;
    }

    public static WarehouseItem builder(){
        return new WarehouseItem();
    }

    public String toString(){
        return String.format("{Item's name: \"%s\", Item's name: \"%s\", }", this.getIngredient().getType());
    }
}
