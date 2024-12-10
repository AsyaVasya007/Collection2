import entity.Person;
import entity.Gender;
import entity.Division;
import org.junit.jupiter.api.Test;
import serveses.CSVToList;

import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVToListTest {

    private static final String FOREIGN_NAMES_CSV_PATH;

    static {
        try {
            FOREIGN_NAMES_CSV_PATH = Paths.get(
                    CSVToListTest.class.getClassLoader().getResource("foreign_names.csv").toURI()
            ).toString();
        } catch (Exception e) {
            throw new RuntimeException("Error locating the file 'foreign_names.csv': " + e.getMessage(), e);
        }
    }

    @Test
    void testToPersonList_ForeignNames() {
        CSVToList parser = CSVToList.CSV_PARSER;
        List<Person> personList = parser.toPersonList(FOREIGN_NAMES_CSV_PATH, ';');

        // Проверяем, что список не пуст
        assertNotNull(personList);
        assertEquals(25898, personList.size()); // В файле 22 записи

        // Проверяем первую запись
        Person firstPerson = personList.get(0);
        assertEquals(28281, firstPerson.getId());
        assertEquals("Aahan", firstPerson.getName());
        assertEquals(Gender.MALE, firstPerson.getGender());
        assertEquals("15.05.1970", firstPerson.getBirthDay());
        assertEquals(Division.divisionFabric("I"), firstPerson.getDivision());
        assertEquals(4800, firstPerson.getSalary());

        // Проверяем последнюю запись
        Person lastPerson = personList.get(personList.size() - 1);
        assertEquals(54178, lastPerson.getId());
        assertEquals("Zyta", lastPerson.getName());
        assertEquals(Gender.FEMALE, lastPerson.getGender());
        assertEquals("16.04.1955", lastPerson.getBirthDay());
        assertEquals(Division.divisionFabric("H"), lastPerson.getDivision());
        assertEquals(7600, lastPerson.getSalary());
    }

}
