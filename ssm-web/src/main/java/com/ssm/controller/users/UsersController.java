package com.ssm.controller.users;

import com.ssm.common.utils.BeanUtil;
import com.ssm.model.users.domain.UsersDO;
import com.ssm.model.users.vo.UsersVO;
import com.ssm.service.users.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    @RequestMapping("/addUser")
    public ModelAndView addUser(UsersVO usersVO) {
        ModelAndView modelAndView = new ModelAndView("/users/index");

        UsersDO usersDO = new UsersDO();
        BeanUtil.coverBean2Bean(usersVO, usersDO);
        try {
            //usersService.save(usersDO);
            //为了测试事物;
            int count = usersService.saveUsers(usersDO);

        } catch (Exception e) {
            e.printStackTrace();
        }

        modelAndView.addObject("users", usersService.list());
        return modelAndView;

    }

    @RequestMapping("/list")
    public ModelAndView list() {
        List<UsersDO> list = null;
        try {
            list = usersService.list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        ModelAndView mav = new ModelAndView("/users/index");
        mav.addObject("users", list);

        return mav;

    }

    @RequestMapping(value = "/modifyUser", method = RequestMethod.POST)
    public ModelAndView modifyUser(@ModelAttribute("user") UsersDO user) {
        ModelAndView modelAndView = new ModelAndView("/users/index");
        int count = usersService.update(user);

        modelAndView.addObject("users", usersService.list());
        return modelAndView;

    }

    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ModelAndView deleteUser(@ModelAttribute("user") UsersDO user) {
        ModelAndView modelAndView = new ModelAndView("/users/index");
        int count = usersService.delete(user.getId());

        modelAndView.addObject("users", usersService.list());
        return modelAndView;

    }

}
