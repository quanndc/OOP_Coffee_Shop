package OOP_Coffee_Shop.UI;

import javax.swing.JCheckBox;

import OOP_Coffee_Shop.drinks.Drinks;

public class DrinkCheckbox extends JCheckBox {
    private Drinks drink;
    
    public Drinks getDrink() {
        return drink;
    }

    public void setDrink(Drinks drink) {
        this.drink = drink;
    }

    public DrinkCheckbox(Drinks drink) {
        super(drink.getName()+": \t   "+drink.totalPrice() + " VND");
        this.drink = drink;
    }
}
