package sudyar.blps.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sudyar.blps.dto.response.*;

@RestController
@RequestMapping("/")
public class HelloController {

    private static final String EMPLOYER_INFO= "Заказчики переходите к /employer";

    private static final String EXECUTOR_INFO= "Заказчики переходите к /executor";
    @GetMapping
    public InfoResponse showStatus() {
        return new InfoResponse(EMPLOYER_INFO + '\n' + EXECUTOR_INFO, 1);
    }
}
