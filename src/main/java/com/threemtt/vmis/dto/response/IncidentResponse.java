package com.threemtt.vmis.dto.response;


import com.threemtt.vmis.enums.ReportReason;

import com.threemtt.vmis.model.Officer;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class IncidentResponse {

    private String description;

    private String location;

    private String plateNumber;

    private String witness;

    private String phoneNumber;

    private ReportReason reportReason;

    private LocalDateTime updatedAt;

    private Officer officer;
}
