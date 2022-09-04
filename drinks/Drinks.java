package OOP_Coffee_Shop.drinks;

import java.util.ArrayList;

import OOP_Coffee_Shop.ingredients.Ingredients;

public class Drinks {
    public String name;
    public String getName() {
        return name;
    }
    public Drinks setName(String name) {
        this.name = name;
        return this;
    }

    protected double temperature;
    public Drinks setTemp(double temp){
        this.temperature = temp;
        return this;
    }
    public double getTemp(){
        return this.temperature;
    }

    public double getSweetLevel(){
        double sweetLevel = 0;
        double totalWeight = 0;
        for(int i=0;i<ingredients.size();i++){
            totalWeight += ingredients.get(i).getMass();
            sweetLevel += ingredients.get(i).getSweetLevel() * ingredients.get(i).getMass();
        }
        return sweetLevel / totalWeight;
    }

    public double getBitterLevel(){
        double bitterLevel = 0;
        double totalWeight = 0;
        for(int i=0;i<ingredients.size();i++){
            totalWeight += ingredients.get(i).getMass();
            bitterLevel += ingredients.get(i).getBitterLevel() * ingredients.get(i).getMass();
        }
        return bitterLevel / totalWeight;
    }

    public double getSourLevel(){
        double sourLevel = 0;
        double totalWeight = 0;
        for(int i=0;i<ingredients.size();i++){
            totalWeight += ingredients.get(i).getMass();
            sourLevel += ingredients.get(i).getSourLevel() * ingredients.get(i).getMass();
        }
        return sourLevel / totalWeight;
    }

    public double getSaltyLevel(){
        double saltyLevel = 0;
        double totalWeight = 0;
        for(int i=0;i<ingredients.size();i++){
            totalWeight += ingredients.get(i).getMass();
            saltyLevel += ingredients.get(i).getSaltyLevel() * ingredients.get(i).getMass();
        }
        return saltyLevel / totalWeight;
    }

    public double totalPrice(){
        double totalPrice = 0;
        for(int i=0;i<ingredients.size();i++){
            totalPrice += (ingredients.get(i).getPrice());
        }
        return totalPrice*1000;
    }

    protected ArrayList<Ingredients> ingredients = new ArrayList<>();
    public Drinks addIngredient(Ingredients ingredient){
        this.ingredients.add(ingredient);
        return this;
    }
    public ArrayList<Ingredients> getIngredients(){
        return this.ingredients;
    }

    public static Drinks builder(){
        return new Drinks();
    }

    public String toString(){
        return String.format("%s      Price: %lf\n",this.getName(),this.totalPrice());
    }
}
