/**
 * Copyright (C) 2004 - 2011 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */
package com.shopzilla.api.driver;

import com.shopzilla.api.service.ProductService;
import java.io.IOException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.xml.bind.JAXBException;

/**
 * @author alook
 * @since 3/27/11
 */
public class ProductServiceDriver {

    public static void main(String[] args) throws JAXBException, IOException {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        ProductService service = applicationContext.getBean("productService", ProductService.class);

        //service.xmlInputStreamToJava();
    }
}
