package lw02.prelab;

import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(Main.class.getResourceAsStream("transaction.txt"));
        LinkedList<String[]> transactions = new LinkedList<>();
        LinkedList<String[]> customers = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> failed = new Stack<>();

        while (sc.hasNext()) {
            String nama = sc.next();
            String type = sc.next();
            String amount = sc.next();
            String[] data = {nama, type, amount};

            transactions.add(data);

            boolean cekCustomer = false;

            for(String[] customer: customers) {
                if (customer[0].equals(nama)) {
                    cekCustomer = true;
                    break;
                }

            }

            if (!cekCustomer) {
                String[] tambah = {nama, "0"};
                customers.add(tambah);
            }
        }

        sc.close();
        
        while (!transactions.isEmpty()) {
            queue.offer(transactions.remove());
        }

        while (!queue.isEmpty()) {

            String[] transaction = queue.poll();
            String name = transaction[0];
            String type = transaction[1];
            int amount = Integer.parseInt(transaction[2]);

            // String[] customer = null;
            for(String[] c : customers) {
                if (c[0].equals(name)) {
                    int balance = Integer.parseInt(c[1]);

                    if(type.equals("DEPOSIT")) {
                        balance += amount;

                        c[1] = String.valueOf(balance);
                    }

                    else if (type.equals("WITHDRAW")) {
                        
                        if (amount > balance) {
                            failed.push(transaction);
                        } else {
                            balance -= amount;
                            c[1] = String.valueOf(balance);
                        }
                    }

                    break;
                }
            }
        }

        System.out.println("=== Final Balances ===");

        for (String[] customer : customers) {
            System.out.println(customer[0] + " : " + customer[1]);
        }

        System.out.println("=== Failed Transactions ===");

        while (!failed.isEmpty()) {
            String[] gagal = failed.pop();

            System.out.println(gagal[0] + " " + gagal[1] + " " + gagal[2] + " ");
        }

    }
    
}
