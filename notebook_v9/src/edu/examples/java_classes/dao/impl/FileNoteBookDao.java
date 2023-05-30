package edu.examples.java_classes.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import edu.examples.java_classes.dao.DaoException;
import edu.examples.java_classes.dao.NoteBookDao;
import edu.examples.java_classes.entity.Note;

public class FileNoteBookDao implements NoteBookDao {

	@Override
	public void save(Note n) throws DaoException {
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new FileWriter("resources/my_notes.txt", true));

			writer.write(n.toString());
			writer.newLine();
			
		} catch (IOException e) {
			throw new DaoException("Notepad data not saved.", e);
		} finally {
			try {
				writer.close();
			} catch (IOException e) {
				throw new DaoException("Notepad data not saved.", e);
			}
		}
	}

	@Override
	public List<Note> allNotes() {

		List<Note> allNotes = new ArrayList<>();
		try {

			BufferedReader breader = new BufferedReader(new FileReader("resources/my_notes.txt"));

			String line;

			while ((line = breader.readLine()) != null) {

				allNotes.add(formText(line));				
			}			

		} catch (IOException e) {
			throw new RuntimeException("Somthing Wrong!");
		}
		return allNotes;

	}

	private Note formText(String line) throws IOException {

		String[] params = line.split("\\s+", 5);

		String title = params[2].split("=")[1];
		String content = params[3].split("=")[1];

		Note note = new Note(title, content);
		return note;
	}

}
