package com.example.demo;

import lombok.Data;

import java.io.Serializable;

@Data
public class EventPayload implements Serializable {
    private String id;
    private String name;
    private Integer age;
}
