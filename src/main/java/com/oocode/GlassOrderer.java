package com.oocode;

import java.io.IOException;

public class GlassOrderer {

    private GlassSupplier supplier;

    public GlassOrderer(GlassSupplier supplier) {
        this.supplier = supplier;
    }

    public String OrderGlass(int quantity, int windowWidth, int windowHeight, String windowModel) throws IOException {
        // the thickness of the frame depends on the model of window
        int frameWidth = width(windowModel, true);
        int frameHeight = width(windowModel, false);

        // the glass pane is the size of the window minus allowance for
        // the thickness of the frame
        int paneWidth = windowWidth - frameWidth;
        int paneHeight = windowHeight - frameHeight;

        String glassType = windowHeight > 120 || (paneWidth * paneHeight > 3000) ? "toughened" : "plain";

        return supplier.SubmitOrder(quantity, paneWidth, paneHeight, glassType);
    }

    private static int width(String r, boolean b) {
        if (!b) return h(r, b);
        if (r.equals("Churchill")) {
            return 4;
        }
        if (r.equals("Victoria")) {
            return 2;
        }
        if (r.equals("Albert")) {
            return 3;
        }
        throw null; // model name isn't known
    }

    private static int h(String r, boolean b) {
        if (r.equals("Churchill")) return 3;
        if (r.equals("Victoria")) {
            return 3;
        }
        if (r.equals("Albert")) {
            return 4;
        }
        throw null; // model name isn't known
    }
}