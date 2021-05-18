package dp.lcs;

public class LongestRepeationgSubsequeneString {

	public static void main(String[] args) {
		String s1 = "AABEBCDD"; //AABEBCDD
	    String s2 = "AABEBCDD"; //GXTXAYB
	    
	   String subSeq =  topDown(s1, s2, s1.length(), s2.length());
	   System.out.println(subSeq);

	}
	public static String topDown(String str1, String str2, int len1, int len2) {
		int mat[][] =  new int[len1+1][len2+1];
		
		/*
		 * if(len1==0 || len2==0) return 0;
		 */
		for(int i=0;i<len1+1;i++) {
			mat[i][0]=0;
		}
		for(int i=0;i<len2+1;i++) {
			mat[0][i]=0;
		}
		
		/*
		 * if(str1.charAt(len1-1)== str2.charAt(len2-1)) return 1+ LCS(str1, str2, len1-1,
		 * len2-1); else { return Math.max(LCS(str1, str2, len1-1, len2), LCS(str1,
		 * str2, len1, len2-1)); }
		 */
		// len1 = i & len2 = j
		for(int i=1;i<len1+1;i++) {
			for(int j=1;j<len2+1;j++) {
				
				if(str1.charAt(i-1)==str2.charAt(j-1) && i!=j) {
					mat[i][j] = 1+ mat[i-1][j-1];
				}
				else {
					mat[i][j] = Math.max(mat[i-1][j], mat[i][j-1]);
				}
			}
		}
		return findSequence(str1, str2, mat);
		
	}
	
	/*
	 * Comments: 1. Here we will take the matrix and traverse through it upto the
	 * top. 2. We will check if both are same then we have to move i-1,j-1 and store
	 * the string. 3. if both are not same then we have to check i,j-1 is greater or
	 * i-1,j is greater. 4. we need to move toward greater and decrease the i or j.
	 * 5. now at end reverse the string and return.
	 */
	public static String findSequence(String str1, String str2,int mat[][]) {
		int i = str1.length(), j= str2.length();
		StringBuilder str = new StringBuilder();
		
		while(i>0 && j>0) {
			if(str1.charAt(i-1) == str2.charAt(j-1)  && i!=j) {
				str.append(str1.charAt(i-1));
				i--;
				j--;
			}
			else {
				if(mat[i][j-1]>mat[i-1][j]) {
					j--;
				}else {
					i--;
				}
			}
		}
		return str.reverse().toString();
	}


}
