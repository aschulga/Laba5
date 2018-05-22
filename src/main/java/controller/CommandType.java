package controller;

import controller.book.*;
import controller.site.HandlerVK;
import controller.theme.AddThemeCommand;
import controller.theme.DeleteThemeCommand;
import controller.theme.ReplaceThemeCommand;
import controller.theme.ShowTableOfThemesCommand;

public enum CommandType {
    SHOW_TABLE_OF_BOOKS(new ShowTableOfBookCommand()),
    ADD_BOOK(new AddBookCommand()),
    DELETE_BOOK(new DeleteBookCommand()),
    REPLACE_BOOK(new ReplaceBookCommand()),
    OPEN_BOOK(new OpenBookCommand()),
    SHOW_TABLE_OF_THEMES(new ShowTableOfThemesCommand()),
    ADD_THEME(new AddThemeCommand()),
    DELETE_THEME(new DeleteThemeCommand()),
    REPLACE_THEME(new ReplaceThemeCommand());

    private Command command;

    CommandType(Command command) {
        this.command = command;
    }

    public Command getCommand() {
        return command;
    }
}
