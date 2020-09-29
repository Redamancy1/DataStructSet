package forward.trees.HuffmanTree.HuffmanCodeTest;

import com.sun.deploy.util.StringUtils;

import javax.sound.midi.Soundbank;
import java.util.*;

/**
 * TODO
 *
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/10 - 1:38
 * @since jdk 1.8
 */
public class TestHuffmanCode {
    public static void main(String[] args) {
        String msg = "can you can a can as a can canner can a can.";
        byte[] bytes = msg.getBytes();
        //进行赫夫曼编码
        byte[] b = huffmanZip(bytes);
        System.out.println(bytes.length);
        System.out.println(b.length);
    }

    /**
     * 进行赫夫曼编码压缩的方法
     * @param bytes
     * @return
     */
    private static byte[] huffmanZip(byte[] bytes){
        //先统计每一个byte出现的次数，并放入一个集合中
        List<Node> nodes = getNodes(bytes);
        //创建一颗赫夫曼树
        Node tree = createHuffmanTree(nodes);
//        System.out.println(tree);
//        System.out.println(tree.left);
//        System.out.println(tree.right);
        //创建一个赫夫曼编码表
        Map<Byte,String> huffCodes = getCodes(tree);
//        System.out.println(huffCodes);
        //编码
        byte[] b = zip(bytes,huffCodes);

        return b;
    }

    private static byte[] zip(byte[] bytes,Map<Byte,String> huffCodes){
        StringBuilder sb = new StringBuilder();
        //把想要压缩的byte数组处理成一个二进制的字符串
        for(byte b : bytes){
            sb.append(huffCodes.get(b));
        }
//        System.out.println(sb.toString());
        //定义长度
        int len;
        if(sb.length()%8 == 0){
            len = sb.length()/8;
        }else {
            len = sb.length()/8 + 1;
        }

        //用于存储压缩后的byte
        byte[] by = new byte[len];
        //记录洗的 byte 的位置
        int index = 0;
        for(int i=0;i<sb.length();i+=8){
            String strByte;
            if(i+8>sb.length()){
                strByte = sb.substring(i);
            }else{
                strByte = sb.substring(i,i+8);
            }
//            System.out.println(strByte);
            byte byt = (byte)Integer.parseInt(strByte,2);
//            System.out.println(strByte+":"+byt);
            by[index] = byt;
            index++;
        }

        return by;
    }


    //用于临时存储路径
    static StringBuilder sb = new StringBuilder();
   //用于存储赫夫曼编码
    static Map<Byte,String> huffCodes = new HashMap<>();
    /**
     * 根据赫夫曼树获取赫夫曼编码
     * @param tree
     * @return
     */
    private static Map<Byte,String> getCodes(Node tree){
        if(tree == null){
            return null;
        }
        getCodes(tree.left,"0",sb);
        getCodes(tree.right,"1",sb);

        return huffCodes;
    }

    private static void getCodes(Node node,String code,StringBuilder sb){
        StringBuilder sb2 = new StringBuilder(sb);
        sb2.append(code);
        if(node.data == null){
            getCodes(node.left,"0",sb2);
            getCodes(node.right,"1",sb2);
        }else{
            huffCodes.put(node.data,sb2.toString());
        }


    }

    /**
     * 创建赫夫曼树
     * @param nodes
     * @return
     */
    private static Node createHuffmanTree(List<Node> nodes){
        while (nodes.size()>1){
            //排序
            Collections.sort(nodes);
            //取出两个权值最低的二叉树
            Node left = nodes.get(nodes.size()-1);
            Node right = nodes.get(nodes.size()-2);
            //创建一颗新的二叉树
            Node parent = new Node(null,left.weight+right.weight);
            //把之前取出来的两颗二叉树设置为新创建二叉树的子树
            parent.left = left;
            parent.right = right;
            //把前面取出来的两颗二叉树删除
            nodes.remove(left);
            nodes.remove(right);
            //把新创建的二叉树放入集合中
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    /**
     * 把byte数组转化为node集合
     * @param bytes
     * @return
     */
    private static List<Node> getNodes(byte[] bytes){
        List<Node> nodes = new ArrayList<>();
        //存储每一个byte出现了多少次
        Map<Byte,Integer> counts = new HashMap<>();
        //统计每一个byte出现的次数
        for(byte b : bytes){
            Integer count = counts.get(b);
            //第一次统计的时候的记录数都是 null ,赋初始值 1
            if(count == null){
                counts.put(b,1);
            }else{
                counts.put(b,count+1);
            }
        }
        //把每一个键值对转化为一个 node 对象
        for(Map.Entry<Byte,Integer> entry:counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }

        return nodes;
    }
}
