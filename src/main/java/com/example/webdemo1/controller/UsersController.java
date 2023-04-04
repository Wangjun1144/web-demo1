package com.example.webdemo1.controller;

import com.example.webdemo1.entity.Users;
import com.example.webdemo1.mapper.UsersMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "UsersController", description = "利用HTTP状态码表示操作结果状态的控制器")
@RestController
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private UsersMapper usersMapper;

    @Operation(summary = "获取userslist", description = "返回值为全部的userslist")
    @GetMapping(path = "/", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public List<Users> findall(){
        return usersMapper.findall();
    }

    @Operation(summary = "根据id获取相应的users", description = "如果不存在，返回状态码为404")
    @GetMapping(path = "/{id}", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Users getUser(@PathVariable Long id){
        return usersMapper.getUserById(id);
    }

    @Operation(summary = "根据name获取相应的users", description = "如果不存在，返回状态码为404")
    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<Users> getUserList(@RequestParam(name = "name", required = false) String name) {
        return usersMapper.getUserList(name);
    }

    @Operation(summary = "添加新的users", description = "创建成功，返回状态码201")
    @PostMapping(path="", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Users addUser(@RequestBody Users users){
        usersMapper.addUsers(users);
        return users;
    }


    @Operation(summary = "根据id删除users")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable Long id){
        usersMapper.deleteUserById(id);
    }

    @Operation(summary = "更新users", description = "如果不存在，则返回状态码404")
    @PutMapping(path="/{id}", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Users updateUser(@PathVariable Long id,@RequestBody Users users){
        users.setId(id);
        usersMapper.updateUser(users);
        return users;
    }
}
