package lab2;

import java.time.LocalDate;

public class Human {
    private int age;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;
    private int weight;
    public Human(int age, String firstName, String lastName, LocalDate birthDay, int weight) {
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
        this.weight = weight;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public int getWeight() {
        return weight;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", birthDay=" + birthDay +
                ", weight=" + weight +
                '}';
    }
}
