package com.threemtt.vmis.service;

import com.threemtt.vmis.dto.request.IncidentRequest;
import com.threemtt.vmis.dto.response.IncidentResponse;
import com.threemtt.vmis.model.Incident;

import java.util.List;
import java.util.Optional;

public interface IncidentService {

    IncidentResponse witnessIncidentReport(IncidentRequest incidentRequest) throws Exception;
    List<Incident> incidents ();
    Optional<Incident> findIncident(Long id);
}
