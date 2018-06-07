package com.ypeksen.mvc.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.ypeksen.mvc.hibernateapplication.HibernateApplication;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer{

	@Override
	protected Class<?>[] getRootConfigClasses() {
		 return new Class[] { HibernateApplication.class };
	}
	@Override
        protected Class<?>[] getServletConfigClasses() {
                 return null;
        }
        @Override
        protected String[] getServletMappings() {
                 return new String[]{ "/" };
        }
}
