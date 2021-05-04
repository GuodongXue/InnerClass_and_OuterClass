package com.gdx.test01;
//外部类的修饰只能是public， default
public class testOuter {
    //属性，方法， 构造器， 代码块， 普通快， 静态块， 构造快， 同步块, 内部类
    private int age;
    int a = 10;
    public void eat(){
        {
            System.out.println("这是普通块");
        }
        //内部类创建了比private更小的权限， 外部类访问不了内部类
        //System.out.println(name);
        //想要调用， 必须要创建对象
        TestInner t = new TestInner();
        System.out.println(t.name);

    }
    public testOuter(){
        {
            System.out.println("这是构造块");
        }

    }
    static{
        System.out.println("这是一个静态块");
    }
    //1.成员内部类， 可以是public， private， default， 和protected
    public class TestInner extends com.gdx.Student.Student{

        String name;
        int a = 20;
        public void sleep(){
            int a = 30;
            System.out.println(age);
            System.out.println(a);//这里的a是30
            System.out.println(this.a);//这里a是20
            System.out.println(testOuter.this.a);//这里的a就是10了
        }
        //内部类创建了比private更小的权限， 外部类访问不了内部类
        public class aa{
            //内部类里还是可以再有内部类
        }

    }

    public static void main(String[] args) {
        testOuter to = new testOuter();
        //创建内部类对象
        //TestInner ti = new TestInner();
        //不行，需要以下
        TestInner ti = to.new TestInner();
        int age = to.age;
        //这两句话原理相同， 上面是访问了外部类里的内部类， 下面是访问了外部类里的变量
        ti.sleep();
        //内部类也会产生一个独自的字节码文件
        //内部类的对象
        //内部类可以有比private还小的访问
        //可以实现java的多继承
    }
}

