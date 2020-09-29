package forward.trees.ArrayBinaryTree;

/**
 * TODO
 *  测试顺序二叉树的遍历
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/10 - 14:39
 * @since jdk 1.8
 */
public class TestArrayBinaryTree {

    public static void main(String[] args) {
        int[] data = new int[]{1,2,3,4,5,6,7};
        ArrayBinaryTree tree = new ArrayBinaryTree(data);
        //前序遍历:1245367
        tree.frontShow();
    }
}
