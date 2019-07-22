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

package com.neoflightoperationsystem.services;

import com.neoflightoperationsystem.models.ServiceResult;
import com.neoflightoperationsystem.models.User;
import com.neoflightoperationsystem.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    public ServiceResult<User> addNewUser(User user) {
        User newUser = userRepository.save(user);
        ServiceResult<User> userCreationResult = new ServiceResult<User>();
        userCreationResult.setId(UUID.randomUUID());
        userCreationResult.setData(newUser);
        userCreationResult.setOk(true);

        return userCreationResult;
    }

    public ServiceResult<String> removeUserById(String userId) {
        UUID userIdUUID = UUID.fromString(userId);
        userRepository.deleteById(userIdUUID);
        ServiceResult<String> serviceResult = new ServiceResult<String>();
        serviceResult.setId(UUID.randomUUID());
        serviceResult.setOk(true);
        serviceResult.setData("User deleted");

        return serviceResult;
    }

    public ServiceResult<User> getUserById(String userId) {
        UUID userIdUUID = UUID.fromString(userId);
        ServiceResult<User> serviceResult = new ServiceResult<User>();
        serviceResult.setId(UUID.randomUUID());
        serviceResult.setOk(true);
        serviceResult.setData(userRepository.findById(userIdUUID).get()); //TODO change this

        return serviceResult;
    }


}
