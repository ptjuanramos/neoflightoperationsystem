/*
 * MIT License
 *
 * Copyright (c) 2019 Juan Ramos
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.neoflightoperationsystem.controllers;

import com.neoflightoperationsystem.models.ServiceResult;
import com.neoflightoperationsystem.models.User;
import com.neoflightoperationsystem.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController implements BaseCrudControllerInterface<User, ServiceResult<User>> {

    @Autowired
    private UserService userService;

    @PostMapping("/user/create")
    public ServiceResult<User> create(User newUser) {
        return userService.addNewUser(newUser);
    }

    @GetMapping("/user/{userId}")
    public ServiceResult<User> get(@PathVariable String userId) {
        return userService.getUserById(userId);
    }

    @PostMapping("/user/delete/{userId}")
    public ServiceResult delete(@PathVariable String userId) {
        return userService.removeUserById(userId);
    }

    @PostMapping("/user/update")
    public ServiceResult<User> update(@RequestBody User newUserData) {
        return null;
    }
}
