package com.lambdaschool.friendfinderbe;

import com.lambdaschool.friendfinderbe.handlers.ExternalAccess;
import com.lambdaschool.friendfinderbe.models.RandomUserMe;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@EnableWebMvc
@EnableJpaAuditing
@SpringBootApplication
@EnableSwagger2
public class StartHereApplication
{
    public static void main(String[] args)
    {
        ApplicationContext ctx = SpringApplication.run(StartHereApplication.class, args);

        DispatcherServlet dispatcherServlet = (DispatcherServlet) ctx.getBean("dispatcherServlet");
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

/*        ExternalAccess externalAccess = new ExternalAccess();
        ArrayList<RandomUserMe> arrayList = externalAccess.connectAndRetrieveJson("?seed=ffbe&results=3");
        System.out.println("test");*/
    }
}
