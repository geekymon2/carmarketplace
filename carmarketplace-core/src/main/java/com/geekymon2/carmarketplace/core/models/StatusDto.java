package com.geekymon2.carmarketplace.core.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusDto implements Serializable {
    private String environment;
    private String version;
    private String hostname;
    private String description;
}
