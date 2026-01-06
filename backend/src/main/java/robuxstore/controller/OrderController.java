package robuxstore.controller;

import robuxstore.dto.PurchaseRequest;
import robuxstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
@CrossOrigin(origins = "*") // Разрешаем запросы с любого источника (для локальной разработки)
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/buy")
    public ResponseEntity<String> buyRobux(@RequestBody PurchaseRequest request) {
        try {
            orderService.processOrder(request);
            return ResponseEntity.ok("Покупка успешно оформлена! Робуксы скоро придут.");
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Ошибка при обработке заказа.");
        }
    }
}