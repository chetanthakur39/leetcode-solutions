class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        for(int i=0;i<numbers.length;i++){
            int m = numbers[i];
            int req = target - numbers[i];

            int low = i+1;
            int high = numbers.length-1;

            while(low<=high){
              int  mid = low + (high-low)/2;

              if(numbers[mid] == req){
                return new int[] {i+1,mid+1};
              }
              else if(numbers[mid]<req){
                  low = mid+1;
              }
              else{
                high = mid-1;
              }
            }
        }
         return new int[] {};

    }

}