/*
 * Copyright 2011 Shopzilla.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.shopzilla.api.driver;

import com.shopzilla.api.client.ProductClient;
import com.shopzilla.api.client.helper.CredentialFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ProductClientDriver {

    private static CredentialFactory credentialFactory;
    private static String apiKey;
    private static String publisherId;

    private static final String keyword = "nike+men%27s+shoes";

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ProductClient client = applicationContext.getBean("productClient", ProductClient.class);
        credentialFactory = applicationContext.getBean("credentialFactory", CredentialFactory.class);
        apiKey = credentialFactory.getPublisherApiKey();
        publisherId = credentialFactory.getPublisherId();
        client.doProductSearch(apiKey, publisherId, keyword, 10);
    }



}
