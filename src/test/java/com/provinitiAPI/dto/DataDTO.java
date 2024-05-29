package com.provinitiAPI.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@FieldDefaults(level = PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
// import com.fasterxml.jackson.databind.ObjectMapper; // version 2.11.1
// import com.fasterxml.jackson.annotation.JsonProperty; // version 2.11.1
/* ObjectMapper om = new ObjectMapper();
Root[] root = om.readValue(myJsonString, Root[].class); */

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataDTO{





    @JsonProperty("Year")
    public Integer Year;





    @JsonProperty("cPU_model")
    public String cPU_model;


    @JsonProperty("hard_disk_size")
    public String hard_disk_size;


    @JsonProperty("strap_Colour")
    public String strap_Colour;


    @JsonProperty("case_Size")
    public String case_Size;


    @JsonProperty("Color")
    public String Color;



    @JsonProperty("Description")
    public String Description;


    public int capacity_GB;

    @JsonProperty("Capacity")
    public String Capacity;


    @JsonProperty("screen_size1")
    public double screen_size1;


    @JsonProperty("Generation")
    public String Generation;

    public double price1;
    @JsonProperty("Price")
    public String Price;


}


