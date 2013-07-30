import ij.ImagePlus;
import ij.ImageStack;
import ij.plugin.PlugIn;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;


public class RGB_cube implements PlugIn 
{ 
	public void run(String arg) 
	{ 
		int width = 256; 
		int height = 256;
		int size = 256;
		ImageStack is = new ImageStack (256, 256);
		ImageProcessor ip = new ColorProcessor(width, height); 
		for (int z = 0; z < size; z++)
		{
			for (int x = 0; x < width; x++)
			{
				for(int y = 0; y < height; y++)
				{
					int[] col = {x, y, z};
					ip.putPixel(x,y,col);
				}
			}
			is.addSlice(ip);
		}
		ImagePlus imp = new ImagePlus("Result image", is); 
		imp.show();
	}
}