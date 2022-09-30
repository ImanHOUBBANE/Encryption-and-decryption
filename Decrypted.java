import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;
import java.lang.String;

public class Decrypted {
    public static StringBuilder encryption(String input, int number,String charlist){
        StringBuilder output = new StringBuilder();
        for (int index=0; index<input.length();index++){
            char letter = input.charAt(index);
            int index_letter=charlist.indexOf(Character.toString(letter));
            if (index_letter != -1){
                if (index_letter + number >= charlist.length()){
                    int num = charlist.length()-index_letter-1;
                    String new_ = String.valueOf(charlist.charAt(number-num-1));

                    output.append(new_);
                }
                else{
                    String new_ = String.valueOf(charlist.charAt(index_letter + number ));

                    output.append(new_);
                }


            }
            else{
                output.append(letter);
            }

        }
        return output;

    }

    public static StringBuilder decryption(String input, int number,String charlist){
        StringBuilder output = new StringBuilder();
        for (int index=0; index<input.length();index++){
            char letter = input.charAt(index);
            int index_letter=charlist.indexOf(Character.toString(letter));
            if (index_letter != -1){
                if (index_letter - number < 0){
                    int num = number - index_letter;
                    String new_ = String.valueOf(charlist.charAt(charlist.length()-1-num));

                    output.append(new_);
                }
                else{
                    String new_ = String.valueOf(charlist.charAt(index_letter - number ));

                    output.append(new_);
                }


            }
            else{
                output.append(letter);
            }

        }
        return output;

    }


    public static void main(String[] args){
        Scanner scanner =  new Scanner(System.in);
        String choice = scanner.nextLine();
        String input = scanner.nextLine();
        int number = scanner.nextInt();
        String element_chara= " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        // encryption choice
        if (choice.equals("enc")){
            System.out.println(encryption(input,number,element_chara));
        }
        //decryption choice
        if (choice.equals("dec")){
            System.out.println(decryption(input,number,element_chara));
        }

    }
}
