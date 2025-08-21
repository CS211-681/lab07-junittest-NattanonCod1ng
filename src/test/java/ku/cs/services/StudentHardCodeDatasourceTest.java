package ku.cs.services;

import ku.cs.models.Student;
import ku.cs.models.StudentList;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentHardCodeDatasourceTest {
    StudentHardCodeDatasource students = new StudentHardCodeDatasource();
    @Test
    @DisplayName("Test Read Data")
    void testReadData() {
        StudentList studentsTest =  students.readData();
        assertEquals(4,  studentsTest.getStudents().size());
    }
}