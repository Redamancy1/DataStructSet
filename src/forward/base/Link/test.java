package forward.base.Link;

/**
 * TODO
 *  链表测试
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/12 - 16:21
 * @since jdk 1.8
 */
public class test {
    public static void main(String[] args) {
        System.out.println("=====单链表测试=====");
        Node node = new Node(1);
        node.append(new Node(2));
        node.append(new Node(3));
        node.after(new Node(4));
        node.show();
        System.out.println("移除后继");
        node.removeNext();
        node.show();

        System.out.println("=====循环链表测试=====");
        //不建议使用 show() 因为后继永远都有会不停重复打印
        LoopNode ln = new LoopNode(1);
        ln.after(new LoopNode(2));
        ln.next.after(new LoopNode(3));
        ln.next.after(new LoopNode(4));
        ln.show();
        System.out.println("移除后继");
        ln.next.removeNext();
        ln.show();

        System.out.println("=====递归解决汉诺塔=====");
        DoubleNode dn = new DoubleNode(2);
        dn.hanoi(3,"A","B","C");
    }

}
