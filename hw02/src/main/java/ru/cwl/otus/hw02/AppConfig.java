package ru.cwl.otus.hw02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.cwl.otus.hw02.service.CsvLoadService;
import ru.cwl.otus.hw02.service.ExamFabricService;
import ru.cwl.otus.hw02.service.QAService;
import ru.cwl.otus.hw02.ui.ExamConsoleUI;

/**
 * Created by vadim.tishenko
 * on 01.07.2018 21:52.
 */
@Configuration
public class AppConfig {
    @Bean
    QAService geCsvLoadService(){
        return new CsvLoadService();
    }

    @Bean
    ExamFabricService getExamFabricService(QAService loadService){
        return new ExamFabricService(loadService);
    }

    @Bean
    ExamConsoleUI getExamConsoleUI(ExamFabricService examFabricService){
        return new ExamConsoleUI(examFabricService);
    }
}
