import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

public class EvaluateGCFAlgorithm {

    public static void main(String[] args) {
        System.out.println("Warming up the JVM...");
        for (int i = 0; i < 50000; i++) {
            GCFAlgorithm.gcf1(12345, 67890);
            GCFAlgorithm.gcf2(12345, 67890);
            GCFAlgorithm.gcf3(12345, 67890);

            GCFAlgorithm.gcf1(12, 60);
            GCFAlgorithm.gcf2(45, 67);
            GCFAlgorithm.gcf3(125, 678);

        }
        System.out.println("Warm-up complete. Starting test...\n");
        // --- END OF WARM-UP ---

        // The exact test cases from your instructions, plus one extreme case
        // to clearly demonstrate the inefficiency of gcf3.
        int[][] testCases = {
           // Small numbers (negligible difference)
            {2, 6},
            {7, 13},
            {15, 15},
            {17, 13},
            {48, 18},
            
            // Medium numbers (starting to show slight variations)
            {200, 1},
            {1000, 500},
            
            // Large numbers (where gcf3 starts to slow down)
            {12345, 54321},
            {50000, 25},
            {100000, 2},
            
            // Very large numbers (the "efficiency gap" becomes obvious)
            {500000, 1},
            {999999, 3},
            {1000000, 2},
            {2000000, 2}
            
        };

        String filename = "results.txt";

        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            
            // Formatting to perfectly match the table style in your instructions
            String header = String.format("%-10s | %-12s | %-12s | %-12s |", "a, b", "gcf1", "gcf2", "gcf3");
            String divider = "--------------------------------------------------------";
            
            System.out.println(header);
            System.out.println(divider);
            writer.println(header);
            writer.println(divider);

            for (int[] pair : testCases) {
                int a = pair[0];
                int b = pair[1];
                String pairStr = a + ", " + b;

                // --- Test GCF 1 ---
                long start1 = System.nanoTime();
                int result1 = GCFAlgorithm.gcf1(a, b);
                long time1 = System.nanoTime() - start1;

                // --- Test GCF 2 ---
                long start2 = System.nanoTime();
                int result2 = GCFAlgorithm.gcf2(a, b);
                long time2 = System.nanoTime() - start2;

                // --- Test GCF 3 ---
                long start3 = System.nanoTime();
                int result3 = GCFAlgorithm.gcf3(a, b);
                long time3 = System.nanoTime() - start3;

                // Format the row with pipes to match the example
                String resultRow = String.format("%-10s | %-12d | %-12d | %-12d |", pairStr, time1, time2, time3);
                System.out.println(resultRow);
                writer.println(resultRow);
            }

            System.out.println("\nSuccess! Results have been saved to " + filename);

        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}
