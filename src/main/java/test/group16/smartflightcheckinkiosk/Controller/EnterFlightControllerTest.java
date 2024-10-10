package test.group16.smartflightcheckinkiosk.Controller; 

import group16.smartflightcheckinkiosk.Controller.EnterFlightController;
import org.junit.Assert;
import org.junit.Test;


/** 
* EnterFlightController Tester. 
* 
* @author <Authors name> 
* @since <pre>5�� 29, 2022</pre> 
* @version 1.0 
*/ 
public class EnterFlightControllerTest { 


/** 
* 
* Method: gotoStaffLogin(ActionEvent event) 
* 
*/ 
@Test
public void testGotoStaffLogin() throws Exception {
    EnterFlightController a=new EnterFlightController();
    a.flightNum="CA1343";
    Assert.assertEquals(0, a.test);
} 

/** 
* 
* Method: gotoCheckFlight(ActionEvent event) 
* 
*/ 
@Test
public void testGotoCheckFlight() throws Exception {
    EnterFlightController a=new EnterFlightController();
    a.flightNum="CA1343";
    Assert.assertEquals(0, a.test);
} 


} 
