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
        /*// 9*9乘法表
        for(int i = 0;i<9;i++){
            for(int j = 0;j<i + 1;j++){
                System.out.print((i + 1) + "*" + (j + 1) + "=" + (i + 1) * (j + 1) + "  ");
            }
            System.out.println();
        }
        System.out.println(0x80000000);
        System.out.println(0x7fffffff);*/

        String a = "ssdsdsdsfsnihao你好，，，你好sdej";
        String b = "你好";
        int count = 0;
        while(a.contains(b)){
            int index = a.indexOf(b);
            int len = b.length();
            a = a.substring(index + len);
            count++;
        }

        System.out.println(count);
    }
}
