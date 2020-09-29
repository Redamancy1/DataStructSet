package forward.base.Hash;

/**
 * TODO
 *  哈希表-本质数组
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/12 - 0:47
 * @since jdk 1.8
 */
public class HashTable {
    private StuInfo[] data = new StuInfo[100];

    /**
     * 直接存址法
     * 向散列表中添加元素
     * @param stuInfo 学生信息对象
     */
    public void put(StuInfo stuInfo){
        //调用散列函数获取存储位置-根据年龄
        int index = stuInfo.hashCode();
//        int index1 = stuInfo.hashCode1();
        //添加元素-将对象信息存到以年龄为下标的位置
        data[index] = stuInfo;
    }

    //通过 传入的对象判断查找哪一个下标的数据
    public StuInfo get(StuInfo stuInfo){
        return data[stuInfo.hashCode()];
    }
}
