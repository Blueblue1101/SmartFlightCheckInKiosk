package test.group16.smartflightcheckinkiosk.Controller; 

import group16.smartflightcheckinkiosk.Controller.BoardingpassTagController;
import org.junit.Assert;
import org.junit.Test;

/** 
* BoardingpassTagController Tester. 
* 
* @author <Ziding Lin>
* @since <pre>5�� 15, 2022</pre> 
* @version 1.0 
*/ 
public class BoardingpassTagControllerTest { 


/** 
* 
* Method: initialize(URL arg0, ResourceBundle arg1) 
* 
*/ 
@Test
public void testInitialize() throws Exception {
    BoardingpassTagController a=new BoardingpassTagController();
    a.name="JACK";
    Assert.assertEquals(0, a.test);
} 


} 
