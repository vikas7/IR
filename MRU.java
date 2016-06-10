import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class MRU {
	static int page_fault;
	static ArrayList<Integer> pg_table;
	public static void main(String args[]) throws NumberFormatException, IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the starting index of the outer loop");
		int index_outer=Integer.parseInt(br.readLine());
		System.out.println("Enter the index of the inner loop");
		int index_inner=Integer.parseInt(br.readLine());
		System.out.println("Enter the size of the outer loop");
		int size_Outer=Integer.parseInt(br.readLine());
		System.out.println("Enter the size of the inner  loop");
		int size_Inner=Integer.parseInt(br.readLine());
		System.out.println("Enter the buffer size");
		int buffer_Size=Integer.parseInt(br.readLine());
		System.out.println(FindPageFault( index_outer,index_inner, size_Outer,size_Inner,buffer_Size));
	}
	public static int FindPageFault(int index_Outer,int index_Inner,int size_Outer, int size_Inner, int buffer_Size) throws IOException{
		page_fault=0;
		FileWriter fw=new FileWriter("vikas.txt");
		pg_table=new ArrayList<Integer>(buffer_Size);
		for(int i=index_Outer;i<index_Outer+size_Outer;i++){
			 insertIntoTable(pg_table,i,buffer_Size,fw);
			
			for(int j=index_Inner;j<index_Inner+size_Inner;j++){
				insertIntoTable(pg_table,j,buffer_Size,fw);
				
			}
		}
		return page_fault;
	}
	
	
	public static void insertIntoTable(ArrayList<Integer> pg_table, int element,int buffer_Size,FileWriter fw) throws IOException{
		
		if(pg_table.contains(element)){
			int index=pg_table.indexOf(element);
			pg_table.remove(index);
			pg_table.add(0,element);
			
		}else{
			if(pg_table.size()>=buffer_Size){
				pg_table.remove(0);
				pg_table.add(0,element);
				fw.write("page fault for the page number  :"+element);
				//fw.write(newline());
				page_fault++;
			}else{
				pg_table.add(0,element);
				fw.write("page fault for the page number  :"+element);
				page_fault++;
			}
		}
		
		
	}
}
