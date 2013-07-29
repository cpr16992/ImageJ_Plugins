import ij.plugin.PlugIn;

/** Pops up the dimensions and number of voxels of the image
*/
public class My_plugin implements PlugIn 
{

    public void run(String arg) 
    {
    	Atlas atlas = new Atlas();
    	atlas.get_dimensions(arg);  
    }
}