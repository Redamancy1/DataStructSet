package forward.trees.AVLTree;

/**
 * TODO
 *  二叉平衡树
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/10 - 17:22
 * @since jdk 1.8
 */
public class BinarySoreTree {
    Node root;

    /**
     * 删除节点
     * 三种情况：
     * 1.删除叶子节点
     * 2.删除有一个子节点的节点
     * 3.删除有两个子节点的节点
     */
    public void delete(int value){
        if(root == null){
            return;
        }else{
            //找到该节点
            Node target = search(value);
            //若找不到该节点
            if(target == null){
                return;
            }
            //找到该节点的父节点
            Node parent = searchParent(value);
            //1.要删除的结点是叶子节点
            if(target.left==null && target.right==null){
                //要删除的结点是左子节点
                if(parent.left.value==value){
                    parent.left = null;
                }else {
                    parent.right = null;
                }
                //删除有两个子节点的节点
            }else if(target.left!=null && target.right!=null){
                //删除右子树中值最小的节点，获取到该节点的值
                int min = deleteMin(target.right);
                //替换目标结点的值
                target.value = min;

            //删除有一个子节点的节点
            }else{
                //有左子节点
                if(target.left!=null){
                    //要删除的节点是父节点的左子节点
                    if(parent.left.value == value){
                        //将目标节点的子节点赋给目标节点父节点作为新节点
                        parent.left = target.left;
                    //要删除的节点是父节点的右子节点
                    }else {
                        parent.right = target.left;
                    }
                 //有右子节点
                }else {
                    //要删除的节点是父节点的左子节点
                    if(parent.left.value == value){
                        parent.left = target.right;
                    //要删除的节点是父节点的右子节点
                    }else {
                        parent.right = target.right;
                    }
                }
            }
        }
    }

    /**
     * 删除一棵树中最小节点
     * @param node  实际要删除的目标结点的右子节点
     * @return  返回 右子树 中的最小值
     */
    private int deleteMin(Node node){
        Node target = node;
        //递归向左找
        while(target.left != null){
            target = target.left;
        }
        //删除最小的这个节点
        delete(target.value);
        return target.value;
    }

    /**
     * 寻找父节点
     */
    public Node searchParent(int value){
        if(root == null){
            return null;
        }else{
            return root.searchParent(value);
        }
    }

    /**
     * 向二叉排序树中添加节点
     */
    public void add(Node node){
        //如果是空树
        if(root == null){
            root=node;
        }else {
            root.add(node);
        }
    }

    /**
     * 查找节点
     */
    public Node search(int value){
        if(root == null){
            return null;
        }else{
            return root.search(value);
        }
    }

    /**
     * 遍历树
     */
    public void midShow(){
        if(root != null){
            root.midShow(root);
        }
    }
}
