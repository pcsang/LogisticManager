package com.express.controller;

import com.express.model.entities.Account;
import com.express.model.entities.Partner;
import com.express.model.entities.Shipper;
import com.express.service.ShipperService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/shipper/api/v1")
@Slf4j
public class ShipperController {
    private final ShipperService shipperService;

    /**
     * Constructor of ShipperController
     * @param shipperService shipperService
     */
    @Autowired
    public ShipperController(ShipperService shipperService) {
        this.shipperService = shipperService;
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(@RequestParam(required = false) Integer id){
        log.info("GET url: {}", "shipper/api/v1/accounts");
        return shipperService.getAllAccounts();
    }

    @PostMapping("/account")
    public Account postAccount(@RequestBody Account account) {
        log.info("POST url: {}", "shipper/api/v1/account");
        return shipperService.saveAccount(account);
    }

    @GetMapping("/partners")
    public List<Partner> getAllPartners() {
        log.info("GET url: {}", "shipper/api/v1/partners");
        return shipperService.getAllPartners();
    }

    @PostMapping("/partner")
    public Partner postPartner(@RequestBody Partner partner) {
        log.info("POST url: {}", "shipper/api/v1/partner");
        return shipperService.savePartner(partner);
    }

    @GetMapping("/shippers")
    public List<Shipper> getAllShippers() {
        log.info("GET url: {}", "shipper/api/v1/shippers");
        return shipperService.getAllShippers();
    }

    @PostMapping("/shipper")
    public Shipper postShipper(@RequestBody Shipper shipper) {
        log.info("POST url: {}", "shipper/api/v1/shipper");
        return shipperService.saveShipper(shipper);
    }
}
