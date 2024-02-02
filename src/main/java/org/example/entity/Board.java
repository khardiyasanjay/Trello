package org.example.entity;

import lombok.Data;

import java.util.List;
@Data
public class Board {
    private String id;
    private String name;
    private String privacy;
    private String url;
    private List<User> members;
    private List<LIST> lists;
}
