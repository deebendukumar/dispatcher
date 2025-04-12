package com.dispatcher.gateway.document;

import com.dispatcher.gateway.model.Endpoint;
import com.dispatcher.gateway.model.Filter;
import com.dispatcher.gateway.model.Predicate;
import com.dispatcher.service.base.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//@formatter:off
/**
 * https://localhost:9999/restfulservice/v1/users/{id}
 * ------ protocol
 *         --------- host / domain name
 *                   ---- port number
 *                        -------------- application context
 *                                       -- apiVersion
 *                                          ----- resource
 *                                                -- parameter
 */
//@formatter:on
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Document(collection = "routes")
public class ApiRoute extends BaseEntity {

    @Id
    private String id;
    private String name;
    private String description;

    @JsonProperty(value = "context")
    private String context;                     //context path should be unique per api

    @JsonProperty(value = "version")
    private String version;                     //apiVersion of api

    @JsonProperty(value = "endpoint")
    private Endpoint endpoint;

    private Predicate predicate;                //holds endpoint related details
    private Filter filter;                      //

    private Integer orders = 0;

    private Plan plan;

    public void setName(String name) {
        this.name = name.toUpperCase().replaceAll(" ", "-");
    }
}
