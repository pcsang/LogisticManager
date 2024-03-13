package com.express.model;

import com.express.model.entities.Packages;
import com.express.model.entities.Receiver;
import com.express.model.entities.Sender;
import com.express.model.entities.Shipper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderRequest {
    private Shipper shippers;
    private Receiver receivers;
    private List<Packages> packages;
    private Sender sender;
    private String status;
    private String payStatus;
}
