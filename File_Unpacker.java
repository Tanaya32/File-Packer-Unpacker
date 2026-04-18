

import java.io.*;
import java.util.*;

class program614
{
    public static void main(String A[]) throws Exception
    {
        //Variable creation
        int FileSize = 0;
        int i =0;
        int iRet = 0;

        Scanner sobj = null ;
        String FileName = null ;
        String Header = null;
        String Tokens[] = null;

        File fpackobj = null;
        File fobj = null;

        FileInputStream fiobj = null;
        FileOutputStream foobj = null;

        byte BHeader[] = new byte[100];
        byte Buffer[] = null;
        byte Key = 0x11;
    
        sobj =  new Scanner(System.in);

        System.out.println("Enter the name of packed file : ");

        FileName = sobj.nextLine();

        fpackobj = new File(FileName);  // input will be the previously created pack.txt file

        if(fpackobj.exists() == false)   // !fpackobj.exists() -> same
        {
            System.out.println("Error : there is no such packed file");
            return;
        }

        fiobj = new FileInputStream(fpackobj);  // for reading

        //Read the header
        while ((iRet = fiobj.read(BHeader,0,100)) != -1) 
        {

            Header = new String(BHeader);  // convert byte array to 100-byte string

            Header = Header.trim();  // removes extra white spaces added during packing

            Tokens = Header.split(" "); // split into tokens

            System.out.println("File name : "+ Tokens[0]);
            System.out.println("File size : "+ Tokens[1]);

            fobj = new File(Tokens[0]);

            fobj.createNewFile();

            foobj = new FileOutputStream(fobj);  // for writing

            FileSize = Integer.parseInt(Tokens[1]);

            //Buffer for reading the data
            Buffer = new byte[FileSize];  // empty buffer

            //Read from packed file
            fiobj.read(Buffer,0,FileSize);

            //Decrypt the data
            for(i=0 ; i<FileSize ; i++)
            {
                Buffer[i] = (byte)(Buffer[i] ^ Key);
            }

            //Write into extracted file
            foobj.write(Buffer,0,FileSize);

        }
        
    }
}