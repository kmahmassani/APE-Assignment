package com.oocode;

import okhttp3.*;

public class Main {
    public static void main(String[] args) throws Exception {
        int quantity = Integer.parseInt(args[2]);  // the number of windows of this size
        int windowWidth = Integer.parseInt(args[0]);  // the width of the window
        int windowHeight = Integer.parseInt(args[1]);  // the height of the window
        String windowModel = args[3];                 // the model name of these windows
        OkHttpClient client = new OkHttpClient();

        // the thickness of the frame depends on the model of window
        int width = width(windowModel, true); int height = width(windowModel, false);

        RequestBody requestBody = BodyBuilder.bodyBuilder(windowWidth, windowHeight, quantity, width, height);
        if (windowHeight > 120) requestBody = BodyBuilder.bodyBuilder2(windowWidth, windowHeight, quantity, width, height);

        // the glass pane is the size of the window minus allowance for
        // the thickness of the frame
        if ((windowWidth-width) * (windowHeight-height) * quantity > 20000) {
            Request request = new Request.Builder()
                    .url("https://immense-fortress-19979.herokuapp.com/large-order")
                    .method("POST", RequestBody.create(null, new byte[0]))
                    .post(requestBody)
                    .build();

        try (Response response = client.newCall(request).execute()) {
            try (ResponseBody body = response.body()) {
                assert body != null;
                System.out.println(body.string());
            }
        }
        return;
        }

        Request request = new Request.Builder()
                .url("https://immense-fortress-19979.herokuapp.com/order")
                .method("POST", RequestBody.create(null, new byte[0]))
                .post(requestBody)
                .build();

        try (Response response = client.newCall(request).execute()) {
            try (ResponseBody body = response.body()) {
                assert body != null; System.out.println(body.string());
            }
        }
    }

    public static
    int width(String r, boolean b) {
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

    public static int h(String r, boolean b) {
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
