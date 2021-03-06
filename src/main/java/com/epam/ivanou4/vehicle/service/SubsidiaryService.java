package com.epam.ivanou4.vehicle.service;

import com.epam.ivanou4.vehicle.model.Subsidiary;

import java.util.List;

public interface SubsidiaryService {
    Subsidiary create(Subsidiary subsidiary);

    void update(Subsidiary subsidiary);

    void delete(String id);

    Subsidiary get(String id);

    List<Subsidiary> getAll();

    List<Subsidiary> getByCompanyId(String id);
}
