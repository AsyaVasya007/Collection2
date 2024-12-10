package entity;

/**
 * Класс Person, представляющий человека.
 */
public class Person {
    private int id;
    private int salary;
    private String name;
    private Gender gender;
    private String birthDay;
    private Division division;

    /**
     * Конструктор класса Person
     * Создает новый объект с заданными параметрами.
     * @param id
     * @param name
     * @param gender
     * @param birthDay
     * @param division
     * @param salary
     */
    public Person(int id,  String name, Gender gender, String birthDay, Division division, int salary) {
        this.id = id;
        this.salary = salary;
        this.name = name;
        this.gender = gender;
        this.birthDay = birthDay;
        this.division = division;
    }

    /**
     * Возвращает уникальный идентификатор человека.
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Возвращает зарплату человека.
     * @return зарплату
     */
    public int getSalary() {
        return salary;
    }

    /**
     * Возвращает имя человека.
     * @return имя
     */
    public String getName() {
        return name;
    }

    /**
     * Возвращает гендер человека.
     * @return гендер
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Возвращает день рождения человека.
     * @return день рождения
     */
    public String getBirthDay() {
        return birthDay;
    }

    /**
     * Возвращает подразделение, к которому относится человек
     * @return подразделение
     */
    public Division getDivision() {
        return division;
    }

    /**
     * Возвращает строковое представление объекта Person.
     * Включает id, зарплату, имя, пол, дату рождения и подразделение.
     */
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