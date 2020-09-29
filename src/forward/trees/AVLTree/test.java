package forward.trees.AVLTree;

/**
 * TODO
 *  二叉平衡树测试
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/10 - 17:29
 * @since jdk 1.8
 */
public class test {
    public static void main(String[] args) {
        //用于构建二叉排序树的数据
//        int[] arr = new int[]{7,3,10,12,5,1,9};
        //用于右旋转测试的数据
//        int[] arr = new int[]{8,9,6,7,5,4};
        //用于左旋转测试的数据
//        int[] arr = new int[]{2,1,4,3,5,6};
        //用于双旋转测试的数据-先左后右
        int[] arr = new int[]{8,9,5,4,6,7};
        //创建一颗二叉排序树
        BinarySoreTree bst = new BinarySoreTree();
        //循环添加
        for(int i:arr){
            //添加元素的时候构建平衡二叉树
            bst.add(new Node(i));
        }
        //中序遍历查看树
        //bst.midShow();
//        System.out.println("查找中");
//        Node t = bst.search(10);
//        System.out.println(t.value);
//        Node s = bst.search(15);
//        System.out.println(s);
//        System.out.println("======查找父节点=====");
//        Node p = bst.searchParent(10);
//        System.out.println(p);
//        System.out.println("==========删除叶子节点==========");
//        bst.delete(12);
//        bst.midShow();
//        System.out.println("-----");
//        bst.delete(10);
//        bst.midShow();
//        System.out.println("-=-=-=-=-=-=-");
//        bst.delete(7);
//
        //旋转测试
        System.out.println(bst.root.height());
        System.out.println(bst.root.value);

    }
}
