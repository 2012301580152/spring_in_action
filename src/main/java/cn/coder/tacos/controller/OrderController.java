package cn.coder.tacos.controller;

import cn.coder.tacos.domain.Order;
import cn.coder.tacos.web.domain.User;
import cn.coder.tacos.web.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("/order")
public class OrderController {

    private UserRepository userRepository;

    @Autowired
    public OrderController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping
    public String processOrder(@Valid Order order, Errors errors,
                               SessionStatus sessionStatus,
                               Principal principal) {
//        Authentication authentication =
//                SecurityContextHolder.getContext().getAuthentication();
//        User user = (User) authentication.getPrincipal();

        User user = userRepository.findByUsername(principal.getName());
        order.setUser(user);
        return "order";
    }
}
