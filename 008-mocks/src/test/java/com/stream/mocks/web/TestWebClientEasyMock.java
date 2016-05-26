package com.stream.mocks.web;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.expectLastCall;
import static org.easymock.classextension.EasyMock.createMock;
import static org.easymock.classextension.EasyMock.replay;
import static org.easymock.classextension.EasyMock.verify;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.io.IOException;
import java.io.InputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.stream.mocks.web.ConnectionFactory;
import com.stream.mocks.web.WebClient2;

public class TestWebClientEasyMock {

    private ConnectionFactory factory;
    private InputStream stream;

    @Before
    public void setUp() {
        factory = createMock("factory", ConnectionFactory.class);
        stream = createMock("stream", InputStream.class);
    }

    @Test
    public void testGetContentOk() throws Exception {
        expect(factory.getData()).andReturn(stream);
        expect(stream.read()).andReturn(new Integer((byte) 'W' ));
        expect(stream.read()).andReturn(new Integer((byte) 'o' ));
        expect(stream.read()).andReturn(new Integer((byte) 'r' ));
        expect(stream.read()).andReturn(new Integer((byte) 'k' ));
        expect(stream.read()).andReturn(new Integer((byte) 's' ));
        expect(stream.read()).andReturn(new Integer((byte) '!' ));

        expect(stream.read()).andReturn(-1);
        stream.close();

        replay(factory);
        replay(stream);

        WebClient2 client = new WebClient2();

        String result = client.getContent(factory);

        assertEquals("Works!", result);
    }

    @Test
    public void testGetContentInputStreamNull() throws Exception {
        expect(factory.getData()).andReturn(null);

        replay(factory);
        replay(stream);

        WebClient2 client = new WebClient2();

        String result = client.getContent(factory);

        assertNull(result);
    }

    @Test
    public void testGetContentCannotCloseInputStream() throws Exception {
        expect(factory.getData()).andReturn(stream);
        expect(stream.read()).andReturn(-1);
        stream.close();
        expectLastCall().andThrow(new IOException("cannot close"));

        replay(factory);
        replay(stream);

        WebClient2 client = new WebClient2();
        String result = client.getContent(factory);

        assertNull(result);
    }

    @After
    public void tearDown() {
        verify(factory);
        verify(stream);
    }
}
