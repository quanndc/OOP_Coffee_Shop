package OOP_Coffee_Shop.promotion;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Voucher {
    private String title;
    public String getTitle() {
        return title;
    }
    public Voucher setTitle(String title) {
        this.title = title;
        return this;
    }

    private Date dateAvailable;
    public Date getDateAvailable() {
        return dateAvailable;
    }
    public Voucher setDateAvailable(String dateAvailable) throws ParseException{
        this.dateAvailable = (new SimpleDateFormat("dd/MM/yyyy")).parse(dateAvailable);
        return this;
    }

    private Date dateUnavailable;
    public Date getDateUnavailable() {
        return dateUnavailable;
    }
    public Voucher setDateUnavailable(String dateUnavailable) throws ParseException{
        this.dateUnavailable = (new SimpleDateFormat("dd/MM/yyyy")).parse(dateUnavailable);
        return this;
    }

    private double discount;
    public double getDiscount() {
        return discount;
    }
    public Voucher setDiscount(double discount) {
        this.discount = discount;
        return this;
    }

    public static Voucher builder(){
        return new Voucher();
    }

    public String toString(){
        return String.format("{Voucher's name: \"%s\"}", this.getTitle());
    }

}
