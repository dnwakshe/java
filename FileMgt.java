import java.io.*;
import java.util.Scanner;
import java.io.File;



public class FileMgt {
    
   public static void main(String[] args) {
     
   
      
            System.out.println("Enter your choice..");
            System.out.println("1.Create File");
            System.out.println("2.Read File");
            System.out.println("3.Delete File");
            System.out.println("4.Exit ");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt(); 
        
        

            files objMgt = new files(); // bojecte of files is created
            System.out.println("**********************************************************");
                switch(choice){
            case 1: objMgt.WriteFile(); // call for creating and wiritting in file 
                break;
            case 2: objMgt.ReadFile();  // call for reading form file. 
                break;
            case 3: objMgt.DeleteFile();
                break;
            case 4: 
                    break;
            default:
                System.out.println("wrong input..");
            }
      
       
    
    }

    
}
class files{

    
    // This function is used for creating and writting in created file
    public void WriteFile(){

        System.out.println("Enter name of file.");
        Scanner sc = new Scanner(System.in);
        String FileName = sc.next();
        try{
            
            FileWriter myWriter = new FileWriter(FileName +".txt" );  // creatting the file with file1 name
            FileContent(myWriter);
            //myWriter.write("This is created through progream..!");
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
            File myObj = new File(FileName+".txt" );
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
    public static void DeleteFile(){

        System.out.println("Enter file name want to delete..");
        Scanner sc = new Scanner(System.in); // scanner's object for get input form user.
        String FileName = sc.next();
        File myObj = new File(FileName+".txt" );
       
        if (myObj.delete()){
            System.out.println("Deleted the file "+ myObj.getName());
        }
        else{
            System.out.println("Enable to delete the file.");
        }
    }

    public void FileContent( FileWriter Writer){
        System.out.println("Enter file containt.");
        Scanner sc = new Scanner(System.in); // scanner's object for get input form user.
        String lines = sc.next();
        Writer.write(lines);


    }
}