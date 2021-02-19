import java.io.*;
import java.util.Scanner;



public class FileMgt {
   public static void main(String[] args) {
        int a;
        System.out.println("Enter your choice..");
        System.out.println("1.Create File");
        System.out.println("2.Read File");
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
                switch(a){
            case 1: files file1 = new files();  
                   file1.WriteFile();
                break;
            case 2: // ReadFile();
                break;
            default:
                System.out.println("wrong input..");
        }
    }

    
}
class files {
    
    files() {
        
    }
    // This function is used for creating and writting in created file
    public void WriteFile(){
        try{
            
            FileWriter myWriter = new FileWriter("file1.txt");
            myWriter.write("This is created through progream..!");
            myWriter.close();
            System.out.println("File is Sucessfully created..");
        }        

        catch(IOException e){
            System.out.println("Error is Occurred..");
            e.printStackTrace();

        }
    }
}