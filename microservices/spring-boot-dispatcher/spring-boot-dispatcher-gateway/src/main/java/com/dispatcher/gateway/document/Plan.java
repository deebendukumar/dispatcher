package com.dispatcher.gateway.document;

import com.dispatcher.service.integration.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "plan")
public class Plan extends BaseEntity {

    @Id
    private Long id;
    private String name;
    private Integer limit;
}
