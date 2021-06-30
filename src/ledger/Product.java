
package ledger;

import java.util.Scanner;

public class Product {
    
    private String name;
    private double buy_price,sell_price,profit,total_profit;
    private int inventory=0;
    
    public Product(String name, double buy_price, double sell_price, int inventory){
        this.name = name;
        this.buy_price = buy_price;
        this.sell_price = sell_price;
        this.inventory+= inventory;
        this.profit = sell_price - buy_price;
    }
    
    public void setProductName(String name){
        this.name = name;
        }
    public String getProductName(){
        return this.name;
        }
    
    public void setBuyPrice(double price){
        this.buy_price = price;
        }
    public double getBuyPrice(){
        return this.buy_price;
        }
    
    public void setSellPrice(double price){
        this.sell_price = price;
        }
    public double getSellPrice(){
        return this.sell_price;
        }
    
    public void setAvailableProduct(int inventory){
        this.inventory += inventory;
        }
    public int getAvailableProduct(){
        return this.inventory;
        }
    
    public void setProfit(){
        profit= sell_price - buy_price;
    }
    public double getProfit(){
        return profit;
    }
    
    public void setTotalProfit(int inventory){
        this.total_profit+=profit*inventory;
        }
    public double getTotalProfit(){
        return this.total_profit;
        }
}
