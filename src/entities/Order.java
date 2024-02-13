package entities;

import entities.nums.OrderStatus;
import entities.OrderItem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private static DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private LocalDateTime moment;
    private OrderStatus status;
    private Client client;

    private List<OrderItem> items = new ArrayList<>();
    public Order(){

    }

    public Order(LocalDateTime moment, OrderStatus status, Client client){
        this.moment = moment;
        this.status = status;
        this.client = client;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public LocalDateTime getMoment() {
        return moment;
    }

    public void setMoment(LocalDateTime moment) {
        this.moment = moment;
    }

    public List<OrderItem> getItems() {
        return items;
    }
    public void addItem(OrderItem item){
        items.add(item);
    }
    public void removeItem(OrderItem item){
        items.remove(item);
    }
    public double total(){
        double soma = 0.0;
        for (OrderItem it : items) {
            soma += it.subTotal();
        }//fim do for
        return soma;
    }
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Order moment: ");
        sb.append(fmt1.format(getMoment()) + "\n");
        sb.append("Order status: ");
        sb.append(getStatus() + "\n");
        sb.append("Client: ");
        sb.append(client + "\n");
        sb.append("Order items: \n");
        for (OrderItem item : items){
            sb.append(item + "\n");
        }
        sb.append("Total Price: $");
        sb.append(String.format("%.2f", total()));
        return sb.toString();
    }
}
