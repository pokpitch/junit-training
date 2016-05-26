package com.stream.mocks.configurations;

import com.stream.mocks.configurations.Configuration;

/**
 * Mock implementation of the configuration interface.
 *
 * @version $Id: MockConfiguration.java 505 2009-08-16 17:58:38Z paranoid12 $
 */
public class MockConfiguration implements Configuration
{

    /**
     * Sets the sql query.
     *
     * @param sqlString
     */
    public void setSQL(String sqlString)
    {
    }

    /**
     * Gets the sql query.
     *
     * @param sqlString
     * @return
     */
    public String getSQL(String sqlString)
    {
        return null;
    }

}
