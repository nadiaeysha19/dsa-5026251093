package lw03.prelab;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== Problem 1 =====");
        Scanner a = new Scanner(Main.class.getResourceAsStream("playlist.txt"));
        managePlaylist(a);

        System.out.println("===== Problem 2 =====");
        Scanner b = new Scanner(Main.class.getResourceAsStream("participants.txt"));
        manageParticipants(b);

        System.out.println("===== Problem 3 =====");
        Scanner c = new Scanner(Main.class.getResourceAsStream("inventory.txt"));
        manageInventory(c);
    }

    public static void managePlaylist(Scanner a) {
        List<String> playlist = new ArrayList<>();

        while(a.hasNextLine()) {
            String line = a.nextLine();
            String operation = line.substring(0, line.indexOf(" "));
            String information = line.substring(line.indexOf(" ") + 1);

            if (operation.equals("ADD")) {
                playlist.add(information);

            } else if (operation.equals("INSERT")) {
                int index = Integer.parseInt(information.substring(0, information.indexOf(" ")));
                String song = information.substring(information.indexOf(" ") + 1);
                playlist.add(index, song);

            } else {
                if(playlist.contains(information)) {
                    playlist.remove(information);
                } 
            }
        }

        int totalSongs = playlist.size();
        System.out.println("Total songs: " + totalSongs);

        for (int i = 0; i < totalSongs; i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }
    }

    public static void manageParticipants(Scanner b) {
        Set<String> participants = new LinkedHashSet<>();
        int noUnique = 1;
        int duplication = 0;

        while(b.hasNextLine()) {
            String name = b.nextLine();
            if (!participants.contains(name)) {
                participants.add(name);
            } else {
                duplication++;
            }
        }

        int totalParticipants = participants.size();
        System.out.println("Unique participants: " + totalParticipants);

        for (String participant : participants) {
            System.out.println(noUnique + ". " + participant);
            noUnique++;
        }

        System.out.println("Duplicate registrations: " + duplication);
    }

    public static void manageInventory(Scanner c) {
        Map<String, Integer> inventory = new LinkedHashMap<>();
        int failedTransactions = 0;

        while(c.hasNextLine()) {
            String operation = c.next();
            String product = c.next();
            int quantity = c.nextInt();

            if (operation.equals("ADD")) {
                if (inventory.containsKey(product)) {
                    inventory.put(product, inventory.get(product) + quantity);
                } else {
                    inventory.put(product, quantity);
                }
            } else {
                if (inventory.containsKey(product) && inventory.get(product) >= quantity) {
                    inventory.put(product, inventory.get(product) - quantity);
                } else {
                    failedTransactions++;
                }
            }
        }

        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Failed sales: " + failedTransactions);

    }

    
}
