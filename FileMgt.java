import java.io.*;
import java.util.Scanner;



public class FileMgt {
    
   public static void main(String[] args) {
      
        System.out.println("Enter your choice..");
        System.out.println("1.Create File");
        System.out.println("2.Read File");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt(); 

        files objMgt = new files(); // bojecte of files is created
        
                switch(choice){
            case 1: objMgt.WriteFile(); // call for creating and wiritting in file 
                break;
            case 2: objMgt.ReadFile();  // call for reading form file. 
                break;
            default:
                System.out.println("wrong input..");
        }
    }

    
}
class files{

    
    // This function is used for creating and writting in created file
    public void WriteFile(){
        try{
            
            FileWriter myWriter = new FileWriter("file1.txt");  // creatting the file with file1 name
            myWriter.write("This is created through progream..!");
            myWriter.close();
            System.out.println("File is Sucessfully created..");
        }        

        catch(IOException e){
            System.out.println("Error is Occurred..");
            e.printStackTrace();

        }
    }

    public void ReadFile(){

        System.out.println("Enter file name want to read..");
        Scanner sc = new Scanner(System.in); // scanner's object for get input form user.
        String FileName = sc.next();
        try {
            File myObj = new File(FileName);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              System.out.println(data);
            }
            myReader.close();
        } 
            catch (FileNotFoundException e) {
             System.out.println("An error occurred.");
             e.printStackTrace();
           }
    }
}