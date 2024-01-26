import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import com.meteo.projet_meteo.service.UserService;



@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String home(Model model){
        return "index";
    }


    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        boolean isAuthenticated = userService.authenticate(username, password);

        if (isAuthenticated) {
            return "redirect:/admin_page"; // Redirige vers une page de tableau de bord si authentifié
        } else {
            return "redirect:/?error"; // Redirige vers le formulaire de connexion avec un message d'erreur
        }
    }
}
