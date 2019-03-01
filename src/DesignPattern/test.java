package DesignPattern;

public class test {
    public static void main(String[] args) {
        int[] a = {1,2,5,3,7,3,4,8,3};


        System.out.println(partitionArray(a,3));
    }
    static int partitionArray(int[] nums, int k) {
        // write your code here
        if(nums.length<1){
            return 0;
        }
        //快速排序
        int begin = 0;
        int end = nums.length-1;

        while(begin<=end){
            while(begin<=end){
                if(nums[begin]<k) begin++;
                else break;
            }
            while(begin<=end){
                if(nums[end]>=k) end--;
                else break;
            }

            int temp = nums[begin];
            nums[begin] = nums[end];
            nums[end] = temp;
        }
        return begin;
    }
}
