package com.example.webSiteBanGiay.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;


@Getter
@Setter
@MappedSuperclass
@FieldDefaults(level = AccessLevel.PRIVATE)

public abstract class BaseEntity<E extends Serializable> implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    E id;

    @Column(name = "ngay_them",updatable = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime ngayThem;

    @Column(name = "ngay_update",updatable = false)
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    LocalDateTime ngayUpdate;

}
