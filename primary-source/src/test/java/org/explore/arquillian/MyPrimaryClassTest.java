package org.explore.arquillian;


import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;
import javax.ejb.EJB;

@RunWith(Arquillian.class)
public class MyPrimaryClassTest {


    @Deployment
    public static JavaArchive createDeployment() {

        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
                .addClass(MyPrimaryClass.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");

        System.out.println(jar.toString(true));

        return jar;
    }



    @Inject
    private MyPrimaryClass myPrimaryClass;

    @org.junit.Test
    public void helloPrimary() {

        //assertEquals("Hello Primary XX", myPrimaryClass.helloPrimary());

        assertTrue("Method returns an unexpected value",
                myPrimaryClass.helloPrimary() == "Hello Primary");


    }



}