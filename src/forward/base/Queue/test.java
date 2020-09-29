package forward.base.Queue;

/**
 * TODO
 *  队列相关操作的测试
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/12 - 15:52
 * @since jdk 1.8
 */
public class test {

    public static void main(String[] args) {
        MyQueue mq = new MyQueue();
        mq.add(9);
        mq.add(8);;
        mq.add(7);
        System.out.println(mq.poll());
    }
}
