
package files;

public class Student {
    private String name;
    private String surnames;
    private String course;
    private byte gender;
    private int age;
    private String sport;

    public Student(String name, String surnames, String course, byte gender, int age, String sport) {
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
    public void setName(String name) {
        this.name = name;
    }

    public String getSurnames() {
        return surnames;
    }
    public void setSurnames(String surnames) {
        this.surnames = surnames;
    }

    public String getCourse() {
        return course;
    }
    public void setCourse(String course) {
        this.course = course;
    }

    public byte getGender() {
        return gender;
    }
    public void setGender(byte gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public String getSport() {
        return sport;
    }
    public void setSport(String sport) {
        this.sport = sport;
    }
}
