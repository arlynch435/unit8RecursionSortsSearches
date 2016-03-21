import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
/**
 * Write a description of class FileChooser here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FileChooser
{
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner user=new Scanner(System.in);
        String fileName=user.next();
        File text=new File(fileName);
        Scanner in=new Scanner(text);
       int wordCount=0;
       int lines=0;
       int letters=0;
        while (in.next()!=null)
        {
            wordCount++;
        }
                while (in.next()!=null)
        {
            wordCount++;
        }
                while (in.hasNextLine())
        {
            lines++;
        }
    }

}
