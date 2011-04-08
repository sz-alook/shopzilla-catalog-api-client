/**
 * Copyright (C) 2004 - 2011 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */
package com.shopzilla.api.client.helper;

/**
 * Class that looks for the API key and publisher Id in environment variables
 * when the context initializes. Be sure to set the following variables before
 * starting a server:
 *  - PUBLISHER_ID
 *  - PUBLISHER_API_KEY
 *
 * @author alook
 * @since 4/7/11
 */
public class CredentialFactory {
    private String publisherId;
    private String publisherApiKey;

    public CredentialFactory() {
        String id = System.getenv("PUBLISHER_ID");
        String key = System.getenv("PUBLISHER_API_KEY");

        if (key != null && id != null) {
            this.publisherId = id;
            this.publisherApiKey = key;
        } else {
            throw new IllegalArgumentException("No API credentials were provided! "+
                                               "Please set PUBLISHER_ID and PUBLISHER_API_KEY ");
        }
    }

    public String getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(String publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherApiKey() {
        return publisherApiKey;
    }

    public void setPublisherApiKey(String publisherApiKey) {
        this.publisherApiKey = publisherApiKey;
    }
}
