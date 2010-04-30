package org.mycoz.tools;

import java.util.*;
import java.io.File;
import java.io.*;
import java.io.IOException;
import java.io.OutputStream;
import java.io.FileInputStream;
import java.awt.Color;
import java.sql.*;

import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRRectangle;
import net.sf.jasperreports.engine.JRStyle;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.data.JRXmlDataSource;


import net.sf.jasperreports.engine.design.*;
import net.sf.jasperreports.engine.xml.*;



public class DebugReport{
       
        
/**
	 *
	 */
	private static void usage()
	{
		System.out.println( "DebugFill usage:" );
		System.out.println( "\tjava DebugReport [more|one] dxml jrxml " );
             System.out.println( "\tjava DebugReport man.jrxml" );
	}
public DebugReport(){}

public DebugReport(String dType,String jrxmlFile,String dxmlFile) {
			
    try {//compile sub jasper
System.out.println("jrxmlFile="+jrxmlFile);
System.out.println("dxmlFile="+dxmlFile);
	JasperDesign jasperDesign = JRXmlLoader.load(jrxmlFile);
    	JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
        //JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, 
            //new JRXmlDataSource(dxmlFile, "/XpcJRDataSource/DSRows"));
	JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, new JRXmlDataSource(new BufferedInputStream(new FileInputStream(dxmlFile)), "/XpcJRDataSource/DSRows"));
	JasperExportManager.exportReportToPdfFile(jasperPrint,"debug.pdf");
        /*
		//sub Report
	String fileName = null;//man.jrxml
	String jasperFile = jrxmlFile.substring(0, jrxmlFile.indexOf("."));
	JasperCompileManager jcm = new JasperCompileManager();
                             jcm.compileReportToFile("SubSum.jrxml","SubSum.jasper");
                             jcm.compileReportToFile("SubRow.jrxml","SubRow.jasper");
                             
        JasperDesign jasperDesign = JRXmlLoader.load(fileName);
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, 
            new JRXmlDataSource("data.xml", "/XpcJRDataSource/DSRows"));

	  File destFile = new File("man.jrprint");

	  JRSaver.saveObject(jasperPrint, destFile);

          JasperExportManager.exportReportToPdfFile(jasperPrint,"man.pdf");
	  System.err.println("Success!");
	*/			
             }catch (JRException e) {
			e.printStackTrace();
			System.exit(1);
	     }catch (Exception e){
			e.printStackTrace();
			System.exit(1);
		}
            
          }
}
