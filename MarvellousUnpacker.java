package MarvellousPackerUnpacker;

import java.io.*;

public class MarvellousUnpacker
{
    private  String PackName;

    public MarvellousUnpacker(String A)
    {
        this.PackName = A;
    }

    public void UnpackingActivity()
        {
            try
        {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("-----------------Marvellous Packer Unpacker------------------------");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("---------------------UnPacking Activity----------------------------");
            System.out.println("-------------------------------------------------------------------");

             String Header = null;
              File fobjnew = null;
            

            int FileSize = 0, iret =0,icountfile =0 ;


            File fobj = new File(PackName);
            
            //if packed file is not present
            if( ! fobj.exists())
            {
                System.out.println("Unable to access packed file");
                return;
            }
            System.out.println("Packed file get succsssfully open");

            FileInputStream fiobj = new FileInputStream(fobj);

            // Buffer to read header
            byte HeaderBuffer[] = new byte[100];
 
            //scan the pack file to extract the files from it
            while((iret = fiobj.read(HeaderBuffer,0,100))!=-1 )
            {
                 //Convert byte array to string
            Header = new String(HeaderBuffer);
            

            Header = Header.trim();

            //Tokenize the header into two part
            String Tokens[] = Header.split(" ");
            
            fobjnew =  new File(Tokens[0]);
            
            //create new file to extract
            fobjnew.createNewFile();

            FileSize = Integer.parseInt(Tokens[1]);

            // create new buffer to store files data
            byte Buffre[] = new byte[FileSize];

            FileOutputStream foobj = new FileOutputStream(fobjnew);

            // read the data from packed file
            fiobj.read(Buffre,0,FileSize);
            //write the data into extracted file
            foobj.write(Buffre,0,FileSize);

            System.out.println("File unpacked with name: "+Tokens[0]+"Having size: "+FileSize);
            icountfile++;
            foobj.close();

            }//end of while
            System.out.println("-------------------------------------------------------------------");
            System.out.println("---------------------Statistical Report---------------------------");
            System.out.println("-------------------------------------------------------------------");

            System.out.println("Total number of file unpacked :"+icountfile);

            System.out.println("-------------------------------------------------------------------");
            System.out.println("-------------Thank You For Using Our Application-------------------");
            System.out.println("-------------------------------------------------------------------");
            fiobj.close();
           

           }
        catch(Exception eobj)
        {}

        }
    
}