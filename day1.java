import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class day1 {
    public static void main(String[] args) {
        String fileName = "day1.txt";
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        try {
            File file = new File(fileName);
            Scanner scan2 = new Scanner(file);
            
            while (scan2.hasNextLine()) {
                String[] word = scan2.nextLine().split("   ");

                list1.add(Integer.parseInt(word[0]));
                list2.add(Integer.parseInt(word[1]));
            }
        }
        catch (IOException e){
            System.out.println("An IOException occured: " + e.getMessage());
        }

        Collections.sort(list1);
        Collections.sort(list2);

        HashMap<Integer, Integer> listCount = new HashMap<>();

        for (int i = 0; i < list1.size(); i++){
            listCount.put(list1.get(i), 0);
            System.out.println(list1.get(i));
            
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(1).equals(list2.get(j))) {
                    listCount.put(list1.get(i), listCount.get(list1.get(i)) + 1);
                }
            }

        }

        int sum = 0;
        for (int i = 0; i < list1.size(); i++) {
            sum += list1.get(i) * listCount.get(list1.get(i));
        }

        System.out.println(sum);
    }
}