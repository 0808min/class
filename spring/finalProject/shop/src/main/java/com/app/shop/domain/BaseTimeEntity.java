package com.app.shop.domain;


import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
@EntityListeners(value = {AuditingEntityListener.class})
public class BaseTimeEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime regTime;

    @LastModifiedDate
    private LocalDateTime updateTime;


}
