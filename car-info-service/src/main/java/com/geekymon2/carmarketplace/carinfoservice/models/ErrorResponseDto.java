package com.geekymon2.carmarketplace.carinfoservice.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDto {
    private Date timestamp;
    private int status;
    private String error;
    private List<String> details;
    private String path;
}
