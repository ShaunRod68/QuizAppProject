package org.kjsim.quizapppro;

import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

    @Autowired
    private UserRepository userRepository;


    @RequestMapping({"/", "home"})
    public String viewHome() {
        return "index";
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String handleLogin(@RequestParam String username,
                              @RequestParam String password,
                              HttpSession session,
                              Model model) {
        User user = userRepository.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("username", username);
            return "redirect:/dashboard";
        } else {
            model.addAttribute("msg", "Invalid credentials");
            return "login";
        }
    }


    @GetMapping("/register")
    public String showRegisterPage() {
        return "register";
    }

    @PostMapping("/register")
    public String handleRegister(@RequestParam String username,
                                 @RequestParam String password,
                                 Model model) {
        if (userRepository.findByUsername(username) != null) {
            model.addAttribute("msg", "Username already exists.");
            return "register";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password); // Note: In production, encrypt passwords!
        userRepository.save(user);

        model.addAttribute("msg", "Registered successfully. Please log in.");
        return "login";
    }

    @GetMapping("/dashboard")
    public String showDashboard(HttpSession session, Model model) {
        String username = (String) session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }
        model.addAttribute("username", username);
        return "home"; // home.jsp expects ${sessionScope.username}
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }

    @GetMapping("/lobby")
    public String showLobbyPage() {
        return "lobby"; // lobby.jsp
    }

    @PostMapping("/lobby")
    public String createLobby(@RequestParam("lobby_name") String name, Model model) {
        model.addAttribute("msg", "Lobby '" + name + "' created!");
        return "lobby";
    }

}
