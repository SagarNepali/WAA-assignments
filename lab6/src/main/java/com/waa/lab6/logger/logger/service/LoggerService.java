package com.waa.lab6.logger.logger.service;

import com.waa.lab6.logger.logger.domain.Logger;

public interface LoggerService {

    void save(Logger logger) throws Exception;
}
