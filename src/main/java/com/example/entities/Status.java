package com.example.entities;

public enum Status {
    NEW(1),
    IN_PROGRESS(2),
    COMPLETED(3),
    CANCELLED(4);

    private final int value;

    Status(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
