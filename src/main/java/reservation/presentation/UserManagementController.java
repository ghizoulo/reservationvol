package reservation.presentation;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import reservation.metier.user.UserAdd;
import reservation.metier.user.UserFind;
import reservation.metier.user.UserManager;
import reservation.metier.user.UserUpdate;
import reservation.model.User;

@Controller
//@RequestMapping("/user")
public class UserManagementController {

	protected final Log logger = LogFactory.getLog(getClass());
	
    @Autowired
    private UserManager userManager;

    @RequestMapping(value = "/user.htm", method = RequestMethod.GET)
    public ModelAndView manageUsers() {
        return new ModelAndView("user");
    }
    
    @RequestMapping(value = "/user/add.htm", method = RequestMethod.POST)
    public ModelAndView addUser(
            HttpServletRequest request, @ModelAttribute("useradd") @Valid UserAdd userAdd,
            BindingResult result) {
        
        if (result.hasErrors()) {
            return manageUsers();
        }
        User user = userAdd.getUser();
        try {
            userManager.add(user);
            return new ModelAndView(new RedirectView("/user.htm", true));
        } catch (Exception e) {
            result.rejectValue("login", "error.user.update");
            return manageUsers();
        }
    }

    @RequestMapping(value = "/user/update.htm", method = RequestMethod.POST)
    public ModelAndView updateUser(
            HttpServletRequest request, @ModelAttribute("userupdate") @Valid UserUpdate userUpdate,
            BindingResult result) {

        User user = userUpdate.getUser();
        user.setId(Integer.parseInt(request.getParameter("id")));
        String OriginalLoginUser = request.getParameter("updateLogin");
        if (result.hasErrors()) {
            request.setAttribute("loginErrorUser", OriginalLoginUser);
            request.setAttribute("errorUser",user.getId());            
            return manageUsers();          
        }

        try {
            userManager.update(user);
            return new ModelAndView(new RedirectView("/user.htm", true));
        } catch (Exception e) {
            result.rejectValue("login", "error.user.update");
            return manageUsers();
        }
    }

    @RequestMapping(value = "/user/delete.htm", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) {

        User user = new User();
        user.setId(Integer.parseInt(request.getParameter("id")));
        userManager.delete(user);
        return new ModelAndView(new RedirectView("/user.htm", true));
    }

    @RequestMapping(value = "/user/find.htm", method = RequestMethod.POST)
    public ModelAndView findUsers(
            HttpServletRequest request, @ModelAttribute("userfind") @Valid UserFind userFind,
            BindingResult result) throws Exception {
        
        if (result.hasErrors()) {
            return manageUsers();
        }
        
        String keyword = userFind.getKeyword();
        List<User> usersFound;
        usersFound = userManager.find(keyword);
        return manageUsers().addObject("users", usersFound);
    }

    @ModelAttribute("userRoles")
    public Map<String, String> getUserRoles() {
        return User.USER_ROLES;
    }

    @ModelAttribute("userfind")
    public UserFind getUserFind() {
        return new UserFind();
    }

    @ModelAttribute("userupdate")
    public UserUpdate getUserUpdate() {
        return new UserUpdate();
    }

    @ModelAttribute("useradd")
    public UserAdd getUserAdd() {
        return new UserAdd();
    }

    @ModelAttribute("users")
    private List<User> listUsers() {
        List<User> users = new LinkedList<User>();
        try {
            users = userManager.list();
        } catch (Exception e) {
        }
        return users;
    }
}
