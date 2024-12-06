package com.threemtt.vmis.controller;

import com.threemtt.vmis.dto.request.IncidentRequest;
import com.threemtt.vmis.dto.response.IncidentResponse;
import com.threemtt.vmis.model.Car;
import com.threemtt.vmis.model.Incident;
import com.threemtt.vmis.service.IncidentServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/incidents/report")
public class IncidentController {

    private final IncidentServiceImpl incidentService;

    @PostMapping
    public ResponseEntity<IncidentResponse> incidentReport(@Valid @RequestBody IncidentRequest incidentRequest) throws Exception {
        return new ResponseEntity<>(incidentService.witnessIncidentReport(incidentRequest), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Incident>> getAllCars(){
        return new ResponseEntity<>(incidentService.incidents(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<Optional<Incident>> findACar(@RequestParam Long id){
        return new ResponseEntity<>(incidentService.findIncident(id), HttpStatus.OK);
    }
}
