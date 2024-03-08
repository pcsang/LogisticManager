package com.express.service;

import com.express.model.CustomerOrder;
import com.express.model.Order;
import com.express.model.OrderDetails;
import com.express.model.Receiver;
import com.express.model.request.CustomerOrderDTO;
import com.express.model.request.OrderDTO;
import com.express.model.request.OrderRequest;
import com.express.model.request.ReceiverDTO;
import com.express.model.response.OrderInfo;
import com.express.repository.CustomerOrderRepository;
import com.express.repository.OrderRepository;
import com.express.repository.ReceiverRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    private final CustomerOrderRepository customerOrderRepository;
    private final OrderRepository orderRepository;
    private final ReceiverRepository receiverRepository;

    /**
     * Constructor of OrderService
     *
     * @param customerOrderRepository customerOrderRepository
     * @param orderRepository orderRepository
     * @param receiverRepository receiverRepository
     */
    @Autowired
    public OrderService(CustomerOrderRepository customerOrderRepository,
                        OrderRepository orderRepository,
                        ReceiverRepository receiverRepository) {
        this.customerOrderRepository = customerOrderRepository;
        this.orderRepository = orderRepository;
        this.receiverRepository = receiverRepository;
    }

    public OrderInfo postOrder(OrderRequest orderRequest) {
        //TODO need to insert data into tables relationship foreign key with main table
        //receiver, CustomerOrder, etc..
        // order
        String id = UUID.randomUUID().toString();

        //Save CustomerOrder
        CustomerOrderDTO customerOrderDTO = orderRequest.getCustomerOrderDTO();
        CustomerOrder customerOrder = new CustomerOrder();
        BeanUtils.copyProperties(customerOrderDTO, customerOrder);
        customerOrder.setId("CO-" + id);
        customerOrderDTO.setId("CO-" + id);
        customerOrderRepository.save(customerOrder);

        //Save Receiver
        ReceiverDTO receiverDTO = orderRequest.getReceiverDTO();
        Receiver receiver = new Receiver();
        BeanUtils.copyProperties(receiverDTO, receiver);
        receiver.setId("R-" + id);
        receiverDTO.setId("R-" + id);
        receiverRepository.save(receiver);

        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setId(id);
        orderDetails.setPrice(100);

        //Save order
        OrderDTO orderDTO = orderRequest.getOrder();
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        order.setId(id);
        orderDTO.setId(id);
        order.setCustomerOrder(customerOrder);
        order.setReceiver(receiver);
        order.setOrderDetails(orderDetails);
        orderRepository.save(order);

        //Mapping order info
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCustomerOrderDTO(customerOrderDTO);
        orderInfo.setReceiverDTO(receiverDTO);
        orderInfo.setOrder(orderDTO);

        return orderInfo;
    }
}
