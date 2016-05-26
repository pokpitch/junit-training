package com.stream.mocks.web;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.stream.mocks.web.WebClient2;


public class TestWebClient1 {
    @Test
    public void testGetContentOk() throws Exception {
        MockConnectionFactory mockConnectionFactory = new MockConnectionFactory();

        mockConnectionFactory.setData(new ByteArrayInputStream("It works".getBytes()));

        WebClient2 client = new WebClient2();
        String result = client.getContent(mockConnectionFactory);

        assertEquals("It works", result);
        
    }
}
