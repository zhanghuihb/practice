package 类的加载顺序;

/**
 * @author Tainy
 * @date 2020-03-24 11:27
 */
public class Parent {

    // 静态变量
    private static Parent parent = new Parent();
    // 静态代码块
    static {
        System.out.println("parent static");
    }
    // 构造方法
    public Parent(){
        System.out.println("parent constructor");
    }

}
