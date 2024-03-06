package com.express.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderRequest {
    private OrderDTO order;
    private CustomerOrderDTO customerOrderDTO;
    private ReceiverDTO receiverDTO;

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public CustomerOrderDTO getCustomerOrderDTO() {
        return customerOrderDTO;
    }

    public void setCustomerOrderDTO(CustomerOrderDTO customerOrderDTO) {
        this.customerOrderDTO = customerOrderDTO;
    }

    public ReceiverDTO getReceiverDTO() {
        return receiverDTO;
    }

    public void setReceiverDTO(ReceiverDTO receiverDTO) {
        this.receiverDTO = receiverDTO;
    }
}
