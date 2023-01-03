import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter client data: ");
        System.out.print("Name: ");
        String clientName = scan.nextLine();
        System.out.print("Email: ");
        String clientEmail = scan.next();
        System.out.print("Birth date (DD/MM/YYYY): ");
        Date birthDate = sdf.parse(scan.next());

        System.out.println("Enter order data: ");
        System.out.print("Status: ");
        OrderStatus orderStatus = OrderStatus.valueOf(scan.next());
        Order order = new Order(new Date(), orderStatus, new Client(clientName, clientEmail, birthDate));

        System.out.print("How many items to this order? ");
        int n = scan.nextInt();

        for(int i = 0; i < n; i++){
            System.out.println("Enter "+(i+1)+" item data:");
            System.out.print("Product name: ");
            String productName = scan.next();
            System.out.print("Product price: ");
            double productPrice = scan.nextDouble();
            System.out.print("Quantity: ");
            int productQuantity = scan.nextInt();
            OrderItem it = new OrderItem(productQuantity, productPrice, new Product(productName, productPrice));
            order.addItem(it);
        }
        System.out.println();
        System.out.println(order);

        scan.close();
    }
}