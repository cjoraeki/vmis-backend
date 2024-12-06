package com.threemtt.vmis.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarRequest {

    private String carModel;

    private String plateNumber;

    private String carOwner;

    private String nin;

    private String driversLicense;

    private String description;

    private String engineNumber;

    private Integer yearOfManufacture;

    private String color;

    private Boolean flagged;
}
