package org.mycoz.tools;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.regex.Pattern;

public class ShowMethods {
	private static final String usage = "usage: \n" + "ShowMethods qualified.class.name\n" + "To show all methods in class or: \n"
			+ "ShowMethods qualified.class.name word\n" + "To search for methods involving 'word'";

	private static Pattern p = Pattern.compile("\\w+\\.");

	public ShowMethods() {
	}

	public ShowMethods(String[] args) {
		if (args.length < 1) {
			System.out.println(usage);
			System.exit(0);
		}
		int lines = 0;
		try {
			Class c = Class.forName(args[0]);
			Method[] m = c.getMethods();
			Constructor[] ctor = c.getConstructors();
			if (args.length == 1) {
				for (int i = 0; i < m.length; i++)
					System.out.println(p.matcher(m[i].toString()).replaceAll(""));
				for (int i = 0; i < ctor.length; i++)
					System.out.println(p.matcher(ctor[i].toString()).replaceAll(""));
				lines = m.length + ctor.length;
			} else {
				for (int i = 0; i < m.length; i++)
					if (m[i].toString().indexOf(args[1]) != -1) {
						System.out.println(p.matcher(m[i].toString()).replaceAll(""));
						lines++;
					}
				for (int i = 0; i < ctor.length; i++)
					if (ctor[i].toString().indexOf(args[1]) != -1) {
						System.out.println(p.matcher(ctor[i].toString()).replaceAll(""));
						lines++;
					}
			}
		} catch (ClassNotFoundException e) {
			System.out.println("No such class: " + e);
		}
	}
} // /:~

