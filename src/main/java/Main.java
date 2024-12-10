import entity.Person;
import serveses.CSVToList;
import java.util.List;


public class Main {

    public static final String PATH = "C://Users//Анастасия//IdeaProjects//Collection2//src//main//resources//foreign_names.csv";

    public static void main(String[] args){
        CSVToList parser = CSVToList.CSV_PARSER;
        List<Person> personList = parser.toPersonList(PATH, ';');
        System.out.println(personList.size());
    }
}