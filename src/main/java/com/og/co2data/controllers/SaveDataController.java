package com.og.co2data.controllers;

import com.og.co2data.model.CO2Data;
import com.og.co2data.model.CO2DataTmp;
import com.og.co2data.repository.CO2DataRepository;
import com.og.co2data.repository.CO2DataTmpRepository;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

@Named(value = "saveDataController")
@SessionScoped
public class SaveDataController implements Serializable {
    private static final Logger logger = LogManager.getLogger(SaveDataController.class);


    @Inject
    CO2DataTmpRepository co2Tmprepo;

    @Inject
    LoginController lc;

    private static final long serialVersionUID = 1L;

    private String Country;
    private Integer Year;
    private String CO2;

    public SaveDataController() {

    }

    public String save() {
        co2Tmprepo.findAll().forEach(tmp -> co2Tmprepo.save(tmp));
        co2Tmprepo.deleteAll();
        return "savedata";
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public Integer getYear() {
        return Year;
    }

    public void setYear(Integer year) {
        Year = year;
    }

    public String getCO2() {
        return CO2;
    }

    public void setCO2(String CO2) {
        this.CO2 = CO2;
    }

    public String processForm() throws IOException {
        CO2DataTmp co2DataTmp = co2Tmprepo.insert(new CO2DataTmp(Country, Year, CO2));
        logger.info(co2DataTmp.toString());
        return "savetmpdata";
    }


}