package com.example.demo.hibernate;

import java.util.Collections;
import org.hibernate.MappingException;
import org.hibernate.QueryException;
import org.hibernate.engine.jdbc.internal.FormatStyle;
import org.hibernate.hql.internal.ast.ASTQueryTranslatorFactory;
import org.hibernate.hql.spi.QueryTranslator;
import org.hibernate.hql.spi.QueryTranslatorFactory;

/**
 * @author Burkhard Graves
 */
public class MyQueryTranslator {

    private final static QueryTranslatorFactory translatorFactory = new ASTQueryTranslatorFactory();

    private MyQueryTranslator() {
    }

    public static String translate(String hql, boolean format) {
        if (hql == null || hql.trim().length() == 0) {
            return "";
        }
        try {
            final QueryTranslator translator = translatorFactory.createQueryTranslator(
                    hql, hql,
                    Collections.EMPTY_MAP,
                    HibernateIntegrator.getSessionFactory(),
                    null);
            translator.compile(Collections.EMPTY_MAP, false);
            StringBuilder sb = new StringBuilder();
            for (String sql : translator.collectSqlStrings()) {
                sb.append(format
                        ? FormatStyle.BASIC.getFormatter().format(sql)
                        : sql).append(";\n");
            }
            return sb.toString();
        } catch (QueryException | MappingException t) {
            return t.getMessage();
        }
    }
}
