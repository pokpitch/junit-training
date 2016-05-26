package com.stream;

import static org.junit.Assert.assertEquals;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import com.stream.WebClient;


public class TestWebClientSkeleton {

    @Before
    public void setUp()
    {
        // Start Jetty and configure it to return "It works" when
        // the http://localhost:8080/testGetContentOk URL is
        // called.
    }

    @After
    public void tearDown()
    {
        // Stop Jetty.
    }

    @Test
    @Ignore(value = "This is just initial skeleton of a test. " + "Therefore if we run it now it will fail." )
    public void testGetContentOk() throws Exception {
        WebClient client = new WebClient();
        String result = client.getContent( new URL( "http://localhost:8080/testGetContentOk" ) );
        assertEquals( "It works", result );
    }
}
