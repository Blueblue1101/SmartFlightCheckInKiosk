package test.group16.smartflightcheckinkiosk.Controller; 

import group16.smartflightcheckinkiosk.Controller.BoardingpassController;
import org.junit.Assert;
import org.junit.Test;

/** 
* BoardingpassController Tester. 
* 
* @author <Ziding Lin>
* @since <pre>5�� 15, 2022</pre> 
* @version 1.0 
*/ 
public class BoardingpassControllerTest { 


/** 
* 
* Method: onHelpClick() 
* 
*/ 
@Test
public void testOnHelpClick() throws Exception {
    BoardingpassController a=new BoardingpassController();
    a.name="JACK";
    Assert.assertEquals(0, a.test);
} 

/** 
* 
* Method: onOKClick() 
* 
*/ 
@Test
public void testOnOKClick() throws Exception {
    BoardingpassController a=new BoardingpassController();
    a.name="JACK";
    Assert.assertEquals(0, a.test);
} 


} 
