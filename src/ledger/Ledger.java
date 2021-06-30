
package ledger;

import java.util.ArrayList;
import java.util.Scanner;

public class Ledger {

    static ArrayList<Product> productList = new ArrayList<>();
    static double balance= 0;
    
    public static void main(String[] args) {
        doFuntionalities();
    }
    
    public static void doFuntionalities(){
        System.out.println("Main Menu:\n"
                + "1. Add a product.\n"
                + "2. Delete a product.\n"
                + "3. Buy a product.\n"
                + "4. Sell a product.\n"
                + "5. See the list of products.\n"
                + "6. See available balance.");
        System.out.print("Selet an option: ");
        
        Scanner scan = new Scanner(System.in);
        
        int a = scan.nextInt();
        
        switch(a){
        
            case 1:
                {
                    
                    scan.nextLine();
                    System.out.print("Name: ");
                    String name = scan.nextLine();
                    
                    System.out.print("Buy Price: ");
                    double buy_price = scan.nextDouble();
                    
                    System.out.print("Sell Price: ");
                    double sell_price = scan.nextDouble();
                    
                    System.out.print("How many product you add: ");
                    int inventory = scan.nextInt();
                    
                    Product product = new Product(name,buy_price,sell_price,inventory);
                    
                    productList.add(product);
                   
                    break;
                }
             
            case 2:
                {
                    deleteProduct();
                    break;
                }
                
            case 3:
                {
                    buyProduct();
                    break;
                }
                
             case 4:
                {
                    sellProduct();
                    break;
                }
                 
            case 5:
                {
                    listProduct();
                    break;
                }
                
            case 6:
                {
                    availableBalance();
                    break;
                }
                
            default:
                System.out.println("Press between 1 and 6.");
        
        }
        System.out.print("Do you want to go main menu? (y/n): ");
        char menu = scan.next().charAt(0);
        if(menu == 'y' || menu =='Y'){
            doFuntionalities();
        }
        else if(menu == 'n' || menu == 'N'){
        System.exit(0);
        }
    }
    
    public static void deleteProduct(){
        getList();
        System.out.print("Select a product to delete: ");
        
        Scanner del = new Scanner(System.in);
        int p = del.nextInt();
        
        productList.remove(p-1);
    
    }
    
    public static void buyProduct(){
        getList();
        System.out.print("Select a product to buy: ");
        
        Scanner buy = new Scanner(System.in);
        int p = buy.nextInt();
        Product product =  productList.get(p-1);
        System.out.print("How many "+ product.getProductName()+" you want to buy: ");
        int inventory = buy.nextInt();
        
        if(balance>= product.getBuyPrice() * inventory){
            product.setAvailableProduct(inventory);
            balance -= product.getBuyPrice() * inventory;
        }
        else
            System.out.println("Insufficient balance.");
    }
    
    public static void sellProduct(){
        getList();
        System.out.print("Select a product to sell: ");
        
        Scanner sell = new Scanner(System.in);
        int p = sell.nextInt();
        Product product =  productList.get(p-1);
        System.out.print("How many "+ product.getProductName()+" you want to sell: ");
        int inventory = sell.nextInt();
        
        if(inventory<=product.getAvailableProduct()){
            product.setAvailableProduct(-inventory);
            balance += product.getSellPrice() * inventory;
            product.setTotalProfit(inventory);
        }
        else
            System.out.println("Stock Out.");
        
    }
    
    public static void listProduct(){
        for(int i=0; i<productList.size();i++){
            Product product = productList.get(i);
            System.out.println("Name of the product: "+product.getProductName());
            System.out.println("Available product: "+product.getAvailableProduct());
            System.out.println("Total profit of the product: "+product.getTotalProfit()+"\n");
        }
    }
    
    public static void availableBalance(){
        System.out.println("Available Balance: "+ balance);
    }
    
    public static void getList(){
        System.out.println("Product List:");
        for(int i=0;i<productList.size();i++){
            System.out.println(i+1 + ": "+productList.get(i).getProductName());
        }
    }
}
