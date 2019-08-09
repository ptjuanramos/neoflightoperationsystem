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

package com.neoflightoperationsystemapi.controllers;

import com.neoflightoperationsystemapi.entities.PilotInfoEntity;
import com.neoflightoperationsystemapi.models.ServiceResult;
import com.neoflightoperationsystemapi.services.interfaces.PilotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class PilotController {

    @Autowired
    private PilotService pilotService;

    @GetMapping("/pilot/{userOrPilotId}")
    public ServiceResult<PilotInfoEntity> getPilotInfoByUserOrPilotId(@PathVariable UUID userOrPilotId) {
        return pilotService.getPilotInfoByUserOrPilotId(userOrPilotId);
    }

    @PostMapping("/pilot/{userId}")
    public ServiceResult<PilotInfoEntity> createPilotInfo(@PathVariable UUID userId, @RequestBody PilotInfoEntity newPilotInfo) {
        return pilotService.createPilotInfoWithExistentUser(userId, newPilotInfo);
    }

    @PostMapping("/pilot/")
    public ServiceResult<PilotInfoEntity> createPilotInfo(@RequestBody PilotInfoEntity newPilotInfo) {
        return pilotService.createPilotInfo(newPilotInfo);
    }

}
