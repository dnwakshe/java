
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author dnwakshe
 */
 


public class FileMgt{
    public static void main(String[] args) {
        System.out.println("Enter your choice..");
            System.out.print("  1.student Details");
            System.out.print("  2.Create File");
            System.out.print("  3.Read File");
            System.out.print("  4.Delete File");        
            System.out.println("    5.Exit ");
            System.out.println("**********************************************************");
            System.out.print(" \n \n ");
            
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt(); 
        
        
            Student objStd = new Student();// objecte of subject class 
            files objMgt = new files(); // objecte of files is created
            
                switch(choice){
            case 1:objStd.details();
                break;
            case 2: objMgt.WriteFile(); // call for creating and wiritting in file 
                break;
            case 3: objMgt.ReadFile();  // call for reading form file. 
                break;
            case 4: objMgt.DeleteFile();
                break;            
            case 5: 
                    break;
            default:
                System.out.println("wrong input..");
            }
    }
}
class files{

    
    // This function is used for creating and writting in created file
    public void WriteFile(){

        System.out.println("Enter name of file.\n");
        Scanner sc = new Scanner(System.in);
        String FileName = sc.next();
        try{
            
            FileWriter myWriter = new FileWriter(FileName +".txt" );  // creatting the file with file1 name
            FileContent(myWriter);
            //myWriter.write("This is created through progream..!");
            myWriter.close();
            System.out.println("File is Sucessfully created..\n");
        }        

        catch(IOException e){
            System.out.println("Error is Occurred..\n");
            e.printStackTrace();

        }
    }
     void WriteFile(int math, int eng, int sci, int geo,int  socio,int sum, int avg){
        
        
        Scanner sc = new Scanner(System.in);
        String FileName = sc.next();
        
        try{
            
            FileWriter myWriter = new FileWriter(new File("Student.txt"), true);  // creatting the file with file1 name            
            myWriter.write("************* Student Details ************* \n");
            myWriter.write(math+"\n");
            myWriter.write(eng+"\n");
            myWriter.write(geo+"\n");
            myWriter.write(socio+"\n");            
            myWriter.write("-----------------------------------\n");  
            myWriter.write("Total Marks of Student: "+sum);
            myWriter.write("Avarge Marks of Student: "+avg+"%");
            myWriter.write("-------------------------------------");
            System.out.println("File is created and data is added..");
                      
            myWriter.close();
            
        }        

        catch(IOException e){
            System.out.println("Error is Occurred..");
            e.printStackTrace();

        }
    }
   
    public void ReadFile(){

        System.out.println("Enter file name want to read..\n");
        Scanner sc = new Scanner(System.in); // scanner's object for get input form user.
        String FileName = sc.next();
        try {
            File myObj = new File(FileName+".txt" );
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
              String data = myReader.next();
              System.out.println(data);
            }
            myReader.close();
        } 
            catch (FileNotFoundException e) {
             System.out.println("An error occurred.\n");
             e.printStackTrace();
           }
    }
    public static void DeleteFile(){

        System.out.println("Enter file name want to delete..\n");
        Scanner sc = new Scanner(System.in); // scanner's object for get input form user.
        String FileName = sc.next();
        File myObj = new File(FileName+".txt" );
       
        if (myObj.delete()){
            System.out.println("Deleted the file "+ myObj.getName());
        }
        else{
            System.out.println("Enable to delete the file.\n");
        }
    }
 
    public void FileContent( FileWriter Writer){
        try {
            System.out.println("Enter file containt.\n");
            Scanner sc = new Scanner(System.in); // scanner's object for get input form user.
            String lines = sc.next();
            Writer.write(lines);
            Writer.close();
            
        }       

        catch(IOException e){
            System.out.println("Error is Occurred..\n");
            e.printStackTrace();
        }
    }
   
    
    
    
}
class subject extends files{
   public static int math,eng,sci,geo, socio,sum,avg;
    
    void marks(){
        System.out.println("Enter marks of subjects respectively : \n");
        System.out.println("Math  eng sci geo socio\n");
        Scanner sc = new Scanner(System.in);
        math=sc.nextInt();
        eng=sc.nextInt();
        sci=sc.nextInt();
        geo=sc.nextInt(); 
        socio=sc.nextInt();
       System.out.println( "************* Subject Marks ************* " + "\nMath : "+ math +"\nEnglish: "+ eng+" \nScience: "+sci+"\nGeographi: "+geo+ "\nSocial Science: "+socio);
       sum = math+eng+sci+geo+socio;
        avg=sum/5;
        
        WriteFile(math,eng,sci,geo,socio,sum,avg); // creating new file for new studnet
     
    }
    
   
}
class Student extends subject{
    String name,address,std,mob_no;
    int roll_no;
    subject objsub = new subject();
    void details(){
        Scanner sc = new Scanner(System.in);
        System.out.println( "************* Student Details ************* \n");
        System.out.println("Enter  Roll No: ");
        roll_no=sc.nextInt();
        System.out.println("Enter  Name: ");
        name = sc.next();
        System.out.println("Enter Address: ");
        address = sc.next();
        System.out.println("Enter std: ");
        std= sc.next();
        System.out.println("Enter Mobile No: ");
        mob_no= sc.next();
        try{
            FileWriter myWriter = new FileWriter(new File("Student.txt"), true);
            myWriter.write("************* Student Details ************* \n");
            myWriter.write(roll_no+"\n");
            myWriter.write(name+"\n");
            myWriter.write(address+"\n");
            myWriter.write(std+"\n");    
            myWriter.write(mob_no+"\n"); 
            myWriter.close();
            System.out.println("Data Saved...\n");
             marks();

        }
        
        catch(IOException e){
            System.out.println("Error is Occurred..");
            e.printStackTrace();
        }
    }
}