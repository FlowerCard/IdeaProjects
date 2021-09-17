package test01;

/**
 * @author HuaPai
 * @email HuaPai@odcn.live
 * Created on 2021/9/17.
 */
public abstract class Animal {
    
    private String name;
    private int age;
    private String brand;

    public Animal() {
    }
    
    public Animal(String name, int age, String brand) {
        this.name = name;
        this.age = age;
        this.brand = brand;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return age;
    }

    public String getBrand() {
        return brand;
    }
    
    public abstract void track();
}
