package test01;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/17.
 */
public class Dog extends Animal{

    public Dog() {
    }

    public Dog(String name, int age, String brand) {
        super(name, age, brand);
    }

    @Override
    public void track() {
        System.out.println(getName() + "的攻击行为是咬");
    }

    public static void main(String[] args) {
        Dog dog = new Dog("旺财",4,"二哈");
        dog.track();
    }
}
