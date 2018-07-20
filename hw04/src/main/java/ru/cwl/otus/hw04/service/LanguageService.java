package ru.cwl.otus.hw04.service;

import org.springframework.beans.factory.annotation.Value;

import java.util.Locale;

/**
 * Created by vadim.tishenko
 * on 15.07.2018 22:30.
 */
public class LanguageService {
    Locale locale;

    public LanguageService(String tagName) {
        locale=Locale.forLanguageTag(tagName);
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }

    public String getLangTag(){
        return locale.toLanguageTag();
    }
}
