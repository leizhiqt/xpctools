/* 利用节点类，设计链表类 */
package org.mycoz.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.mycoz.lang.Node;

public class LinkList {

	Node m_FirstNode;

	public LinkList() {
		m_FirstNode = null;
	}

	public LinkList(String key, String inbundlefile, String bundlevalue, String usedinfile) {
		m_FirstNode = new Node(key, inbundlefile, bundlevalue, usedinfile);
	}

	public void insertAfterId(String key, String inbundlefile, String bundlevalue, String usedinfile) {
		Node next = m_FirstNode;

		if (next == null)
			m_FirstNode = new Node(key, inbundlefile, bundlevalue, usedinfile);
		else {
			while (next.getNext() != null)
				next = next.getNext();
			next.setNext(new Node(key, inbundlefile, bundlevalue, usedinfile, next.getNext()));
		}
	}

	public void insertAtBegin(String key, String inbundlefile, String bundlevalue, String usedinfile) {

		if (m_FirstNode == null) {

			m_FirstNode = new Node(key, inbundlefile, bundlevalue, usedinfile);

		} else {
			m_FirstNode = new Node(key, inbundlefile, bundlevalue, usedinfile, m_FirstNode);

		}
	}

	public void removeAll() {
		m_FirstNode = null;
	}

	public void visitAllNode() {
		Node next = m_FirstNode;
		System.out.println("  Key   " + "  InBundleFile  " + "  BundleValue  " + " UsedInFile  ");
		System.out.println("*******************************************************************");
		while (next != null) {
			System.out.println(next.getData());
			next = next.getNext();

		}

	}

	public void writeAllNode() throws IOException {

		Node next = m_FirstNode;
		String head = "Key" + "\tInBundleFile" + "\tBundleValue" + "\tUsedInFile\n";
		head += "******************************************************************* \n";

		File baseDir = new File(".");
		File outDir = new File(baseDir, "tmp");
		outDir.mkdirs();

		File rsfile = new File("./tmp/rs.txt");
		FileWriter fw = new FileWriter("./tmp/rs.txt");
		fw.write(head);
		while (next != null) {
			fw.write(next.getData() + "\n");
			next = next.getNext();

		}
		fw.flush();

	}
}
