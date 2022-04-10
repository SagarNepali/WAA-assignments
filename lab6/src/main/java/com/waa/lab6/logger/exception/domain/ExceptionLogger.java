package com.waa.lab6.logger.exception.domain;

import com.waa.lab6.user.domain.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "exception_log")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExceptionLogger{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionId;

    @CreationTimestamp
    private LocalDateTime timestamp;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    private String operation;
    private String exceptionType;
    @Column(name = "message")
    private String exceptionMessage;

}
