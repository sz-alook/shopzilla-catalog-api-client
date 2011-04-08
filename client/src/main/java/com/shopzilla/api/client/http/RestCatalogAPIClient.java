/**
 * Copyright (C) 2004 - 2011 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */
package com.shopzilla.api.client.http;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.web.client.RestOperations;

import com.shopzilla.api.client.CatalogAPIClient;
import com.shopzilla.api.client.ProductSearchRequest;
import com.shopzilla.api.client.ProductUrl;
import com.shopzilla.api.client.model.CatalogResponse;
import com.shopzilla.api.client.model.CatalogResponseModelAdapter;
import com.shopzilla.services.catalog.ProductResponse;

/**
 * @author sscanlon
 * 
 */
public class RestCatalogAPIClient implements CatalogAPIClient {

    private RestOperations restTemplate;

    public CatalogResponse performSearch(ProductSearchRequest request) {

        ProductResponse result = restTemplate.getForObject(ProductUrl.PRODUCT_URL,
                ProductResponse.class,
                ProductUrl.makeParameterMap(request));

        return CatalogResponseModelAdapter.fromCatalogAPI(result);
    }

    @Required
    public void setRestTemplate(RestOperations restTemplate) {
        this.restTemplate = restTemplate;
    }

}
