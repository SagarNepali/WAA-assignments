package com.waa.lab5.logger.logger.service;

import com.waa.lab5.logger.logger.domain.Logger;

public interface LoggerService {

    void save(Logger logger) throws Exception;
}
