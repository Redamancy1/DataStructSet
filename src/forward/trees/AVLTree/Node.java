package forward.trees.AVLTree;

/**
 * TODO
 *  二叉平衡树
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/10 - 17:21
 * @since jdk 1.8
 */
public class Node {
    int value;
    Node left;
    Node right;

    public Node(int value){
        this.value = value;
    }

    public void midShow(Node node){
        if(node == null){
            return;
        }
        midShow(node.left);
        System.out.println(node.value);
        midShow(node.right);
    }

    /**
     * 查找节点
     */
    public Node search(int value){
        if(this.value == value){
            return this;
        }else if(value < this.value){
            if(left == null){
                return null;
            }
            return left.search(value);
        }else {
            if(right == null){
                return null;
            }
            return right.search(value);
        }
    }

    /**
     * 寻找节点的父节点
     * @param value 要查找的节点
     * @return 返回节点父节点
     */
    public Node searchParent(int value){
        if((this.left != null && this.left.value == value)
        || (this.right != null && this.right.value == value)){
            return this;
        }else{
            if(this.value>value && this.left!=null){
                return this.left.searchParent(value);
            }else if(this.value<value && this.right!=null){
                return this.right.searchParent(value);
            }
            return null;
        }
    }

    /**
     * 往子树中添加节点
     * @param node
     */
    public void add(Node node){
        if(node == null){
            return;
        }
        //判断传入的结点的值跟当前子树的节点的值大小关系
        if(node.value<this.value){
            //判断左节点是否为空
            if(this.left == null){
                this.left = node;
            }else {
                this.left.add(node);
            }
        }else{
            if(this.right == null){
                this.right = node;
            }else{
                this.right.add(node);
            }
        }
        //检查是否平衡-判断左右子树高度差是否>1
         //左长右短，右旋转
        if(leftHeight() - rightHeight() >= 2){
            //判断内层子树的高度情况
            // 内部是否需要双旋转
            // 即在整体左子树高度>右子树高度时，内部出现“左”<“右”
            if(left!=null && left.leftHeight()<left.rightHeight()){
                //子树先旋转
                left.leftRotate();
                //子树完成后再整体右旋转
                rightRotate();
            }else{
                //默认单旋转-左长右短，右旋转
                rightRotate();
            }
        }
        //左短右长，左旋转
        if(leftHeight() - rightHeight() <= -2){
            //判断内层子树的高度情况
            // 内部是否需要双旋转
            // 即在整体左子树高度<右子树高度时，内部出现“左”>“右”
            if(right!=null && right.rightHeight()<right.leftHeight()){
                //子树先旋转
                right.rightRotate();
                //子树完成后再整体左旋转
                leftRotate();
            }else{
                //默认单旋转-左短右长，左旋转
                leftRotate();
            }
        }
    }

    /**
     * 左旋转
     */
    public void leftRotate(){
        Node newLeft = new Node(value);
        newLeft.left = left;
        newLeft.right = right.left;
        value = right.value;
        right = right.right;
        left = newLeft;
    }

    /**
     * 右旋转
     */
    private void rightRotate(){
        //创建一个新的节点，值等于当前节点的值
        Node newRight = new Node(value);
        //把新节点的右子树设置成当前节点的右子树
        newRight.right = right;
        //把新节点的左子树设置成当前节点的左子树，的右子树
        newRight.left = left.right;
        //把当前节点的值设置成左子节点的值
        value = left.value;
        //把当前节点的左子树，设置成左子树的左子树（谋权篡位集体升级）
        left = left.left;
        //把当前节点的右子树设置为新节点
        right = newRight;
    }

    /**
     * 获取左子树的高度
     * @return 左子树高度
     */
    public int leftHeight(){
        if(left == null){
            return 0;
        }
        return left.height();
    }

    /**
     * 获取右子树的高度
     * @return 右子树高度
     */
    public int rightHeight(){
        if(right == null){
            return 0;
        }
        return right.height();
    }

    /**
     * 返回当前节点的高度
     * @return 高度
     */
    public int height(){
        //取左右子树的高度较大的，加上本身 1 ，就是该节点所在子树的高度
        return Math.max(left==null?0:left.height(),right==null?0:right.height())+1;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }
}
