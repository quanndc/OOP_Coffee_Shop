package OOP_Coffee_Shop.menu;

import java.util.ArrayList;

import OOP_Coffee_Shop.drinks.Drinks;
import OOP_Coffee_Shop.ingredients.Coffee;
import OOP_Coffee_Shop.ingredients.Milk;
import OOP_Coffee_Shop.ingredients.Salt;
import OOP_Coffee_Shop.ingredients.Sugar;

public class Menu {
    public ArrayList<Drinks> drinkList = new ArrayList<>();
    public ArrayList<Drinks> getDrinkList() {
        return drinkList;
    }
    public void addDrink(Drinks drink) {
        drinkList.add(drink);
    }
    
    public String toString(){
        String menuText = "";
        for(int i=0;i<drinkList.size();i++){
            menuText += (i+1) + ". " + drinkList.get(i).toString();
        }
        return menuText;
    }


    public static Menu generateMenu(){
        Drinks cappuccino = Drinks.builder()
       .setName("Cappuccino")
       .addIngredient(new Milk(4))
       .addIngredient(new Sugar(0))
       .addIngredient(new Coffee(4))
       .setTemp(10);

       Drinks espresso = Drinks.builder()
       .setName("Espresso")
       .addIngredient(new Milk(1))
       .addIngredient(new Sugar(0))
       .addIngredient(new Coffee(4))
       .setTemp(10);

       Drinks saltyCoffee = Drinks.builder()
       .setName("Salty Coffee")
       .addIngredient(new Milk(1))
       .addIngredient(new Sugar(0))
       .addIngredient(new Coffee(3))
       .addIngredient(new Salt(5))
       .setTemp(50);

       Drinks americano = Drinks.builder()
       .setName("Americano")
       .addIngredient(new Milk(1))
       .addIngredient(new Sugar(0))
       .addIngredient(new Coffee(5))
       .setTemp(50);

        Menu menu = new Menu();
        menu.addDrink(cappuccino);
        menu.addDrink(espresso);
        menu.addDrink(saltyCoffee);
        menu.addDrink(americano);




        return menu;
    }
}
