import java.awt.Color;

import ij.ImagePlus;
import ij.gui.Roi;
import ij.plugin.PlugIn;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;


public class Plugin_RedScale implements PlugIn 
{ 
	public void run(String arg) 
	{ 
		int width = 256; 
		int height = 256; 
		ImageProcessor ip = new ColorProcessor(width, height); 
		for(int y = 0; y < height; y++)
		{
			Color arg0 = new Color(y,0,0);
			Roi line = new Roi(1,y,width,1);
			ip.setColor(arg0);
			ip.fill(line);			
		}
		ImagePlus imp = new ImagePlus("Result image", ip); 
		imp.show();
	}
}