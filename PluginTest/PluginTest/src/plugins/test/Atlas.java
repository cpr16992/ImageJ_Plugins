package plugins.test;

import ij.IJ;
import ij.ImagePlus;
import ij.WindowManager;

public class Atlas extends ImagePlus
{
	private ImagePlus imp;
	public Atlas()
	{
		imp = WindowManager.getCurrentImage();
	}

	public void get_dimensions(String arg) 
	{

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
	}
}


