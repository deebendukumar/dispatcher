package com.dispatcher.gateway.document;

import com.dispatcher.service.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "plan")
public class Plan extends BaseEntity {

    private String name;
    private Integer limit;
}
