package com.oocode;

import org.junit.Test;

import java.io.IOException;

import static org.mockito.AdditionalMatchers.not;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CAttalTest {

    @Test
    public void PlainOrdersOver20000CallLargeEndpoint() throws IOException {
        RequestSender mockSender = mock(RequestSender.class);

        CAttal cAttal = new CAttal(mockSender);

        when(mockSender.SendOrder(any(),any())).thenReturn("");

        // total area is quantity * window area
        cAttal.SubmitOrder(20001, 1,1, "plain");

        verify(mockSender).SendOrder(any(), contains("large"));
    }

    @Test
    public void OrdersFor20000CallSmallEndpoint() throws IOException {
        RequestSender mockSender = mock(RequestSender.class);

        CAttal cAttal = new CAttal(mockSender);

        when(mockSender.SendOrder(any(),any())).thenReturn("");

        // total area is quantity * window area
        cAttal.SubmitOrder(20000, 1,1, "");

        verify(mockSender).SendOrder(any(), not(contains("large")));
    }

    @Test
    public void OrdersUnder20000CallSmallEndpoint() throws IOException {
        RequestSender mockSender = mock(RequestSender.class);

        CAttal cAttal = new CAttal(mockSender);

        when(mockSender.SendOrder(any(),any())).thenReturn("");

        // total area is quantity * window area
        cAttal.SubmitOrder(19999, 1,1, "");

        verify(mockSender).SendOrder(any(), not(contains("large")));
    }

    @Test
    public void ToughenedOrdersOver18000CallLargeEndpoint() throws IOException {
        RequestSender mockSender = mock(RequestSender.class);

        CAttal cAttal = new CAttal(mockSender);

        when(mockSender.SendOrder(any(),any())).thenReturn("");

        // total area is quantity * window area
        cAttal.SubmitOrder(18001, 1,1, "toughened");

        verify(mockSender).SendOrder(any(), contains("large"));
    }
}
