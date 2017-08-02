package com.oocode;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class BodyBuilder {
    public static RequestBody bodyBuilder(int paneWidth, int paneHeight, int quantity, String glassType) {
        return new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("account", "Ivan's Windows")
                .addFormDataPart("quantity", Integer.toString(quantity))
                .addFormDataPart("width", Integer.toString(paneWidth))
                .addFormDataPart("height", Integer.toString(paneHeight))
                .addFormDataPart("type", glassType)
                .build();
    }
}
