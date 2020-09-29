package forward.base.Tu;

import forward.base.Stack.MyStack;

/**
 * TODO
 *  图类，表示顶点关系
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/12 - 1:34
 * @since jdk 1.8
 */
public class Graph {

    private Vertex[] vertex;
    private int currentSize;
    //用来表示顶点之间的关系（矩阵图）
    public int[][] adjMat;
    //存放顶点数据的栈
    private MyStack stack= new MyStack();
    //存放当前遍历的下标
    private int currentIndex;

    public Graph(int size) {
        vertex = new Vertex[size];
        adjMat = new int[size][size];
    }

    /**
     * 深度优先遍历
     * 栈实现
     */
    public void dfs(){
    //把第 0 个顶点标记为已访问
      vertex[0].visited = true;
      //把第 0 个顶点的下标加入栈
        stack.push(0);
        //打印顶点的值
        System.out.println(vertex[0].getValue());
        out:while (!stack.isEmpty()){
            for(int i = currentIndex+1;i < vertex.length;i++){
                //与下一个有边且未访问
                if(adjMat[currentIndex][i]==1 && vertex[i].visited==false){
                    //压入栈
                    stack.push(i);
                    vertex[i].visited = true;
                    System.out.println(vertex[i].getValue());
                    continue out;
                }
            }
            //弹出栈顶元素
            stack.pop();
            //修改当前位置为栈顶元素的位置
            if(!stack.isEmpty()){
                currentIndex = stack.peek();
            }
        }
    }

    /**
     * 向图中加入一个顶点
     * @param v 要添加的顶点
     */
    public void addVertex(Vertex v){
        vertex[currentSize++] = v;
    }

    /**
     * 为顶点之间添加一条边
     * @param v1 顶点1
     * @param v2 顶点2
     */
    public void addEdge(String v1,String v2){

        //找出两个顶点下标
        int index1 = 0;
        for(int i = 0;i < vertex.length;i++) {
            if (vertex[i].getValue().equals(v1)) {
                index1 = i;
                break;
            }
        }
        int index2 = 0;
        for(int i = 0;i < vertex.length;i++){
            if(vertex[i].getValue().equals(v2)) {
                index2 = i;
                break;
            }
        }
        //在矩阵中对应位置赋值 1 ，代表两点直接互通有路
        adjMat[index1][index2] = 1;
        adjMat[index2][index1] = 1;


    }
}
