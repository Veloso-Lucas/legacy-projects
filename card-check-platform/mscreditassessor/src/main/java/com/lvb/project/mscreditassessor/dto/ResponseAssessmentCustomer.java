package com.lvb.project.mscreditassessor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseAssessmentCustomer {

    private List<ApprovedCard> approvedCard;
}
