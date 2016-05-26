package com.stream.mocks.web;

import java.io.InputStream;

/**
 * A connection factory interface. Different connection
 * factories that we have, must implement this interface.
 *
 * @version $Id: ConnectionFactory.java 503 2009-08-16 17:47:12Z paranoid12 $
 */
public interface ConnectionFactory
{
    /**
     * Read the data from the connection.
     *
     * @return
     * @throws Exception
     */
    InputStream getData() throws Exception;
}
