import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class LruSLJ {
	static ArrayList<Integer> queue;
	static int page_fault=0;
	static int tableSize=0;
	
	
public static void main(String[] args) throws IOException{
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	FileWriter fw=new FileWriter("out.txt");
	
	System.out.println("Enter the details");
	String[] detail=br.readLine().split(" ");
	int outerIndex=Integer.parseInt(detail[0]);
	int outerBlock=Integer.parseInt(detail[1]);
	int nRecords=Integer.parseInt(detail[2]);
	
	int innerIndex=Integer.parseInt(detail[3]);
	int innerBlock=Integer.parseInt(detail[4]);
	int  rootIndex=Integer.parseInt(detail[5]);
	int level=Integer.parseInt(detail[6]);
	
	tableSize=Integer.parseInt(detail[7]);
	queue=new ArrayList<Integer>(tableSize);
	
	int blockFactor=Integer.parseInt(detail[8]);
	page_fault=0;
	for(int i=outerIndex;i<outerIndex+outerBlock;i++){
		
		addIntoTable(i);
		
		for(int j=1;j<=blockFactor;j++){
			int start=0;
			for(int k=0;k<level;k++){
				if(k==0){
					addIntoTable(rootIndex);
				}else{
					start=start*30+1;
					start=(int) (Math.random()*30)+start;
					int block=rootIndex+start;
					addIntoTable(block);
				}
			}
			int blockInFile=(int)(Math.random()*innerBlock)+innerIndex;
			addIntoTable(blockInFile);
		//	System.out.println("Total Number of page Fault :"+page_fault);
		}

		
	}
System.out.println("Total Number of page Fault -----outer loop :"+page_fault);
	
	
	
	
}
public static void addIntoTable(int element) throws IOException{
	if(queue.contains(element)){
		int index=queue.indexOf(element);
		queue.remove(index);
		queue.add(element);
		//System.out.println("No page fault for :"+element);
		
		
		
	}else{
		if(queue.size()>=tableSize){
			queue.remove(0);
			queue.add(element);
			//System.out.println("Page fault for the element  :"+element);
			page_fault++;
		}else{
			queue.add(element);
		//	System.out.println("Page fault for the element  :"+element);
			page_fault++;
		}
	}
 
}
}
