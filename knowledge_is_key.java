import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.util.*;
import java.lang.String;

public class knowledge_is_key {
    public static void main(String[] args){
        Scanner scanner =  new Scanner(System.in);
        String input = scanner.nextLine();
        int number = scanner.nextInt();
        String[] ascii={"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
        ArrayList<String> asciilist = new ArrayList<String>();
        StringBuilder output = new StringBuilder();
        asciilist.addAll(Arrays.asList(ascii));
        for (int index=0; index<input.length();index++){
            char letter = input.charAt(index);
            int index_letter=asciilist.indexOf(Character.toString(letter));
            if (index_letter != -1){
                if (index_letter + number >= asciilist.size()){
                    int num = asciilist.size()-index_letter-1;
                    String new_ = asciilist.get(number-num-1);

                    output.append(new_);
                }
                else{
                    String new_ = asciilist.get(index_letter + number );

                    output.append(new_);
                }


            }
            else{
                output.append(letter);
            }

        }
        System.out.println(output);





    }
}

