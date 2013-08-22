import ij.IJ;
import ij.ImagePlus;
import ij.gui.GenericDialog;
import ij.gui.Roi;
import ij.plugin.frame.PlugInFrame;
import ij.process.ColorProcessor;
import ij.process.ImageProcessor;
import java.awt.Color;

public class Plugin_ScaleCheckBox extends PlugInFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Plugin_ScaleCheckBox() {
		super("FrameDemo");
	}
	public void run(String arg) {
		GenericDialog gd = new GenericDialog("Colour Scale settings");
		//gd.addNumericField("Frame width:",200.0,3);
		//gd.addNumericField("Frame height:",200.0,3);
		String[] colours= {"red", "green", "blue"};
		gd.addChoice("Colour", colours, "red");
		gd.showDialog();
		if (gd.wasCanceled()) {
			IJ.error("PlugIn canceled!");
			return;
		}
		int width = 256;//(int) gd.getNextNumber(); 
		int height = 256;//(int) gd.getNextNumber();
		String colour = gd.getNextChoice();
		System.out.println(colour);
		if(colour.equals("red"))
			{ 
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
		else if (colour.equals("green"))
		{ 
			ImageProcessor ip = new ColorProcessor(width, height); 
			for(int y = 0; y < height; y++)
			{
				Color arg0 = new Color(0,y,0);
				Roi line = new Roi(1,y,width,1);
				ip.setColor(arg0);
				ip.fill(line);			
			}
			ImagePlus imp = new ImagePlus("Result image", ip); 
			imp.show();
		}
		else if (colour.equals("blue"))
		{
			ImageProcessor ip = new ColorProcessor(width, height); 
			for(int y = 0; y < height; y++)
			{
				Color arg0 = new Color(0,0,y);
				Roi line = new Roi(1,y,width,1);
				ip.setColor(arg0);
				ip.fill(line);			
			}
			ImagePlus imp = new ImagePlus("Result image", ip); 
			imp.show();
		}
	}
}