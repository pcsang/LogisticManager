package com.express.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ReceiverDTO {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNameReceiver() {
        return nameReceiver;
    }

    public void setNameReceiver(String nameReceiver) {
        this.nameReceiver = nameReceiver;
    }

    public String getAddressReceiver() {
        return addressReceiver;
    }

    public void setAddressReceiver(String addressReceiver) {
        this.addressReceiver = addressReceiver;
    }

    public String getNumbersPhoneReceiver() {
        return numbersPhoneReceiver;
    }

    public void setNumbersPhoneReceiver(String numbersPhoneReceiver) {
        this.numbersPhoneReceiver = numbersPhoneReceiver;
    }

    private String id;
    private String nameReceiver;
    private String addressReceiver;
    private String numbersPhoneReceiver;
}
