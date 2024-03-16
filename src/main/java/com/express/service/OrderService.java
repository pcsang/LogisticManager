package com.express.service;

import com.express.model.OrderRequest;
import com.express.model.entities.Good;
import com.express.model.entities.Order;
import com.express.model.entities.Packages;
import com.express.model.entities.Sender;
import com.express.model.entities.Shipper;
import com.express.repository.GoodRepository;
import com.express.repository.OrderRepository;
import com.express.repository.PackagesRepository;
import com.express.repository.ReceiverRepository;
import com.express.repository.SenderRepository;
import com.express.repository.ShipperRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class OrderService {
    private final SenderRepository senderRepository;
    private final ReceiverRepository receiverRepository;
    private final PackagesRepository packagesRepository;
    private final GoodRepository goodRepository;
    private final OrderRepository orderRepository;
    private final ShipperService shipperService;
    private final ShipperRepository shipperRepository;

    /**
     * Constructor of OrderService
     *
     * @param senderRepository   senderRepository
     * @param receiverRepository receiverRepository
     * @param packagesRepository packagesRepository
     * @param goodRepository     goodRepository
     * @param orderRepository    orderRepository
     * @param shipperService     shipperService
     * @param shipperRepository  shipperRepository
     */
    @Autowired
    public OrderService(SenderRepository senderRepository,
                        ReceiverRepository receiverRepository,
                        PackagesRepository packagesRepository,
                        GoodRepository goodRepository,
                        OrderRepository orderRepository,
                        ShipperService shipperService,
                        ShipperRepository shipperRepository) {
        this.senderRepository = senderRepository;
        this.receiverRepository = receiverRepository;
        this.packagesRepository = packagesRepository;
        this.goodRepository = goodRepository;
        this.orderRepository = orderRepository;
        this.shipperService = shipperService;
        this.shipperRepository = shipperRepository;
    }

    public List<Good> getAllGoods() {
        return goodRepository.findAll();
    }

    public List<Packages> getAllPackages() {
        return packagesRepository.findAll();
    }

    @SneakyThrows
    public Order postOrder(OrderRequest orderRequest) {
        LocalDateTime currentDate = LocalDateTime.now();
        log.info("Time create order: {}", currentDate);

        Shipper shipper = shipperService.getShipperById(orderRequest.getShippers().getId());
        log.info("Order is delivered by Shipper: {}", shipper.getId());

        Sender sender = orderRequest.getSender();
        log.info("Save Sender to database");
        Sender senderSaved = senderRepository.save(sender);

        Order order = new Order();
        order.setNumberOfPackage(orderRequest.getPackages().size());
        order.setPayStatus(orderRequest.getPayStatus());
        order.setSentDate(currentDate);
        order.setStatus(orderRequest.getStatus());
        order.setReceivers(orderRequest.getReceivers());
        order.setShippers(shipper);
        order.setSender(senderSaved);
        log.info("Save Order to database");
        Order orderSaved = orderRepository.save(order);

        log.info("Save Package to database");
        List<Packages> packagesList = new ArrayList<>();
        for(Packages p : orderRequest.getPackages()) {
            List<Good> goodList = new ArrayList<>();
            for(Good g : p.getGoods()) {
                g.setPackages(p);
                goodList.add(g);
            }
            p.setGoods(goodList);
            p.setOrders(orderSaved);
            packagesList.add(p);
        }
        List<Packages> packagesSaved = packagesRepository.saveAll(packagesList);
        log.info("Saved packages to database");
        order.setPackages(packagesSaved);

        return order;
    }
}
