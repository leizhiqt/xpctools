package org.mycoz.lang;

public class Node {
	private String Key;
	private String InBundleFile;
	private String BundleValue;
	private String UsedInFile;
	private Node m_Next;

	public Node() {
	}

	public Node(String key, String inbundlefile, String bundlevalue, String usedinfile) {
		Key = key;
		InBundleFile = inbundlefile;
		BundleValue = bundlevalue;
		UsedInFile = usedinfile;

		m_Next = null;
	}

	public Node(String key, String inbundlefile, String bundlevalue, String usedinfile, Node next) {
		Key = key;
		InBundleFile = inbundlefile;
		BundleValue = bundlevalue;
		UsedInFile = usedinfile;

		m_Next = next;
	}

	public String getData() {
		String alldata = Key + "\t" + InBundleFile + "\t" + BundleValue + "\t" + UsedInFile;
		return alldata;
	}

	public Node getNext() {
		return m_Next;
	}

	public void setData(String key, String inbundlefile, String bundlevalue, String usedinfile) {
		Key = key;
		InBundleFile = inbundlefile;
		BundleValue = bundlevalue;
		UsedInFile = usedinfile;

	}

	public void setNext(Node next) {
		m_Next = next;
	}
}
