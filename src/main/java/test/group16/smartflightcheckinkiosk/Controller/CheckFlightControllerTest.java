package test.group16.smartflightcheckinkiosk.Controller; 

import group16.smartflightcheckinkiosk.Controller.CheckFlightController;
import org.junit.Assert;
import org.junit.Test;

/** 
* CheckFlightController Tester. 
* 
* @author <Ziding Lin>
* @since <pre>5�� 29, 2022</pre> 
* @version 1.0 
*/ 
public class CheckFlightControllerTest { 

/** 
* 
* Method: gotoEnterFlight(ActionEvent event) 
* 
*/ 
@Test
public void testGotoEnterFlight() throws Exception {
    CheckFlightController a=new CheckFlightController();
    a.flightNum="CA1343";
    Assert.assertEquals(0, a.test);
} 

/** 
* 
* Method: initialize(URL arg0, ResourceBundle arg1) 
* 
*/ 
@Test
public void testInitialize() throws Exception {
    CheckFlightController a=new CheckFlightController();
    a.flightNum="CA1343";
    Assert.assertEquals(0, a.test);
} 

/** 
* 
* Method: gotoFlightList(ActionEvent event) 
* 
*/ 
@Test
public void testGotoFlightList() throws Exception {
    CheckFlightController a=new CheckFlightController();
    a.flightNum="CA1343";
    Assert.assertEquals(0, a.test);
} 


} 
