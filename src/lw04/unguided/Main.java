package lw04.unguided;

import java.util.*;

public class Main {
    static void selectionSort(int[] arr, int passes) {
        for (int i = 0; i < arr.length && i < passes; i++) {
            int temp = arr[i];
            int min = arr[i];
            int idx = i;

            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    idx = j;
                }
            }

            arr[i] = min;
            arr[idx] = temp;
        }
    }

    static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("cards.txt"));

        int N = sc.nextInt();
        int[] cards = new int[N];
        
        for (int i = 0; i< N; i++)   {
            cards[i] = sc.nextInt();
        }

        selectionSort(cards, 2);

        for (int i=0; i<N; i++) {
            System.out.print(cards[i]);
            if(i < N-1) System.out.print(" ");
        }
        System.out.println();

        int ask = sc.nextInt();
        for (int i = 0; i < ask; i++) {
            int target = sc.nextInt();
            int found =linearSearch(cards, target);

            if (found != -1) {
                System.out.println(target + ": FOUND at index " + found);
            } else {
                System.out.println(target + ": NOT FOUND");
            }

        }
    }

    
}
