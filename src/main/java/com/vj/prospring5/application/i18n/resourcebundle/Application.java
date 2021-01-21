package com.vj.prospring5.application.i18n.resourcebundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceResolvable;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.context.support.MessageSourceAccessor;

import java.util.Locale;

import static com.vj.prospring5.util.PrintHelper.delimitLine;

public class Application {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:application-context/i18n-resourcebundle.xml");
        ctx.refresh();

        Locale english = Locale.ENGLISH;
        Locale german = new Locale("de", "DE");

        delimitLine();

        System.out.println(ctx.getMessage("msg", null, english));
        System.out.println(ctx.getMessage("msg", null, german));

        System.out.println(ctx.getMessage("nameMsg", new Object[] {"John", "Mayer"}, english));
        System.out.println(ctx.getMessage("nameMsg", new Object[] {"John", "Mayer"}, german));

        delimitLine();

        String msg = ctx.getBean(MessageSource.class).getMessage("msg", null, Locale.ENGLISH);
        System.out.println("Message from message Source ----> " + msg);

        MessageSourceResolvable resolvable = ctx.getBean(MessageSourceResolvable.class);

        delimitLine();

        ctx.close();
    }
}
