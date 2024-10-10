package test.group16.smartflightcheckinkiosk.Controller; 

import group16.smartflightcheckinkiosk.Controller.StaffLoginController;
import org.junit.Assert;
import org.junit.Test;

/** 
* StaffLoginController Tester. 
* 
* @author <Ziding Lin>
* @since <pre>5�� 29, 2022</pre> 
* @version 1.0 
*/ 
public class StaffLoginControllerTest { 


/** 
* 
* Method: gotoChooseLogin(ActionEvent event) 
* 
*/ 
@Test
public void testGotoChooseLogin() throws Exception {
    StaffLoginController a=new StaffLoginController();
    a.staff_num="123";
    Assert.assertEquals(0, a.test);
} 

/** 
* 
* Method: gotoEnterFlight(ActionEvent event) 
* 
*/ 
@Test
public void testGotoEnterFlight() throws Exception { 
    StaffLoginController a=new StaffLoginController();
    a.staff_num="123";
    Assert.assertEquals(0, a.test);
} 


} 
