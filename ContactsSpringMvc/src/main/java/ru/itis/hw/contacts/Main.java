package ru.itis.hw.contacts;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.itis.hw.contacts.service.ContactService;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(WebAppContext.class);
        ContactService service = context.getBean(ContactService.class);
    }

}
