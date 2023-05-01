package sudyar.blps.service;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.data.util.*;
import sudyar.blps.dto.request.OrderingRequest;
import sudyar.blps.dto.response.OrdersResponse;
import sudyar.blps.entity.Ordering;
import sudyar.blps.entity.User;
import sudyar.blps.repo.OrderRepository;

import java.util.Date;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public OrdersResponse getAll(){
        final var res = new OrdersResponse(orderRepository.findAll().stream().toList());
        return res;
    }

    public OrdersResponse getAllByOwner(String loginOwner){
        final var res = new OrdersResponse(orderRepository.findByOwnerLogin(loginOwner).stream().toList());
        return res;
    }

    public Optional<Ordering> getById(Integer idOrdering){
        return orderRepository.findById(idOrdering);
    }

    public void createOrdering(@NonNull OrderingRequest orderingRequest, String owner){
        final var newOrder = new Ordering();
        newOrder.setAddress(orderingRequest.getAddress());
        newOrder.setDescription(orderingRequest.getDescription());
        newOrder.setPrice(orderingRequest.getPrice());
        newOrder.setOwnerLogin(owner);
        orderRepository.save(newOrder);
    }

    public void deleteOrdering(int idOrdering){
        orderRepository.deleteById(idOrdering);
    }

    public int deleteAllOrdering(String loginOwner){
        return (int) orderRepository.deleteAllByOwnerLogin(loginOwner);
    }

}
