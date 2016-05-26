package com.stream.mocks.web;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.stream.mocks.web.WebClient2;

/**
 * A test-case for the WebClient class. We use our MockHttpURLConnection
 * and we also extend the WebClient class to
 * overwrite one of its methods.
 *
 * @version $Id: TestWebClient.java 505 2009-08-16 17:58:38Z paranoid12 $
 */
public class TestWebClient
{
    @Test
    public void testGetContentOk()
        throws Exception
    {
        MockConnectionFactory mockConnectionFactory = new MockConnectionFactory();
        MockInputStream mockStream = new MockInputStream();
        mockStream.setBuffer( "It works" );

        mockConnectionFactory.setData( mockStream );

        WebClient2 client = new WebClient2();

        String result = client.getContent( mockConnectionFactory );

        assertEquals( "It works", result );
        mockStream.verify();
    }
}
