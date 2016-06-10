import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


public class PriorityQ {
	static PriorityQueue<Integer> queue;
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the size of the priority queue");
		int size=Integer.parseInt(br.readLine());
		queue=new PriorityQueue<Integer>(size);
		
		
	}

}
