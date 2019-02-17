package BuildServer.ServerStudy01;

/**
 * 存储person信息，一个person相当于一个类的对象
 * <person>
 *      <name>至尊宝</name>
 *      <age>9000</age>
 * </person>
 * 可看出包含name和age
 */
public class Person {
    private String name;
    private int age;
    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

