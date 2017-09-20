package doapps.me.hilos.model;

/**
 * Created by Melanie Veliz on 19/09/2017.
 */

public class Person {
    private String name;
    private String lastName;
    private int age;
    private String hobby;
    private String career;
    private String city;

    public Person(String name, String lastName, int age, String hobby, String career, String city) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.hobby = hobby;
        this.career = career;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
