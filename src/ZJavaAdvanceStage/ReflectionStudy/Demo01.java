package ZJavaAdvanceStage.ReflectionStudy;

/**
 * 测试各种类型（class,interface,enum,annotation,primitive type,void）对应的java.lang.Class对象的获取方式
 *
 */
public class Demo01 {
    public static void main(String[] args) {
        String path = "ZJavaAdvanceStage.ReflectionStudy.bean.User";

        try {
            Class clazz = Class.forName(path);
            //对象是表示或封装一些数据。一个类被加载后，JVM会创建一个对应该类的Class对象，类的整个结构信息会放到对应的Class对象中
            //这个Class对象就像一面镜子，通过这面镜子可以看到对应类的全部信息
            System.out.println(clazz.hashCode());
            Class clazz2 = Class.forName(path); //一个类只对应一个Class对象
            System.out.println(clazz2.hashCode());

            //方式2
            Class strClazz = String.class;
            Class strClazz2 = path.getClass();
            System.out.println(strClazz==strClazz2); //true

            int[] a1 = new int[10];
            int[] a2 = new int[20];
            int[][] a3 = new int[30][3];
            double[] a4 = new double[10];
            System.out.println(a1.getClass().hashCode());
            System.out.println(a2.getClass().hashCode());
            System.out.println(a3.getClass().hashCode());
            System.out.println(a4.getClass().hashCode());

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
