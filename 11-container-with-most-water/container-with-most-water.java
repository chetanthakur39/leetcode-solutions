class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;

        while (left < right) {
            int width = right - left;
            int h = Math.min(height[left], height[right]);
            int area = width * h;

            if (area > max) {
                max = area;
            }

            // Move the pointer with the smaller height
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return max;
    }
    
    public static void main(String args[]){
      int height[] = {8,6,2,5,4,8,3,7};
      Solution obj = new Solution();
      int result = obj.maxArea(height);
      System.out.print("max area is"+result);
    }
}