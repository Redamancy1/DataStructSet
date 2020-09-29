package forward.base;

/**
 * TODO
 *  二分查找法
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/12 - 15:24
 * @since jdk 1.8
 */
public class TestBinarySearch {

    public static void main(String[] args) {
        //目标数组
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9};
        //目标元素
        int target = 8;
        //记录开始位置
        int begin = 0;
        //记录结束位置
        int end = arr.length-1;
        //记录中间位置
        int mid = (begin+end)/2;
        //记录目标位置
        int index = -1;
        //循环查找
        while (true){
            //判断中间的这个元素是否是要查找的元素
            if(arr[mid] == target){
                index = mid;
                break;
            }else {
                //判断中间这个元素与目标元素的大小
                if(arr[mid] > target){
                    //把新结束位置调整为原中间位置的前一个位置
                    end = mid-1;
                }else {
                    //把新开始位置调整为原中间位置的后一个位置
                    begin = mid+1;
                }
                //取出新的中间位置
                mid = (begin+end)/2;
            }
        }
        System.out.println("index:"+index);
    }

}
