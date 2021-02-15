package com.example.task15022021;

public class Student {
    private String name, group;
    private Integer score;

    public Student(String name, String group, Integer score) {
        this.name = name;
        this.group = group;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getGroup() {
        return group;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
