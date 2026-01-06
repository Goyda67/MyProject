package robuxstore.dto;

import lombok.Data;

@Data
public class PurchaseRequest {
	private String username;
	private int robuxAmount;
	private double price;

	// Данные карты
	private String cardNumber;
	private String cardHolder;
	private String expiryDate;
	private String cvv; // Приходит с фронта, но не пойдет в БД
}