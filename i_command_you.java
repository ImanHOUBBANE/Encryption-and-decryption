import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;
import java.lang.String;

public class i_command_you {
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
        StringBuilder mode = new StringBuilder();
        StringBuilder data = new StringBuilder();
        int key =0;

        if (args.length>0){
            List<String> args_array_list = new ArrayList<>(Arrays.asList(args));
            if (args_array_list.contains("-mode") == true){
                mode.setLength(0);
                int index = args_array_list.indexOf("-mode");
                mode.append(args_array_list.get(index+1));

            }


            if (args_array_list.contains("-mode") == false){
                mode.setLength(0);
                mode.append("enc");
            }


            if (args_array_list.contains("-key")== true){
                int index  = args_array_list.indexOf("-key");
                key = Integer.parseInt(args_array_list.get(index+1));
            }


            if (args_array_list.contains("-key")== false){
                key = 0;
            }

            if (args_array_list.contains("-data")== true){
                int index  = args_array_list.indexOf("-data");
                data.append(args_array_list.get(index+1));
            }

            if (args_array_list.contains("-data")== false){
                data.setLength(0);
                data.append("");
            }


        }
        else{
            data.append("");
            mode.append("enc");
            key=0;
        }
        String element_chara= " !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~";
        // encryption choice
        if (mode.toString().equals("enc")){
            System.out.println(encryption(data.toString(),key,element_chara));
        }
        //decryption choice
        if (mode.toString().equals("dec")){
            System.out.println(decryption(data.toString(),key,element_chara));
        }

    }
}
