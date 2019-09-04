package com.zsoft.supermarketpricing.models;

import com.zsoft.supermarketpricing.models.enums.Unit;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Price {
    private Unit unit;
    private double value;
}
