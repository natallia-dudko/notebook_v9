package edu.examples.java_classes.input.command.impl;

import java.util.Scanner;

import edu.examples.java_classes.controller.Controller;
import edu.examples.java_classes.input.command.Command;

public class ConsoleFindItemByContent implements Command {
	private Controller controller = Controller.getInstance();
	
	@Override
	public void execute() {
		String search;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter title or content for search: > ");
		search = sc.nextLine();
		System.out.println("Ищем");
		
		String request = "FIND_BY_CONTENT content=" + search;
		
		System.out.println(request);
		
		//----------------------------------------------
		
        String response;
		
		response = controller.doAction(request);
		
		//----------------------------------------------------------
		
		System.out.println(response);

	}

}
