package 尚学堂java.类的继承;

/**
 * @author 智障过人的laoxie
 * @create 2019-01-29 23:03 星期二
 * 测试继承类
 */
public class TestExtends {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.height=160;
        stu.name = "laoxie";
        stu.rest();
        stu.study();
    }
}

class Person{
    String name;
    int height;
    public void rest(){
        System.out.println("休息一会！");
    }
}
class Student extends Person{
    String name;
    int height;
    String major;
    public void study(){
        System.out.println("学习两小时！！");
    }
}
