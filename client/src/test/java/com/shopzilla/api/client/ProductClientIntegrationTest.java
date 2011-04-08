/**
 * Copyright (C) 2004 - 2011 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */
package com.shopzilla.api.client;

import com.shopzilla.api.client.helper.CredentialFactory;
import com.shopzilla.services.catalog.ProductResponse;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static junit.framework.Assert.assertEquals;

/**
 * @author alook
 * @since 3/27/11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-test.xml"})
public class ProductClientIntegrationTest {
    @Autowired
    ProductClient client;

    @Autowired
    CredentialFactory credentialFactory;

    private static String apiKey;
    private static String publisherId;
    private static final String keyword = "nike+men%27s+shoes";

    private static final Integer TEN_RESULTS = 10;
    private static final Integer ONE_HUNDRED_RESULTS = 100;

    ProductResponse productResponse;

    @Before
    public void setUp() {
        apiKey = credentialFactory.getPublisherApiKey();
        publisherId = credentialFactory.getPublisherId();
    }

    @Test
    public void testClientSuccessfullyParsedTenProducts() {
        productResponse = client.doProductSearch(apiKey, publisherId, keyword, TEN_RESULTS);
        assertEquals(TEN_RESULTS, (Integer) productResponse.getProducts().getProductOrOffer().size());
    }

    @Test
    public void testClientSuccessfullyParsedOneHundredProducts() {
        productResponse = client.doProductSearch(apiKey, publisherId, keyword, ONE_HUNDRED_RESULTS);
        assertEquals(true, (Integer) productResponse.getProducts().getProductOrOffer().size() > TEN_RESULTS);
    }
}
