package 递归;

/**
 * 一列数的规则如下: 1、1、2、3、5、8、13、21、34...... 求第30位数是多少， 用递归算法实现。
 *
 * @author Tainy
 * @date 2018/7/16 14:58
 */
public class Test2 {

    public static int cal(int n){
        if(n <=0 ){
            return 0;
        }else if(n == 1 || n == 2){
            return 1;
        } else {
            return cal(n -2) + cal(n - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(cal(1));
        System.out.println(cal(2));
        System.out.println(cal(3));
        System.out.println(cal(4));
        System.out.println(cal(5));
        System.out.println(cal(6));
        System.out.println(cal(7));
        System.out.println(cal(8));
        System.out.println(cal(9));
        System.out.println(cal(30));
    }
}
