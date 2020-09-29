package forward.trees.BinarySortTree;

/**
 * TODO
 *  二叉排序树测试
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/10 - 17:29
 * @since jdk 1.8
 */
public class test {
    public static void main(String[] args) {
        int[] arr = new int[]{7,3,10,12,5,1,9};
        //创建一颗二叉排序树
        BinarySoreTree bst = new BinarySoreTree();
        //循环添加
        for(int i:arr){
            bst.add(new Node(i));
        }
        //中序遍历查看树
        bst.midShow();
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
        System.out.println("-=-=-=-=-=-=-");
        bst.delete(7);
        bst.midShow();

    }
}
