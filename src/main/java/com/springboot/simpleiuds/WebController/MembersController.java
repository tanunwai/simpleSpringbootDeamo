package com.springboot.simpleiuds.WebController;

import com.springboot.simpleiuds.beans.Memberships;
import com.springboot.simpleiuds.domain.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/members")
public class MembersController {

    private final MemberDao memberDao;

    @Autowired
    public MembersController(MemberDao memberDao){
        this.memberDao=memberDao;
    }

    /*顯示會員表單*/

    @RequestMapping(method = {RequestMethod.GET})
    public String getMembersList(ModelMap mapping){
        mapping.addAttribute("membersList",memberDao.findAll());
        return "membersList";
    }

    /*顯示會員創建表單*/

    @RequestMapping(method = {RequestMethod.GET},path = {"/create"})
    public String createMembersForm(ModelMap mapping){
        mapping.addAttribute("user",new Memberships());
        mapping.addAttribute("action","create");
        return "userForm";
    }

    /*創建會員;處理"/members"的POST請求，用來獲取用戶列表;通過@ModelAttribute綁定參數*/
    /*也通過@RequestParam從頁面中傳遞參數*/

    @RequestMapping(method = {RequestMethod.POST},path = {"create"})
    public String postMembers(ModelMap mapping, @ModelAttribute @Valid Memberships members, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            mapping.addAttribute("action","create");
            return "userForm";
        }
        memberDao.insertOrUpdate(members);
        return "redirect:/members/";
    }

    /*更新會員;處理"/members/{id}"的GET請求，通過URL的id獲取members的訊息*/
    /*URL中的參數通過@PathVaribale綁定參數*/

    @RequestMapping(method = {RequestMethod.GET},path = {"/update/{id}"})
    public String getMembers(@PathVariable Integer id, ModelMap mapping){
        mapping.addAttribute("user",memberDao.findById(id));
        mapping.addAttribute("action","update");
        return "userForm";
    }

    /*處理"/members/{id}"的PUT請求*/

    @RequestMapping(method={RequestMethod.POST},path={"/update"})
    public String putMembers(ModelMap mapping, @ModelAttribute @Valid Memberships members, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            mapping.addAttribute("action","update");
            return "userForm";
        }
        memberDao.insertOrUpdate(members);
        return "redirect:/members/";
    }

    /*處理"/members/{id}"的delete的請求*/

    @RequestMapping(method = {RequestMethod.GET},path={"/delete/{id}"})
    public String deleteMembers(@PathVariable Integer id){
        memberDao.deleteMembers(id);
        return "redirect:/members/";
    }
}
