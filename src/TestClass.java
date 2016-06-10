import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
class TestClass{
	static Set<String> total_String=new HashSet<String>();
	public static void main(String args[]) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(br.readLine());
		while(t-->0){
			String inp=br.readLine();
			String[] input=inp.split(" ");
			int len=Integer.parseInt(input[0]);
			int seq=Integer.parseInt(input[1]);
			String first="O";
			String second="Z";
			findTheString(first,len);
			findTheString(second,len);
			
			TreeSet myTree=new TreeSet();
			
			myTree.addAll(total_String);
		
			ArrayList<String> ar=new ArrayList<String>(myTree);
			
			if(ar.size()>seq){
				
					System.out.println(ar.get(seq-1));
				
			}
			
		}

	}
	public static void findTheString(String word,int len){
		String newString=word;
		if(word.length()==len){
			total_String.add(newString);
		}
		else{
			if(word.charAt(word.length()-1)=='O'){
				newString=word+"O";
				findTheString(newString,len);
				newString=word+"Z";
				findTheString(newString,len);
			}
			else if(word.charAt(word.length()-1)=='Z'){
				newString=word+"O";
				findTheString(newString,len);
			}
		}
	}
}