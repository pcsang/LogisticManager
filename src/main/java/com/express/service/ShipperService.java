package com.express.service;

import com.express.model.entities.Account;
import com.express.model.entities.Partner;
import com.express.model.entities.Shipper;
import com.express.repository.AccountRepository;
import com.express.repository.PartnerRepository;
import com.express.repository.ShipperDetailsRepository;
import com.express.repository.ShipperRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Transactional
    public Shipper saveShipper(Shipper shipperRequest) {
        log.info("Mapping data for Shipper ọbject");
        Shipper shipper = new Shipper();
        shipper.setRoles(shipperRequest.getRoles());
        shipper.setDetails(shipperRequest.getDetails());
        log.info("Mapping data for Account ọbject");
        List<Account> accounts = new ArrayList<>();
        for(Account ac: shipperRequest.getAccounts()) {
            ac.setShippers(shipper);
            accounts.add(ac);
        }
        log.info("Mapping data for Partner ọbject");
        List<Partner> partners = new ArrayList<>();
        for(Partner p : shipperRequest.getPartners()) {
            p.setShippers(shipper);
            partners.add(p);
        }
        log.info("Mapping data for Shipper ọbject to save");
        shipper.setAccounts(accounts);
        shipper.setPartners(partners);

        log.info("Save Shipper into database");
        Shipper shipperSaved = shipperRepository.save(shipper);
        return shipperSaved;
    }
}
