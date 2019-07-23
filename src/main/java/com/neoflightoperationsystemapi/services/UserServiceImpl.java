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

package com.neoflightoperationsystemapi.services;

import com.neoflightoperationsystemapi.entities.UserEntity;
import com.neoflightoperationsystemapi.models.ServiceResult;
import com.neoflightoperationsystemapi.repositories.interfaces.UserRepository;
import com.neoflightoperationsystemapi.services.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Optional;
import java.util.UUID;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ServiceResult<UserEntity> addNewUser(UserEntity user) {
        UserEntity newUser = userRepository.save(user);
        ServiceResult<UserEntity> userCreationResult = new ServiceResult<>();
        userCreationResult.setId(UUID.randomUUID());
        userCreationResult.setData(newUser);
        userCreationResult.setOk(true);

        return userCreationResult;
    }

    @Override
    public ServiceResult<UserEntity> getUserByEmail(String email) {
        Optional<UserEntity> possibleFoundUser = userRepository.findUserByEmail(email);
        ServiceResult<UserEntity> serviceResult = new ServiceResult<>();
        if(!possibleFoundUser.isPresent()) {
            serviceResult.setOk(false);
            return serviceResult;
        }

        serviceResult.setOk(true);
        serviceResult.setData(possibleFoundUser.get());
        return serviceResult;
    }

    @Override
    public ServiceResult<String> removeUserById(String userId) {
        UUID userIdUUID = UUID.fromString(userId);
        Optional<UserEntity> possibleFoundUser = userRepository.findById(userIdUUID);
        ServiceResult<String> serviceResult = new ServiceResult<>();
        if(!possibleFoundUser.isPresent()) {
            serviceResult.setOk(false);
            serviceResult.setData("UserEntity not found");
            return serviceResult;
        }

        userRepository.deleteById(userIdUUID);
        serviceResult.setOk(true);
        serviceResult.setData("UserEntity deleted");

        return serviceResult;
    }

    @Override
    public ServiceResult<UserEntity> getUserById(String userId) {
        UUID userIdUUID = UUID.fromString(userId);
        ServiceResult<UserEntity> serviceResult = new ServiceResult<>();
        Optional<UserEntity> possibleFoundUser = userRepository.findById(userIdUUID);

        if(possibleFoundUser.isPresent() && !StringUtils.isEmpty(possibleFoundUser.get().getEmail())) {
            serviceResult.setOk(true);
            serviceResult.setData(possibleFoundUser.get());
        } else {
            serviceResult.setOk(false);
        }

        return serviceResult;
    }
}
