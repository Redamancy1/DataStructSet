package forward.base.Link;

import javax.sound.midi.Soundbank;

/**
 * TODO
 * 单链表实现
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/12 - 16:05
 * @since jdk 1.8
 */
public class Node {
    //节点内容
    int data;
    //下一个节点
    Node next;

    public Node(int data){
        this.data = data;
    }

    //为节点追加节点-无限追加放到最后
    public void append(Node node){
//        this.next =
        //当前节点
        Node currentNode = this;
        //循环向后找
        while (true){
            //取出下一个节点
            Node nextNode = currentNode.next;
            if(nextNode==null){
                //当前节点已经没有后继了
                //跳出循环，将当前节点的后继设置成新添加的节点
                break;
            }
            //当前的后继节点赋给当前节点
            currentNode = nextNode;
        }
        //把想要追加的节点追加为找到的当前节点的下一个节点
        currentNode.next = node;
    }

    //在当前节点后插入新节点
    public void after(Node node){
        //取出当前节点的后继，作为下下一个节点
        Node nodeNext = next;
        //将新节点设置为当前节点的后继
        this.next = node;
        //将下下一个节点设置为新节点的后继
        node.next = nodeNext;
    }

    //获取下一个节点
    public Node next(){
        return this.next;
    }

    //获取节点数据
    public int getData(){
        return this.data;
    }

    //删除当前节点的后继
    //单向链表没法删除自己，因为无法获取前驱
    public void removeNext(){
        //需要先取出后继的下一个节点
        // 否则删除后继后无法建立线性关系
        Node newNext = next.next;
        //把后继的下一个节点设置为当前节点的下一个节点
        this.next = newNext;
    }

    //获取节点信息
    public void show(){
        Node current = this;
        while (true){
            System.out.println(current.data+" ");
            //取出下一个节点
            current = current.next;
            if(current == null){
                break;
            }
        }
    }
}
