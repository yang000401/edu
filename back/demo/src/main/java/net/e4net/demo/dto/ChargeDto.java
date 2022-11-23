package net.e4net.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ChargeDto {
    private Long chargeAmt;
    private String chargeMean;
}
