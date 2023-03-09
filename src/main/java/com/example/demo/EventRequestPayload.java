package com.example.demo;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.UUID;

@Data
public class EventRequestPayload implements Serializable {

    @NotNull(message = "geminiRequestKey cannot be null")
    @Size(min = 36, max = 36, message
            = "geminiRequestKey must be 36 characters")
    private UUID geminiRequestKey;

    @Size(min = 0, max = 200, message
            = "eventMasterKey must be between 0 and ... characters")
    private Long eventMasterKey;

    @Size(min = 0, max = 200, message
            = "clientKey must be between 0 and ... characters")
    private Long clientKey;

    @Size(min = 0, max = 200, message
            = "payerKey must be between 0 and ... characters")
    private Long payerKey;

    @NotNull
    @Size(min = 0, max = 80, message
            = "employerGroupName must be between 0 and 80 characters")
    private String employerGroupName;
    private Double totalIncludedAmount;

    @Size(min = 0, max = 1677715, message
            = "employerGroupName must be between 0 and 1677715 characters")
    private String diagnosisCodes;

    @Size(min = 0, max = 20, message
            = "employerGroupName must be between 0 and 20 characters")
    private String sourceSystem;

}
