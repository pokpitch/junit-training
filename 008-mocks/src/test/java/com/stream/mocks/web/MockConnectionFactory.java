package com.stream.mocks.web;

import java.io.InputStream;

import com.stream.mocks.web.ConnectionFactory;


public class MockConnectionFactory implements ConnectionFactory {

    /**
     * The input stream for the connection.
     */
    private InputStream inputStream;

    /**
     * Set the input stream.
     *
     * @param stream
     */
    public void setData(InputStream stream) {
        this.inputStream = stream;
    }

    /**
     * Get the input stream.
     *
     * @throws Exception
     */
    public InputStream getData() throws Exception {
        return this.inputStream;
    }
}
