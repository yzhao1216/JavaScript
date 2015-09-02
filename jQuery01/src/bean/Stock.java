package bean;

/**
 * Created by EYlee on 8/3/15.
 */
public class Stock {
    private String name;
    private String code;
    private double price;

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
