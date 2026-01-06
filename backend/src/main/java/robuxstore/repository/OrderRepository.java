package robuxstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import robuxstore.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	// Можно добавить методы поиска, например: findByUsername(String username);
}