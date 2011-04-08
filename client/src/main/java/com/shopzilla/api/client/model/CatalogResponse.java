/**
 * Copyright (C) 2004 - 2011 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */
package com.shopzilla.api.client.model;

import java.util.Collections;
import java.util.List;

/**
 * @author sscanlon
 * 
 */
public class CatalogResponse {

    private Long relevancyScore;

    private List<Attribute> relatedAttributes;
    private List<Product> products = Collections.emptyList();
    private List<Offer> offers = Collections.emptyList();

    public List<Attribute> getRelatedAttributes() {
        return relatedAttributes;
    }

    public void setRelatedAttributes(List<Attribute> relatedAttributes) {
        this.relatedAttributes = relatedAttributes;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Offer> getOffers() {
        return offers;
    }

    public void setOffers(List<Offer> offers) {
        this.offers = offers;
    }

    public Long getRelevancyScore() {
        return relevancyScore;
    }

    public void setRelevancyScore(Long relevancyScore) {
        this.relevancyScore = relevancyScore;
    }

}
