package com.dispatcher.pim.entity;

import com.dispatcher.service.base.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "brand")
public class Brand extends BaseEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "body")
    private String body;

    @Column(name = "body_html")
    private String bodyHtml;
}
