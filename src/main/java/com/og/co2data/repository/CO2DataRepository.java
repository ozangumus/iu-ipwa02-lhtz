package com.og.co2data.repository;

import com.og.co2data.model.CO2Data;
import com.og.co2data.model.db.LoginUser;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;
import java.util.List;

@Stateless
public class CO2DataRepository implements Serializable {
    @PersistenceContext
    EntityManager em;

    public List<CO2Data> findAll() {
        return em.createQuery("select d from CO2Data d where d.year = 2022", CO2Data.class).getResultList();
    }

    public CO2Data getLastCountryCO2(String country) {
        TypedQuery<CO2Data> q = em.createQuery("SELECT d FROM CO2Data d where d.country=:country and d.year=(Select max(m.year) from CO2Data m where m.country=:country)", CO2Data.class);
        q.setParameter("country", country);
        return q.getResultList().stream().findFirst().orElse(null);

    }

    public CO2Data save(CO2Data data) {
        em.persist(data);
        em.flush();
        return data;
    }

}
