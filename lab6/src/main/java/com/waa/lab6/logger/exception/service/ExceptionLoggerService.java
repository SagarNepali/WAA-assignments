package com.waa.lab6.logger.exception.service;

import com.waa.lab6.exception.domain.DataNotFoundException;
import com.waa.lab6.logger.exception.domain.ExceptionLogger;

public interface ExceptionLoggerService {

    void save(ExceptionLogger logger) throws DataNotFoundException;
}
