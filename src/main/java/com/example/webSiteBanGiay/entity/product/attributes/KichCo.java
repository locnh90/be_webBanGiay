package com.example.webSiteBanGiay.entity.product.attributes;

import com.example.webSiteBanGiay.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@Entity
@Table(name = "kich_co")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class KichCo extends BaseEntity<Integer> {
    @Column(name = "ten_kick_co")
    String tenKichCo;
}
