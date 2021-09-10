/*
 *  Copyright 2021 original authors
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package io.micronaut.example.petclinic.vet;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.transaction.annotation.TransactionalAdvice;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;

@Controller("/api/vets")
@ExecuteOn(TaskExecutors.IO)
public class VetController {

    private final VetRepository repository;

    public VetController(VetRepository repository) {
        this.repository = repository;
    }

    @Get
    @Operation(operationId = "findAllVets", summary = "Find all vets.")
    @TransactionalAdvice(readOnly = true)
    public List<VetDTO> findAll(@Nullable @QueryValue String lastName, @Nullable @QueryValue Integer specialityId) {
        return repository.findAll(lastName, specialityId);
    }

}
