/* This Soft is v1.1 2007.2.7 leizhifesker@gmail.com
 */
package org.mycoz;

import java.io.File;
//import java.io.IOException;
//import java.io.OutputStream;

import org.mycoz.tools.DebugReport;
import org.mycoz.tools.DebugXslFo;
import org.mycoz.tools.Find;
import org.mycoz.tools.ShowMethods;

public class Mycoz {

	public static void main(String[] args) {

		String command = "";
		int argc = args.length;
		File baseDir = new File(".");
		File outDir = new File(baseDir, "tmp");
		outDir.mkdirs();
		String var = outDir.getAbsolutePath();

		if (args.length == 0) {
			usage();
			return;
		}
		int k = 0;

		try {

			System.out.println("\tWelcome Mycoz Software");
			if (args[0].equals("DebugXslFo")) {
				if (argc < 3) {
					usage();
					return;
				} else {
					// DebugXslFo df = new DebugXslFo(args[1],args[2],var);
					new DebugXslFo(args[1], args[2], var);
				}
			} else if (args[0].equals("Find")) {
				if (argc < 4) {
					usage();
					return;
				} else {
					new Find(args[1], args[2], args[3]);
				}
			} else if (args[0].equals("ShowMethods")) {
				if (argc < 2) {
					usage();
					return;
				} else {
					new ShowMethods(args);
				}
			} else if (args[0].equals("DebugReport")) {
				if (argc < 3) {
					usage();
					return;
				} else {
					new DebugReport(args[1], args[2], args[3]);
				}
			} else {
				usage();
				return;
			}

		} catch (Exception e) {
			System.out.println("error:" + e.getMessage());
			System.exit(-1);
		}
	}

	public static void usage() {

		System.out.println("\trun command:");
		System.out.println("\tjava -cp `pwd`/classes org.mycoz.Mycoz option [ arg1 | arg2 ....]");
		System.out.println("\toption [DebugXslFo][DebugReport][Find][ShowMethods]");
		System.out.println("\tDebugXslFo XmlFile XslFile");
		System.out.println("\tFind bundlefild searchPath searchType");
		System.out.println("\tDebugReport [more|one] jrxml dxml");
		System.out.println("\tShowMethods java.lang.String");
		// System.out.println( "\tjava Find -Bbundlefild -PfindPath -TfindType"
		// );
		// System.out.println(
		// "\tjava Find -BMessagesBundle_zh.properties -P/home/zlei -T*.java" );
	}
}
/** this soft is over **/
/** this verison 1.0 **/
