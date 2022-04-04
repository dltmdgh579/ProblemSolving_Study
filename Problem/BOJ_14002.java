import java.util.Scanner;
import java.util.Stack;

public class BOJ_14002 {

	public static void main(String[] args) {
				
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int[] arr = new int[A];
		int[] LIS = new int[A];
		
		for(int i=0; i<A; i++) {
			arr[i] = sc.nextInt();
		}
		
		int max = 0;
		int maxIdx = 0;
		for(int i=0; i<A; i++) {
			LIS[i] = 1;
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
					LIS[i] = LIS[j] + 1;
				}
			}
			if(LIS[i] > max) {
				max = LIS[i];
				maxIdx = i;
			}
		}
		
		Stack<Integer> stack = new Stack<>();
		
		int lisValue = max;
		for(int i=maxIdx; i>=0; i--) {
			if(LIS[i] == lisValue) {
				stack.push(arr[i]);
				lisValue--;
			}
		}
		
		System.out.println(max);
		while(!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}
		
	}

}
