package edu.examples.java_classes.input;

import java.util.HashMap;
import java.util.Map;

import edu.examples.java_classes.input.command.MenuCommand;

public final class MenuBuilder {
	private static final MenuBuilder instance = new MenuBuilder();
	
	private MenuSelectionSystem menuSystem = new MenuSelectionSystem();
	private Display display = new Display();
	private InputTerminal terminal = new InputTerminal();

	private MenuBuilder() {
		ConcreteMenu cm1 = new ConcreteMenu("ГЛАВНОЕ МЕНЮ");
		cm1.setItems(MenuCommand.CREATE_NEW_ITEM.getConsoleCode(), "Создать новую запись.");
		cm1.setItems(MenuCommand.SHOW_FIND_MENU.getConsoleCode(),"Найти запись.");
		cm1.setItems(MenuCommand.EXIT_CODE.getConsoleCode(),"Завершить работу приложения.");

		menuSystem.add(Menu.MAIN_MENU, cm1);

		ConcreteMenu cm2 = new ConcreteMenu("ПОИСК");
		cm2.setItems(MenuCommand.FIND_BY_DATE.getConsoleCode(),"По дате.");
		cm2.setItems(MenuCommand.FIND_BY_CONTENT.getConsoleCode(),"По содержанию.");
		cm2.setItems(MenuCommand.EXIT_CODE.getConsoleCode(), "Выйти из меню.");

		menuSystem.add(Menu.SEARCH_MENU, cm2);
	}

	public static MenuBuilder getInstance() {
		return instance;
	}

	public MenuSelectionSystem getMenuSystem() {
		return menuSystem;
	}

	public Display getDisplay() {
		return display;
	}

	public InputTerminal getTerminal() {
		return terminal;
	}
	
}
