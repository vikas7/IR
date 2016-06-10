import java.io.*;
import java.util.*;
/*class Block{
	int block_Id;
	int priority;
	Block(int id,int pri){
		block_Id=id;
		priority=pri;
	}
}*/




	class PriorityQueue1{
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the size of the Queue");
		int size_Queue=Integer.parseInt(br.readLine());

		Queue<Integer> queue=new PriorityQueue<Integer>(size_Queue);
		System.out.println("Enter the id and priority of the Block");
		String st=br.readLine();
		int size=0;
		int priority=0;
		while(!st.equals("@")){
			int str=Integer.parseInt(st);
		//	Block block=new Block(Integer.parseInt(str[0]),Integer.parseInt(str[1]));
			if(queue.size()<size_Queue){
				if(queue.contains(str)){
					queue.remove(str);
					
				}
				queue.add(str);
			}
			else{
				queue.poll();
				queue.add(str);
			}
			st=br.readLine();

		}
		printTheQueue(queue);


	}
	
	public static void printTheQueue(Queue<Integer> queue){
	//	int b=queue.size();
		while(queue.poll()>0){
			System.out.println("Block_Id :"+queue.poll());
			 //b=queue.poll();
		}
	}
}