package forward.trees.HuffmanTree.HuffmanCodeTest;

/**
 * TODO
 *  赫夫曼编码实现
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/10 - 1:36
 * @since jdk 1.8
 */
public class Node implements Comparable<Node>{
    //使用包装类，允许为空，因为哈夫曼编码的结点中有些结点无值
    Byte data;
    int weight;
    Node left;
    Node right;
    public Node(Byte data,int weight){
        this.data = data ;
        this.weight = weight ;
    }

    @Override
    public int compareTo(Node o) {
        return o.weight - this.weight;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", weight=" + weight +
                '}';
    }
}
