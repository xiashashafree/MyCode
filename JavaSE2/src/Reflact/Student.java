package Reflact;

public class Student {

    private String name;
    private String gender;
    private int age;

    public Student(String name, String gender, int age) {

        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public Student(String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "name: "+name+" gender: "+gender+" age: "+age;
    }

    public String getGender(){
        return gender;
    }

    public int getAge(){
        return age;
    }
    private void setAge(int age){
        this.age = age;
    }
}
