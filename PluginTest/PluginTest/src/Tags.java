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
    	tags = new Hashtable<Integer, String>(43);
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
    	   System.out.println(tags);
    }
    
    public static void main(String[] args){
    	Tags etiquetas = new Tags("C:/Users/carlos/Downloads/PFC/Atlas Toronto/etiquetas.txt");
    	etiquetas.printTags();
    }
}