package entities;

public class OrderItem {
	
	private Product product;
	private Integer quantity;
	private double price;
	
	public OrderItem() {
	}

	public OrderItem(Product product ,Integer quantity, double price) {
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}
	
	public double subTotal() {
		return price * quantity;
	}

	public Product getProduct() {
		return product;
	}
	
}
