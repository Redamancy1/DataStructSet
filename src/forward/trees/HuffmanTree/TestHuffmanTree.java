package forward.trees.HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * TODO
 *  创建赫夫曼树测试类
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/10 - 0:58
 * @since jdk 1.8
 */
public class TestHuffmanTree {
    public static void main(String[] args) {
        int[] arr = new int[]{3,5,7,8,11,14,23,29};
        Node node = createHuffmanTree(arr);
        System.out.println(node);
    }
    //创建赫夫曼树
    public static Node createHuffmanTree(int[] arr){
        //先使用数组中所有的元素创建若干个二叉树（只有一个节点）
        List<Node> nodes = new ArrayList<>();
        for(int value:arr){
            nodes.add(new Node(value));
        }
        //循环处理
        while(nodes.size() > 1){
            // 排序
            Collections.sort(nodes);
            //取出权值最小的两个二叉树
            //取出权值最小的二叉树,因为是降序排序故在最后面
            Node left = nodes.get(nodes.size()-1);
            //取出权值第二小的二叉树
            Node right = nodes.get(nodes.size()-2);
            //创建一颗新的二叉树
            Node parent = new Node(left.value + right.value);
            //把取出来的两颗二叉树移除
            nodes.remove(left);
            nodes.remove(right);
            // 放入原来的二叉树集合
            nodes.add(parent);
        }
        //System.out.println(nodes.get(0).value);
        return nodes.get(0);
    }
}
