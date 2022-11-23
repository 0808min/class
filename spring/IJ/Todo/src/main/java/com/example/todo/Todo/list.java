package com.example.todo.Todo;

public class list {

    private String id;
    private boolean date;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isDate() {
        return date;
    }

    public void setDate(boolean date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "list{" +
                "id='" + id + '\'' +
                ", date=" + date +
                '}';
    }
}
