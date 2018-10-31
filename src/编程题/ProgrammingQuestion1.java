package 编程题;

import java.util.TreeSet;

/**
 * 用 1,2 , 2 ,3, 4 ,5 这 6 个数字, 用 Java 写一个 main 函数, 打印出所有不同的排列, 如:  512234, 412345 等, 要求: “4”不能在第三位, “3”与”5”不能相连
 *
 *
 * @author Tainy
 * @date 2018/10/30 11:39
 */
public class ProgrammingQuestion1 {
    public static void main(String[] args) {
        String [] noValidNumberArr = {"0","6","7","8","9","10"};
        String [] validNumberArr = {"1","2","2","3","4","5"};
        int min = 122345;
        int max = 543221;
        TreeSet<String> result = new TreeSet<>();
        for(int i=min; i<= max; i++){
            // 1.排除非法数字
            boolean sign = false;
            for(String str : noValidNumberArr){
                if((i + "").contains(str)){
                    sign = true;
                    break;
                }
            }
            if(sign){
                continue;
            }
            // 2.排除4在第三位
            if((i + "").indexOf("4") == 2){
                continue;
            }
            // 3.排除3、5相连的
            if((i + "").contains("35") || (i+"").contains("53")){
                continue;
            }
            // 4.必须含有指定数字
            boolean flag = false;
            for(String str : validNumberArr){
                if(!(i + "").contains(str)){
                    flag = true;
                }
            }
            if(flag){
                continue;
            }

            // 5.必须含有两个2
            if((i + "").indexOf("2") == -1 || ((i + "").indexOf("2") == (i + "").lastIndexOf("2"))){
                continue;
            }

            result.add(i + "");
        }

        System.out.println(result);
        System.out.println(result.size());
    }
}
