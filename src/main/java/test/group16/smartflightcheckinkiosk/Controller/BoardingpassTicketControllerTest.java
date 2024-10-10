package test.group16.smartflightcheckinkiosk.Controller; 

import group16.smartflightcheckinkiosk.Controller.BoardingpassTicketController;
import org.junit.Assert;
import org.junit.Test;

/** 
* BoardingpassTicketController Tester. 
* 
* @author <Authors name> 
* @since <pre>5�� 15, 2022</pre> 
* @version 1.0 
*/ 
public class BoardingpassTicketControllerTest { 

/** 
* 
* Method: initialize(URL arg0, ResourceBundle arg1) 
* 
*/ 
@Test
public void testInitialize() throws Exception {
    BoardingpassTicketController a=new BoardingpassTicketController();
    a.name="JACK";
    Assert.assertEquals(0, a.test);
} 


} 
