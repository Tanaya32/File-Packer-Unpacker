

import java.io.*;
import java.util.*;

class program605
{
    public static void main(String A[]) throws Exception
    {
        String Header = null ;

        byte Key = 0x11;
        int iRet = 0;
        int i = 0 , j = 0 ;

        byte Buffer[] = new byte[1024];
        byte BHeader[] = new byte[100];  // byte array

       Scanner sobj = new Scanner(System.in);

       System.out.println("Enter name of Folder :"); // to check
       String FolderName = sobj.nextLine();

       System.out.println("Enter name of packed file :"); // to check
       String PackName = sobj.nextLine();

       File fobj = new File(FolderName);

       if((fobj.exists()) && (fobj.isDirectory())) // check if it exists and is a folder
       {
        File packobj = new File(PackName);

        packobj.createNewFile();

        FileOutputStream foobj = new FileOutputStream(packobj);
        FileInputStream fiobj = null;

        System.out.println("Folder is present");

        File fArr[] = fobj.listFiles();  // stored all file objects in an array

        System.out.println("No. of files in folder are : " + fArr.length);

        for(i = 0 ; i<fArr.length ; i++)
        {
            fiobj = new FileInputStream(fArr[i]);

            
            if (fArr[i].getName().endsWith(".txt"))
            {
                //Header formation
                    Header = fArr[i].getName() + " " + fArr[i].length();  
                    for (j = Header.length() ; j<100 ; j++)
                    {
                        Header = Header + " ";  // header size = 100 bytes
                    }

                    BHeader = Header.getBytes(); // convert string to bytes

                    // Write header into pack file
                    foobj.write(BHeader, 0,100);  // write

                    //Read the data from input files from folder
                    while((iRet = fiobj.read(Buffer))!= -1)         // read data
                    {   
                        //Encryption
                        for (j= 0; j<iRet ; j++)
                        {
                            Buffer[j] =(byte)( Buffer[j] ^ Key);   // encrypt data
                        }

                        //Write file's data into pack file
                        foobj.write( Buffer,0,iRet);            // write data
                    }
                fiobj.close();
                
            }
            
        }

        foobj.close();
       }
       else
       {
        System.out.println("There is no such folder");

       }

    }
}