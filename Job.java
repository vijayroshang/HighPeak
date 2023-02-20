package job;

import java.util.Collections;
import java.util.Scanner;

public class Job {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		 int sum=0;
		 int task=0;
		
		System.out.println("Enter the number of jobs:");
		int n=scanner.nextInt();
		int temp=n;
		int []start=new int[n];
		 int []end=new int[n];
		 int []earning=new int[n];
			System.out.println("Enter the start time, end time, earnings:");
		for (int i = 0; i <n; i++) {
			 start[i]=scanner.nextInt();
			 end[i]=scanner.nextInt();
			 earning[i]=scanner.nextInt();
			 sum+=earning[i];
		}
		for (int j = 0; j < earning.length; j++) {
			for(int i=1;i<earning.length;i++){
				if(earning[i-1]<earning[i]){
					temp=earning[i-1];
					earning[i-1]=earning[i];
					earning[i]=temp;
					
					temp=0;
					temp=start[i-1];
					start[i-1]=start[i];
					start[i]=temp;
					
					temp=0;
					temp=end[i-1];
					end[i-1]=end[i];
					end[i]=temp;
				}
				
			}
		}
		
		sum-=earning[0];
		n--;
		for (int i = 1; i < earning.length; i++) {
			if(end[i-1]< start[i] && start[i-1]<end[i] && start[i]<end[i]){//constraints
				
					sum-=earning[i];
					System.out.println(sum);
					n--;
			}else{
				end[i]=end[i-1];
				start[i]=start[i-1];
			}
		}
		System.out.println("The number of tasks and earnings available for others");
		System.out.println("task: "+n);
		System.out.println("earnings: "+sum);
		
	}
}	