package com.glarimy.template;

public class Application {
	public static void main(String[] args) throws Exception {
		ComputerAssembler assembler = new PCAssembler();
		assembler.assemble();
	}
}