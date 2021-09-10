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
package io.micronaut.example.petclinic.owner;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.example.petclinic.tables.pojos.Owners;
import io.micronaut.example.petclinic.tables.pojos.Pets;
import io.micronaut.example.petclinic.tables.pojos.Visits;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;
import io.micronaut.transaction.annotation.TransactionalAdvice;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import javax.validation.Valid;

@Controller("/api/owners")
@ExecuteOn(TaskExecutors.IO)
class OwnerController {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final VisitRepository visitRepository;

    public OwnerController(OwnerRepository ownerRepository,
        PetRepository petRepository, VisitRepository visitRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.visitRepository = visitRepository;
    }

    @Get
    @Operation(operationId = "findAllOwners", summary = "Find all owners")
    @TransactionalAdvice(readOnly = true)
    public List<OwnerDTO> findAll(@Nullable @QueryValue String lastName) {
        return ownerRepository.findAll(lastName);
    }

    @Get("/{id}")
    @Operation(operationId = "findOneOwner", summary = "Find an owner by his/her id")
    @TransactionalAdvice(readOnly = true)
    public OwnerDTO findOne(Integer id) {
        return ownerRepository.findOne(id);
    }

    @Post
    @Operation(operationId = "createOwner", summary = "Create an owner")
    @TransactionalAdvice
    public Owners create(@Valid @Body OwnerRequest request) {
        var owner = request.toEntity();
        return ownerRepository.save(owner);
    }

    @Put("/{id}")
    @Operation(operationId = "updateOwner", summary = "Update an owner")
    @TransactionalAdvice
    public Owners update(Integer id, @Valid @Body OwnerRequest request) {
        var owner = request.toEntity(id);
        return ownerRepository.update(owner);
    }

    @Post("/{id}/pets")
    @Operation(operationId = "createPet", summary = "Create a pet")
    @TransactionalAdvice
    public Pets createPet(Integer id, @Valid @Body PetRequest request) {
        var pet = request.toEntity(id);
        return petRepository.save(pet);
    }

    @Put("/{id}/pets/{petId}")
    @Operation(operationId = "updatePet", summary = "Update a pet")
    @TransactionalAdvice
    public Pets updatePet(Integer id, Integer petId, @Valid @Body PetRequest request) {
        var pet = request.toEntity(petId, id);
        petRepository.update(pet);
        return pet;
    }

    @SuppressWarnings("unused")
    @Post("/{id}/pets/{petId}/visits")
    @Operation(operationId = "createVisit", summary = "Make a visit reservation")
    @TransactionalAdvice
    public Visits createVisit(Integer id, Integer petId, @Valid @Body VisitRequest request) {
        var visit = request.toEntity(petId);
        return visitRepository.save(visit);
    }

}
