import java.io.*;
import java.util.*;

import java.io.FileNotFoundException;

public class ErrorHandling {
    public static void main(String[] args) throws FileNotFoundException{
        String inputFileName;
        Scanner in = new Scanner(System.in);
        System.out.println("What is the file name: ");
        inputFileName = in.nextLine();
        in.close();
        Scanner inFile = null;
        double total = 0;
        int count = 0;
        try{
            inFile = new Scanner(new File(inputFileName));
            while(inFile.hasNextDouble()){
                total += inFile.nextDouble();
                count++;
            }
            System.out.printf("The average is %.2f", (total/count));
            System.out.println();
        }
        catch(FileNotFoundException e){
            System.out.println("Input file was not found, try again.");
        }
        finally{
            try{
                inFile.close();
            }
            catch(NullPointerException e){
                System.out.println("Null Pointer Exception has occurred.");
            }
        }
    }
}
