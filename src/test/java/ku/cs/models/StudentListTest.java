package ku.cs.models;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentListTest {
    StudentList students;
    @BeforeEach
    void setUp() {
        students = new StudentList();
        students.addNewStudent("0001", "test1");
        students.addNewStudent("0002", "test2");
        students.addNewStudent("0003", "test3");
        students.addNewStudent("0004", "test4");
        students.addNewStudent("0005", "test5");
    }

    @Test
    @DisplayName("Test add students")
    void testAddStudents() {
        int amountBeforeAdd = students.getStudents().size();

        students.addNewStudent("0006", "test6");
        int amountAfterAdd = students.getStudents().size();

        assertEquals(amountBeforeAdd + 1, amountAfterAdd);
    }

    @Test
    @DisplayName("Test find student by ID")
    void testFindStudentByID() {
        String findTest = "0004";
        Student s = students.findStudentById(findTest);
        assertEquals(true, s.getId().equals(findTest));
    }

    @Test
    @DisplayName("Test filter name")
    void testFilterName() {
        students.addNewStudent("0006", "asdasddfcfdsd");
        StudentList students_filtered = students.filterByName("test");
        boolean passed = true;
        for (Student s : students_filtered.getStudents()) {
            if (!s.isNameContains("test")) {
                passed = false;
                break;
            }
        }
        assertEquals(true, passed);
    }

    @Test
    @DisplayName("Test give score to id")
    void testGiveScoreToId() {
        Student s = students.findStudentById("0005");
        double beforeGiveScore = s.getScore();
        students.giveScoreToId("0005", 80);
        assertEquals(80, s.getScore());
    }

    @Test
    @DisplayName("Test view grade")
    void testViewGrade() {
        String s = students.viewGradeOfId("0001");
        assertEquals("F", s);
    }
}