package OOP_Coffee_Shop.ingredients;


public abstract class Ingredients {
    private double price;
    public void setPrice(double price) {
        this.price = price;
    }
    public double getPrice() {
        return this.price;
    }

    private String type;
    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return this.type;
    }

    private double sourLevel;
    public double getSourLevel() {
        return sourLevel;
    }
    public void setSourLevel(double sourLevel) throws Exception{
        if(sourLevel >= 0 && sourLevel <= 10){
            this.sourLevel = sourLevel;
        }
        else{
            throw new Exception("Level must be in the range of 0 to 10");
        }
    }

    private double bitterLevel;
    public double getBitterLevel() {
        return bitterLevel;
    }
    public void setBitterLevel(double bitterLevel) throws Exception {
        if (bitterLevel >= 0 && bitterLevel <= 10) {
            this.bitterLevel = bitterLevel;
        } else {
            throw new Exception("Level must be in the range of 0 to 10");
        }
    }

    private double sweetLevel;
    public double getSweetLevel() {
        return sweetLevel;
    }
    public void setSweetLevel(double sweetLevel) throws Exception {
        if (sweetLevel >= 0 && sweetLevel <= 10) {
            this.sweetLevel = sweetLevel;
        } else {
            throw new Exception("Level must be in the range of 0 to 10");
        }
    }

    private double saltyLevel;
    public double getSaltyLevel() {
        return saltyLevel;
    }
    public void setSaltyLevel(double saltyLevel) throws Exception {
        if (saltyLevel >= 0 && saltyLevel <= 10) {
            this.saltyLevel = saltyLevel;
        } else {
            throw new Exception("Level must be in the range of 0 to 10");
        }
    }

    private double mass;
    public void setMass(double mass) {
        this.mass = mass;
    }
    public double getMass() {
        return this.mass;
    }


    public Ingredients() {
        this.type = "";
        this.mass = 0;
        this.sweetLevel = 0;
        this.bitterLevel = 0;
        this.sourLevel = 0;
        this.saltyLevel = 0;
        this.price = 0;
    }

    public Ingredients(String type, double sweetLevel, double bitterLevel, double saltyLevel, double sourLevel,
            double mass, double price) {
        this.type = type;
        this.mass = mass;
        this.price = price;
        this.bitterLevel = bitterLevel;
        this.sweetLevel = sweetLevel;
        this.sourLevel = sourLevel;
        this.saltyLevel = saltyLevel;
    }

}
