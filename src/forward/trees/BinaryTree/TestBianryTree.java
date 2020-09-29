package forward.trees.BinaryTree;

/**
 * TODO
 *  二叉树
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/10 - 2:22
 * @since jdk 1.8
 */
public class TestBianryTree {

    public static void main(String[] args) {
        //创建一颗树
        BianryTree bianryTree = new BianryTree();
        //创建一个根节点
        TreeNode root = new TreeNode(1);
        //把根节点赋给树
        bianryTree.setRoot(root);
        //创建一个左节点
        TreeNode rootL = new TreeNode(2);
        //把新创建的结点设置为根节点的子节点
        root.setLeftNode(rootL);
        //创建一个右节点
        TreeNode rootR = new TreeNode(3);
        //把新创建的节点设置为根节点的子节点
        root.setRightNode(rootR);

        //下面为根节点的子节点再添加子节点，方便遍历
        TreeNode rootLL = new TreeNode(4);
        rootL.setLeftNode(rootLL);
        TreeNode rootLR = new TreeNode(5);
        rootL.setRightNode(rootLR);

        TreeNode rootRL = new TreeNode(6);
        rootR.setLeftNode(rootRL);
        TreeNode rootRR = new TreeNode(7);
        rootR.setRightNode(rootRR);

        //前序遍历树
        bianryTree.frontShow();
        System.out.println("================");
        TreeNode result = bianryTree.frontSearch(6);
        System.out.println("找到节点信息为："+result);
        System.out.println("下面删除该结点");
        bianryTree.delete(6);
        bianryTree.frontShow();
    }
}
