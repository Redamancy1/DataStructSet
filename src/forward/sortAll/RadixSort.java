package forward.sortAll;

import forward.base.Queue.MyQueue;

import java.util.Arrays;

/**
 * TODO
 *  基数排序
 *  先通过个位数大小按顺序排序，形成新数据
 *  再通过十位数大小按顺序排列，形成新数据，以此类推
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/12 - 23:39
 * @since jdk 1.8
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = new int[]{73,22,93,43,55,14,28,65,39,81};
        radixSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void radixSort(int[] arr){
        //存数组中最大的数字
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        //计算最大的数字是几位数
        int maxLength = (max + "").length();
        //用于临时存储数据的数组
        int[][] temp = new int[10][arr.length];
        //用于记录在temp中相应数组中存放的数字的数量
        int[] counts = new int[10];
        //根据最大长度的数决定比较的次数
        for(int i=0,n=1;i<maxLength;i++,n*=10){
            //把每一个数字分别计算余数
            for(int j=0;j<arr.length;j++){
                //计算余数:个->十->百->千...
                int ys = arr[j]/n%10;
                //把当前遍历的数据放入指定的数组中
                temp[ys][counts[ys]] = arr[j];
                //记录数量,每添加一个（余数相同）记录数+1
                //用于判断该放入二维数组哪个位置
                counts[ys]++;
            }
            //记录取的元素需要放的位置
            int index = 0;
            //把数字取出来
            for(int k=0;k<counts.length;k++){
                //记录数量的数组中当前余数记录的数量不为0
                if(counts[k] != 0){
                    //循环取出元素
                    for(int l=0;l<counts[k];l++){
                        //取出元素
                        arr[index] = temp[k][l];
                        //记录下一个位置
                        index++;
                    }
                    //把数量置为0
                    counts[k] = 0;
                }
            }
        }
    }

    //使用优先队列优化
    public static void radixSort2(int[] arr){
        //存数组中最大的数字
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max){
                max=arr[i];
            }
        }
        //计算最大数字是几位数
        int maxLength = (max + "").length();
        //用于临时存储数据的队列的数组
        MyQueue[] temp = new MyQueue[10];
        //为队列数组赋值
        for(int i=0;i<temp.length;i++){
            temp[i] = new MyQueue();
        }
        //根据最大长度决定比较的次数
        for(int i=0,n=1;i<maxLength;i++,n*=10){
            //把每一个数字分别计算余数
            for(int j=0;j<arr.length;j++){
                //计算余数
                int ys = arr[j]/n%10;
                //把当前遍历的数据放入指定的队列中
                temp[ys].add(arr[j]);
            }
            //记录取的元素需要放的位置
            int index = 0;
            //把所有队列中的数字取出来
            for(int k=0;k<temp.length;k++){
                //循环取出元素
                while (!temp[k].isEmpty()){
                    //取出元素
                    arr[index] = temp[k].poll();
                    //记录下一个位置
                    index++;
                }
            }
        }
    }

}
