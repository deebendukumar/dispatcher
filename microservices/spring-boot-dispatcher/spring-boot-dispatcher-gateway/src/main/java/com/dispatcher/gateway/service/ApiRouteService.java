package com.dispatcher.gateway.service;

import com.dispatcher.gateway.document.ApiRoute;

import java.util.List;

public interface ApiRouteService {
    /**
     * @param id
     * @return
     */
    ApiRoute get(String id);

    /**
     *
     * @return
     */
    List<ApiRoute> findAll();

    /**
     * @param route
     * @return
     */
    ApiRoute create(ApiRoute route);

    /**
     * @return
     */
    List<ApiRoute> query();

    /**
     * @param route
     */
    ApiRoute update(String id, ApiRoute route);

    /**
     * @param id
     */
    Boolean delete(String id);

    /**
     * @return return true successfully
     */
    Boolean overload();
}
