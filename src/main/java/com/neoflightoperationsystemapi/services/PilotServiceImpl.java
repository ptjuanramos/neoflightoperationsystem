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

import com.neoflightoperationsystemapi.entities.PilotInfoEntity;
import com.neoflightoperationsystemapi.entities.UserEntity;
import com.neoflightoperationsystemapi.models.ServiceResult;
import com.neoflightoperationsystemapi.repositories.interfaces.PilotInfoRepository;
import com.neoflightoperationsystemapi.repositories.interfaces.UserRepository;
import com.neoflightoperationsystemapi.services.interfaces.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class PilotServiceImpl implements PilotService {

    @Autowired
    private PilotInfoRepository pilotInfoRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ServiceResult<PilotInfoEntity> getPilotInfoByUserOrPilotId(UUID userOrPilotId) {
        Optional<UserEntity> possibleFoundUser = userRepository.findById(userOrPilotId);
        ServiceResult<PilotInfoEntity> serviceResult = new ServiceResult<>();
        Optional<PilotInfoEntity> possibleFoundPilotFound;

        if(possibleFoundUser.isPresent()) {
            possibleFoundPilotFound = pilotInfoRepository.getPilotInfoByUser(possibleFoundUser.get());
            if(possibleFoundPilotFound.isPresent()) {
                serviceResult.setOk(true);
                serviceResult.setData(possibleFoundPilotFound.get());
                return serviceResult;
            }
        }

        possibleFoundPilotFound = pilotInfoRepository.findById(userOrPilotId);
        if(!possibleFoundPilotFound.isPresent()) {
            serviceResult.setOk(false);
            return serviceResult;
        }

        serviceResult.setOk(true);
        serviceResult.setData(possibleFoundPilotFound.get());
        return serviceResult;
    }

    @Override
    public ServiceResult<PilotInfoEntity> createPilotInfoWithExistentUser(UUID userId, PilotInfoEntity newPilotInfo) {
        Optional<UserEntity> possibleFoundUser = userRepository.findById(userId);
        ServiceResult<PilotInfoEntity> serviceResult = new ServiceResult<>();
        if(!possibleFoundUser.isPresent()) {
            serviceResult.setOk(false);
            return serviceResult;
        }

        newPilotInfo.setUser(possibleFoundUser.get());
        PilotInfoEntity newSavedPilotInfo = pilotInfoRepository.save(newPilotInfo);
        if(newSavedPilotInfo == null) {
            serviceResult.setOk(false);
            return serviceResult;
        }

        serviceResult.setOk(true);
        serviceResult.setData(newSavedPilotInfo);
        return serviceResult;
    }

    @Override
    public ServiceResult<PilotInfoEntity> createPilotInfo(PilotInfoEntity newPilotInfo) {
        return null;
    }

}
