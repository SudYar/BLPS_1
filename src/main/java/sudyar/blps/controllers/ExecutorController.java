package sudyar.blps.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sudyar.blps.dto.response.InfoResponse;
import sudyar.blps.service.OrderService;

@RestController
@RequestMapping("/executor")
public class ExecutorController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public InfoResponse showInfo(){
        String ORDERS_INFO = "Получить вcе заказы: /executor/orders";
        return new InfoResponse(ORDERS_INFO,1);
    }

    @GetMapping("/orders")
    public ResponseEntity<?> getOrders(){
        return ResponseEntity.ok(orderService.getAll());
    }
}
