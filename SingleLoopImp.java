import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;


public class SingleLoopImp {
	static ArrayList<Integer> table;
	static int pageFault=0;
	static int pageTableSize;
	public static void main(String[] agrs) throws NumberFormatException, IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
   System.out.println("Enter the details");
		for(int t=0;t<2;t++);{
		System.out.println("Enter the query details");
		String[] d=br.readLine().split(" ");
		int blockOuter=Integer.parseInt(d[0]);
		int recordOuter=Integer.parseInt(d[1]);
		int blockFactor=Integer.parseInt(d[2]);
		int indexOuter=Integer.parseInt(d[3]);
		int indexInner=Integer.parseInt(d[4]); 
		int blockInner=Integer.parseInt(d[5]);
		int levelInner=Integer.parseInt(d[6]);
		int indexRoot=Integer.parseInt(d[7]);
		
		for(int b=0;b<8;b++){
			pageFault=0;
		   System.out.println("enter the buffer size");
		   pageTableSize	=Integer.parseInt(br.readLine());
		   table=new ArrayList<Integer>(pageTableSize);
		   for(int i=indexOuter;i<indexOuter+blockOuter;i++){
				addInTable(i);
			//	System.out.println("Outer block is added to the table");
				
				
				for(int j=1;j<=blockFactor;j++){
					int interBlock=indexRoot;
					int start=0;
					
					for(int k=0;k<levelInner;k++){
						if(k==0){
							addInTable(interBlock);
						}else{
							start=start*30+1;
							start=(int)(Math.random()*30)+start;	
						//	System.out.println("  Random numer is :"+start);
							int block=indexRoot+start;
						//	System.out.println("block in the B+ tree is :"+block);
							addInTable(block);
						}											
					}
					int blockInfile=(int)(Math.random()*blockInner)+indexInner;
					addInTable(blockInfile);
				//	System.out.println("Total number of Page Fault in inner loop are :"+pageFault);
					
					
				}
			}
		   System.out.println("Total number of Page Fault in inner loop are :"+pageFault);
		}
	}
		
		
		
		
		
	/*	System.out.println("Enter the number of blocks of the outer relation");
		int blockOuter=Integer.parseInt(br.readLine());
		System.out.println("Enter the number of records in the outer relation");
		int recordOuter=Integer.parseInt(br.readLine());
		System.out.println("Enter the number of records in a block");
		int blockFactor=Integer.parseInt(br.readLine());
		System.out.println("Enter the index of the outer loop");
		int indexOuter=Integer.parseInt(br.readLine());
		
		System.out.println("Enter the number of blocks of the inner relation");
		int blockInner=Integer.parseInt(br.readLine());
		System.out.println("Enter the number of records in the inner relation");
		int recordInner=Integer.parseInt(br.readLine());
		System.out.println("Enter the index of the inner loop");
		int indexInner=Integer.parseInt(br.readLine()); 
		System.out.println("Enter  levels in the inner relation");
		int levelInner=Integer.parseInt(br.readLine());
		
		System.out.println("Enter the size of the page table");
		pageTableSize=Integer.parseInt(br.readLine());
		
		 table=new ArrayList<Integer>(pageTableSize);
		
		 System.out.println("Enter the index of the root");
		 int indexRoot=Integer.parseInt(br.readLine());
		for(int i=indexOuter;i<indexOuter+blockOuter;i++){
			
			addInTable(i);
			System.out.println("Outer block is added to the table");
			
			
			for(int j=1;j<=blockFactor;j++){
				int interBlock=indexRoot;
				int start=0;
				
				for(int k=0;k<levelInner;k++){
					if(k==0){
						addInTable(interBlock);
					}else{
						start=start*30+1;
						start=(int)(Math.random()*30)+start;	
						System.out.println("  Random numer is :"+start);
						int block=indexRoot+start;
					//	System.out.println("block in the B+ tree is :"+block);
						addInTable(block);
					}											
				}
				int blockInfile=(int)(Math.random()*blockInner)+indexInner;
				addInTable(blockInfile);
				System.out.println("Total number of Page Fault in inner loop are :"+pageFault);
				
				
			}
		}*/
		
	}
	public static void addInTable(int block){
		if(table.contains(block)){
			int index=table.indexOf(block);
			table.remove(index);
			table.add(0,block);
		}else{
			if(table.size()>=pageTableSize){
				table.remove(0);
				table.add(0,block);
				pageFault++;
			}else{
				table.add(0,block);
				pageFault++;
			}
		}
		
	}

}
