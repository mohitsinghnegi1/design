package com.glarimy.template;

public abstract class ComputerAssembler {
	public abstract void buildMotherBoard();

	public abstract void installDisk();

	public abstract void installOperatingSystem();

	public void assemble() {
		buildMotherBoard();
		installDisk();
		installOperatingSystem();
		System.out.println("booting the system");
	}

}
