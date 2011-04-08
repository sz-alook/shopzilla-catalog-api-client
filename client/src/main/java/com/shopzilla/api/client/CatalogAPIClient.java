/**
 * Copyright (C) 2004 - 2011 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */
package com.shopzilla.api.client;

import com.shopzilla.api.client.model.CatalogResponse;

/**
 * @author sscanlon
 * 
 */
public interface CatalogAPIClient {

    CatalogResponse performSearch(ProductSearchRequest request);
}
