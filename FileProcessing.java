import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessing {
    public static void main(String[] args) {
        String inputFile = "C:\\Users\\vaibh\\OneDrive\\Documents\\Java-Development\\task4.txt";
        String outputFile ="C:\\Users\\vaibh\\OneDrive\\Documents\\Java-Development\\task4op.txt";

        try {
            FileReader fileReader = new FileReader(inputFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            double sum = 0;
            int count = 0;
            double max = Double.MIN_VALUE;
            double min = Double.MAX_VALUE;

            while ((line = bufferedReader.readLine()) != null) {
                try {
                    double num = Double.parseDouble(line.trim());
                    sum += num;
                    count++;
                    if (num > max) {
                        max = num;
                    }
                    if (num < min) {
                        min = num;
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Skipping non-numeric input: " + line);
                }
            }

            bufferedReader.close();
            fileReader.close();

            if (count > 0) {
                double average = sum / count;

                FileWriter fileWriter = new FileWriter(outputFile);
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

                bufferedWriter.write("Total numbers: " + count + "\n");
                bufferedWriter.write("Sum: " + sum + "\n");
                bufferedWriter.write("Average: " + average + "\n");
                bufferedWriter.write("Maximum number: " + max + "\n");
                bufferedWriter.write("Minimum number: " + min + "\n");

                bufferedWriter.close();
                fileWriter.close();

                System.out.println("Processing complete. Results written to " + outputFile);
            } else {
                System.out.println("No valid numbers found in the input file.");
            }

        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
