package Hw5_23001908_VuQuangNam.ex6;

public class TradeOrder {
    private String type;
    private int quantity;
    private double price;

    public TradeOrder(String type, int quantity, double price) {
        this.type = type;
        this.quantity = quantity;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return type + " " + quantity + " shares at $" + price;
    }
}
