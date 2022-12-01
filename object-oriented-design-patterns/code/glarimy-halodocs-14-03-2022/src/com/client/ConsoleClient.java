package com.client;

import com.dir.api.Directory;
import com.dir.api.PrintableDirectory;
import com.dir.api.domain.Profile;
import com.dir.api.exceptions.DirectoryException;
import com.dir.service.SimplePrintableDirectory;

public class ConsoleClient {
	public static void main(String[] args) {
		try {
			Directory dir = (Directory) ObjectFactory.get("directory");
			Profile profile = new Profile();
			profile.setName("Krishna Mohan");
			profile.setPhoneNumber(1234L);
			dir.add(profile);

			PrintableDirectory printer = new SimplePrintableDirectory(dir);
			printer.print();
		} catch (DirectoryException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
