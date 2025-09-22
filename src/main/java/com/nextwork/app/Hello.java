package com.nextwork.app;

public class Hello {
    public String greet(String name) {
        if (name == null || name.trim().isEmpty()) {
            return "Hello, World!";
        }
        return "Hello, " + name + "!";
    }
}

