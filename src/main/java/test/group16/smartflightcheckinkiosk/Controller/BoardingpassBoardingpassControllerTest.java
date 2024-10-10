package test.group16.smartflightcheckinkiosk.Controller;

import group16.smartflightcheckinkiosk.Controller.BoardingpassBoardingpassController;
import org.junit.Assert;
import org.junit.Test;


/** 
* BoardingpassBoardingpassController Tester. 
* 
* @author <Ziding Lin>
* @since <pre>5�� 15, 2022</pre> 
* @version 1.0 
*/ 
public class BoardingpassBoardingpassControllerTest {

/** 
* 
* Method: initialize(URL arg0, ResourceBundle arg1) 
* 
*/ 
@Test
public void testInitialize() {
    BoardingpassBoardingpassController a=new BoardingpassBoardingpassController();
    a.name="JACK";
    Assert.assertEquals(0, a.test);
} 


} 
