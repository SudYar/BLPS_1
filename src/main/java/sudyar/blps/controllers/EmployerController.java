package sudyar.blps.controllers;


import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import sudyar.blps.dto.request.OrderingRequest;
import sudyar.blps.dto.response.InfoResponse;
import sudyar.blps.entity.Ordering;
import sudyar.blps.service.OrderService;
import sudyar.blps.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/employer")
public class EmployerController {

    Logger logger = LoggerFactory.getLogger(EmployerController.class);

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @GetMapping("/infoOrder")
    public InfoResponse getInfo(){
        return new InfoResponse(OrderingRequest.getInfo(), 0);
    }

    @PostMapping("/newOrder")
    public InfoResponse newOrder(@RequestBody OrderingRequest order){
        String login = SecurityContextHolder.getContext().getAuthentication().getName();
        logger.warn(login);
        orderService.createOrdering(order, login);
        return new InfoResponse("Success", 0);
    }

    @DeleteMapping("/deleteOrder")
    public InfoResponse deleteById(@RequestBody Integer idOrdering){
        Optional<Ordering> order = orderService.getById(idOrdering);
        if (order.isPresent()) {
            Ordering ordering = order.get();
            String login = SecurityContextHolder.getContext().getAuthentication().getName();
            if (login.equals(ordering.getOwnerLogin())){
                orderService.deleteOrdering(idOrdering);
                return new InfoResponse("Удален заказ: " + ordering.toString(), 0);
            }
            else return new InfoResponse("Вы не владелец данного заказа", 1);
        }
        else   return new InfoResponse("Нет заказа с таким id", 1);
    }
}
