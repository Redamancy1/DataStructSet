package forward.trees.BinaryTree;

/**
 * TODO
 *  二叉树
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/10 - 2:22
 * @since jdk 1.8
 */
public class TreeNode {
    //节点权值
    int value;
    //左子节点
    TreeNode leftNode;
    //右子节点
    TreeNode rightNode;

    public TreeNode(int value){
        this.value = value;
    }

    //设置左儿子
    public void setLeftNode(TreeNode leftNode){
        this.leftNode = leftNode;
    }

    //设置右儿子
    public void setRightNode(TreeNode rightNode){
        this.rightNode = rightNode;
    }

    //各种遍历方法的实现
    public void frontShow(){
        //先遍历当前节点的内容
        System.out.println(value);
        //左节点
        if(leftNode != null){
            leftNode.frontShow();
        }
        //右节点
        if(rightNode != null){
            rightNode.frontShow();
        }
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

    public void afterShow(){
        if(leftNode != null){
            leftNode.afterShow();
        }
        if(rightNode != null){
            rightNode.afterShow();
        }
        System.out.println(value);
    }

    //前序遍历查找节点
    public TreeNode frontSearch(int i){
        TreeNode target = null;
        //对比当前节点的值
        if(this.value == i){
            return this;
        }else {
            //查找左儿子
            if(leftNode != null){
                //有可能可以找到，也可能找不到
                //找不到的话 target 还是 null
                target = leftNode.frontSearch(i);
            }
            //如果不为空，说明在左儿子中已经找到
            if(target != null){
                return target;
            }
            //查找右儿子
            if(rightNode != null){
                target = rightNode.frontSearch(i);
            }
        }
        return target;
    }

    //删除节点
    public void delete(int i){
        TreeNode parent = this;
        //判断左儿子
        if(parent.leftNode!=null
                && parent.leftNode.value == i){
            parent.leftNode = null;
            return;
        }
        //判断右儿子
        if(parent.rightNode != null
        && parent.rightNode.value == i){
            parent.rightNode = null;
            return;
        }

        //递归检查并删除左儿子
        parent = leftNode;
        if(parent != null){
            parent.delete(i);
        }

        //递归检查并删除右儿子
        parent = rightNode;
        if(parent != null){
            parent.delete(i);
        }
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "value=" + value +
                '}';
    }
}
