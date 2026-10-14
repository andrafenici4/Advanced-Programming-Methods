package model;

public class Turtle implements Creature {
    private int age;
    private String name;

    public Turtle(int age, String name) {
        this.age = age;
        this.name = name;
    }
    @Override
    public int getAge() {
        return age;
    }
    @Override
    public String getType() {
        return "Turtle (" + name + ")";
    }
    @Override
    public String toString() {
        return getType()+ " - Age: " + age + "years";
    }
}
