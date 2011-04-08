/**
 * Copyright (C) 2004 - 2011 Shopzilla, Inc. 
 * All rights reserved. Unauthorized disclosure or distribution is prohibited.
 */
package com.shopzilla.api.service;

import com.shopzilla.services.catalog.ProductResponse;
import java.io.IOException;
import java.io.InputStream;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

import javax.xml.bind.JAXBException;
import javax.xml.transform.stream.StreamSource;

/**
 * @author alook
 * @since 3/27/11
 */
public class ProductService {

    private Marshaller marshaller;
    private Unmarshaller unmarshaller;

    public ProductResponse xmlInputStreamToJava(InputStream in) throws IOException, JAXBException {
        try {

            ProductResponse productResponse = (ProductResponse) unmarshaller.unmarshal(new StreamSource(in));
            System.out.println("productResponse = " + productResponse);
            return productResponse;

        } catch (XmlMappingException xme) {
            xme.printStackTrace();
        }
        return null;
    }

    public void setMarshaller(Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public void setUnmarshaller(Unmarshaller unmarshaller) {
        this.unmarshaller = unmarshaller;
    }
}
