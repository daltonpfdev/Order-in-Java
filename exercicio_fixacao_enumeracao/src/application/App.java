package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class App {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		
		System.out.println("Enter cliente data: ");
		System.out.print("Name: ");
		String name = sc.nextLine();
		
		System.out.print("Email: ");
		String email = sc.nextLine();
		
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.nextLine());
		
		System.out.println("Enter Order Data:");
		System.out.print("Status: ");
		String status = sc.nextLine();
		
		Client cliente = new Client(name, email, birthDate);
		
		Order order = new Order(cliente, birthDate, OrderStatus.valueOf(status));
		
		System.out.println();
		
		System.out.print("How many items to this order: ");
		int quantidadeDeItens = sc.nextInt();
		
		for (int item = 0; item < quantidadeDeItens; item++) {
			
			System.out.println("Enter #" + (item+1) + "item data:");
			
			System.out.print("Product name: ");
			
			if (item == 0) {
				sc.nextLine();
			}
			
			String productName = sc.nextLine();
			
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();
			
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			
			if (item == 0) {
				sc.nextLine();
			}
			
			Product product = new Product(productName, productPrice);
			
			OrderItem orderItem = new OrderItem(product, quantity, productPrice);
			
			order.addItem(orderItem);
		}
		
		System.out.println();
		
		System.out.println("ORDER SUMMARY");
		
		System.out.println("Order status: " + order.getOrderStatus());
		
		System.out.println("Client: " + order.getClient().getName() + " - " + order.getClient().getEmail());
		
		System.out.println("Order items: ");
		
		for (int i = 0; i < quantidadeDeItens; i++) {
			
			System.out.println(order.getItems().get(i).getProduct().getName() + ", " + order.getItems().get(i).getProduct().getPrice() + "Quantity: " + order.getItems().get(i).getQuantity() + ", Subtotal: $" + order.getItems().get(i).subTotal());
			System.out.println("Total price: $" + order.total());
		}
		
	}

}
