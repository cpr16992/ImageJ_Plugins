import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Scanner;
import java.io.File;
 
public class Tags extends Hashtable<Integer, String>
{
    /** Reads tags from a .txt file and stores them in a Hashtable
     * @param fileName the path and name of the file containing tags
	 */
	private static final long serialVersionUID = 1L;
	private Hashtable<Integer, String> tags;
    public Tags(String fileName)
    {
    	Hashtable<Integer, String> tags = new Hashtable<Integer, String>(43);
        try
        {
            Scanner file = new Scanner(new File(fileName));
            while (file.hasNextLine())
            {
                int num = file.nextInt();
                String tag = file.nextLine();
                tags.put(num, tag);
            }
            file.close();
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
 
    }
    /** Prints the list of tags in screen
	 */
    public void printTags()
    {
    	
    	   for (Enumeration<String> e = tags.elements(); e.hasMoreElements();)
    	   {
    	       System.out.println(e.nextElement());
    	   }
    }
    
    public static void main(String[] args){
    	Tags tags = new Tags("C:/Users/carlos/Downloads/PFC/Atlas Toronto/etiquetas.txt");
    	tags.printTags();
    }
}