package ZJavaAdvanceStage.AnnotationStudy;


 /*@AnnotationTest01 */   //这里有问题
@AnnotationTest01 //加上TYPE后就没问题了
public class Demo02 {
    @AnnotationTest01  //这里没问题
    public void test(){
    }

    @AnnotationTest02("2222")
    public void test2(){

    }
}
