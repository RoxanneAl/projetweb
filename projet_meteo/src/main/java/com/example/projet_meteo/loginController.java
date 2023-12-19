@Controller
public class LoginController{

    @PostMapping("/login")
    public ModelAndView login(@RequestParam String login, @RequestParam String password){

        if(authentificationSuccess(login, password)){
            return new ModelAndView("redirect:/home");
        }
        else {
            ModelAndView modelAndView = new ModelAndView("redirect:/login")
            modelAndView.addObject("error", "Invalid credentials");
            return modeAndView;
        }
    }
    @RequestMapping("/home.html")
    public String home(){
        return "home.html";
    }

    @RequestMapping("/login.html")
    public String loginPage(Model model){
        model.addAttribute("loginError",true);
        return "login.html";
    }

    private boolean authentificationSuccess(String login, String password){
        if( login == sa || password == password ){
            return true;
        }else{
            return false;
        }
    }

}