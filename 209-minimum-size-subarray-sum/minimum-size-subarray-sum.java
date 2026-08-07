class Solution {
    public int minSubArrayLen(int target, int[] nums) {

         int left = 0;
         int sum =0;
         int min_length= Integer.MAX_VALUE;;
         int length = 0;
   for(int right = 0; right < nums.length; right++){
         sum += nums[right];

         while(sum >= target){
        length  = right - left +1;
        min_length = Math.min(min_length,length);
               sum -= nums[left];
               left++;
             }
         }

         if(min_length == Integer.MAX_VALUE){
             return 0;
         }
         else{
            return min_length;
         }
        
}
    }
  