package wallethub;

import java.util.Scanner;

public class Test {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            int local = 1, value = a + (local * b);
            String output = "" + value;
            
            for (int j = 1; j < n; j++) {
            	local*=2;
            	value = value + (local * b);
            	output = output + " " + value;
            }
            System.out.println(output);
        }
        in.close();
        
	}

}
