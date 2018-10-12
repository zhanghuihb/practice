package 排序;

/**
 * @author Tainy
 * @date 2018/9/19 14:10
 */
public class 冒泡 {
    public static int[] sorting(int[] sortArr){
        for(int i=0;i<sortArr.length;i++){
            for(int j = 0;j<sortArr.length - i -1;j++){
                int temp = sortArr[j];
                if(sortArr[j] > sortArr[j+1]){
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = temp;
                }
            }
        }

        return sortArr;
    }

    public static void main(String[] args) {
        int[] sortArr = {23,45,12,9,40,67,78,21,56};
        sorting(sortArr);
        for(int i = 0; i < sortArr.length; i++){
            System.out.print(sortArr[i] + ",");
        }
    }
}
