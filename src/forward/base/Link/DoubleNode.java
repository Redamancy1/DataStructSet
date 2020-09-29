package forward.base.Link;

/**
 * TODO
 *  双向循环链表
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/12 - 16:40
 * @since jdk 1.8
 */
public class DoubleNode {
    //前驱节点
    DoubleNode pre = this;
    //后继节点
    DoubleNode next = this;
    //节点内容
    int data;

    public DoubleNode(int data){
        this.data = data;
    }

    //插入新节点
    public void after(DoubleNode node){
        //找到当前节点的后继
        DoubleNode nextNode = next;
        //将新节点设置成当前节点的后继
        this.next = node;
        //新节点的前驱设置成当前节点
        node.pre = this;
        //将当前节点的原后继设置成新节点的后继
        node.next = nextNode;
        //将当前节点的原后继的前驱设置成新节点
        nextNode.pre = node;
    }

    //递归解决汉诺塔问题。一次只能移动一个
    public void hanoi(int n,String from,String in,String to){
        //只有一个盘子
        if(n == 1){
            System.out.println("第1个盘子从"+from+"移动到"+to);
        }else{
            //无论有多少个盘子，都认为只有两个
            //上面的所有盘子和最下面的一个盘子
            //1.移动上面所有盘子到中间位置
            hanoi(n-1,from,to,in);
            //2.移动最下面的盘子
            System.out.println("第"+n+"个盘子从"+from+"移到"+to);
            //把上面的所有盘子从中间位置移到目标位置
            hanoi(n-1,in,from,to);
        }
    }
}
