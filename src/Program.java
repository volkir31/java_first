import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Converter{
    public static String toBinary(int digit){
        digit = digit;
        String binary = "";
        while(digit > 0){
            binary = (digit % 2) + binary;
            digit /= 2;
        }
        return binary;
    }
}

public class Program {
    private static boolean isDigit(String x) throws NumberFormatException{
        try{
            Integer.parseInt(x);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }
    public static void main(String[] args) throws IOException {
        File nf = new File("src/123.txt");
        if(nf.exists()){
            Path file = Path.of("src/123.txt");
            List<String> f = Files.readAllLines(file);
            for(String output_string: f){
                if(isDigit(output_string)){
                    System.out.println(Converter.toBinary(Integer.parseInt(output_string)));
                }
                else{
                    System.out.println(output_string+" not num");
                }
            }
        }
        int x = new Random().nextInt();
        int y = new Random().nextInt();
        System.out.println(x + " " + y + " " + gcd(x, y));
    }
    private static int gcd(int num1, int num2){
        if(num1 == 0){
            return num1;
        }
        else if(num2 ==0){
            return  num2;
        }
        else{
            while(num1 > 0 || num2 > 0){
                if(num1 >= num2){
                    num1 %= num2;
                }
                else{
                    num2 %= num2;
                }
                if(num1 == 0){
                    return num2;
                }
                else if(num2 == 0){
                    return num1;
                }
            }
        }
        return -1;
    }

}

