package org.mycoz.tools;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

//import org.apache.avalon.framework.ExceptionUtil;
//import org.apache.avalon.framework.logger.ConsoleLogger;
//import org.apache.avalon.framework.logger.Logger;
import org.apache.fop.apps.Driver;
import org.apache.fop.apps.Options;
import org.apache.fop.messaging.MessageHandler;

public class DebugXslFo{

public void convertXML2PDF(File xml, File xslt, File pdf)
               throws TransformerException, IOException {

Driver driver = new Driver();
ConsoleLogger logger = new ConsoleLogger(ConsoleLogger.LEVEL_INFO);
driver.setLogger((org.apache.avalon.framework.logger.Logger) logger);
MessageHandler.setScreenLogger((org.apache.avalon.framework.logger.Logger) logger);

//Setup Renderer (output format)
driver.setRenderer(Driver.RENDER_PDF);

//Setup output
OutputStream out = new java.io.FileOutputStream(pdf);

try {

driver.setOutputStream(out);
//Setup XSLT
TransformerFactory factory = TransformerFactory.newInstance();
Transformer transformer = factory.newTransformer(new StreamSource(xslt));
//Setup input for XSLT transformation
Source src = new StreamSource(xml);
//Resulting SAX events (the generated FO) must be piped through to FOP
Result res = new SAXResult(driver.getContentHandler());
//Start XSLT transformation and FOP processing
transformer.transform(src, res);

} finally {

out.close();

}

}

private static void usage() {
		System.out.println( "Debug usage:" );
		System.out.println( "\tjava DebugXslFo XmlFile XslFile" );
	}
 

public DebugXslFo (String xmlFile,String xslFile,String varPath){

try {

System.out.println("FOP DebugXmlToPdf");

      new Options(new File("/usr/local/share/fonts/userconfig.xml"));
// org.apache.fop.configuration.Configuration.put("baseDir", "/usr/local/share/fonts/");
   
//Setup directories

//File baseDir = new File(".");
//File outDir = new File(baseDir, "tmp");
//outDir.mkdirs();
//System.out.println("Please in XML file..");
//BufferedReader XmlIn = new BufferedReader( new InputStreamReader( System.in ) );
//String XmlFile = XmlIn.readLine();

File xmlfile = new File(xmlFile);
File xsltfile = new File(xslFile);
File pdffile = new File(varPath+"/xslfo.pdf");

System.out.println("Input: XML (" + xmlfile + ")");
System.out.println("Stylesheet: " + xsltfile);
System.out.println("Output: PDF (" + pdffile + ")");
System.out.println();
System.out.println("Transforming...");

convertXML2PDF(xmlfile, xsltfile, pdffile);
System.out.println("Success!");

} catch (Exception e) {

System.err.println(ExceptionUtil.printStackTrace(e));
System.exit(-1);

}

}

}
