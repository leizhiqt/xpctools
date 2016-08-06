package org.mycoz.tools;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRXmlDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class DebugReport {

	/**
	 *
	 */
	private static void usage() {
		System.out.println("DebugFill usage:");
		System.out.println("\tjava DebugReport [more|one] dxml jrxml ");
		System.out.println("\tjava DebugReport man.jrxml");
	}

	public DebugReport() {
	}

	public DebugReport(String dType, String jrxmlFile, String dxmlFile) {

		try {// compile sub jasper
			System.out.println("jrxmlFile=" + jrxmlFile);
			System.out.println("dxmlFile=" + dxmlFile);
			JasperDesign jasperDesign = JRXmlLoader.load(jrxmlFile);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			// JasperPrint jasperPrint =
			// JasperFillManager.fillReport(jasperReport, null,
			// new JRXmlDataSource(dxmlFile, "/XpcJRDataSource/DSRows"));
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRXmlDataSource(new BufferedInputStream(
					new FileInputStream(dxmlFile)), "/XpcJRDataSource/DSRows"));
			JasperExportManager.exportReportToPdfFile(jasperPrint, "debug.pdf");
			/*
			 * //sub Report String fileName = null;//man.jrxml String jasperFile
			 * = jrxmlFile.substring(0, jrxmlFile.indexOf("."));
			 * JasperCompileManager jcm = new JasperCompileManager();
			 * jcm.compileReportToFile("SubSum.jrxml","SubSum.jasper");
			 * jcm.compileReportToFile("SubRow.jrxml","SubRow.jasper");
			 * 
			 * JasperDesign jasperDesign = JRXmlLoader.load(fileName);
			 * JasperReport jasperReport =
			 * JasperCompileManager.compileReport(jasperDesign);
			 * 
			 * JasperPrint jasperPrint =
			 * JasperFillManager.fillReport(jasperReport, null, new
			 * JRXmlDataSource("data.xml", "/XpcJRDataSource/DSRows"));
			 * 
			 * File destFile = new File("man.jrprint");
			 * 
			 * JRSaver.saveObject(jasperPrint, destFile);
			 * 
			 * JasperExportManager.exportReportToPdfFile(jasperPrint,"man.pdf");
			 * System.err.println("Success!");
			 */
		} catch (JRException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public static void CreatePDF(String fileName) {
		try {// compile sub jasper
			JasperCompileManager jcm = new JasperCompileManager();
			jcm.compileReportToFile("oneReport.jrxml", "oneReport.jasper");

			JasperDesign jasperDesign = JRXmlLoader.load(fileName);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRXmlDataSource("oneData.xml", "/XpcJRDataSource/DSRows"));

			File destFile = new File("oneReport.jrprint");

			JRSaver.saveObject(jasperPrint, destFile);

			JasperExportManager.exportReportToPdfFile(jasperPrint, "oneReport.pdf");

			System.err.println("Success!");

		} catch (JRException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public static void DebugCompile(String fileName) {
		/*
		 * do compile *.jrxml To *.jasper
		 */
		try {
			JasperDesign jasperDesign = JRXmlLoader.load(fileName);
			JasperCompileManager jcm = new JasperCompileManager();
			jcm.compileReportToFile("SubSum.jrxml", "SubSum.jasper");
			jcm.compileReportToFile(jasperDesign, "SubRow.jasper");// compile
																	// sub
																	// jasper
			/*
			 * do *.jasper To *.jrprint
			 */

			JasperReport jasperReport = (JasperReport) JRLoader.loadObject("SubRow.jasper");
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRXmlDataSource("data.xml", "/XpcJRDataSource/DSSub/DSSubRows"));

			// File destFile = new File("test.jrprint");

			// JRSaver.saveObject(jasperPrint, destFile);
			JasperExportManager.exportReportToPdfFile(jasperPrint, "SubRow.pdf");

			System.err.println("Compile File is test.jasper and SubRow.pdf");

		} catch (JRException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}

	public static void DebugPDF(String fileName) {
		try {// compile sub jasper
			JasperCompileManager jcm = new JasperCompileManager();
			jcm.compileReportToFile("SubSum.jrxml", "SubSum.jasper");
			jcm.compileReportToFile("SubRow.jrxml", "SubRow.jasper");

			JasperDesign jasperDesign = JRXmlLoader.load(fileName);
			JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRXmlDataSource("data.xml", "/XpcJRDataSource/DSRows"));

			File destFile = new File("man.jrprint");

			JRSaver.saveObject(jasperPrint, destFile);

			JasperExportManager.exportReportToPdfFile(jasperPrint, "man.pdf");

			System.err.println("Success!");

		} catch (JRException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}
	
	public static void main(String args[]) {
		String fileName = null;

		if (args.length == 0) {
			usage();
			return;
		}
		int k = 0;
		while (args.length > k) {
			if (args[k].startsWith("-F"))
				fileName = args[k].substring(2);

			k++;
		}
	}
}
