package 泛型;

import com.sun.org.apache.xpath.internal.objects.XObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Tainy
 * @date 2020-03-25 15:12
 */
public class Test1 {
    public static <T> void show1(List<T> list){
        for (Object object: list) {
            System.out.println(object);
        }
    }

    public static void show2(List<?> list){
        for (Object object: list) {
            System.out.println(object);
        }
    }

    public static void main(String[] args) {
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("zhangsan",(short)18,(byte)0 ));
        list1.add(new Student("lisi",(short)25,(byte)1 ));
        list1.add(new Student("wangwu",(short)19,(byte)0 ));
        Test1.show1(list1);
        System.out.println("************分割线**************");
        List list2 = new ArrayList<>();
        list2.add(new Student("zhangsan",(short)18,(byte)0 ));
        list2.add(new Teacher("lisi",(short)25,(byte)1 ));
        list2.add(new Student("wangwu",(short)19,(byte)0 ));
        Test1.show2(list2);
    }
}
