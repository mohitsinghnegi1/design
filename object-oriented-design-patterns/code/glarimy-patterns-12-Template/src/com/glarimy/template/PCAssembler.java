package com.glarimy.template;

public class PCAssembler extends ComputerAssembler {

	@Override
	public void buildMotherBoard() {
		System.out.println("Building mother board for personal computer");
	}

	@Override
	public void installDisk() {
		System.out.println("Installing hard disk for personal computer");
	}

	@Override
	public void installOperatingSystem() {
		System.out.println("Installing OS for personal computer");
	}

}
