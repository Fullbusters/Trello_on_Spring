package com.trello.controller;

import java.security.Principal;

import com.trello.model.AppUser;
import com.trello.model.Board;
import com.trello.service.AppUserService;
import com.trello.service.BoardService;
import com.trello.utils.WebUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import static com.trello.utils.EncrytedPasswordUtils.encrytePassword;


@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private BoardService boardService;

    @Autowired
    private AppUserService appUserService;

    public String getCurrentUsername() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @RequestMapping(method = RequestMethod.GET)
    public String mainPage(Model model) {
        String username = getCurrentUsername();
        if ("anonymousUser".equalsIgnoreCase(username)) {
            model.addAttribute("check", "anonim");
            model.addAttribute("message", "hello");
        } else {
            model.addAttribute("check", "userloginned");
            model.addAttribute("message", "hello  " + username);
        }

        model.addAttribute("board", boardService.getAll());
        return "main";

    }

    @RequestMapping(value = "/board")
    public String boardPage(Model model, Principal principal) {
        User loginedUser = (User) ((Authentication) principal).getPrincipal();
        //TODO create board with creator_id
        model.addAttribute("board", new Board());
        return "board";
    }


    @RequestMapping(value = "/board/view")
    public String boardcontentPage(Model model, @RequestParam Long id) {
        model.addAttribute("board", boardService.findOne(id));
        return "boardcontent";
    }

    @RequestMapping(value = "/board/submit", method = RequestMethod.POST)
    public String submitBoard(@ModelAttribute Board board) {
        boardService.save(board);
        return "redirect:/";
    }


    @RequestMapping(value = "/reg")
    public String reg(Model model) {
        model.addAttribute("user", new AppUser());
        return "reg";
    }

    @RequestMapping(value = "/reg/submit", method = RequestMethod.POST)
    public String submitUser(Model model, @ModelAttribute AppUser user) {
        String encrytedPassword = encrytePassword(user.getEncrytedPassword());
        user.setEncrytedPassword(encrytedPassword);
        short enable = 1;
        user.setEnabled(enable);
        appUserService.save(user);
        model.addAttribute("check", "anonim");
        model.addAttribute("message", "Registration successful");
        return "main";
    }

    @RequestMapping(value = "/login")
    public String loginPage() {
        return "login";
    }
}
