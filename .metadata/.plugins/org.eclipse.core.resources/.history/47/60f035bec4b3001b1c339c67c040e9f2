package dp.knapsackunbounded;

//Rod Cutting Problem
public class UnboundedKnapsack {

	public static void main(String[] args) {
		int W = 8, val[]  = {1, 5, 8, 9, 10, 17, 17, 20}, wt[] = {1, 2,3,4,5,6,7,8};
		int sum = unboundedKnapsack(val, wt, W, val.length);
		System.out.println(sum);

	}
	
	public static int unboundedKnapsack(int[]val, int[] wt,int W, int n) {	
		if(W ==0 || n ==0 )
			return 0;
		else if(wt[n-1]<=W) {
			return  Math.max(val[n-1] + unboundedKnapsack(val, wt, W-wt[n-1], n),
					unboundedKnapsack(val, wt, W, n-1));					
		}
		else
			return unboundedKnapsack(val, wt, W, n-1);
	}
	
	//only change is i-1 to i
	// n==i, W==j
	public static int unboundedKnapsackDp(int[]val, int[] wt,int W, int n) {	
		int dp[][] = new int[n+1][W+1];
		
		for(int i=0;i<n+1;i++)
			dp[i][0]=0;
		for(int i=0;i<W+1;i++)
			dp[0][i]=0;
		
		for(int i=1;i<n+1;i++)
			for(int j=1;j<W+1;j++) {
				
				if(wt[i-1]<=j) {
					dp[i][j] = Math.max(val[i-1]+dp[i][j-wt[i-1]] , dp[i-1][j]); // remove i-1 to i bcz we need to include this as many as we can
				}
				else
					dp[i][j] = dp[i-1][j];
			}
		return dp[n][W];
		}

}
