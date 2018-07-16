package 递归;

/**
 * 递归实现回文判断（如：abcdedbca就是回文，判断一个面试者对递归理解的简单程序）
 *
 * @author Tainy
 * @date 2018/7/16 15:16
 */
public class Test4 {

    public static boolean judge(String str, int i){
        if(str.charAt(i) == str.charAt(str.length() - i - 1)){
            if(i == str.length()/2){
                return true;
            }
            return judge(str, i + 1);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

        System.out.println(Test4.judge("abcdedcba", 0));
    }
}
