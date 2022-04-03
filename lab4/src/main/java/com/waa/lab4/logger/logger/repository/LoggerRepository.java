package com.waa.lab4.logger.logger.repository;

import com.waa.lab4.logger.logger.domain.Logger;
import org.springframework.data.repository.CrudRepository;

public interface LoggerRepository extends CrudRepository<Logger,Long> {
}
