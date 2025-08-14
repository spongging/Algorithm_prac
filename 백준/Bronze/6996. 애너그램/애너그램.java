import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        String ch1,ch2;
        for(int i=0;i<n;i++){
            ch1 = scanner.next();
            ch2 = scanner.next();

            char[] A = ch1.toCharArray();
            char[] B = ch2.toCharArray();

            Arrays.sort(A);
            Arrays.sort(B);

            if(Arrays.equals(A,B)){
                System.out.println(ch1+ " & " +ch2+ " are anagrams.");
            }else{
                System.out.println(ch1+ " & " +ch2+ " are NOT anagrams.");
            }
        }
    }
}