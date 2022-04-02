package com.waa.lab4.logger.domain;

import com.waa.lab4.user.domain.User;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Data
public class Logger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;
    private LocalDate date;
    private LocalTime time;
    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String operation;

}
