package com.epam.ivanou4.vehicle.controller;

import com.epam.ivanou4.vehicle.model.Company;
import com.epam.ivanou4.vehicle.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static com.epam.ivanou4.vehicle.controller.CompanyRestController.REST_URL;

@RestController
@RequestMapping(REST_URL)
public class CompanyRestController {
    public static final String REST_URL = "/rest/company";

    @Autowired
    private CompanyService service;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Company> getAll() {
        return service.getAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Company get(@PathVariable("id") String id) {
        return service.get(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Company> createWithLocation(@RequestBody Company company) {
        Company createdCompany = service.create(company);
        URI uriOfNewResource = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path(REST_URL + "/{id}")
                .buildAndExpand(createdCompany.getId()).toUri();
        return ResponseEntity.created(uriOfNewResource).body(createdCompany);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void update(@RequestBody Company company) {
        service.update(company);
    }

    @DeleteMapping(value = "/{id}")
    public void delete(@PathVariable("id") String id) {
        service.delete(id);
    }
}
