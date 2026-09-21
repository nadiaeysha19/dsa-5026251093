package lw01.unguided;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Rental> rentals = new ArrayList<>();
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("./rentals.txt"));

        while (scanner.hasNext()) {
            int jumlah = scanner.nextInt();
            for (int i = 0; i <= jumlah; i++) {
                String type = scanner.next();
                String id = scanner.next();
                int days = scanner.nextInt();
                int units = scanner.nextInt();

                if (type.equals("PROJECTOR")) {
                    rentals.add(new ProjectorRental(id, days){
                        @Override 
                        public int calculateCharge() {
                            return super.calculateCharge(units);
                        }
                    });
                } else if (type.equals("LAPTOP")) {
                    rentals.add(new LaptopRental(id, days) {
                        @Override 
                        public int calculateCharge() {
                            return super.calculateCharge(units);
                        }
                    });
                }
            }

        }

        for (Rental rental : rentals) {
            System.out.println(rental.summary());
        }
    }
}
