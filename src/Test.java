/**
 * @author Tainy
 * @date 2018/9/19 15:26
 */
public class Test {
    public static int a = 100;

    public static void main(String[] args) {
        /*Test test = new Test();
        test = null;
        System.out.println(test);
        System.out.println(test.a);
        System.out.println(Test.a);
        System.out.println(a);*/
        // 9*9乘法表
        for(int i = 0;i<9;i++){
            for(int j = 0;j<i + 1;j++){
                System.out.print((i + 1) + "*" + (j + 1) + "=" + (i + 1) * (j + 1) + "  ");
            }
            System.out.println();
        }
    }
}
