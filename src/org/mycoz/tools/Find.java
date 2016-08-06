package org.mycoz.tools;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.mycoz.util.LinkList;

public class Find {

	private static int sum = 0;
	private static LinkedList jspKey = new LinkedList();
	private static LinkedList whichFile = new LinkedList();
	private static LinkedList bundKey = new LinkedList();
	private static LinkedList bundkeyvalue = new LinkedList();
	private static LinkList list = new LinkList();

	private static void bundleCheck(String bundleFile) throws IOException {
		int row = 0;

		FileReader fr = new FileReader(bundleFile);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while (line != null) {
			row++;
			Pattern key = Pattern.compile("[\\s\\=]");
			Pattern keyvalue = Pattern.compile("[\\=][\\s*]");
			Matcher keym = key.matcher(line);
			Matcher keyvaluem = keyvalue.matcher(line);
			if (keym.find() && keyvaluem.find()) {
				int tmp = keym.start();
				bundKey.addLast(line.substring(0, tmp));
				tmp = keyvaluem.end();
				bundkeyvalue.addLast(line.substring(tmp));
			}
			line = br.readLine();
		}
		br.close();
		fr.close();
	}

	private static boolean isJsp(String str) {
		Pattern p = Pattern.compile("\\.jsp");
		Matcher m = p.matcher(str);
		if (m.find())
			return true;
		else
			return false;
	}

	private static void listData(String findPath, String findType) throws IOException {

		File file = new File(findPath);
		File[] tempFile = file.listFiles();

		for (int i = 0; i < tempFile.length; i++) {
			if (tempFile[i].isFile()) {

				if (isJsp(tempFile[i].getName())) {

					open(tempFile[i].getAbsolutePath());
				}

			}
			if (tempFile[i].isDirectory()) {

				showFile(tempFile[i].getAbsolutePath(), findType);

			}
		}
	}

	/*********************************************************/
	private static void open(String file) throws IOException {
		int row = 0;

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line = br.readLine();
		while (line != null) {
			row++;
			startcmp(line, row, file);// 检查匹配规则
			line = br.readLine();
		}
		br.close();
		fr.close();
	}

	private static void setData(String bundleFile, String findPath, String findType) throws IOException {

		String key = null;
		String inBundleFile = null;
		String bundleValue = null;
		String whichInFile = null;
		int row = 0;
		int column = 0;

		bundleCheck(bundleFile);
		showFile(findPath, findType);

		LinkList data = new LinkList();

		for (int i = 0; i < bundKey.size(); i++) {
			for (int j = 0; j < jspKey.size(); j++) {
				if (bundKey.get(i).equals(jspKey.get(j))) {
					key = bundKey.get(i).toString();
					inBundleFile = "all";
					bundleValue = bundkeyvalue.get(i).toString();
					whichInFile = whichFile.get(j).toString();
					row++;
					data.insertAfterId(key, inBundleFile, bundleValue, whichInFile);
				}
			}
			if (row == 0) {
				key = bundKey.get(i).toString();
				inBundleFile = "Bund";
				bundleValue = bundkeyvalue.get(i).toString();
				whichInFile = null;
				data.insertAfterId(key, inBundleFile, bundleValue, whichInFile);
			} else
				row = 0;

		}
		// ////////////////////////////////////////////
		row = 0;
		for (int i = 0; i < jspKey.size(); i++) {
			for (int j = 0; j < bundKey.size(); j++) {
				if (jspKey.get(i).equals(bundKey.get(j)))
					row++;
			}
			if (row == 0) {
				key = jspKey.get(i).toString();
				inBundleFile = "Jsp";
				bundleValue = null;
				whichInFile = whichFile.get(i).toString();
				data.insertAfterId(key, inBundleFile, bundleValue, whichInFile);
			} else
				row = 0;

		}

		data.writeAllNode();
	}

	/********************************************************************/
	private static void showFile(String findpath, String findname) throws IOException {

		File file = new File(findpath);
		File[] tempFile = file.listFiles();

		for (int i = 0; i < tempFile.length; i++) {

			if (tempFile[i].isFile()) {

				if (isJsp(tempFile[i].getName()))
					open(tempFile[i].getAbsolutePath());

			} else if (tempFile[i].isDirectory()) {

				showFile(tempFile[i].getAbsolutePath(), findname);

			} else
				break;
		} // End For
	}

	private static void startcmp(String str, int row, String file) {
		Pattern p = Pattern.compile("\\s+key\\s*=\\s*\"\\w+\\.*\\w+\"\\s*");
		Matcher m = p.matcher(str);
		while (m.find()) {
			int stat = m.group().indexOf("\"");
			int end = m.group().lastIndexOf("\"");
			jspKey.addLast(m.group().substring(stat + 1, end));
			whichFile.addLast(file);
		}
	}

	private static void usage() {

		System.out.println("Find usage:");
		System.out.println("\tjava Find -Bbundlefild -PfindPath -TfindType");
		System.out.println("\tjava Find -BMessagesBundle_zh.properties -P/home/zlei -T*.java");
	}

	/*
	 * This Soft is v1.1 2007.2.7 leizhifesker@gmail.com
	 */
	public Find(String bundlefild, String searchPath, String searchType) {

		try {

			System.out.println("Wercom to there!\n");
			System.out.println("Load...\n");
			System.out.println("BunleFile=" + bundlefild);
			System.out.println("FindPath=" + searchPath);
			System.out.println("FindType=" + searchType);
			System.out.println("Plase wait......");
			if (bundlefild != null && !bundlefild.equals(""))
				setData(bundlefild, searchPath, searchType);// write to file of
															// meassage
			else
				listData(searchPath, searchType);
			System.out.println("Exec End!\n");
		} catch (Exception e) {
			System.out.println("error:" + e.getMessage());
			System.exit(-1);
		}
	}
}
/** this soft is over **/
/** this verison 1.0 **/
