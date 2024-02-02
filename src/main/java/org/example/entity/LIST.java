package org.example.entity;

import lombok.Data;

import java.util.List;
@Data
public class LIST {
    private String id;
    private String name;
    private List<Card> cards;
}
