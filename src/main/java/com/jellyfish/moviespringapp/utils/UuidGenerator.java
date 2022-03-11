package com.jellyfish.moviespringapp.utils;

import static java.util.UUID.randomUUID;

public class UuidGenerator {
    public static String uuid() {
        return randomUUID().toString();
    }
}
