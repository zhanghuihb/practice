package 单例模式;

/**
 * @author Tainy
 * @date 2018/9/17 19:16
 */
public class Test {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            System.out.println("第" + i + "对象 = " + 枚举.INSTANCE.getTimerTaskTest());
        }
    }
}
