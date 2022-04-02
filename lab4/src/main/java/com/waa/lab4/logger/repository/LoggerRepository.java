package com.waa.lab4.logger.repository;

import com.waa.lab4.logger.domain.Logger;
import org.springframework.data.repository.CrudRepository;

public interface LoggerRepository extends CrudRepository<Logger,Long> {
}
