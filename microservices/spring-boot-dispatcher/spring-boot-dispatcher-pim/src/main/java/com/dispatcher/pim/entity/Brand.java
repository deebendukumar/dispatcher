package com.dispatcher.pim.entity;

import com.dispatcher.service.integration.ApplicationEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "brand")
public class Brand extends ApplicationEntity implements Serializable {

    @Column(name = "name")
    private String name;

    @Column(name = "body")
    private String body;

    @Column(name = "body_html")
    private String bodyHtml;
}
