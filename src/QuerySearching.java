import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;


public class QuerySearching {
	static ArrayList<String> list0=new ArrayList<String>();
	static ArrayList<String> list1=new ArrayList<String>();
	static ArrayList<String> list2=new ArrayList<String>();
	static ArrayList<String> list3=new ArrayList<String>();
	static ArrayList<String> list4=new ArrayList<String>();
	static ArrayList<String> total=new ArrayList<String>();
	static ArrayList<ArrayList<String>> cList=new ArrayList<ArrayList<String>>(){{add(list0);add(list1);add(list2);add(list3);add(list4);}};
	

	public static void main(String[] args) throws IOException {
		System.out.println("Enter the size of n-gram");
		BufferedReader br3=new BufferedReader(new InputStreamReader(System.in));
		int size=Integer.parseInt(br3.readLine());
		File[] files=new File[5];
		files[0]=new File("Aladdin,The wonderful lamp.txt");
		files[1]=new File("Cindrella.txt");
		files[2]=new File("Elizabeth Fry, the angel of the prisons.txt");
		files[3]=new File("Lewis Carroll in Wonderland and at home, the story of his life.txt");
		files[4]=new File("The magic ring and other Oriental fairy tales.txt");
		
		Set<String> term=new HashSet<String>();
		Set<String> doc1=new HashSet<String>();
		Set<String> doc2=new HashSet<String>();
		Set<String> doc3=new HashSet<String>();
		Set<String> doc4=new HashSet<String>();
		Set<String> doc5=new HashSet<String>();
		Set[] doc={doc1,doc2,doc3,doc4,doc5};
		
		
		
		File[] files1=new File[5];
		files1[0]=new File("doc1.txt");
		files1[1]=new File("doc2.txt");
		files1[2]=new File("doc3.txt");
		files1[3]=new File("doc4.txt");
		files1[4]=new File("doc5.txt");
		
		for(int i=0;i<5;i++){
			
			files1[i].createNewFile();
			BufferedReader br=new BufferedReader(new FileReader(files[i]));
			BufferedWriter br1=new BufferedWriter(new FileWriter(files1[i]));
			String str=br.readLine();
			while(str!=null){
			
			
				String string1=str.replaceAll("[,~/!().&|%@\\<>:*;^&\"\'0-9@#$?\\-]+", " ");
				br1.write(string1.trim());
				String[] string=string1.split(" " );
				
				for(int j=0;j<string.length;j++){
					term.add(string[j].trim());
					doc[i].add(string[j]);
					br1.write(string[j]+" ");
				}
				
				str=br.readLine();
		}
			if(br1!=null){
				br1.flush();
				br1.close();
			}
}	
		
		
		
		list0=	findNgram(files1[0],size);
		list1=findNgram(files[1],size);
		list2=findNgram(files[2],size);
		list3=findNgram(files[3],size);
		list4=findNgram(files[4],size);
		
		Iterator<String> listItr=total.iterator();
		HashMap<String,Set<String>> invertedBi=new HashMap<String, Set<String>>();
		while(listItr.hasNext()){
			String s=listItr.next();
			Set<String> set=new HashSet<String>();
			if(!invertedBi.containsKey(s)){
				if(list0.contains(s)){
					set.add("0");
				}
				if(list1.contains(s)){
					set.add("1");
				}
				if(list2.contains(s)){
					set.add("2");
				}
				if(list3.contains(s)){
					set.add("3");
				}
				if(list4.contains(s)){
					set.add("4");
				}
				invertedBi.put(s, set);
			}
		
			
		}
		
	for(String s:invertedBi.keySet()){
		System.out.println(s+" :"+invertedBi.get(s));
	}
	
	
	
	System.out.println("Enter the phrase :");
	
	BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
	String phrase=b.readLine();
	
		
		
		if(invertedBi.containsKey(phrase)){
			System.out.println(invertedBi.get(phrase));
		}		
			
	}
	
	
	public static ArrayList<String> findNgram(File str, int size) throws IOException{
			
		
		BufferedReader br2=new BufferedReader(new FileReader(str));
		StringBuilder st=new StringBuilder();
		String nSt=br2.readLine();
		
		while(nSt!=null){
			String mst=nSt.replaceAll("[,~/!().&|%@\\<>:*;^&\"\'0-9@#$?\\-]+", " ");
			st.append(mst);
			st.append(" ");
			nSt=br2.readLine();
		}
		nSt=st.toString();
	
	
		String[] string=nSt.split(" ");
		ArrayList<String> ngrams=new ArrayList<String>(string.length-size+1);
		for(int i=0;i<string.length-size+1;i++){
			StringBuilder sb=new StringBuilder();
			for(int j=0;j<size;j++){
				if(j>0)
					sb.append(" ");
				sb.append(string[i+j]);
			}
			String bi=sb.toString();
			ngrams.add(bi);
			
			total.add(bi);
			
		}
		return ngrams;
	}
	
	
	public static String FindTheLine(File file,String phrase) throws IOException{
		LineNumberReader lineReader=new LineNumberReader(new FileReader(file));
		String number="";
		String line;
		while((line=lineReader.readLine())!=null){
			if(line.contains(phrase)){
				number+=","+lineReader.getLineNumber();
			}
		}
		return "["+number.substring(1)+"]";
	}
	

}
