package com.threemtt.vmis.dto.request;

import com.threemtt.vmis.enums.ReportReason;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class IncidentRequest {

    private String description;

    private String location;

    private String plateNumber;

    private String witness;

    private String reporterPhoneNumber;

    private ReportReason reportReason;

    private LocalDateTime updatedAt;
}
