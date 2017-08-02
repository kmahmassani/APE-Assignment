package com.oocode;

import okhttp3.RequestBody;

import java.io.IOException;

public class CAttal implements GlassSupplier {
    RequestSender requestSender;

    public CAttal(RequestSender requestSender) {
        this.requestSender = requestSender;
    }

    public CAttal() {
        this.requestSender = new RequestSender();
    }

    @Override
    public String SubmitOrder(int quantity, int paneWidth, int paneHeight, String glassType) throws IOException {
        RequestBody requestBody = BodyBuilder.bodyBuilder(paneWidth, paneHeight, quantity, glassType);

        String url = paneWidth * paneHeight * quantity > 20000 ? "https://immense-fortress-19979.herokuapp.com/large-order" : "https://immense-fortress-19979.herokuapp.com/order";

        return requestSender.SendOrder(requestBody, url);
    }
}