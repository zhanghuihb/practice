package 递归;

/**
 * 用递归法求和1+2+3+4......+n
 *
 * @author Tainy
 * @date 2018/7/16 14:50
 */
public class Test1 {

    public static int sum(int n){
        if(n == 1){
            return 1;
        } else {
            return n + sum(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(Test1.sum(100));
    }

}
