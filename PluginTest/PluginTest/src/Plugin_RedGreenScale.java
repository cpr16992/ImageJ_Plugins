import ij.ImagePlus;
import ij.plugin.PlugIn;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;


public class Plugin_RedGreenScale implements PlugIn 
{ 
	public void run(String arg) 
	{ 
		int width = 256; 
		int height = 256;
		ImageProcessor ip = new ColorProcessor(width, height); 
		for(int y = 0; y < height; y++)
		{
			for (int x = 0; x < width; x++)
			{
				int[] col = {x, y, 0};
				ip.putPixel(x,y,col);
			}
		}
		ImagePlus imp = new ImagePlus("Result image", ip); 
		imp.show();
	}
}