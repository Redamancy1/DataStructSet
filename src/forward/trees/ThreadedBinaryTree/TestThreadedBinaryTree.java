package forward.trees.ThreadedBinaryTree;

import forward.trees.BinaryTree.BianryTree;
import forward.trees.BinaryTree.TreeNode;
import sun.reflect.generics.tree.Tree;

import javax.sound.midi.Soundbank;

/**
 * TODO
 *  线索二叉树测试
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/10 - 15:01
 * @since jdk 1.8
 */
public class TestThreadedBinaryTree {
    public static void main(String[] args) {
        //创建一颗树
        ThreadedBinaryTree binTree = new ThreadedBinaryTree();
        //创建一个根节点
        ThreadedNode root = new ThreadedNode(1);
        //把根节点赋给树
        binTree.setRoot(root);
        //创建一个左节点
        ThreadedNode rootL = new ThreadedNode(2);
        //把新创建的结点设置为根节点的子节点
        root.setLeftNode(rootL);
        //创建一个右节点
        ThreadedNode rootR = new ThreadedNode(3);
        //把新创建的节点设置为根节点的子节点
        root.setRightNode(rootR);

        //为第二层的左节点创建两个子节点
        rootL.setLeftNode(new ThreadedNode(4));
        ThreadedNode fiveNode = new ThreadedNode(5);
        rootL.setRightNode(fiveNode);
        //为第二层的右节点创建两个子节点
        rootR.setLeftNode(new ThreadedNode(6));
        rootR.setRightNode(new ThreadedNode(7));
        //中序遍历树
        binTree.midShow();
        System.out.println("====线索化中====");
        //中序线索化二叉树
        binTree.threadNodes();
        ThreadedNode afterNode = fiveNode.rightNode;
        System.out.println(afterNode.value);
        System.out.println("开始遍历线索二叉树");
        binTree.threadIterate();
    }
}
