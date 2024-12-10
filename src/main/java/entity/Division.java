package entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Класс, представляющий подразделение.
 * Каждое подразделение имеет уникальное имя и идентификатор.
 */
public class Division {

    private static Map<String, Division> divisions = new HashMap<>();
    private static int count = 0;

    private int id;
    private String name;

    /**
     * Конструктор, который создает новый объект с заданными параметрами
     * @param name
     */
    private Division(String name) {
        this.name = name;
        this.id = makeId();

    }

    /**
     * Вспомогательный метод, который возвращает номер подразделения
     * @return номер подразделения
     */
    private int makeId(){
        return ++count;
    }

    /**
     * Фабричный метод
     * @param name
     * @return
     */
    public static Division divisionFabric(String name){
        if (divisions.containsKey(name)){
            return divisions.get(name);
        }else {
            Division division = new Division(name);
            divisions.put(name, division);
            return division;
        }
    }

    /**
     * Метод, проверяющий равенство двух объектов
     * @param o объект сравнения
     * @return true, если объекты равны
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Division)) return false;
        Division division = (Division) o;
        return id == division.id && Objects.equals(name, division.name);
    }

    /**
     * Возвращает численное представление объекта
     * @return численное представление объекта
     */
    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}