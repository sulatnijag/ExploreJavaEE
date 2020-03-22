package org.lessons.arquillian.ejb;



import javax.ejb.Stateless;
import javax.ejb.EJB;
import javax.inject.Inject;



@Stateless
public class CalculatorService {


    public String HelloEJB(){
        return "Hello EJB";
    }

}