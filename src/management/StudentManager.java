
package management;

import files.Student;
import java.util.ArrayList;

public class StudentManager {
    private static ArrayList<Student> students = new ArrayList<>();

    /**
     * @param name student's name
     * @param surname student's surname
     * @return student with given name + surname, null if not found
     */
    public static Student getStudentByFullName(String name, String surnames) {
        for (Student student : students) {
            if (student.getName().equals(name) && student.getSurnames().equals(surnames))
                return student;
        }
        
        return null;
    }
    
    public static String[] getStudentData(String name, String surnames) {
        // TO DO: Check for NullPointer
        return getStudentByFullName(name, surnames).getData();
    }
    
    /**
     * Adds student to students collection if it's not already there.
     * @param name student's name
     * @param surnames student's surname
     * @param course student's course
     * @param gender student's gender
     * @param age student's age
     * @param sport sport to which the student signs up
     * @return the student if it was added successfully, null otherwise
     */
    public static Student addStudent(String name, String surnames, String course, char gender, int age, String sport) {
        // Check if student with given name + surname exists
        if (getStudentByFullName(name, surnames) == null) {
            Student student = new Student(name, surnames, course, gender, age, sport);
            students.add(student);
            return student;
        } else return null;
    }
    
    /**
     * @param name student's name
     * @param surnames student's surnames
     * @return true if student was found and removed, false otherwise
     */
    public static boolean removeStudent(String name, String surnames) {
        return students.remove(getStudentByFullName(name, surnames));
    }
    
    public static void listStudentsGroupedBySportFromAToZ() {
    }
}
