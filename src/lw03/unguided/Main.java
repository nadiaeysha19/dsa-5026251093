package lw03.unguided;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));

        Map<String, Integer> dataa = new LinkedHashMap<String, Integer>();
        Map<String, String> cekDataa = new LinkedHashMap<String, String>();
        int reject = 0;

        while(in.hasNextLine()) {
            String operation = in.next();
            String course = in.next();
            int amount;

            if(operation.equals("REGISTER")) {
                amount = in.nextInt();
                if(dataa.containsKey(course)) {
                    int currentAmount = dataa.get(course);
                    dataa.put(course, amount + currentAmount);
                } else {
                    dataa.put(course, amount);
                }
            } else if(operation.equals("WITHDRAW")) {
                amount = in.nextInt();
                if(dataa.containsKey(course)) {
                    int currentAmount = dataa.get(course);
                    if(currentAmount >= amount) {
                        dataa.put(course, currentAmount - amount);
                    } else {
                        reject++;
                    }
                } else {
                    reject++;
                }
            } else if(operation.equals("CHECK")) {
                if(dataa.containsKey(course)) {
                    cekDataa.put(course, String.valueOf(dataa.get(course) + " students"));
                } else {
                    cekDataa.put(course, "Not Found");
                    reject++;
                }
            } else {
                reject++;
            }
        }

        System.out.println("===== Enrollment Checks =====");
        for (String matkul : cekDataa.keySet()) {
            System.out.println(matkul + ": " + cekDataa.get(matkul));
        }

        System.out.println("\n===== Final Enrollment =====");
        for (String matkuls : dataa.keySet()) {
            System.out.println(matkuls + ": " + dataa.get(matkuls) + " students");
        }

        System.out.println("\nRejected operations: " + reject);
    }

}
