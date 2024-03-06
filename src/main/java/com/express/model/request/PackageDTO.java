package com.express.model.request;

import com.express.model.DeliveryService;
import com.express.model.Order;
import com.express.model.PackageDetails;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class PackageDTO {
    private String id;
    private String name;
    private PackageDetails packageDetails;
    private Order order;
    private DeliveryService deliveryService;
}
