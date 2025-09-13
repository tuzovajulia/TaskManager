package com.example.entities;

import java.io.Serializable;
import java.util.UUID;

public abstract class BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    private final UUID id;

    protected BaseEntity() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }
}
