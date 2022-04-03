package com.waa.lab4.logger.exception.service;

import com.waa.lab4.exception.domain.DataNotFoundException;
import com.waa.lab4.logger.exception.domain.ExceptionLogger;

public interface ExceptionLoggerService {

    void save(ExceptionLogger logger) throws DataNotFoundException;
}
