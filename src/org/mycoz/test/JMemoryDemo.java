package org.mycoz.test;

import java.awt.Dimension;
import java.awt.Toolkit;

public class JMemoryDemo {
	public static void main(String[] args) {
		new JMemoryDemo();
	}

	private boolean packFrame = false;

	public JMemoryDemo() {
		MainFrame frame = new MainFrame();

		if (packFrame) {
			frame.pack();
		} else {
			frame.validate();
		}

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		Dimension frameSize = frame.getSize();
		if (frameSize.height > screenSize.height) {
			frameSize.height = screenSize.height;
		}
		if (frameSize.width > screenSize.width) {
			frameSize.width = screenSize.width;
		}
		frame.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);
		frame.setVisible(true);
	}
}
