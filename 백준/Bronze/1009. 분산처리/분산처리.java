import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			String str = br.readLine();
			String st[] = str.split(" ");
			int a = Integer.parseInt(st[0]);
			int b = Integer.parseInt(st[1]);
			int num = 1;
			for (int j = 0; j < b; j++) {
				num = (a * num) % 10; 
				if (num == 0) {
					num = 10;
				}
			}
			System.out.println(num);
		}
	}
}