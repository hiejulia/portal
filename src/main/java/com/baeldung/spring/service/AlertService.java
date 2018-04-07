package com.baeldung.spring.service;


import java.util.Date;

import org.hibernate.service.spi.ServiceException;


public interface AlertService {

    public void sendAlerts(Date testDate, boolean debug);

    public void generateFines(Date testDate, boolean debug);
}