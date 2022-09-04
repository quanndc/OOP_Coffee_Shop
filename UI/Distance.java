package OOP_Coffee_Shop.UI;

import java.security.PublicKey;

import OOP_Coffee_Shop.drinks.Drinks;

public class Distance {
    private Drinks drink;
    public Drinks getDrink() {
        return drink;
    }
    public void setDrink(Drinks drink) {
        this.drink = drink;
    }
    private double distances;
    public double getDistances() {
        return distances;
    }
    public void setDistances(double distances) {
        this.distances = distances;
    }

    public Distance(double distances, Drinks drink){
        this.distances = distances;
        this.drink = drink;
    }
}
