package junit;

import JUNIT.*;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class DefaultControllerTest {

    private DefaultController defaultController;
    private Request request;
    private RequestHandler requestHandler;
    private SampleExceptionHandler sampleExceptionHandler;

    @Before
    public void initialize() {

        defaultController = new DefaultController();
        request = new SampleRequest();
        requestHandler = new SampleHandler();
        sampleExceptionHandler = new SampleExceptionHandler();

        defaultController.addHandler(request, requestHandler);
    }

    @Test
    public void testAddHandler() {
        RequestHandler handler2 = defaultController.getHandler(request);
        Assert.assertSame("Handler we set in defaultController should be the same handler we get", handler2, requestHandler);
    }

    @Test
    public void testProcessRequest() {
        Response response = defaultController.processRequest(request);
        Assert.assertNotNull("Must not return a null response", response);
        Assert.assertEquals("Response should be of type SampleResponse",
                SampleResponse.class, response.getClass());

    }


    @Test
    public void testProcessRequestAnswerErrorResponse() {

        SampleRequest requestErr = new SampleRequest("testError");
        defaultController.addHandler(requestErr, sampleExceptionHandler);
        Response response = defaultController.processRequest(requestErr);
        Assert.assertNotNull("Must not return a null Respone", response);
        Assert.assertEquals(ErrorResponse.class, response.getClass());
    }

    @Test(expected = RuntimeException.class)
    public void testGetHandlerNotDefined() {

        SampleRequest sampleRequest = new SampleRequest("Not Defined");

        defaultController.getHandler(sampleRequest);

    }

    @Test(expected = RuntimeException.class)
    public void testAddHandlerNotDefined(){

        defaultController.addHandler(request,requestHandler);
    }


    private class SampleRequest implements Request {
        private static final String DEFAULT_NAME = "Test";
        private String name;

        public SampleRequest(String name) {
            this.name = name;
        }

        public SampleRequest() {
            this(DEFAULT_NAME);
        }

        public String getName() {
            return this.name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    private class SampleHandler implements RequestHandler {
        public Response process(Request request) throws Exception {
            return new SampleResponse();
        }
    }

    private class SampleResponse implements Response {
        // empty
    }

    private class SampleExceptionHandler implements RequestHandler {

        public Response process(Request request) throws Exception {
            throw new Exception("testing exception handler");
        }
    }

}
