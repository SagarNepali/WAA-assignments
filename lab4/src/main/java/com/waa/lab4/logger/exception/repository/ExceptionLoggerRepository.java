package com.waa.lab4.logger.exception.repository;

import com.waa.lab4.logger.exception.domain.ExceptionLogger;
import org.springframework.data.repository.CrudRepository;

public interface ExceptionLoggerRepository extends CrudRepository<ExceptionLogger,Long> {
}
