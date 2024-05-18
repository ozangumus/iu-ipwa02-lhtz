package com.og.co2data;

import com.og.co2data.repository.LoginUserRepository;
import com.og.co2data.model.CO2Data;
import com.og.co2data.model.db.LoginUser;
import com.og.co2data.repository.CO2DataRepository;
import jakarta.inject.Inject;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;


@WebListener
public class CO2DataApplicationListener implements ServletContextListener {
    private static final Logger logger = LogManager.getLogger(CO2DataApplicationListener.class);

    @Inject
    CO2DataRepository co2repo;
    @Inject
    LoginUserRepository userRepo;

    public void contextInitialized(ServletContextEvent event) {
        //createUsers();
        //createData();
    }

    public void contextDestroyed(ServletContextEvent event) {
        // Do stuff during webapp's shutdown.
    }

    private void createData() {
        List<CO2Data> co2DataList = new ArrayList<>();
        co2DataList.add(new CO2Data("Pakistan", 2024, "15.2345"));
        co2DataList.add(new CO2Data("Germany", 2023, "30.123"));
        co2DataList.add(new CO2Data("UK", 2024, "50.875"));

        co2DataList.stream().map(data -> co2repo.save(data))
                .forEach(data -> logger.info("co2 data saved:{}", data));
    }

    private void createUsers() {
        List<LoginUser> users = new ArrayList<>();
        users.add(new LoginUser("Ozan", "passwordOzan123", "ozan@gmail.com", "Germany"));


        users.stream().map(user -> userRepo.save(user))
                .forEach(user -> logger.info("user saved:{}", user));

    }


}


