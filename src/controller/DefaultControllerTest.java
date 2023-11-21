package controller;

import controller.DefaultController;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DefaultControllerTest { // 1
    private DefaultController controller;

    @Before
    public void instantiate() throws Exception { // 2
        controller = new DefaultController();
    }

    @Test
    public void testMethod() { // 3
        throw new RuntimeException("implement me"); // 4
    }

}