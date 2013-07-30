import ij.ImagePlus;
import ij.plugin.PlugIn;
import ij.process.ByteProcessor;
import ij.process.ImageProcessor;


public class Plugin_GrayScale implements PlugIn 
{ 
	public void run(String arg) 
	{ 
		int width = 256; 
		int height = 256; 
		ImageProcessor ip = new ByteProcessor(width, height); 
		for(int y = 0; y < height; y++)
		{
			//Color arg0 = new Color(y,0,0);
			for(int x = 0; x < width; x++)
			{
				ip.putPixel(x,y,y);
			}
		}
		ImagePlus imp = new ImagePlus("Result image", ip); 
		imp.show();
	}
}