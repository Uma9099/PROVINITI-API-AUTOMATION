package com.provinitiAPI.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@lombok.Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RootDTO {


        public String id;
        public String name;
        public DataDTO data;
    }

