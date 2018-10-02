
package files;

public class Student {
    private String name;
    private String surnames;
    private String course;
    private char gender;
    private int age;
    private String sport;

    public Student(String name, String surnames, String course, char gender, int age, String sport) {
        this.name = name;
        this.surnames = surnames;
        this.course = course;
        this.gender = gender;
        this.age = age;
        this.sport = sport;
    }

    public String getName() {
        return name;
    }

    public String getSurnames() {
        return surnames;
    }

    public String getCourse() {
        return course;
    }

    public char getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getSport() {
        return sport;
    }
    public void setSport(String sport) {
        this.sport = sport;
    }
}