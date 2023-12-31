import java.net.*;
import javax.swing.*;
import java.util.*;

public class ImageProxyTestDrive {
	ImageComponent imageComponent;
	JFrame frame = new JFrame("CD Cover Viewer");
	JMenuBar menuBar;
	JMenu menu;
	Hashtable<String, String> cds = new Hashtable<String, String>();

	public static void main (String[] args) throws Exception {
		MyHWInfo.printInfo();
		ImageProxyTestDrive testDrive = new ImageProxyTestDrive();
	}

	public ImageProxyTestDrive() throws Exception{
/*
		cds.put("Buddha Bar","http://images.amazon.com/images/P/B00009XBYK.01.LZZZZZZZ.jpg");
		cds.put("Ima","https://images.amazon.com/images/P/B000005IRM.01.LZZZZZZZ.jpg");
		cds.put("Karma","https://images.amazon.com/images/P/B000005DCB.01.LZZZZZZZ.gif");
		cds.put("MCMXC A.D.","https://images.amazon.com/images/P/B000002URV.01.LZZZZZZZ.jpg");
		cds.put("Northern Exposure","https://images.amazon.com/images/P/B000003SFN.01.LZZZZZZZ.jpg");
		cds.put("Selected Ambient Works, Vol. 2","https://images.amazon.com/images/P/B000002MNZ.01.LZZZZZZZ.jpg");
		URL initialURL = new URL((String)cds.get("Selected Ambient Works, Vol. 2"));
*/
		cds.put("synthesize","https://cdnimg.melon.co.kr/cm2/album/images/069/09/725/6909725_20230908012408_500.jpg");
		cds.put("Oh It's Christmas","https://cdnimg.melon.co.kr/cm2/album/images/113/83/611/11383611_20231213112820_500.jpg");
		cds.put("ketamine","https://cdnimg.melon.co.kr/cm2/album/images/113/82/915/11382915_20231212152122_500.jpg");
		cds.put("Decent Shapes","https://cdnimg.melon.co.kr/cm2/album/images/113/82/588/11382588_20231212111028_500.jpg");
		cds.put("BIRTHDAY","https://cdnimg.melon.co.kr/cm2/album/images/070/53/614/7053614_20231213073810_500.jpg");
		cds.put("WINTER SEASON","https://cdnimg.melon.co.kr/cm2/album/images/113/82/596/11382596_20231212111936_500.jpg");
		URL initialURL = new URL((String)cds.get("WINTER SEASON"));

		menuBar = new JMenuBar();
		menu = new JMenu("Favorite CDs");
		menuBar.add(menu);
		frame.setJMenuBar(menuBar);

		for (Enumeration<String> e = cds.keys(); e.hasMoreElements();) {
			String name = (String)e.nextElement();
			JMenuItem menuItem = new JMenuItem(name);
			menu.add(menuItem); 
			menuItem.addActionListener(event -> {
				imageComponent.setIcon(new ImageProxy(getCDUrl(event.getActionCommand())));
				frame.repaint();
			});
		}

		// set up frame and menus

		Icon icon = new ImageProxy(initialURL);
		imageComponent = new ImageComponent(icon);
		frame.getContentPane().add(imageComponent);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(800,600);
		frame.setVisible(true);

	}

	URL getCDUrl(String name) {
		try {
			return new URL((String)cds.get(name));
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
