package model;

public class Fish implements Creature {
    private int age;
    private String species;

    public Fish(int age, String species) {
        this.age = age;
        this.species = species;
    }
    @Override
    public int getAge() {
        return this.age;
    }
    @Override
    public String getType() {
        return "Fish (" + species + ")";
    }
    @Override
    public String toString() {
        return getType()+ " - Age: " + age + "years";
    }
}
