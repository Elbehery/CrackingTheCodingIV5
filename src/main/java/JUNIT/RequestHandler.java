package JUNIT;

/**
 * Created by mustafa on 03.04.16.
 */
public interface RequestHandler {

    Response process(Request request) throws Exception;
}
