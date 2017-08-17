package com.oocode;

import org.junit.Test;

import java.io.IOException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GlassOrdererTest {
    @Test
    public void WindowsOver120HeightShouldBeTough() throws IOException {
        GlassSupplier mockSupplier = mock(GlassSupplier.class);
        GlassOrderer orderer = new GlassOrderer(mockSupplier);

        when(mockSupplier.SubmitOrder(any(int.class),any(int.class),any(int.class), any(String.class))).thenReturn("");

        orderer.OrderGlass(1,1,121,"Churchill");

        verify(mockSupplier).SubmitOrder(any(int.class), any(int.class), any(int.class), eq("toughened"));
    }

    @Test
    public void GlassAreaOver3000ShouldBeTough() throws IOException {
        GlassSupplier mockSupplier = mock(GlassSupplier.class);
        GlassOrderer orderer = new GlassOrderer(mockSupplier);

        when(mockSupplier.SubmitOrder(any(int.class),any(int.class),any(int.class), any(String.class))).thenReturn("");

        orderer.OrderGlass(1,3005,4,"Churchill");

        verify(mockSupplier).SubmitOrder(any(int.class), any(int.class), any(int.class), eq("toughened"));
    }
}
