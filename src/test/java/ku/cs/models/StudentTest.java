package ku.cs.models;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {
    Student s;

    @BeforeEach
    void setUp() {
        s = new Student("62xxxxxxxx", "test");
    }

    @Test
    @DisplayName("Add score test")
    void testAddScore(){
        s.addScore(45.15);
        assertEquals(45.15, s.getScore());
    }

    @Test
    @DisplayName("Calculate grade test")
    void testCalculateScore(){
        s.addScore(1);
        assertEquals("F", s.getGrade());
    }

    @Test
    @DisplayName("Change name test")
    void testChangeName(){
        String currentName =  s.getName();
        s.changeName("test2");
        assertEquals(false, currentName.equals(s.getName()));
    }

    @Test
    @DisplayName("Name contains test")
    void testNameContains(){
        String test = "ES";
        assertEquals(true, s.isNameContains(test));
    }

    @Test
    @DisplayName("ID Test")
    void  testID(){
        String test = "2229930";
        assertEquals(false, s.isId(test));
    }
}