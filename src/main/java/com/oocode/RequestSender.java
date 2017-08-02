package com.oocode;

import okhttp3.*;

import java.io.IOException;

public class RequestSender {
    OkHttpClient client = new OkHttpClient();

    public RequestSender() {
    }

    public String SendOrder(RequestBody requestBody, String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .method("POST", RequestBody.create(null, new byte[0]))
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            try (ResponseBody body = response.body()) {
                assert body != null;
                return body.string();
            }
        }
    }
}