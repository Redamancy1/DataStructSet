package forward.base.Hash;

/**
 * TODO
 *  散列表函数设计/哈希表
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/12 - 0:43
 * @since jdk 1.8
 */
public class TestHashTable {
    public static void main(String[] args) {
        StuInfo s1 = new StuInfo(16,3);
        StuInfo s2 = new StuInfo(17,11);
        StuInfo s3 = new StuInfo(18,23);
        StuInfo s4 = new StuInfo(19,24);
        StuInfo s5 = new StuInfo(20,9);

        HashTable ht = new HashTable();
        ht.put(s1);
        ht.put(s2);
        ht.put(s3);
        ht.put(s4);
        ht.put(s5);

        //想要获取的目标数据
        StuInfo target = new StuInfo(18);
        StuInfo info = ht.get(target);
        System.out.println(info);


    }
}
