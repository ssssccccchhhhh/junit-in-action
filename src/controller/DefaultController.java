package controller;

import java.util.HashMap;
import java.util.Map;

public class DefaultController implements Controller {
    private Map requestHandlers = new HashMap(); // 1

    protected RequestHandler getHandler(Request request) { // 2
        if (!this.requestHandlers.containsKey(request.getName())) {
            String message = "Cannot find handler for request name " + "[" + request.getName() + "]";
            throw new RuntimeException(message); // 3
        }
        return (RequestHandler) this.requestHandlers.get(request.getName()); // 4
    }

    @Override
    public Response processRequest(Request request) { // 5
        Response response;
        try {
            response = getHandler(request).process(request);
        } catch (Exception exception) {
            response = new ErrorResponse(request, exception);
        }
        return response;
    }

    @Override
    public void addHandler(Request request, RequestHandler requestHandler) {
        if (this.requestHandlers.containsKey(request.getName())) {
            throw new RuntimeException("A request handler has already been registered for request name [" + request.getName() + "]"); // 6
        } else {
            this.requestHandlers.put(request.getName(), requestHandler);
        }
    }
}
