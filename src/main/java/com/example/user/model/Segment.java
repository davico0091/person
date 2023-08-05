package com.example.user.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Segment {
    private String idSegmentTerm;
    private String segment;
    private String segmentCode;
    private String description;
}
