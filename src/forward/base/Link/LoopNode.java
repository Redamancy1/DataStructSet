package forward.base.Link;

/**
 * TODO
 *  循环链表
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/12 - 16:26
 * @since jdk 1.8
 */
public class LoopNode {
    //重要：LoopNode next = this
    //节点内容
    int data;
    //下一个节点，一个默认是自己-自成环
    LoopNode next = this;

    public LoopNode(int data){
        this.data = data;
    }

    //为当前节点插入节点
    public void after(LoopNode node){
        //取出当前节点后继，作为下下一个节点
        LoopNode nextNext = next;
        //把新节点设置为当前节点的后继
        this.next = node;
        //把下下一个节点设置成新节点的后继
        node.next = nextNext;
    }

    //删除当前节点的后继
    public void removeNext(){
        //取出当前节点的后继的后继
        LoopNode nextNext = next.next;
        this.next = nextNext;
    }

    //获取节点信息-实际上循环会一直打印
    public void show(){
        LoopNode start = this;
        LoopNode current = this;
        while (true){
            System.out.println(current.data+" ");
            //取出下一个节点
            current = current.next;
            if(current.data == start.data){
                break;
            }
        }
    }

}
