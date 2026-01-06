package robuxstore.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import robuxstore.dto.PurchaseRequest;
import robuxstore.entity.Order;
import robuxstore.repository.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	public void processOrder(PurchaseRequest request) {
		// 1. Здесь могла бы быть логика отправки данных в банк
		System.out.println("Processing payment for user: " + request.getUsername());
		System.out.println("CVV check passed (mock): " + request.getCvv());

		// 2. Сохраняем данные о заказе в БД
		Order order = new Order();
		order.setUsername(request.getUsername());
		order.setRobuxAmount(request.getRobuxAmount());
		order.setPrice(request.getPrice());

		// Сохраняем номер карты (в реальности нужно хешировать или маскировать!)
		order.setCardNumber(request.getCardNumber());
		order.setCardHolder(request.getCardHolder());
		order.setExpiryDate(request.getExpiryDate());

		orderRepository.save(order);
	}
}