package forward.base.Hash;

/**
 * TODO
 *  以学生年龄来取余数分配位置
 * @author Redamancy
 * @version 1.0
 * @date 2020/9/12 - 0:44
 * @since jdk 1.8
 */
public class StuInfo {
    //学生年龄
    int age;
    //学生年龄对应人数
    int nums;

    //构造方法
    public StuInfo(int age,int nums){
        this.age = age;
        this.nums = nums;
    }

    public StuInfo(int age) {
        this.age = age;
    }

    //散列函数-根据年龄-直接存址法
    public int hashCode(){
        return age;
    }

    //取余法，因为设置的年龄都是10~20范围内
    public int hashCode1(){
        return age%10;
    }


    @Override
    public String toString() {
        return "StuInfo{" +
                "age=" + age +
                ", nums=" + nums +
                '}';
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }
}
