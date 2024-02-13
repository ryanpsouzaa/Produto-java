package entities;
import java.util.ArrayList;

public class OrderItem {
    private Integer quantity;
    private Double price;

    private Product product;
    public OrderItem(){

    }

    public OrderItem(int quantity, double price, Product product){
        this.quantity = quantity;
        this.price = price;
        this.product = product;
    }

    public double subTotal(){
        return quantity * price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }

    public Product getProduct() {
        return product;
    }

    public String toString(){
        return product.getName()
                +", $"
                +String.format("%.2f",getPrice())
                +", Quantity: "
                +getQuantity()
                +", Subtotal: "
                +String.format("%.2f",subTotal());
    }
}
