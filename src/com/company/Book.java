package com.company;

public class Book {

    int score;
    int id;

    public Book( int id, int score) {
        this.score = score;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
