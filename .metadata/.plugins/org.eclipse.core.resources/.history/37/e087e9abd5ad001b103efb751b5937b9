import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;



public class Main1 {

	public static void main(String[] args) {
		String str = "abccc";
		ArrayList<ArrayList<Character>> temp = new ArrayList<ArrayList<Character>>();
			ArrayList<Character> list = new ArrayList<Character>();
			list.add('b');
			list.add('c');
			temp.add(list);
			ArrayList<Character> list2 = new ArrayList<Character>();
			list2.add('a');
			list2.add('b');
			temp.add(list2);
		solve(str, temp);

	}
	
	public static void solve(String str, ArrayList<ArrayList<Character>> list) {
		HashSet<Character> set = new HashSet<Character>();
		for(int i =0;i<str.length();i++)
			set.add(str.charAt(i));
		
		int total = set.size();
		int mark[] = new int[26];
		int flag = 0;
		for(int i=0;i<26;i++) {
			int ct = 0;
			if(mark[i]==0 && list.get(i).size()>0) {
				ct = dfs(i,list,mark);
			}
			char ch = (char)('a'+i);
			if(set.contains(ch)) {
				if(ct==total) {
					flag=1;
					break;
				}
				else {
					break;
				}
			}
		}
		if(flag==0)
			System.out.println("NO");
		else
			System.out.println("YES");
	}
	public static int dfs(int i, ArrayList<ArrayList<Character>> list,int[]mark) {
		int ct =1;
		mark[i]=1;
		for(int x:list.get(i)) {
			x=x-'a';
			if(mark[x]==0) {
				ct+=dfs(x,list,mark);
			}
		}
		return ct;
	}

}
