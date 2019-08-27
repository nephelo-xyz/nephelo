package com.nephelo.gate.session;

import org.springframework.security.web.session.HttpSessionEventPublisher;
import org.springframework.session.web.context.AbstractHttpSessionApplicationInitializer;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;

/**
 * Created by nephelo on 2018/12/21.
 */
@Service
public class SessionApplicationInitializer  extends AbstractHttpSessionApplicationInitializer {
    @Override
    protected void afterSessionRepositoryFilter(ServletContext servletContext) {
        servletContext.addListener(new HttpSessionEventPublisher());
    }
}