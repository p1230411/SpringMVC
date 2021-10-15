package hello.servlet.web.frontcontroller;

import java.util.Map;

public interface ControllerV4 {

    /**
     *
     * @param paraMap
     * @param model
     * @return viewName
     */
    String process(Map<String, String> paraMap, Map<String, Object> model);
}
