package com.waa.lab5.logger.logger.service;

import com.waa.lab5.logger.logger.domain.Logger;
import com.waa.lab5.logger.logger.repository.LoggerRepository;
import com.waa.lab5.user.domain.User;
import com.waa.lab5.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public void save(Logger logger) throws Exception {
        logger.setUser(modelMapper.map(userService.getById(Long.valueOf(2)), User.class));
        loggerRepository.save(logger);
    }
}
