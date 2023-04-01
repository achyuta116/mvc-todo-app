package com.example.mvcooad.dto;

/**
 * TodoContent
 */
public class TodoContent {
    public String title;
    public String description;

    public String getTitle() { return title; }

    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    TodoContent() {}
}
