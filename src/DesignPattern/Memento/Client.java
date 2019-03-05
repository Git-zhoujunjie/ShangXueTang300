package DesignPattern.Memento;

public class Client {
    public static void main(String[] args) {
        CareTaker ct = new CareTaker();

        Emp emp = new Emp("老周",20,1000);
        System.out.println("第一次："+emp.getName()+"---"+emp.getAge()+"---"+emp.getSalary());

//        //设置备忘点
//        EmpMemento mmt = emp.getMemento();
        //第一次设置备忘点
        ct.setEmpMemento(emp.getMemento());

        emp = new Emp("老李",30,3000);
        System.out.println("第二次："+emp.getName()+"---"+emp.getAge()+"---"+emp.getSalary());
        //第二次设置备忘点
        ct.setEmpMemento(emp.getMemento());

        emp = new Emp("老王",60,6000);
        System.out.println("第三次："+emp.getName()+"---"+emp.getAge()+"---"+emp.getSalary());
        //第三次设置备忘点
        ct.setEmpMemento(emp.getMemento());

        EmpMemento mmt = null;
        while((mmt = ct.getEmpMemento())!=null) {
            emp.recovery(mmt);
            System.out.println("备忘点：" + emp.getName() + "---" + emp.getAge() + "---" + emp.getSalary());
        }

    }
}
