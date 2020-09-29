package forward.trees.HuffmanTree;

/**
 * TODO
 *  赫夫曼树节点类
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/10 - 0:56
 * @since jdk 1.8
 */
public class Node implements Comparable<Node>{
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

    @Override
    public int compareTo(Node o) {
        //降序
        return -(this.value - o.value);
        //return this.value - o.value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }
}
