package com.og.co2data.repository;

import com.og.co2data.model.db.LoginUser;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import java.io.Serializable;

@Stateless
public class LoginUserRepository implements Serializable {
    @PersistenceContext
    EntityManager em;

    public LoginUser authenticate(LoginUser user) {
        TypedQuery<LoginUser> q = em.createQuery("SELECT u FROM LoginUser u where u.username=:username and u.password=:password", LoginUser.class);
        q.setParameter("username", user.getUsername());
        q.setParameter("password", user.getPassword());
        return q.getSingleResult();
    }

    public LoginUser save(LoginUser u) {
        em.persist(u);
        return u;
    }

}
