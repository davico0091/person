package com.example.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Term {
    private String id;
    private String idTerm;
    private int idTermType;
    private Segment segment;
    private String termDays;
    private Range range;
    private double rate;
    private String penalty;

}
