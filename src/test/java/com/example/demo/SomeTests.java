package com.example.demo;

import com.example.demo.hibernate.HibernateIntegrator;
import com.example.demo.hibernate.MyQueryTranslator;
import java.util.EnumSet;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.hibernate.tool.schema.TargetType;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author Burkhard Graves
 */
@SpringBootTest
public class SomeTests {
    
//	@Test
	public void printCreateScript() {
        
        SchemaExport schemaExport = new SchemaExport();
        schemaExport.setDelimiter(";");
        schemaExport.setFormat(true);
        
        schemaExport.createOnly(EnumSet.of(TargetType.STDOUT), HibernateIntegrator.getMetadata());
	}
    
    /**
     * https://hibernate.atlassian.net/browse/HHH-14475
     * 
     * created SQL is ok in 5.4.12.Final
     * but broken in 5.4.13.Final
     */
    @Test
    public void selectIndicesFromTernaryRelation() {
        SomeTests.this.print("select indices(p.roles) from Person p");
    }
    
    private void print(String hql) {
        System.out.println(MyQueryTranslator.translate(hql, true));
    }
}
