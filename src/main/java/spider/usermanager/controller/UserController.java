package spider.usermanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import spider.usermanager.modeldata.User;
import spider.usermanager.service.UserService;

/**
 * Created by SPIDER on 20.06.2017.
 */
@Controller
public class UserController {
private UserService userService;

@Autowired(required = true)
@Qualifier("userService")
    public void setUserService(UserService userService) {
        this.userService = userService;
    }
 @RequestMapping(value = "users",method = RequestMethod.GET)
    public String listUsers(Model model){
    model.addAttribute("user",new User());
    model.addAttribute("listUsers",this.userService.listUsers());
     model.addAttribute("listUsersPart",this.userService.listUsersPart());
    return "users";
 }
 @RequestMapping(value = "next",method = RequestMethod.GET)
 public String listUsersPart(Model model){
     model.addAttribute("user",new User());
     model.addAttribute("listUsersPart",this.userService.listUsersPart());
     return "next";
 }
 @RequestMapping(value = "previous",method = RequestMethod.GET)
 public String listUsersPrevious(Model model){
     model.addAttribute("user",new User());
     model.addAttribute("listUsersPrevious",this.userService.listUsersPrevious());
     return "previous";
 }
    @RequestMapping(value = "users/add",method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){

        if(user.getId()==0)
            this.userService.addUser(user);
        else {
            this.userService.updateUser(user);
        }
        return "redirect:/users";
    }
 @RequestMapping(value = "remove/{id}")
    public String removeUser(@PathVariable("id")int id){
        this.userService.deleteUser(id);
        return "redirect:/users";
 }
 @RequestMapping(value = "edit/{id}")
  public String updateUser(@PathVariable("id")int id,Model model){
        model.addAttribute("user",this.userService.getUserById(id));
     model.addAttribute("listUsers",this.userService.listUsers());

     return "users";
 }
 @RequestMapping(value = "userdata/",method = RequestMethod.GET)
    public String userData(@RequestParam("name") String name, Model model){

      model.addAttribute("listUsersByName",this.userService.listUsersByName(name));
      return "userdata";
 }

}
