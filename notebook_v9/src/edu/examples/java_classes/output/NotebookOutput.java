package edu.examples.java_classes.output;

import java.util.List;

import edu.examples.java_classes.entity.Note;

public class NotebookOutput {
	

	public static String print(List<Note> notes) {
		
		if(notes == null || notes.size() <= 0) {
			return "Нет записей для вывода.";
			
		}
		StringBuilder text = new StringBuilder();
		for(Note n : notes) {
			text.append(n.toString());
			text.append('\n');
		}
		return text.toString();
	}

}
