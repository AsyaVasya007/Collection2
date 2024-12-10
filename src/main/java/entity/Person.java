package entity;

public class Person {
    private int id;
    private int salary;
    private String name;
    private Gender gender;
    private String birthDay;
    private Division division;

    public Person(int id,  String name, Gender gender, String birthDay, Division division, int salary) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.division = division;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public Division getDivision() {
        return division;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", salary=" + salary +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", birthDay='" + birthDay + '\'' +
                ", division=" + division +
                '}';
    }
}