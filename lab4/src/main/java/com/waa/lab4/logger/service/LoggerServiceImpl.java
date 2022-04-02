package com.waa.lab4.logger.service;

import com.waa.lab4.logger.domain.Logger;
import com.waa.lab4.logger.repository.LoggerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService{

    private LoggerRepository loggerRepository;

    @Autowired
    public LoggerServiceImpl(LoggerRepository loggerRepository){
        this.loggerRepository = loggerRepository;
    }

    @Override
    public void save(Logger logger) {

    }
}
