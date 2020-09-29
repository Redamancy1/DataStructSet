package forward.trees.ThreadedBinaryTree;

/**
 * TODO
 *  线索二叉树
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/10 - 14:42
 * @since jdk 1.8
 */
public class ThreadedNode {
    //节点的权
    int value;
    //左右儿子
    ThreadedNode leftNode;
    ThreadedNode rightNode;
    //标识指针类型：0-子树，1-前驱后继
    int leftType;
    int rightType;

    public ThreadedNode(int value){
        this.value = value;
    }

    public void midShow(){
        if(leftNode != null){
            leftNode.midShow();
        }
        System.out.println(value);
        if(rightNode != null){
            rightNode.midShow();
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public ThreadedNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(ThreadedNode leftNode) {
        this.leftNode = leftNode;
    }

    public ThreadedNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(ThreadedNode rightNode) {
        this.rightNode = rightNode;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }
}
