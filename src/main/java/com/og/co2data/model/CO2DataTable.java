package com.og.co2data.model;

import com.og.co2data.repository.CO2DataRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named("co2data_table")
public class CO2DataTable {
    private static final Logger logger = LogManager.getLogger(CO2DataTable.class);

    //private List<CO2Data> co2DataList = new ArrayList<>();

    @Inject
    CO2DataRepository repo;

    public List<CO2Data> getCo2DataList() {
        logger.info("Get all entries from the database.");
        return repo.findAll();
    }
}
