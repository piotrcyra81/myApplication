package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;


import java.util.ArrayList;
import java.util.List;

@Service
public class HowManyTasksAvailable {
    @Autowired
    private AdminConfig adminConfig;


    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String createMailHowManyTasks(String message) {
        List<String> howManyTasks = new ArrayList<>();
        howManyTasks.add("Task to do");
        howManyTasks.add("Task to do");
        howManyTasks.add("Task to do");

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://piotrcyra81.github.io/");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", false);
        context.setVariable("admin_config", adminConfig);
        context.setVariable("howManyTasks ", howManyTasks);
        context.setVariable("goodbye_message", "Bye bye!");
        context.setVariable("company_details", adminConfig.getCompanyName());

        return templateEngine.process("mail/mail-howManyTaskYouHave", context);
    }
}
