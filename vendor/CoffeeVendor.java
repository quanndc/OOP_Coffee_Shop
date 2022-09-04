package OOP_Coffee_Shop.vendor;
import java.util.Date;
//import OOP_Coffee_Shop.ingredients.Coffee;
import OOP_Coffee_Shop.ingredients.Ingredients;

public class CoffeeVendor extends Vendor {
    public WarehouseItem supply(double quantity, Ingredients ingredient) throws Exception {
        return WarehouseItem.builder().setIngredient(ingredient).setUnit(Units.kg)
        .setStock(quantity)
        .setUpdateDate(new Date(System.currentTimeMillis()));
    }

}
