package com.stream.mocks.web;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.stream.mocks.web.WebClient2;

/**
 * Another test-case to test the WebClient.
 *
 * @version $Id: TestWebClientFail.java 505 2009-08-16 17:58:38Z paranoid12 $
 */
public class TestWebClientFail
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
