package com.oocode;

import org.junit.Test;

import java.io.IOException;

import static org.mockito.AdditionalMatchers.not;
import static org.mockito.Mockito.*;

public class MainTest {
//    @Test
//    public void test1() throws Exception {
//        // do not run without changing "Ivan's Windows" in com.oocode.BodyBuilder to "test"
//        // otherwise you have to pay for the order
//        Main.main(new String[]{"123", "456", "789", "Churchill"});
//        Main.main(new String[]{"48", "36", "1", "Victoria"});
//
//        /* EXPECTED OUTPUT
//
//Thank you "test" for your large order (q=789, w=119, h=453, toughened). Order not really placed - nothing to pay
//Thank you "test" for your order (q=1, w=46, h=33, plain). Order not really placed - nothing to pay
//
//         */
//    }

    @Test
    public void LegacyBaseTest() throws IOException {
        RequestSender mockSender = mock(RequestSender.class);

        CAttal cAttal = new CAttal(mockSender);

        when(mockSender.SendOrder(any(),any())).thenReturn("");

        new GlassOrderer(cAttal).OrderGlass(123, 456, 789, "Churchill");

        verify(mockSender).SendOrder(any(), contains("large"));

        new GlassOrderer(cAttal).OrderGlass(48, 36, 1, "Victoria");

        verify(mockSender).SendOrder(any(), not(contains("large")));
    }
}
