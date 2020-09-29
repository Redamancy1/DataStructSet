package forward.trees.BinarySortTree;

/**
 * TODO
 *  二叉排序树
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/10 - 17:21
 * @since jdk 1.8
 */
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

    public void midShow(Node node){
        if(node == null){
            return;
        }
        midShow(node.left);
        System.out.println(node.value);
        midShow(node.right);
    }

    /**
     * 查找节点
     */
    public Node search(int value){
        if(this.value == value){
            return this;
        }else if(value < this.value){
            if(left == null){
                return null;
            }
            return left.search(value);
        }else {
            if(right == null){
                return null;
            }
            return right.search(value);
        }
    }

    /**
     * 寻找节点的父节点
     * @param value 要查找的节点
     * @return 返回节点父节点
     */
    public Node searchParent(int value){
        if((this.left != null && this.left.value == value)
        || (this.right != null && this.right.value == value)){
            return this;
        }else{
            if(this.value>value && this.left!=null){
                return this.left.searchParent(value);
            }else if(this.value<value && this.right!=null){
                return this.right.searchParent(value);
            }
            return null;
        }
    }

    /**
     * 往子树中添加节点
     * @param node
     */
    public void add(Node node){
        if(node == null){
            return;
        }
        //判断传入的结点的值跟当前子树的节点的值大小关系
        if(node.value<this.value){
            //判断左节点是否为空
            if(this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else{
            if(this.right == null){
                this.right = node;
            }else{
                this.right.add(node);
            }
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
