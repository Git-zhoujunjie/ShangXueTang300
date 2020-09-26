package test;

import java.util.Arrays;

public class test01 {
    public static void main(String[] args) {
        int[] a = {};

        //int[] b = Arrays.copyOfRange(a, 1, 4);

        //System.out.println(Arrays.toString(b));
        System.out.println(VerifySquenceOfBST(a));
    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length<=0) return false;

        return VerifySquenceOfBST2(sequence);
    }
    public static boolean VerifySquenceOfBST2(int [] sequence) {
        if(sequence.length<=0) return true;

        int root = sequence[sequence.length-1];
        int mid=0;
        for(int i=0;i<sequence.length-1;i++){
            if(sequence[i]>root){
                mid = i;
                for(int j=i;j<sequence.length-1;j++){
                    if(sequence[j]<root) return false;
                }
                break;
            }
        }
        int[] left = Arrays.copyOfRange(sequence,0,mid);
        int[] right = Arrays.copyOfRange(sequence,mid,sequence.length-1);

        return VerifySquenceOfBST2(left) || VerifySquenceOfBST2(right);
    }
}
