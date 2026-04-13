import java.util.Scanner;
import java.util.HashMap;

public class Task5 {
    public static int firstNonRepeatingChar(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (freqMap.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        int index = firstNonRepeatingChar(input);
        if (index == -1) {
            System.out.println("No non-repeating character found. Result: -1");
        } else {
            System.out.println("First non-repeating character: '" + input.charAt(index) + "'");
            System.out.println("Index: " + index);
        }

        scanner.close();
    }
}
