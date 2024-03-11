package com.express.service;

import com.express.repository.GoodRepository;
import com.express.repository.PackagesRepository;
import com.express.repository.ReceiverRepository;
import com.express.repository.SenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final SenderRepository senderRepository;
    private final ReceiverRepository receiverRepository;
    private final PackagesRepository packagesRepository;
    private final GoodRepository goodRepository;

    /**
     * Constructor of OrderService
     *
     * @param senderRepository      senderRepository
     * @param receiverRepository    receiverRepository
     * @param packagesRepository    packagesRepository
     * @param goodRepository        goodRepository
     */
    @Autowired
    public OrderService(SenderRepository senderRepository,
                        ReceiverRepository receiverRepository,
                        PackagesRepository packagesRepository,
                        GoodRepository goodRepository) {
        this.senderRepository = senderRepository;
        this.receiverRepository = receiverRepository;
        this.packagesRepository = packagesRepository;
        this.goodRepository = goodRepository;
    }
}
