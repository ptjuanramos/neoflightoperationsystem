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
import com.neoflightoperationsystem.repositories.interfaces.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserService {

    @Autowired
    UserRepository userRepository;

    /**
     *
     * @param user
     * @return
     */
    public ServiceResult<User> addNewUser(User user) {
        User newUser = userRepository.save(user);
        ServiceResult<User> userCreationResult = new ServiceResult<User>();
        userCreationResult.setId(UUID.randomUUID());
        userCreationResult.setData(newUser);
        userCreationResult.setOk(true);

        return userCreationResult;
    }

    /**
     *
     * @param email
     * @return
     */
    public ServiceResult<User> getUserByEmail(String email) {
        Optional<User> possibleFoundUser = userRepository.findUserByEmail(email);
        ServiceResult<User> serviceResult = new ServiceResult<User>();
        if(!possibleFoundUser.isPresent()) {
            serviceResult.setOk(false);
            return serviceResult;
        }

        serviceResult.setOk(true);
        serviceResult.setData(possibleFoundUser.get());
        return serviceResult;
    }

    /**
     *
     * @param userId
     * @return
     */
    public ServiceResult<String> removeUserById(String userId) {
        UUID userIdUUID = UUID.fromString(userId);
        Optional<User> possibleFoundUser = userRepository.findById(userIdUUID);
        ServiceResult<String> serviceResult = new ServiceResult<String>();
        if(!possibleFoundUser.isPresent()) {
            serviceResult.setOk(false);
            serviceResult.setData("User not found");
            return serviceResult;
        }

        userRepository.deleteById(userIdUUID);
        serviceResult.setOk(true);
        serviceResult.setData("User deleted");

        return serviceResult;
    }

    /**
     *
     * @param userId
     * @return
     */
    public ServiceResult<User> getUserById(String userId) {
        UUID userIdUUID = UUID.fromString(userId);
        ServiceResult<User> serviceResult = new ServiceResult<User>();
        Optional<User> possibleFoundUser = userRepository.findById(userIdUUID);

        if(possibleFoundUser.isPresent() && !StringUtils.isEmpty(possibleFoundUser.get().getFirstName())) {
            serviceResult.setOk(true);
            serviceResult.setData(possibleFoundUser.get());
        } else {
            serviceResult.setOk(false);
        }

        return serviceResult;
    }
}
