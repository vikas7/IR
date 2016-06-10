import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class MakeGram {
	public static void main(String[] args) throws NumberFormatException, IOException{
		String input="I am vikas singh and I am a bad boy";
		System.out.println("Enter the size of n-gram");
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
		
		BufferedReader br=new BufferedReader(new FileReader("doc2.txt"));
		StringBuilder st=new StringBuilder();
		String nSt=br.readLine();
		while(nSt!=null){
			String mst=nSt.replaceAll("\\W", " ").replaceAll("_", " ").replaceAll("\\s+", " ");
			st.append(mst);
			st.append(" ");
			nSt=br.readLine();
		}
		nSt=st.toString();
		System.out.println(nSt);
		
		System.out.println(Arrays.toString(ngram(nSt,Integer.parseInt(br1.readLine()))));
		
	}
public static String[] ngram(String str, int size){
	String[] st=str.split(" ");
	String[] ngrams=new String[st.length-size+1];
	for(int i=0;i<st.length-size+1;i++){
		StringBuilder sb=new StringBuilder();
		for(int j=0;j<size;j++){
			if(j>0)
				sb.append(" ");
			sb.append(st[i+j]);
		}
		ngrams[i]=sb.toString();
	}
	return ngrams;
}
}
