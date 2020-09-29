package forward.sortAll;

import java.util.Arrays;

/**
 * TODO
 *  堆排序的实现
 *  1.构建最大堆/最小堆
 *  2.进行堆排序
 *  升序排序使用大顶堆
 *  降序排序使用小顶堆
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/9 - 23:24
 * @since jdk 1.8
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9,6,8,7,0,1,10,4,2};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 开始堆排序
     * @param arr 要使用的数组
     */
    public static void heapSort(int[] arr){
        //开始位置是最后一个非叶子结点，即最后一个节点的父亲
        int start = (arr.length-1)/2;
        //调整为大顶堆
        for(int i = start;i >= 0;i--){
            maxHeap(arr,arr.length,i);
        }
        //先把数组中的第 0 个结点和最后一个节点交换位置
        //再把交换后的结构再次处理为大顶堆
        for(int i = arr.length-1;i > 0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //堆顶最大值交换到最后一位之后就不去动他
            //故数组不变，i每次向前移动一位，固定从堆顶开始重新构建大顶堆
            maxHeap(arr,i,0);
        }
    }

    /**
     * 构建大顶堆
     * @param arr 使用的数组
     * @param size  需要构建的长度
     * @param index 从哪一个节点开始
     */
    public static void maxHeap(int[] arr,int size,int index){
        //左子节点
        int leftNode = 2*index + 1;
        //右子节点
        int rightNode = 2*index + 2;
        //设置临时变量用来存储比较节点与其子节点之间的较大值
        int max = index;
        //与两个子节点进行比较，找出最大的结点
        if(leftNode < size && arr[leftNode] > arr[max]){
            max = leftNode;
        }
        if(rightNode < size && arr[rightNode] > arr[max]){
                max = rightNode;
        }
        //交换位置，使得最大的结点在最上面
        if(max != index){
            int temp = arr[index];
            arr[index] = arr[max];
            arr[max] = temp;
            //交换位置以后，可能会破坏之前排序好的堆
            //所以之前排好的堆需要重新调整
            maxHeap(arr,size,max);
        }
    }
}
