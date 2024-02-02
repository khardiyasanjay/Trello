package org.example.entity;

import lombok.Data;

@Data
public class Card {
    private String id;
    private String name;
    private String description;
    private User user;
}
