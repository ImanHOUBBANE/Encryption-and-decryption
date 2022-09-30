import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class X_files {
    private static final int last = 127;

    public static void main(String[] args) {


        String operation = "enc";
        String input = "";
        int key = 0;
        String outputFileName ="";
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode" -> operation = args[++i];
                case "-key" -> key = Integer.parseInt(args[++i]);
                case "-data" -> input = args[++i];
                case "-in" -> input = readFromFile(args[++i]);
                case "-out" -> outputFileName = args[++i];
            }
        }

        switch (operation) {
            case "enc" -> encode(input.toCharArray(), key, output);
            case "dec" -> decode(input.toCharArray(), key, output);
        }

        if (outputFileName.equals("")) {
            System.out.println(output);
        } else {
            writeToFile(output.toString(), outputFileName);
        }
    }

    private static void decode(char[] input, int key, StringBuilder output) {
        for (char ch : input) {
            output.append((char)(((int) ch - key) % last));
        }
    }

    private static void encode(char[] input, int key, StringBuilder output) {
        for (char ch : input) {
            output.append((char)(((int) ch + key) % last));
        }
    }

    private static String readFromFile(String fileName) {

        StringBuilder input = new StringBuilder();
        File file = new File(fileName);

        try (Scanner readFile = new Scanner(file)) {
            while (readFile.hasNextLine()) {
                input.append(readFile.nextLine());
            }
        } catch (Exception e) {
            System.out.println("Error: File not found");
        }
        return input.toString();
    }

    private static void writeToFile(String output, String fileName) {
        File file = new File(fileName);

        try (PrintWriter printWriter = new PrintWriter(file)) {

            printWriter.println(output);
        } catch (IOException e) {
            System.out.println("Error: Can't write output to file");
        }
    }
}