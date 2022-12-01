package com.glarimy.template;

public class ServerAssembler extends ComputerAssembler {

	@Override
	public void buildMotherBoard() {
		System.out.println("Building mother board for server computer");
	}

	@Override
	public void installDisk() {
		System.out.println("Installing hard disk for server computer");
	}

	@Override
	public void installOperatingSystem() {
		System.out.println("Installing OS for server computer");
	}

}
