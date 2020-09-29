package forward.trees.ArrayBinaryTree;

/**
 * TODO
 *  顺序二叉树
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/10 - 14:25
 * @since jdk 1.8
 */
public class ArrayBinaryTree {

    int[] data;

    public ArrayBinaryTree(int[] data){
        this.data = data;
    }

    //无参 遍历顺序二叉树-前序遍历
    public void frontShow(){
        frontShow(0);
    }

    //前序遍历
    public void frontShow(int index){
        if(data == null || data.length == 0){
            return;
        }
        //先遍历当前节点的内容
        System.out.println(data[index]);
        //2*index+1:处理左子树
        if(2*index+1<data.length){
            frontShow(2*index+1);
        }
        //2*index+2:处理右子树
        if(2*index+2<data.length){
            frontShow(2*index+2);
        }
    }

}
