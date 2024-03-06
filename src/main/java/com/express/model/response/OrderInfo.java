package com.express.model.response;

import com.express.model.request.CustomerOrderDTO;
import com.express.model.request.OrderDTO;
import com.express.model.request.PackageDTO;
import com.express.model.request.ReceiverDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class OrderInfo {
    private OrderDTO order;
    private CustomerOrderDTO customerOrderDTO;
    private ReceiverDTO receiverDTO;
    private PackageDTO packageDTO;

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

    public PackageDTO getPackageDTO() {
        return packageDTO;
    }

    public void setPackageDTO(PackageDTO packageDTO) {
        this.packageDTO = packageDTO;
    }
}
