package com.threemtt.vmis.service;


import com.threemtt.vmis.dto.response.IncidentResponse;
import com.threemtt.vmis.enums.ReportReason;
import com.threemtt.vmis.model.Car;
import com.threemtt.vmis.model.Incident;
import com.threemtt.vmis.model.Officer;
import com.threemtt.vmis.repository.IncidentRepository;
import com.threemtt.vmis.repository.OfficerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import com.threemtt.vmis.dto.request.IncidentRequest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class IncidentServiceImpl implements IncidentService {

    private final IncidentRepository incidentRepository;
    private final OfficerRepository officerRepository;
    private static final Logger LOG = Logger.getLogger(IncidentServiceImpl.class.getName());
    private static String AVAILABLE;
    private static String UNAVAILABLE;

    public ReportReason getReportReason(String reportReason) {
        return reportReason.equalsIgnoreCase("Stolen") ? ReportReason.THEFT : ReportReason.SUSPICIOUS_ACTIVITY;
    }

    @Override
    public IncidentResponse witnessIncidentReport(IncidentRequest incidentRequest) throws Exception {

        Incident incident = new Incident();

        incident.setDescription(incidentRequest.getDescription());
        incident.setLocation(incidentRequest.getLocation());
        incident.setPlateNumber(incidentRequest.getPlateNumber());
        incident.setWitness(incidentRequest.getWitness());
        incident.setReporterPhoneNumber(incidentRequest.getReporterPhoneNumber());
        incident.setReportReason(getReportReason(String.valueOf(incidentRequest.getReportReason())));

        Officer availableOfficer = officerRepository.findByAvailabilityStatus(AVAILABLE);

        if (availableOfficer != null) {
            incident.setOfficer(availableOfficer);
            availableOfficer.getIncidents().add(incident);
            availableOfficer.setAvailabilityStatus(UNAVAILABLE);
        } else {
            throw new Exception("Officers are currently not available. This incident will be attended to when an officer is free.");
        }

        LOG.info("Officer: {} " +availableOfficer.getBadgeNumber());

        IncidentResponse incidentResponse = new IncidentResponse();
        incidentRepository.save(incident);

        BeanUtils.copyProperties(incident, incidentResponse);

        return incidentResponse;
    }

    @Override
    public List<Incident> incidents() {
        return incidentRepository.findAll();
    }


    @Override
    public Optional<Incident> findIncident(Long id) {
        return incidentRepository.findById(id);
    }

}
