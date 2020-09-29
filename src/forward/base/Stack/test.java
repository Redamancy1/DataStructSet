package forward.base.Stack;

import javax.sound.midi.Soundbank;

/**
 * TODO
 *  栈的相关操作测试
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/12 - 15:41
 * @since jdk 1.8
 */
public class test {

    public static void main(String[] args) {
        MyStack ms = new MyStack();
        ms.push(9);
        ms.push(8);
        ms.push(7);
        int i = ms.pop();
        int j = ms.pop();
        System.out.println(i + "-" + j);
        System.out.println(ms.isEmpty());


    }
}
