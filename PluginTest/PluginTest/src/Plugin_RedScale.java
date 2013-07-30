import java.awt.Color;

import ij.ImagePlus;
import ij.gui.Roi;
import ij.plugin.PlugIn;
import ij.process.ByteProcessor;
import ij.process.ImageProcessor;


public class Plugin_RedScale implements PlugIn 
{ 
	public void run(String arg) 
	{ 
		int width = 256; 
		int height = 256; 
		ImageProcessor ip = new ByteProcessor(width, height); 
		for(int y = 0; y < height; y++)
		{
			Color arg0 = new Color(y,0,0);
			Roi line = new Roi(1,y,width,1);
			line.setColor(arg0);
			ip.fill(line);			
		}
		ImagePlus imp = new ImagePlus("Result image", ip); 
		imp.show();
	}
}