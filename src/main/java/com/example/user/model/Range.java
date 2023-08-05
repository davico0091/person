package com.example.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Range {
    private String idRange;
    private int coin;
    private Currency currency;
    private double minimum;
    private double maximum;

}
