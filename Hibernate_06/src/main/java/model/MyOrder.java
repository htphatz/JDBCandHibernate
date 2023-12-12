package model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class MyOrder {
	@Id
	private String orderId;
	private String address;
	@ManyToOne
	@JoinColumn(name = "customerId")
	private Customer customer;
	
	public MyOrder() {
		// TODO Auto-generated constructor stub
	}

	public MyOrder(String orderId, String address, Customer customer) {
		super();
		this.orderId = orderId;
		this.address = address;
		this.customer = customer;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	@Override
	public String toString() {
		return "MyOrder [orderId=" + orderId + ", address=" + address + ", customer=" + customer.getName() + "]";
	}
	
}
