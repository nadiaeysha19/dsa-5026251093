package lw06.unguided;

import java.util.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner read = new Scanner(Main.class.getResourceAsStream("treenumbers.txt"));

        // Write your main code here

        BinarySearchTree bst = new BinarySearchTree();

        String firstLine = read.nextLine();
        String[] numbers = firstLine.trim().split(" ");

        for(String number : numbers) {
            int nilai = Integer.parseInt(number);
            bst.insert(nilai);
        }

        int target = read.nextInt();

        System.out.print("Preorder : ");
        bst.preOrder();

        System.out.print("Inorder : ");
        bst.inOrder();

        System.out.print("Postorder : ");
        bst.postOrder();

        System.out.println("Search " + target + " : " + bst.search(target));

        System.out.println("Minimum : " + bst.findMin());

        System.out.println("Maximum : " + bst.findMax());

        read.close();
    }
}
