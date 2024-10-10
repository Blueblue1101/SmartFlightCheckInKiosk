package test.group16.smartflightcheckinkiosk.Controller;
import group16.smartflightcheckinkiosk.Controller.BoardingpassCheckController;
import org.junit.Assert;
import org.junit.Test;

/** 
* BoardingpassCheckController Tester. 
* 
* @author <Ziding Lin>
* @since <pre>5�� 29, 2022</pre> 
* @version 1.0 
*/ 
public class BoardingpassCheckControllerTest { 


/** 
* 
* Method: onNextClick() 
* 
*/ 
@Test
public void testOnNextClick() throws Exception {
    BoardingpassCheckController a=new BoardingpassCheckController();
    a.name="Rose";
    Assert.assertEquals(0, a.test);
} 

/** 
* 
* Method: initialize(URL arg0, ResourceBundle arg1) 
* 
*/ 
@Test
public void testInitialize() throws Exception {
    BoardingpassCheckController a=new BoardingpassCheckController();
    a.name="JACK";
    Assert.assertEquals(0, a.test);
} 

/** 
* 
* Method: onPrevClick() 
* 
*/ 
@Test
public void testOnPrevClick() throws Exception {
    BoardingpassCheckController a=new BoardingpassCheckController();
    a.name="JACK";
    Assert.assertEquals(0, a.test);
} 


} 
