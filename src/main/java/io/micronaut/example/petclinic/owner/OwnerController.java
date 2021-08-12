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
import io.micronaut.transaction.TransactionDefinition.Propagation;
import io.micronaut.transaction.annotation.TransactionalAdvice;
import io.micronaut.validation.Validated;
import io.swagger.v3.oas.annotations.Operation;
import java.util.List;
import javax.transaction.Transactional;
import javax.validation.Valid;

@Validated
@Controller("/api/owners")
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
    @TransactionalAdvice(readOnly = true, propagation = Propagation.REQUIRES_NEW)
    public OwnerDTO findOne(Integer id) {
        return ownerRepository.findOne(id);
    }

    @Post
    @Operation(operationId = "createOwner", summary = "Create an owner")
    @TransactionalAdvice
    public Owners create(@Valid @Body OwnerRequest request) {
        var owner = request.toEntity();
        ownerRepository.insert(owner);
        return owner;
    }

    @Put("/{id}")
    @Operation(operationId = "updateOwner", summary = "Update an owner")
    @TransactionalAdvice
    public Owners update(Integer id, @Valid @Body OwnerRequest request) {
        var owner = request.toEntity(id);
        ownerRepository.update(owner);
        return owner;
    }

    @Post("/{id}/pets")
    @Operation(operationId = "createPet", summary = "Create a pet")
    @TransactionalAdvice
    public Pets createPet(Integer id, @Valid @Body PetRequest request) {
        var pet = request.toEntity(id);
        petRepository.insert(pet);
        return pet;
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
        visitRepository.insert(visit);
        return visit;
    }

}
