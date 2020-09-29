package forward.base.Queue;

/**
 * TODO
 *  队列的实现
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/12 - 15:51
 * @since jdk 1.8
 */
public class MyQueue {

    int[] elements;

    public MyQueue(){
        elements = new int[0];
    }

    //入队
    public void add(int element){
        int[] newArr = new int[elements.length+1];
        //把原数组的元素复制到新数组
        for(int i=0;i<elements.length;i++){
            newArr[i] = elements[i];
        }
        //把添加的元素放入新数组中
        newArr[elements.length] = element;
        //新数组替换旧数组
        elements = newArr;
    }

    //出队-第一个元素
    public int poll(){
        int element = elements[0];
        int[] newArr = new int[elements.length-1];
        for(int i=0;i<newArr.length;i++){
            //除去原数组第一个元素
            newArr[i] = elements[i+1];
        }
        //替换数组
        elements = newArr;
        return element;
    }

    public boolean isEmpty(){
        return elements.length==0;
    }


}
