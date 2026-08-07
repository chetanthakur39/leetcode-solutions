class Solution {
    public static int maxProfit(int[] arr) {
    int minPrice = arr[0];
    int tempBuyDay = 0;

    int buyDay = 0;
    int sellDay = 0;

    int maxProfit = 0;

    for (int i = 1; i < arr.length; i++) {

        // Update minimum price
        if (arr[i] < minPrice) {
            minPrice = arr[i];
            tempBuyDay = i;
        }

        int profit = arr[i] - minPrice;

        // Update maximum profit
        if (profit > maxProfit) {
            maxProfit = profit;
            buyDay = tempBuyDay;
            sellDay = i;
        }
    }

    System.out.println("Buy on day: " + buyDay);
    System.out.println("Sell on day: " + sellDay);

    return maxProfit;
}
    
public static void main(String[] args){
  int arr[] = {7,1,5,3,6,4};
  System.out.print(maxProfit(arr));
}
}