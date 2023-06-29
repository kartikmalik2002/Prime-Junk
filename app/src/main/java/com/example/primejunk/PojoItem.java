package com.example.primejunk;

public class PojoItem {

    int pic;
    String quantity, no_of_coins, rate;

    public PojoItem(int pic, String quantity, String no_of_coins, String rate) {
        this.pic = pic;
        this.quantity = quantity;
        this.no_of_coins = no_of_coins;
        this.rate = rate;
    }

    public int getPic() {
        return pic;
    }

    public void setPic(int pic) {
        this.pic = pic;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getNo_of_coins() {
        return no_of_coins;
    }

    public void setNo_of_coins(String no_of_coins) {
        this.no_of_coins = no_of_coins;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }
}
