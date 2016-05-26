package com.stream.mocks.web;

import java.io.InputStream;

import com.stream.mocks.web.ConnectionFactory;

/**
 * Mock implementation of the ConnectionFactory interface.
 *
 * @version $Id: MockConnectionFactory.java 505 2009-08-16 17:58:38Z paranoid12 $
 */
public class MockConnectionFactory implements ConnectionFactory
{
    /**
     * The input stream for the connection.
     */
    private InputStream inputStream;

    /**
     * Set the input stream.
     *
     * @param stream
     */
    public void setData(InputStream stream)
    {
        this.inputStream = stream;
    }

    /**
     * Get the input stream.
     *
     * @throws Exception
     */
    public InputStream getData() throws Exception
    {
        return this.inputStream;
    }
}
