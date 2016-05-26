package JUNIT;

/**
 * Created by mustafa on 03.04.16.
 */
public interface Controller {

    Response processRequest(Request request);

    void addHandler(Request request, RequestHandler requestHandler);
}
