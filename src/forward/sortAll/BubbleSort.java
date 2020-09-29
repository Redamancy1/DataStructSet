package forward.sortAll;

import java.util.Arrays;

/**
 * TODO
 *  冒泡排序
 *  相邻两个比较，重复多轮
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/12 - 17:27
 * @since jdk 1.8
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,1,7,2,9,11};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void bubbleSort(int[] arr){
        //控制共比较多少轮
        for(int i=0;i<arr.length-1;i++){
            //控制比较的次数
            for(int j=0;j<arr.length-1-i;j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
}
