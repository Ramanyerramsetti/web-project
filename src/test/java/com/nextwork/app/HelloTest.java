package com.nextwork.app;

import junit.framework.TestCase;

public class HelloTest extends TestCase {
    public void testGreetWithName() {
        Hello hello = new Hello();
        assertEquals("Hello, Alice!", hello.greet("Alice"));
    }

    public void testGreetWithNullOrEmpty() {
        Hello hello = new Hello();
        assertEquals("Hello, World!", hello.greet(null));
        assertEquals("Hello, World!", hello.greet(""));
        assertEquals("Hello, World!", hello.greet("   "));
    }
}

