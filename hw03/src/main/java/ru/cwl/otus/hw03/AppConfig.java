package ru.cwl.otus.hw03;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import ru.cwl.otus.hw03.service.CsvLoadService;
import ru.cwl.otus.hw03.service.ExamFabricService;
import ru.cwl.otus.hw03.service.QAService;
import ru.cwl.otus.hw03.ui.ExamConsoleUI;

import java.util.Locale;

/**
 * Created by vadim.tishenko
 * on 01.07.2018 21:52.
 */
@Configuration
public class AppConfig {
    @Value("${hw03.locale}")
    private String locale;

    @Bean
    Locale getLocale() {
        return Locale.forLanguageTag(locale);
    }

    @Bean
    public QAService geCsvLoadService(Locale locale) {
        return new CsvLoadService(locale);
    }

    @Bean
    ExamFabricService getExamFabricService(QAService loadService) {
        return new ExamFabricService(loadService);
    }

    @Bean
    public ExamConsoleUI getExamConsoleUI(ExamFabricService examFabricService, MessageSource ms, Locale locale) {
        return new ExamConsoleUI(examFabricService, ms, locale);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/exam_console");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
}
