package application;
import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.nums.OrderStatus;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Pedido {
    public static void main(String[]args){
        DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        Locale.setDefault(Locale.US);
        Scanner resp = new Scanner(System.in);

        System.out.println("Enter Client Data:");
        System.out.print("Name: ");
        String nome = resp.nextLine();

        System.out.print("Email: ");
        String email = resp.nextLine();

        System.out.print("Birth date (dd/mm/yyyy) : ");
        String data = resp.nextLine();
        LocalDate dt01 = LocalDate.parse(data, fmt1);

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        String statusString = resp.nextLine();

        Client cliente = new Client(nome, email, LocalDate.parse(data,fmt1));

        LocalDateTime dt02 = LocalDateTime.now();
        Order items = new Order(LocalDateTime.now(),OrderStatus.valueOf(statusString), cliente);


        System.out.print("How many items to this order? ");
        int contador = resp.nextInt();
        for (int k = 0; k < contador; k++) {

            System.out.printf("Enter #%d item data: \n", (k+1));
            System.out.print("Product name: ");
            resp.nextLine();

            String nomeProduto = resp.next();

            System.out.print("Product price: ");
            double precoProduto = resp.nextDouble();

            System.out.print("Product quantity: ");
            int quantProduto = resp.nextInt();

            Product product = new Product(nomeProduto, precoProduto);

            OrderItem item = new OrderItem(quantProduto, precoProduto, product);

            items.addItem(item);

        }
        System.out.println("ORDER SUMARY:");
        System.out.println(items);
        resp.close();

    }
}
