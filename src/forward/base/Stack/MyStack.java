package forward.base.Stack;

/**
 * TODO
 *  栈的实现
 *  取元素只能取最后一个
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/12 - 15:32
 * @since jdk 1.8
 */
public class MyStack {
    //栈的底层使用数组实现
    int[] elements;

    public MyStack(){
        elements = new int[0];
    }

    //压入元素
    public void push(int element){
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

    //取出栈顶元素
    public int pop(){
        //栈中无元素
        if(elements.length==0){
            throw new RuntimeException("stack is empty");
        }

        //取最后一个元素
        int element = elements[elements.length-1];
        //创建新的数组：长度-1
        int[] newArr = new int[elements.length-1];
        //原数组除了最后一个元素都放入新数组中
        for(int i=0;i<elements.length-1;i++){
            newArr[i] = elements[i];
        }
        //替换数组
        elements = newArr;
        //返回栈顶元素
        return element;
    }

    //查看栈顶元素-不删除
    public int peek(){
        //栈中无元素
        if(elements.length==0){
            throw new RuntimeException("stack is empty");
        }
        return elements[elements.length -1];
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return elements.length==0;
    }
}
