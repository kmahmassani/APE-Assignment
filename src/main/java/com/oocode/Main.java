package com.oocode;

public class Main {
    public static void main(String[] args) throws Exception {
        int quantity = Integer.parseInt(args[2]);  // the number of windows of this size
        int windowWidth = Integer.parseInt(args[0]);  // the width of the window
        int windowHeight = Integer.parseInt(args[1]);  // the height of the window
        String windowModel = args[3];                 // the model name of these windows

        System.out.println(new GlassOrderer().OrderGlass(quantity, windowWidth, windowHeight, windowModel));
    }

}
