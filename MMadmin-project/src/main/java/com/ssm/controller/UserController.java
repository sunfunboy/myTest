package com.ssm.controller;


import com.ssm.pojo.PageBean;
import com.ssm.pojo.ResultVo;
import com.ssm.pojo.User;
import com.ssm.pojo.User00;
import com.ssm.service.UserService;
import com.ssm.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;


@Controller
@ResponseBody
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/login",method = RequestMethod.POST)
    public Object login(String username,String password){
       User user = userService.loginId(username,password);

       if(user!=null){
           user.setPassword("");
           return ResultVo.success(user);
       }else{
           return  ResultVo.error();
       }
    }
    @RequestMapping(value = "/users" ,method =RequestMethod.GET)
    public Object queryUser(String userAccount){

       List<User> list= userService.queryUsers(userAccount);
       return list;

    }
    @RequestMapping(value = "/deleteone{userId}",method = RequestMethod.DELETE)
    public Object deletUser(@PathVariable("userId") String userId){

       boolean f = userService.deletUser(userId);
       if(f){
           return ResultVo.success();
        }else return ResultVo.error();

    }

    @RequestMapping(value = "addUser",method=RequestMethod.POST)
    public Object addUser(User user){


       if(user.getUserAccount()==null) {
           return false;
       }else {
         boolean f=  userService.addUser(user);
           if(f) {
               return ResultVo.success();
           }else return ResultVo.error("失败");

       }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public Object deleUsers(String ids){
        boolean f = userService.deletUsers(ids);

        if(f){
            return ResultVo.success();
        }else return  ResultVo.error();

    }
@RequestMapping(value = "/user/{userId}" , method = RequestMethod.GET)
  public Object getUser(@PathVariable("userId") String userId){
        User user= userService.getUser(userId);
        if(user!=null){
            return user;
        }else return ResultVo.error();
            }

        @RequestMapping(value = "/update" ,method = RequestMethod.POST)
        public  Object update(User00 user00){
        boolean f=userService.update(user00);
        if(f){
            return ResultVo.success();
        }else return ResultVo.error();
        }

        @RequestMapping(value = "changePwd", method = RequestMethod.POST)
        public Object changePwd(String oldp ,String newp){

        return false;
        }

        @RequestMapping(value = "/pageUser",method = RequestMethod.POST)
        public Object pageUser(String userAccount,
                               @RequestParam(defaultValue = "2") int currentPage,
                                @RequestParam(defaultValue = "2") int pageSize )
                              {

       PageBean <User> pb= userService.pageUser(userAccount,currentPage,pageSize);

        return pb;
        }


        @RequestMapping(value = "/updatehead", method=RequestMethod.POST)
       public Object updateHead(@RequestParam MultipartFile file,long userId, HttpServletRequest request) throws IOException {
            String dir = request.getServletContext().getRealPath("/static/images");
            File fileDir = new File(dir);
            if(!fileDir.isDirectory()){
                fileDir.delete();
                fileDir.mkdirs();
            }
            if(file.isEmpty()){
                return false;
            }

            String fileName = UUIDUtils.getUUID()+".png";

            file.transferTo(new File(dir+"/"+fileName));

            boolean f= userService.updateHead(userId,"http://localhost:80/static/images"+fileName);
            return f?"seccse":"false";
        }

































//        @RequestMapping(value = "headImage",method = RequestMethod.GET)
//        public Object upload(@RequestParam MultipartFile file,long userId,HttpServletRequest request) throws IOException {
//
//            String dir = request.getServletContext().getRealPath("/static/headimages");
//            File fileDir = new File(dir);
//            if(!fileDir.isDirectory()){
//                fileDir.delete();
//                fileDir.mkdirs();
//
//            }
//            if(!file.isEmpty()){
//                return "上传失败";
//            }
//
//           String fileName = UUIDUtils.getUUID()+".png";
//            file.transferTo(new File(dir+"/"+fileName));
//
//            Boolean  f= userService.updateHead(userId,"http://localhost:80/static/headimages"+fileName);
//            return f?"上传成功":"上传失败" ;
//
//        }


}
