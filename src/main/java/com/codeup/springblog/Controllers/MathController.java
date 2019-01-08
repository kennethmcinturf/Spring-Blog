package com.codeup.springblog.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MathController {
    @Controller
    class doThatMath{
        @GetMapping("/{operations}/{numberOne}/{unimportant}/{numberTwo}")
        @ResponseBody
        public int doMath(@PathVariable String operations, @PathVariable int numberOne, @PathVariable int numberTwo){
            if (operations.equals("add")){
                return numberOne + numberTwo;
            }else if (operations.equals("subtract")){
                return numberTwo + numberOne;
            }else if (operations.equals("multiply")){
                return numberOne + numberTwo;
            }else{
                return numberOne / numberTwo;
            }
        }
    }
}
