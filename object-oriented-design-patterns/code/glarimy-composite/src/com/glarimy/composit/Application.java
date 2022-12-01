package com.glarimy.composit;

public class Application {
	public static void main(String[] args) throws Exception {
		Container container = new ConcreteContainer();
		Container partOne = new ConcreteContainer();
		Container partTwo = new ConcreteContainer();
		Component partThree = new ConcreteComponent();
		Component partFour = new ConcreteComponent();
		
		partTwo.add(partThree);
		partTwo.add(partFour);
		partOne.add(partTwo);
		
		container.add(partOne);
		
		container.service();
	}
}