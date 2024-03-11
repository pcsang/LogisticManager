package com.express.service;

import com.express.model.entities.Account;
import com.express.model.entities.Partner;
import com.express.model.entities.Shipper;
import com.express.model.entities.ShipperDetails;
import com.express.repository.AccountRepository;
import com.express.repository.PartnerRepository;
import com.express.repository.ShipperDetailsRepository;
import com.express.repository.ShipperRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ShipperService {
    private final AccountRepository accountRepository;
    private final PartnerRepository partnerRepository;
    private final ShipperDetailsRepository shipperDetailsRepository;
    private final ShipperRepository shipperRepository;

    /**
     * Construtor of ShipperService
     *
     * @param accountRepository         accountRepository
     * @param partnerRepository         partnerRepository
     * @param shipperDetailsRepository  shipperDetailsRepository
     * @param shipperRepository         shipperRepository
     */
    @Autowired
    public ShipperService(AccountRepository accountRepository,
                          PartnerRepository partnerRepository,
                          ShipperDetailsRepository shipperDetailsRepository,
                          ShipperRepository shipperRepository) {
        this.accountRepository = accountRepository;
        this.partnerRepository = partnerRepository;
        this.shipperDetailsRepository = shipperDetailsRepository;
        this.shipperRepository = shipperRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account saveAccount(Account account) {
        log.info("Save Account into database: {}", account.toString());
        return accountRepository.save(account);
    }

    public List<Partner> getAllPartners() {
        return partnerRepository.findAll();
    }

    public Partner savePartner(Partner partner) {
        log.info("Save Partner into database: {}", partner.toString());
        return partnerRepository.save(partner);
    }

    public List<Shipper> getAllShippers()  {
        return shipperRepository.findAll();
    }

    public Shipper getShipperById(Integer id) {
        return shipperRepository.getReferenceById(id);
    }

    public Shipper saveShipper(Shipper shipper) {
        log.info("Save Shipper into database: {}", shipper.toString());
        //save ShipperDetails in Shipper
        ShipperDetails shipperDetails = shipperDetailsRepository.save(shipper.getDetails());
        return shipperRepository.save(shipper);
    }
}
