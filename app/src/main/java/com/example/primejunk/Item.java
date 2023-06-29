package com.example.primejunk;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Item {
    @PrimaryKey(autoGenerate = true)
    public int pid;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "quantity")
    public String quantity;

    @ColumnInfo(name = "rate")
   public String rate;

    @ColumnInfo(name = "no_of_coins")
    public int no_of_coins;

    public Item(int pid, String title, String quantity,String rate,int no_of_coins) {
        this.pid = pid;
        this.title = title;
        this.quantity = quantity;
        this.no_of_coins= no_of_coins;
        //this.rate=rate;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public int getNo_of_coins() {
        return no_of_coins;
    }

    public void setNo_of_coins(int no_of_coins) {
        this.no_of_coins = no_of_coins;
    }
}
