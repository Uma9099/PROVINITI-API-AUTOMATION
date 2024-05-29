package com.provinitiAPI.dto;

import lombok.Builder;

import java.util.List;
@lombok.Data
@Builder

public class RootSummaryResponseDTO {

    List<RootDTO> ListPhone;
}
