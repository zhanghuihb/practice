package 类的加载顺序;

/**
 * @author Tainy
 * @date 2020-03-24 11:30
 */
public class Child extends Parent{
    // 静态变量

    // 静态代码块
    static {
        System.out.println("child static");
    }
    // 构造方法
    public Child(){
        System.out.println("child constructor");
    }

    public static void main(String[] args) {
        Child child = new Child();
    }
}
