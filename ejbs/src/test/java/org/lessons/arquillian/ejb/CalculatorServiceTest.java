package org.lessons.arquillian.ejb;

import static org.junit.Assert.*;


import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ejb.EJB;


@RunWith(Arquillian.class)
public class CalculatorServiceTest {


    @Deployment
    public static JavaArchive createDeployment() {

        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addClass(org.lessons.arquillian.ejb.CalculatorService.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        System.out.println(jar.toString(true));

        return jar;
    }


    @EJB
    CalculatorService calculatorService;

    @Test
    public void helloEJB() {

        assertTrue("EJB method returns an unexpected value",
                calculatorService.HelloEJB() == "Hello EJB");

    }
}