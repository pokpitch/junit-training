package com.stream.mocks.web;

import java.io.InputStream;
import java.io.IOException;

/**
 * A sample WebClient that opens a connection to a web-server and reads the data from it.
 *
 * @version $Id: WebClient2.java 503 2009-08-16 17:47:12Z paranoid12 $
 */
public class WebClient2
{
    /**
     * Open a connection to the given URL and read the content
     * out of it. In case of an exception we return null.
     *
     * @param connectionFactory
     * @return
     */
    public String getContent( ConnectionFactory connectionFactory )
        throws IOException
    {
        String result;

        StringBuffer content = new StringBuffer();
        InputStream is = null;
        try
        {
            is = connectionFactory.getData();

            int count;
            while ( -1 != ( count = is.read() ) )
            {
                content.append( new String( Character.toChars( count ) ) );
            }

            result = content.toString();
        }
        catch ( Exception e )
        {
            result = null;
        }

        // Close the stream
        if ( is != null )
        {
            try
            {
                is.close();
            }
            catch ( IOException e )
            {
                result = null;
            }
        }

        return result;
    }
}
