package 用面向对象的方法求出数组中重复的value的个数;

import java.util.*;

/**
 * @author Tainy
 * @date 2018/5/27
 */
public class Test {

    private static int[] targetArr = {1,4,1,4,2,5,4,5,8,7,8,77,88,5,4,9,6,2,4,1,5};

    /** 方法1 */
    private static void test1(){
        HashMap<Integer, Integer> temp = new HashMap<Integer, Integer>();
        for (int i = 0; i < targetArr.length; i++){
            if(temp.containsKey(targetArr[i])){
                temp.put(targetArr[i], temp.get(targetArr[i]) + 1);
            }else{
                temp.put(targetArr[i], 1);
            }
        }

        temp = sorting(temp);

        for(Map.Entry<Integer, Integer> e : temp.entrySet()){
            System.out.println(e.getKey() + "出现了 " + e.getValue() + "次");
        }
    }

    /** 对HashMap排序 */
    private static HashMap<Integer, Integer> sorting(HashMap<Integer, Integer> hashMap){
        Set<Map.Entry<Integer, Integer>> entrySet = hashMap.entrySet();
        List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(entrySet);
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if(o1.getValue() - o2.getValue() > 0){
                    return 1;
                }else if(o1.getValue() - o2.getValue() < 0){
                    return -1;
                }
                return 0;
            }
        });

        LinkedHashMap<Integer, Integer> linkedHashMap = new LinkedHashMap<Integer, Integer>();
        list.stream().forEach(e -> {
            linkedHashMap.put(e.getKey(), e.getValue());
        });
        return linkedHashMap;
    }

    /** 方法2 */
    private static void test2(){
        ArrayList<Integer> al = new ArrayList<Integer>();
        ArrayList<Integer> all = new ArrayList<Integer>();
        for(int i =0;i<targetArr.length;i++){
            if(!al.contains(targetArr[i])){
                al.add(targetArr[i]);
            }
        }
        for(int i=0;i<targetArr.length;i++){
            all.add(targetArr[i]);
        }
        for(int i=0;i<al.size();i++){
            int result = Collections.frequency(all,al.get(i));
            System.out.println(al.get(i) + "出现了" + result + "次");
        }
    }

    public static void main(String[] args) {
        Test.test1();
        System.out.println("========================================");
        Test.test2();
    }
}
