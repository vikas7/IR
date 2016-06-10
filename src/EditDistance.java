import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class EditDistance {
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the First String");
		String str1=br.readLine();
		System.out.println("Enter the second String");
		String str2=br.readLine();
		System.out.println(FindTheCost(str1,str2,str1.length(),str2.length()));
	}
	public static int FindTheCost(String str1, String str2, int l1, int l2){
		if(l1==0){
			return l2;
		}
		if(l2==0){
			return l1;
		}
		if(str1.charAt(l1-1)==(str2.charAt(l2-1))){
			return FindTheCost(str1,str2,l1-1,l2-1);
		}
		return 1+Math.min(FindTheCost(str1,str2,l1,l2-1), Math.min(FindTheCost(str1,str2,l1-1,l2), FindTheCost(str1,str2,l1-1,l2-1)));
	}

}
