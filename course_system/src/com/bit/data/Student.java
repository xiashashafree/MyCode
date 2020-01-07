package com.bit.data;

public class Student {
    private int sn;
    private String name;
    private  int classid;

    public void setSn(int sn) {
        this.sn = sn;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public int getSn() {
        return sn;
    }

    public String getName() {
        return name;
    }

    public int getClassid() {
        return classid;
    }

    @Override
    public String toString() {
        return "Student{" +
                "sn=" + sn +
                ", name='" + name + '\'' +
                ", classid=" + classid +
                '}';
    }
}
