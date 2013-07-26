import ij.IJ;
import ij.ImagePlus;
import ij.WindowManager;
import ij.plugin.PlugIn;

/** Pops up the dimensions and number of voxels of the image
*/
public class get_dimensions implements PlugIn 
{

    public void run(String arg) 
    {
        ImagePlus imp = WindowManager.getCurrentImage();
        if (imp==null) {
            IJ.noImage();
            return;
        }
        
        int height = imp.getHeight();
        int width = imp.getWidth();
        int depth = imp.getStackSize();
        String dimensions = height + " high, " + width + " wide, " + depth + " deep.";
        int volvalue = height * width * depth;
        String volume = "The volume is: " + volvalue + " voxels.";
        IJ.showMessage(dimensions);
        IJ.showMessage(volume);
        IJ.showMessage("Mensaje de prueba");
        
    }
}