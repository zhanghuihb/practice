package 序列化和反序列化实现克隆;

import common.MyUtil;

import java.io.IOException;

/**
 * @author Tainy
 * @date 2018/10/22 13:24
 */
public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Person person1 =  new Person("Hao LUO", 33, new Car("Benz", 300));
        Person person2 = MyUtil.clone(person1);
        person2.getCar().setBrand("BYD");
        System.out.println(person1);
        System.out.println(person2);
    }
}
