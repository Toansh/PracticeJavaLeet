package leetcode;

import java.util.HashMap;

public class TwoSum {
    void main(){
       IO.println("Hello there");
       int[] result1=twoSum(new int[]{2,7,11,15},9);
       IO.println(result1[0]+""+result1[1]);
       int[] result2=twoSum(new int[]{3,2,4},6);
        IO.println(result2[0]+""+result2[1]);
    }



    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> hm1 = new HashMap<>();
            for(int i=0;i<=nums.length-1;i++){
                int complement=target - nums[i];
                if(hm1.containsKey(complement)) {
                    return new int[]{i, hm1.get(complement)};
                }
                else hm1.put(nums[i],i);
                }
        return null;
            }

    }
