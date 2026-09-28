package lw02.unguided;

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));

        LinkedList<String[]> dataRequest = new LinkedList<String[]>();
        LinkedList<String[]> stockBuku = new LinkedList<String[]>();
        LinkedList<String[]> dataMember = new LinkedList<String[]>();
        Queue<String[]> prosesRequest = new LinkedList<String[]>();
        Queue<String[]> success = new LinkedList<String[]>();
        Stack<String[]> failed = new Stack<>();
        
        String[] kalkulus = {"Kalkulus", "2"};
        String[] fisika = {"Fisika", "2"};
        String[] statistika = {"Statistika", "2"};

        stockBuku.add(kalkulus);
        stockBuku.add(fisika);
        stockBuku.add(statistika);

        while(sc.hasNext()) {
            String peminjam = sc.next();
            String bookTitle = sc.next();
            String[] dataPeminjaman = {peminjam, bookTitle};

            dataRequest.add(dataPeminjaman);
        }

        sc.close();

        prosesRequest.addAll(dataRequest);

        while(!prosesRequest.isEmpty()) {
            String[] request = prosesRequest.poll();
            String name = request[0];
            String book = request[1];

            String[] anggota = null;

            for(String[] data : dataMember) {
                if(data[0].equals(name)) {
                    anggota = data;
                    break;
                }
            }

            if (anggota == null) {
                anggota = new String[] {name, "0"};
                dataMember.add(anggota);
            }

            int jumlahPinjam = Integer.parseInt(anggota[1]);
            int max = 2;
            boolean firstCondition = false;
            boolean secondCondition = false;

            for(int i=0; i < stockBuku.size(); i++) {
                if(book.equals(stockBuku.get(i)[0])) {
                    if(Integer.parseInt(stockBuku.get(i)[1]) >= 1) {
                        firstCondition = true;
                    }
                    break;
                }
            }

            for (int j=0; j < dataMember.size(); j++) {
                if(name.equals(dataMember.get(j)[0])) {
                    int batasan = Integer.parseInt(dataMember.get(j)[1]);

                    if (max > batasan) {
                        secondCondition = true;
                    }

                    break;
                }
            }

            if (firstCondition && secondCondition) {
                jumlahPinjam += 1;
                anggota[1] = String.valueOf(jumlahPinjam);
                int stockSisa;

                for (int i=0; i<stockBuku.size(); i++){
                    stockSisa = Integer.parseInt(stockBuku.get(i)[1]) -1;

                    stockBuku.get(i)[1] = String.valueOf(stockSisa);
                }

                success.add(request);

            } else {
                failed.push(request);
            }

        }

        System.out.println("=== Sucessfully Processed Requests ===");
        while(!success.isEmpty()) {
            String[] sukses = success.poll();

            System.out.println(sukses[0] + " " + sukses[1] + " ");

        }

        System.out.println();

        System.out.println("=== Remaining Book Stock");
        for(int i=0; i<stockBuku.size(); i++) {
            System.out.println(stockBuku.get(i)[0] + " : " + stockBuku.get(i)[1]);
        
        }

        System.out.println();

        System.out.println("=== Failed Requests ====");
        while(!failed.isEmpty()) {
            String[] gagal = failed.pop();

            System.out.println(gagal[0] + " " + gagal[1]);
        }
    }
}
