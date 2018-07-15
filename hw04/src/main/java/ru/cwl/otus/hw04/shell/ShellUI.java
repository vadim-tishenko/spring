package ru.cwl.otus.hw04.shell;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.cwl.otus.hw04.service.LanguageService;
import ru.cwl.otus.hw04.ui.ExamConsoleUI;

import java.util.Locale;

/**
 * Created by vadim.tishenko
 * on 15.07.2018 20:27.
 */
@ShellComponent
public class ShellUI {
    private final Locale EN=Locale.ENGLISH;
    private final Locale RU=Locale.forLanguageTag("RU");

    @Autowired
    ExamConsoleUI examConsoleUI;

    @Autowired
    LanguageService languageService;

    @ShellMethod("Switch to Russian")
    public void ru(){
        languageService.setLocale(RU);
    }

    @ShellMethod("Switch to English")
    public void en(){
        languageService.setLocale(EN);
    }

    @ShellMethod("Start test")
    public void start(){
        examConsoleUI.start();
    }
}
