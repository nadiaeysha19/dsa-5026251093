package lw04.prelab;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("branches.txt"));
        int n = sc.nextInt();
        int[] arr = new int[n];

        for(int i=0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int passes = 3;

        for (int i = 1; i < n && i <= passes; i++) {
            int a = arr[i];
            int j = i-1;

            while (j >= 0 && arr[j] < a) {
                arr[j+1] = arr[j];
                j--;
            }

            arr[j+1] = a;
        }

        for(int b : arr) {
            System.out.print(b + " ");
        }

        System.out.println();

        int t = sc.nextInt();
        int[] nilai = new int[t];

        for(int i=0; i<t; i++) {
            nilai[i] = sc.nextInt();
            int target = nilai[i];
            boolean found = false;
            int idx = -1;

            for(int j=0; j<arr.length; j++) {
                if(arr[j] == target) {
                    found = true;
                    idx=j;
                    break;
                }
            }

            if(found) {
                System.out.println(target + ": FOUND at index " + idx);
            } else {
                System.out.println(target + ": NOT FOUND");
            }
        }

        sc.close();
    }
    
}
