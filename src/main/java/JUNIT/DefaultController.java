package JUNIT;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mustafa on 03.04.16.
 */
public class DefaultController implements Controller {

    private Map requestHandlers = new HashMap();

    public RequestHandler getHandler(Request request) {
        if (!this.requestHandlers.containsKey(request.getName())) {
            String message = "Cannot find handler for request name "
                    + "[" + request.getName() + "]";
            throw new RuntimeException(message);
        }
        return (RequestHandler)
                this.requestHandlers.get(request.getName());
    }

    public Response processRequest(Request request) {
        Response response;
        try {
            response = getHandler(request).process(request);
        } catch (Exception exception) {
            response = new ErrorResponse(request, exception);
        }
        return response;
    }

    public void addHandler(Request request, RequestHandler requestHandler) {

        if (this.requestHandlers.containsKey(request.getName())) {
            throw new RuntimeException("A request handler has "
                    + "already been registered for request name "
                    + "[" + request.getName() + "]");
        } else {
            this.requestHandlers.put(request.getName(), requestHandler);
        }
    }

}

