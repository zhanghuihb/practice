package 泛型;

/**
 * @author Tainy
 * @date 2020-03-25 14:36
 */
public class Teacher {

    private String name;

    private Short age;

    private Byte gender;

    public Teacher(){}

    public Teacher(String name, Short age, Byte gender){
        this.name = name;
        this.age = age;
        this.gender = gender;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Byte getGender() {
        return gender;
    }

    public void setGender(Byte gender) {
        this.gender = gender;
    }
}
