package robuxstore.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data // Lombok генерирует геттеры, сеттеры и конструкторы
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username; // Никнейм в Roblox
	private int robuxAmount; // Количество робуксов
	private double price; // Цена покупки

	// Данные карты (В реальности хранят только последние 4 цифры или токен)
	private String cardNumber;
	private String cardHolder;
	private String expiryDate;

	// CVV поле мы намеренно не добавляем в Entity, чтобы не хранить его в БД.

	private LocalDateTime purchaseTime;

	@PrePersist
	protected void onCreate() {
		this.purchaseTime = LocalDateTime.now();
	}
}