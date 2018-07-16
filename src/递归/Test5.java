package 递归;

/**
 * 分解成质因数(如435234=251*17*17*3*2，据说是华为笔试题)
 *
 * @author Tainy
 * @date 2018/7/16 15:30
 */
public class Test5 {

    public static int divide(int num, int factor){
        if(factor < num && num%factor == 0){
            num = num/factor;
            System.out.println(factor + " ");
            if(factor >= num){
                return factor;
            }

        }
        return divide(num, factor + 1);

    }

    public static void main(String[] args) {
        System.out.println(Test5.divide(435234, 2));
    }
}
