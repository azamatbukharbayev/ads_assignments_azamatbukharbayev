public class Hashing {

    static int[] table;
    static int M = 7;

    public static void initTable() {
        table = new int[M];

        for (int i = 0; i < M; i++) {
            table[i] = -1;
        }
    }

    public static int hash(int key) {
        return key % M;
    }

    public static boolean insert(int key) {
        int index = hash(key);

        System.out.print("  Insert " + key + ": h(" + key + ") = " + key + " mod " + M + " = " + index);

        if (table[index] == -1) {
            table[index] = key;
            System.out.println(" → slot " + index + " is EMPTY → placed at index " + index);
            return true;
        } else {
            System.out.print(" → COLLISION with " + table[index]);

            int originalIndex = index;
            int probes = 1;

            index = (index + 1) % M;

            while (table[index] != -1) {
                index = (index + 1) % M;
                probes++;

                if (index == originalIndex) {
                    System.out.println(" → TABLE IS FULL! Cannot insert " + key);
                    return false;
                }
            }

            table[index] = key;
            System.out.println(" → probed " + probes + " slot(s) → placed at index " + index);
            return true;
        }
    }

    public static void printTable() {
        System.out.println("\n  Hash Table (M=" + M + "):");
        System.out.println("  +-------+-------+");
        System.out.println("  | Index | Value |");
        System.out.println("  +-------+-------+");

        for (int i = 0; i < M; i++) {
            if (table[i] == -1) {
                System.out.println("  |   " + i + "   | empty |");
            } else {
                System.out.printf("  |   %d   |  %3d  |%n", i, table[i]);
            }
        }

        System.out.println("  +-------+-------+");
    }

    public static void main(String[] args) {
        int[] data = {43, 42, 90, 74, 10, 29, 68, 73, 75, 62};

        System.out.println("====== Hash Table with Linear Probing ======");
        System.out.println("Table size M = " + M);
        System.out.println("Hash function: h(k) = k mod " + M);
        System.out.println("Dataset: {43, 42, 90, 74, 10, 29, 68, 73, 75, 62}");
        System.out.println();

        System.out.println("--- Hash values for each key ---");
        for (int i = 0; i < data.length; i++) {
            System.out.println("  h(" + data[i] + ") = " + data[i] + " mod " + M + " = " + hash(data[i]));
        }
        System.out.println();

        initTable();

        System.out.println("--- Inserting elements ---");
        int inserted = 0;
        for (int i = 0; i < data.length; i++) {
            boolean success = insert(data[i]);
            if (success) {
                inserted++;
            }
        }
        System.out.println("\n  Successfully inserted " + inserted + " out of " + data.length + " elements.");

        System.out.println("\n--- Final Hash Table ---");
        printTable();

        System.out.println("\n  Note: We have 10 elements but only 7 slots.");
        System.out.println("  With linear probing, the table overflows when");
        System.out.println("  all slots are filled. In practice, we would use");
        System.out.println("  a larger table (load factor < 0.75 is recommended).");
        System.out.println("  Here, only the first 7 elements can be inserted");
        System.out.println("  before the table is completely full.");
    }
}
