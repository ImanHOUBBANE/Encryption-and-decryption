import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;
import java.lang.String;

public class choices {

    private static final int last = 127;

    public static void main(String[] args) {


        String operation = "enc";
        String input = "";
        String algorithm = "shift";
        int key = 0;
        String outputFileName ="";
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-mode" -> operation = args[++i];
                case "-key" -> key = Integer.parseInt(args[++i]);
                case "-data" -> input = args[++i];
                case "-in" -> input = readFromFile(args[++i]);
                case "-alg" -> algorithm=args[++i];
                case "-out" -> outputFileName = args[++i];
            }
        }



        if  (algorithm.equals("shift")) {

            if (operation.equals("enc")) {
                encode2(input.toCharArray(), key, output);

            } else if (operation.equals("dec")) {
                decode2(input.toCharArray(), key, output);

            }
        }
        if(algorithm.equals("unicode")){

            if (operation.equals("enc")){
                encode1(input.toCharArray(), key, output);

            }
            else if (operation.equals("dec")){
                decode1(input.toCharArray(), key, output);

            }
        }

        if (outputFileName.equals("")) {
            System.out.println(output);
        } else {
            writeToFile(output.toString(), outputFileName);
        }
    }

    private static void encode2(char[] input,int key,StringBuilder output){
        String[] ascii = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        ArrayList<String> asciilist = new ArrayList<String>();
        asciilist.addAll(Arrays.asList(ascii));
        for (char ch : input) {

            String ch1 = Character.toString(ch).toLowerCase();
            if (asciilist.contains(ch1)) {
                int index = asciilist.indexOf(ch1);

                if (index + key >= 26) {
                    String ch2 = asciilist.get(((index + key) % 26));

                    if (Character.isUpperCase(ch)) {
                        String ch3 = ch2.toUpperCase();
                        output.append(ch3);
                    } else {
                        output.append(ch2);
                    }
                } else if (index + key < 26) {
                    String ch2 = asciilist.get(index + key);
                    if (Character.isUpperCase(ch)) {
                        String ch3 = ch2.toUpperCase();
                        output.append(ch3);
                    } else {
                        output.append(ch2);
                    }

                }
            }


            else if (asciilist.contains(ch1) == false) {
                output.append(ch);
            }


        }}



    private static void decode2(char[] input,int key,StringBuilder output) {
        String[] ascii = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        ArrayList<String> asciilist = new ArrayList<String>();
        asciilist.addAll(Arrays.asList(ascii));
        for (char ch : input) {

            String ch1 = Character.toString(ch).toLowerCase();
            if (asciilist.contains(ch1)) {
                int index = asciilist.indexOf(ch1);

                if (index - key < 0) {
                    String ch2 = asciilist.get(26 + ((index - key) % 26));
                    if (Character.isUpperCase(ch)) {
                        String ch3 = ch2.toUpperCase();
                        output.append(ch3);
                    } else {
                        output.append(ch2);
                    }
                } else if (index - key >= 0) {
                    String ch2 = asciilist.get(index - key);

                    if (Character.isUpperCase(ch)) {
                        String ch3 = ch2.toUpperCase();
                        output.append(ch3);
                    } else {
                        output.append(ch2);
                    }

            }

            }
            else if (asciilist.contains(ch1) == false) {
                output.append(ch);
            }
    }}





    private static void decode1(char[] input, int key, StringBuilder output) {
        for (char ch : input) {
            output.append((char)(((int) ch - key) % last));
        }

    }

    private static void encode1(char[] input, int key, StringBuilder output) {
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
