package ZJavaAdvanceStage;

public class test {
    public static void main(String[] args) {
        long t1 = System.currentTimeMillis();
        String s1 = countAndSay1(30);
        System.out.println(s1);
        long t2 = System.currentTimeMillis();
        System.out.println("方法1： "+(t2-t1));
        System.out.println(s1.length());

        new Thread(()->{
            long t3 = System.currentTimeMillis();
            System.out.println(countAndSay2(30));
            long t4 = System.currentTimeMillis();
            System.out.println(t4-t3);
            System.out.println("方法3： "+(t4-t3));
        }).start();
    }
    public static String countAndSay1(int n) {
        if(n==1) return "1";

        if(n>1){
            String str = countAndSay1(n-1);
            //根据上一个结果得到本次结果
            int len = str.length();
            int i=0;
            String s="";

            int count = 1; //用来表示有几个连续的数字
            while(i<len){
                int j = i+1;
                if(j>=len){
                    s = s+count+str.charAt(i);
                    count=1;
                    i++;
                    continue;
                }
                if(str.charAt(i)==str.charAt(j)){
                    count++;
                    i++;
                    continue;
                }else{
                    s = s+count+str.charAt(i);
                    count=1;
                    i++;
                    continue;
                }
            }

            return s;
        }

        return "";
    }

    public static String countAndSay2(int n){
        String str="1";
        for(int t=2;t<=n;t++){
            int len = str.length();
            int i=0;
            String s="";

            int count = 1; //用来表示有几个连续的数字
            while(i<len){
                int j = i+1;
                if(j>=len){
                    s = s+count+str.charAt(i);
                    count=1;
                    i++;
                    continue;
                }
                if(str.charAt(i)==str.charAt(j)){
                    count++;
                    i++;
                    continue;
                }else{
                    s = s+count+str.charAt(i);
                    count=1;
                    i++;
                    continue;
                }
            }
            str = s;
        }

        return str;
    }
}
