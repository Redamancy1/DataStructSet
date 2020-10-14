package forward.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 层次遍历
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
public class Frontprint {
    public static class TreeNode{
        int val;
        TreeNode left=null;
        TreeNode right=null;

        public TreeNode(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public TreeNode getLeft() {
            return left;
        }

        public void setLeft(TreeNode left) {
            this.left = left;
        }

        public TreeNode getRight() {
            return right;
        }

        public void setRight(TreeNode right) {
            this.right = right;
        }
    }

    public ArrayList<Integer> Frontprint(TreeNode root) {
        ArrayList<Integer> list=new ArrayList<Integer>();  //存放结果
        Queue<TreeNode> queue= new LinkedList<TreeNode>();   //辅助队列
        if (root!=null){
            //根节点入队
            queue.offer(root);
        }
        //队列不为空，执行循环
        while (!queue.isEmpty()){
            TreeNode node=queue.poll();
            list.add(node.val);     //将队列元素输出

            //如果有左节点，就把左节点加入
            if (node.left!=null){
                queue.offer(node.left);
            }
            //如果有右节点，就把右节点加入
            if(node.right!=null){
                queue.offer(node.right);
            }
        }
        return list;
    }
}
