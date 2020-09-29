package forward.base.Tu;

import java.awt.print.PrinterAbortException;

/**
 * TODO
 * 顶点类
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/12 - 1:32
 * @since jdk 1.8
 */
public class Vertex {
    private String value;
    //标志该顶点是否已经遍历过
    public boolean visited;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Vertex(String value) {
        this.value = value;
    }
}
