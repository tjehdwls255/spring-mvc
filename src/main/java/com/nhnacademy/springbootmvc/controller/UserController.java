package com.nhnacademy.springbootmvc.controller;

import com.nhnacademy.springbootmvc.domain.User;
import com.nhnacademy.springbootmvc.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // TODO: 아래 요청을 처리하는 컨트롤러 메서드를 완성

    /* TODO 1
     * GET /users
     * 모든 저장된 멤버들을 출력
     */

    @GetMapping("/user")
    public String getUsers(Model model) {
        List<User> users = userRepository.getUsers();
        model.addAttribute("users", users);
        return "users";
    }

    /**
     * TODO 2
     * GET /user/{id}
     * id를 URL path variable 로 받아서 해당하는 유저를 조회
     */

    /* TODO 2-1 */
    @GetMapping("/user/{id}")
    public String getUser(Model model, @PathVariable("id") String id) {
        User user = userRepository.getUser(id);
        model.addAttribute("user", user);
        return "user";
    }

    /**
     * TODO 3
     * GET /user?id={id}
     * id를 request parameter 로 받아서 해당하는 유저를 조회
     */

    /* TODO 3-1 */
    @GetMapping("/user")
    public String getUserByName(Model model, @RequestParam("id") String id) {
        User user = userRepository.getUser(id);
        model.addAttribute("user", user);
        return "user";
    }

    @GetMapping("/agent")
    public String getUserAgent(Model model, @RequestHeader(name = "User-Agent") String userAgent) {
        if (userAgent == "Android") {
            model.addAttribute("agent", "Android");
        } else if (userAgent.equals("iOS")) {
            model.addAttribute("agent", "iOS");
        } else {
            model.addAttribute("agent", "PC");
        }
        return "user";
    }


}
