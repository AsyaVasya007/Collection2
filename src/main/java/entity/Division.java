package entity;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Division {

    private static Map<String, Division> divisions = new HashMap<>();
    private static int count = 0;

    private int id;
    private String name;


    private Division(String name) {
        this.name = name;
        this.id = makeId();

    }
    private int makeId(){
        return ++count;
    }

    public static Division divisionFabric(String name){
        if (divisions.containsKey(name)){
            return divisions.get(name);
        }else {
            Division division = new Division(name);
            divisions.put(name, division);
            return division;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Division)) return false;
        Division division = (Division) o;
        return id == division.id && Objects.equals(name, division.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}