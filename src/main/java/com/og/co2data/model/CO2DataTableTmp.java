package com.og.co2data.model;

import com.og.co2data.repository.CO2DataRepository;
import com.og.co2data.repository.CO2DataTmpRepository;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.List;

@RequestScoped
@Named("co2data_table_tmp")
public class CO2DataTableTmp implements Serializable {
    private static final Logger logger = LogManager.getLogger(CO2DataTableTmp.class);
    //private List<CO2DataTmp> co2DataTmpList;
    @Inject
    CO2DataTmpRepository repo;

    public List<CO2DataTmp> getCo2DataTmpList() {
        logger.info("Get all tmp entries from the database.");
        return repo.findAll();
    }
}
