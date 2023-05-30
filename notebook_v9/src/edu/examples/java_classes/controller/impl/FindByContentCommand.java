package edu.examples.java_classes.controller.impl;

import java.util.List;

import edu.examples.java_classes.controller.Command;
import edu.examples.java_classes.entity.Note;
import edu.examples.java_classes.logic.LogicException;
import edu.examples.java_classes.logic.LogicProvider;
import edu.examples.java_classes.logic.NoteBookLogic;
import edu.examples.java_classes.output.NotebookOutput;

public class FindByContentCommand implements Command {
	private final NoteBookLogic logic = LogicProvider.getInstance().getNoteBookLogic();

	@Override
	public String execute(String request) {
		String[] params = request.split("\\s+");

		String search = params[1].split("=")[1];

		String response = "";
		System.out.println(search);

		try {
			response = NotebookOutput.print(logic.find(search));
		} catch (LogicException e) {
			// log
			response = "Error!!!";
		}

		return response;
	}

}
