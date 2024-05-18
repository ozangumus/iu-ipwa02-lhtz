package com.og.co2data.repository;

import com.og.co2data.model.CO2Data;
import com.og.co2data.model.CO2DataTmp;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.io.Serializable;
import java.util.List;

@Stateless
public class CO2DataTmpRepository implements Serializable {
    @PersistenceContext
    EntityManager em;

    public List<CO2DataTmp> findAll() {
        return em.createQuery("select d from CO2DataTmp d", CO2DataTmp.class).getResultList();
    }

    public CO2DataTmp insert(CO2DataTmp co2DataTmp) {
        CO2DataTmp n = new CO2DataTmp(co2DataTmp.getCountry(), co2DataTmp.getYear(), co2DataTmp.getCo2());
        em.persist(n);
        em.flush();
        return n;
    }

    public CO2Data save(CO2DataTmp co2DataTmp) {
        CO2Data n = new CO2Data(co2DataTmp.getCountry(), co2DataTmp.getYear(), co2DataTmp.getCo2());
        em.persist(n);
        em.flush();
        return n;
    }

    public void deleteAll(){
        findAll().forEach(t -> em.remove(t));
        em.flush();
    }

}
