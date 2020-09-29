package forward.trees.BinaryTree;

import sun.reflect.generics.tree.Tree;

/**
 * TODO
 *  二叉树
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/10 - 2:22
 * @since jdk 1.8
 */
public class BianryTree {

    TreeNode root;

    //设置根节点
    public void setRoot(TreeNode root){
        this.root = root;
    }

    //获取根节点
    public TreeNode getRoot(){
        return root;
    }

    //前序遍历
    public void frontShow(){
        if(root != null){
            root.frontShow();
        }
    }

    public void midShow(){
        if(root != null){
            root.midShow();
        }
    }

    public void afterShow(){
        if(root != null){
            root.afterShow();
        }
    }

    //查找节点信息
    public TreeNode frontSearch(int i){
        return root.frontSearch(i);
    }

    //删除结点
    public void delete(int i){
        root.delete(i);
    }
}
