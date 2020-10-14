package forward.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 树的层次遍历测试
 *
 * @author Redamancy
 * @version 1.0
 * @since jdk 1.8
 */
public class FrontTest {

    public static void main(String[] args) {
        Frontprint.TreeNode root = new Frontprint.TreeNode(10);
        Frontprint.TreeNode left = new Frontprint.TreeNode(7);
        Frontprint.TreeNode right = new Frontprint.TreeNode(15);
        Frontprint.TreeNode lleft2 = new Frontprint.TreeNode(5);
        Frontprint.TreeNode lright2 = new Frontprint.TreeNode(9);
        Frontprint.TreeNode rright2 = new Frontprint.TreeNode(18);


        root.setLeft(left);
        root.setRight(right);
        left.setLeft(lleft2);
        left.setRight(lright2);
        right.setRight(rright2);

        List<Integer> list = new ArrayList();
        Frontprint frontprint = new Frontprint();
        list = frontprint.Frontprint(root);

        for (int i:list
             ) {
            System.out.println(i);
        }
    }

}
