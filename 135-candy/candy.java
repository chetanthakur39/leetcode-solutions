class Solution {
    public int candy(int[] ratings) {
        int[] candyes = new int[ratings.length];
        // for giving one candy to each child
        Arrays.fill(candyes,1);

        // trverse from left to right

        for(int i=1;i<=ratings.length-1;i++){
            if(ratings[i-1] < ratings[i]){
               candyes[i] = candyes[i - 1] + 1;
            }
        }
       // traverse from right to left
            for(int i=ratings.length-2;i>=0;i--){
                if (ratings[i] > ratings[i + 1]) {
                candyes[i] = Math.max(candyes[i], candyes[i + 1] + 1);
            }
            }
            int total=0;
            for(int candy : candyes){
                total += candy;
            }
            return total;
    }
}