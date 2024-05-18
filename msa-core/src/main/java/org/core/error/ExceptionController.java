package org.core.error;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ExceptionController implements ErrorController {

    @RequestMapping("/error")
    public ModelAndView handleError(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (status != null) {
            int statusCode = Integer.parseInt(status.toString());
            modelAndView.addObject("statusCode", statusCode);

            switch (statusCode) {
                case 404:
                    modelAndView.addObject("errorMessage", "페이지를 찾을 수 없습니다.");
                    modelAndView.setViewName("error/404");
                    break;
                case 500:
                    modelAndView.addObject("errorMessage", "서버 에러입니다.");
                    modelAndView.setViewName("error/500");
                    break;
                default:
                    modelAndView.addObject("errorMessage", "잘못된 접근입니다.");
                    modelAndView.setViewName("error/404");
                    break;
            }
        }
        return modelAndView;
    }

}
