package test.group16.smartflightcheckinkiosk.Controller; 

import group16.smartflightcheckinkiosk.Controller.FlightListController;
import org.junit.Assert;
import org.junit.Test;

/** 
* FlightListController Tester. 
* 
* @author <Ziding Lin>
* @since <pre>5�� 29, 2022</pre> 
* @version 1.0 
*/ 
public class FlightListControllerTest { 


/** 
* 
* Method: gotoCheckFlight(ActionEvent event) 
* 
*/ 
@Test
public void testGotoCheckFlight() throws Exception {
    FlightListController a=new FlightListController();
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
    FlightListController a=new FlightListController();
    a.flightNum="CA1343";
    Assert.assertEquals(0, a.test);
} 


} 
