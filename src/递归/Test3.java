package 递归;

/**
 * 将一整数逆序后放入一数组中（要求递归实现） Ex : 1234 变为 {4,3,2,1}
 *
 * @author Tainy
 * @date 2018/7/16 15:02
 */
public class Test3 {

    public static int[] genStr(int[] res, int i, int num){
        if(i < res.length){
            res[i] = num%10;
            num = num/10;
            return genStr(res,i+1,num);
        } else {
            return res;
        }
    }

    public static void main(String[] args) {
        int[] res = Test3.genStr(new int[5], 0, 12345);
        for (int i = 0; i< res.length; i++){

            System.out.println(res[i]);
        }
    }
}
