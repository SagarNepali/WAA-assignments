package com.waa.lab6.logger.exception.service;

import com.waa.lab6.exception.domain.DataNotFoundException;
import com.waa.lab6.logger.exception.repository.ExceptionLoggerRepository;
import com.waa.lab6.logger.exception.domain.ExceptionLogger;
import com.waa.lab6.user.domain.User;
import com.waa.lab6.user.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExceptionLoggerServiceImpl implements ExceptionLoggerService {

    @Autowired
    private ExceptionLoggerRepository exceptionLoggerRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ExceptionLoggerServiceImpl(ExceptionLoggerRepository exceptionLoggerRepository){
        this.exceptionLoggerRepository = exceptionLoggerRepository;
    }

    @Override
    public void save(ExceptionLogger exceptionLogger) throws DataNotFoundException {
        exceptionLogger.setUser(modelMapper.map(userService.getById(Long.valueOf(2)), User.class));
        exceptionLoggerRepository.save(exceptionLogger);
    }
}
