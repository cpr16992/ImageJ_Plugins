import ij.*;
import ij.gui.*;
import ij.plugin.frame.PlugInFrame;

import java.awt.Label;

public class Example_inteface extends PlugInFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Example_inteface() {
		super("FrameDemo");
	}
	@SuppressWarnings("deprecation")
	public void run(String arg) {
		GenericDialog gd = new GenericDialog("FrameDemo settings");
		gd.addNumericField("Frame width:",200.0,3);
		gd.addNumericField("Frame height:",200.0,3);
		gd.showDialog();
		if (gd.wasCanceled()) {
			IJ.error("PlugIn canceled!");
			return;
		}
		this.setSize((int) gd.getNextNumber(),(int) gd.getNextNumber());
		this.add(new Label("PlugInFrame demo",Label.CENTER));
		this.show();
	}
}