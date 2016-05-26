package com.stream.mocks.web;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.stream.mocks.web.WebClient2;

/**
 * Another test-case for the WebClient class.
 *
 * @version $Id: TestWebClient1.java 505 2009-08-16 17:58:38Z paranoid12 $
 */
public class TestWebClient1
{
    @Test
    public void testGetContentOk() throws Exception
    {
        MockConnectionFactory mockConnectionFactory =
            new MockConnectionFactory();

        mockConnectionFactory.setData(
            new ByteArrayInputStream("It works".getBytes()));

        WebClient2 client = new WebClient2();

        String result = client.getContent(mockConnectionFactory);

        assertEquals("It works", result);
    }
}
