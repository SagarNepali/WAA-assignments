package com.waa.lab4.logger.logger.service;

import com.waa.lab4.logger.logger.domain.Logger;

public interface LoggerService {

    void save(Logger logger) throws Exception;
}
