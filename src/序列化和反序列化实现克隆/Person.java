package 序列化和反序列化实现克隆;

import java.io.Serializable;

/**
 * @author Tainy
 * @date 2018/10/22 13:14
 */
public class Person implements Serializable{

    private String name;

    private int age;

    private Car car;

    public Person() {

    }

    public Person(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ",Car=" + car + "]";
    }
}
