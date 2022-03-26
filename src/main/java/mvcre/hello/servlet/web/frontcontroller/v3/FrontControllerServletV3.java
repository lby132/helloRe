package mvcre.hello.servlet.web.frontcontroller.v3;

import mvcre.hello.servlet.web.frontcontroller.ModelView;
import mvcre.hello.servlet.web.frontcontroller.MyView;
import mvcre.hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import mvcre.hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import mvcre.hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>();

    public FrontControllerServletV3() {
        controllerMap.put("/front-controller/v3/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final String requestURI = request.getRequestURI();
        final ControllerV3 controller = controllerMap.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        final Map<String, String> paramMap = createParamMap(request);

        final ModelView mv = controller.process(paramMap);
        final String viewName = mv.getViewName();
        final MyView myView = viewResolver(viewName);

        myView.render(request, response, mv.getModel());

    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();
        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));
        return paramMap;
    }

    public MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }
}