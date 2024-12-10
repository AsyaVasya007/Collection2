package serveses;

import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import entity.Division;
import entity.Gender;
import entity.Person;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Сервисный класс, реализурующий паттерн проектирования Singleton
 * Выполняет операцию преобразования csv-файла в список объектов Person
 */
public class CSVToList {

    public static final CSVToList CSV_PARSER = new CSVToList();

    private CSVToList() {
    }

    /**
     * Метод, преобразующий csv-файл в список объектов Person
     * @param CSVFilePath путь к используемому csv-файлу
     * @param separator разделитель
     * @return список объектов Person
     */
    public List<Person> toPersonList(String CSVFilePath, char separator) {
        List<Person> personList = new ArrayList<>();
        CSVParser parser = new CSVParserBuilder().withSeparator(separator).build();

        try (FileReader fileReader = new FileReader(CSVFilePath);
             CSVReader csvReader = new CSVReaderBuilder(fileReader).withCSVParser(parser).build()) {
            String[] next;
            while ((next = csvReader.readNext()) != null){
                try {
                    int id = Integer.parseInt(next[0]);
                    int salary = Integer.parseInt(next[5]);
                    Gender gender = Gender.valueOf(next[2].toUpperCase());
                    Division division = Division.divisionFabric(next[4]);
                    Person person = new Person(id, next[1], gender, next[3], division, salary);
                    personList.add(person);
                } catch (IllegalArgumentException e) {
                    System.out.println("");
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);
        }
        return personList;
    }
}