package com.waa.lab5.logger.exception.service;

import com.waa.lab5.exception.domain.DataNotFoundException;
import com.waa.lab5.logger.exception.domain.ExceptionLogger;

public interface ExceptionLoggerService {

    void save(ExceptionLogger logger) throws DataNotFoundException;
}
