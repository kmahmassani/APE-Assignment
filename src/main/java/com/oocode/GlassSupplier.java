package com.oocode;

import java.io.IOException;

public interface GlassSupplier {
    String SubmitOrder(int quantity, int paneWidth, int paneHeight, String glassType) throws IOException;
}
