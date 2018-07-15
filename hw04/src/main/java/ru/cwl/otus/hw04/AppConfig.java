package ru.cwl.otus.hw04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import ru.cwl.otus.hw04.service.CsvLoadService;
import ru.cwl.otus.hw04.service.ExamFabricService;
import ru.cwl.otus.hw04.service.LanguageService;
import ru.cwl.otus.hw04.service.QAService;
import ru.cwl.otus.hw04.ui.ExamConsoleUI;

import java.util.Locale;

/**
 * Created by vadim.tishenko
 * on 01.07.2018 21:52.
 */
@Configuration
public class AppConfig {
    @Value("${hw04.locale}")
    private String locale;


    @Bean
    LanguageService getLanContext(){
        return new LanguageService(locale);
    }

    @Bean
    public QAService getCsvLoadService(LanguageService languageService) {
        return new CsvLoadService(languageService);
    }

    @Bean
    ExamFabricService getExamFabricService(QAService loadService) {
        return new ExamFabricService(loadService);
    }

    @Bean
    public ExamConsoleUI getExamConsoleUI(ExamFabricService examFabricService, MessageSource ms, LanguageService languageService) {
        return new ExamConsoleUI(examFabricService, ms, languageService);
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("/i18n/exam_console");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
}
