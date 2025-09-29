package MarvellousPackerUnpacker;

import java.io.*;

public class MarvellousPacker
{
    private String PackName;
    private String DirName;

    public MarvellousPacker(String A,String B)
    {
        this.PackName = A;
        this.DirName = B;
    }
    public void PackingActivity()
    {
         try
        {
            System.out.println("-------------------------------------------------------------------");
            System.out.println("-----------------Marvellous Packer Unpacker------------------------");
            System.out.println("-------------------------------------------------------------------");
            System.out.println("-----------------------Packing Activity----------------------------");
            System.out.println("-------------------------------------------------------------------");

            int i = 0,j = 0, iret  =0,icountfile = 0 ;

            File fobj = new File(DirName);

            if(fobj.exists() && fobj.isDirectory())
            {
                System.out.println(DirName+" is Successfully opened");
                 File packobj = new File(PackName);

                //create a packed file
                boolean bret =   packobj.createNewFile();

                //check the existance of directory
             if(bret == false)
            {
               System.out.println("unable to create pack file");
               return;
            }

              System.out.println("Packed file Gets Successfully created with name:"+PackName);

              // retrive all files from directory
                File arr[] = fobj.listFiles();

                //PAcked file object
                FileOutputStream foobj = new FileOutputStream(packobj);

                //Buffer Read and write activity
                byte Buffer[] = new byte[1024];
              

                String Header = null;
                 // Directory Travesal
                for(i = 0;i< arr.length;i++)
                {
                    Header = arr[i].getName()+ " " + arr[i].length();
                    
                    // loop to from 100byte header
                    for(j = Header.length(); j < 100 ; j++)
                    {
                        Header = Header + " ";
                    }
                    //Write header into packed file

                    foobj.write(Header.getBytes());

                    //open file from directory for reading
                     FileInputStream fiobj = new FileInputStream(arr[i]);

                    //write content of file into packed file
                   while((iret = fiobj.read(Buffer)) != -1)
                   {
                    foobj.write(Buffer,0,iret);
                    System.out.println("File name scanned:"+arr[i].getName());
                    System.out.println("File size read is:"+iret);
                   }

                   fiobj.close();
                   icountfile++;
                }
                System.out.println("Packing Activity Done");

                System.out.println("-------------------------------------------------------------------");
                System.out.println("---------------------Staticitical Report---------------------------");
                System.out.println("-------------------------------------------------------------------");

                //to be add
                System.out.println("Total file Packed:"+icountfile);

                System.out.println("-------------------------------------------------------------------");
                System.out.println("-------------Thank You For Using Our Application-------------------");
                System.out.println("-------------------------------------------------------------------");
            }
            else
            {
                System.out.println("there is no such directory");
            }


        }// end of try
        catch(Exception eobj)
        {}

    }//end of packing activity function
}// end of Marvellous Packer Class