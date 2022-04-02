package com.waa.lab4.logger.service;

import com.waa.lab4.logger.domain.Logger;
import com.waa.lab4.logger.repository.LoggerRepository;
import com.waa.lab4.user.domain.User;
import com.waa.lab4.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

@Service
public class LoggerServiceImpl implements LoggerService{

    private LoggerRepository loggerRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public LoggerServiceImpl(LoggerRepository loggerRepository){
        this.loggerRepository = loggerRepository;
    }

    @Override
    public void save(Logger logger) {
        logger.setUser(modelMapper.map(userService.getById(Long.valueOf(2)), User.class));
        loggerRepository.save(logger);
    }
}
