package entities;

public class Product {
    private String name;
    private Double price;
    public Product(){

    }

    public Product(String name, double price){
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}