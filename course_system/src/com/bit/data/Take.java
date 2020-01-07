package com.bit.data;

public class Take {
    private int score;
    private int count;
    private int id;
    private int sn;

    public void setScore(int score) {
        this.score = score;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public int getScore() {
        return score;
    }

    public int getCount() {
        return count;
    }

    public int getId() {
        return id;
    }

    public int getSn() {
        return sn;
    }

    @Override
    public String toString() {
        return "Take{" +
                "score=" + score +
                ", count=" + count +
                ", id=" + id +
                ", sn=" + sn +
                '}';
    }
}
