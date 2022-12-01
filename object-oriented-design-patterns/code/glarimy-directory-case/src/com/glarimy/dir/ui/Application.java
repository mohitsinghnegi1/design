package com.glarimy.dir.ui;

import com.glarimy.dir.api.Directory;
import com.glarimy.dir.api.domain.Employee;
import com.glarimy.dir.service.SortableDirectory;
import com.glarimy.factory.ObjectFactory;

public class Application {

	public static void main(String[] args) throws Exception {
		Directory directory = (Directory) ObjectFactory.get("directory");
		
		Employee first = new Employee();
		first.setName("Krishna");
		first.setPhone(12345);

		Employee second = new Employee();
		second.setName("Koyya");
		second.setPhone(23456);

		directory.add(first);
		directory.add(second);

		SortableDirectory sd = new SortableDirectory(directory);
		System.out.println(sd.sort((o1, o2) -> o2.getEid() - o1.getEid()));
		System.out.println(sd.search(e -> e.getName().startsWith("Krishna")));
	}

}
