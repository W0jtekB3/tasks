package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("welcomeMessage", "Welcome to the TaskCrudApp!");
        context.setVariable("goodbyeMessage", "Thank you for using our service!");
        context.setVariable("buttonName", "Click here");
        context.setVariable("buttonUrl", "http://localhost:8888/crud");

        // Company details
        context.setVariable("companyDetails",
                String.format("%s<br>%s<br>Email: %s<br>Phone: %s",
                        adminConfig.getCompanyName(),
                        adminConfig.getCompanyGoal(),
                        adminConfig.getCompanyEmail(),
                        adminConfig.getCompanyPhone()));

        return templateEngine.process("mail/created-trello-card-mail", context);
    }
}
