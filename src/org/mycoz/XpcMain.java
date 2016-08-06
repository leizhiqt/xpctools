/* This Soft is v1.1 2007.2.7 leizhifesker@gmail.com
 */
package org.mycoz;

public class XpcMain {

	public static void usage() {

		System.out.println("\trun command:");
		System.out.println("\tjava -cp `pwd`/classes org.mycoz.Mycoz option [ arg1 | arg2 ....]");
		System.out.println("\toption [DebugXslFo][DebugReport][Find][ShowMethods]");
		System.out.println("\tDebugXslFo XmlFile XslFile");
		System.out.println("\tFind bundlefild searchPath searchType");
		System.out.println("\tDebugReport [more|one] jrxml dxml");
		System.out.println("\tShowMethods java.lang.String");
	}
	
	public static void main(String args[]) {
		String fileName = null;

		if (args.length == 0) {
			usage();
			return;
		}
		
		int k = 0;
		while (args.length > k) {
			if (args[k].startsWith("-c"))
				fileName = args[k].substring(2);
			
			if (args[k].startsWith("-t"))
				fileName = args[k].substring(2);
			
			if (args[k].startsWith("-d"))
				fileName = args[k].substring(2);
			
			k++;
		}
		
		System.out.println("\texec args:"+fileName);
	}
}
/** this soft is over **/
/** this verison 1.0 **/
