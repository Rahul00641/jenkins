package org.acme.Model;

import java.util.ArrayList;
import java.util.List;

public class Book {

    private Integer id;

    private String name;
    private List<Integer> tags = new ArrayList<>();

    public Book() {
    }

    public Book(Integer id, String name, List<Integer> tags) {
        this.id = id;
        this.name = name;
        this.tags = tags;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Integer> getTags() {
        return tags;
    }

    public void setTags(List<Integer> tags) {
        this.tags = tags;
    }

}
