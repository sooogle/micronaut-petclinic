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

import static org.assertj.core.api.Assertions.assertThat;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.example.petclinic.tables.pojos.Owners;
import io.micronaut.example.petclinic.tables.pojos.Pets;
import io.micronaut.example.petclinic.tables.pojos.Visits;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

@MicronautTest
public class OwnerControllerTest {

    @Inject
    OwnerClient client;

    @Inject
    OwnerRepository ownerRepository;

    @Inject
    VisitRepository visitRepository;

    @Test
    void testFindAll() {
        var response = client.findAll(null);
        assertThat(response).hasSize((int) ownerRepository.count());
    }

    @Test
    void testFindByLastName() {
        var response = client.findAll("d");
        var expected = (int) ownerRepository.findAll().stream()
            .filter(x -> x.getLastName().toLowerCase().startsWith("d")).count();
        assertThat(response).hasSize(expected);
    }

    @Test
    void testFindOne() {
        var response = client.findOne(1);
        assertThat(response).isNotNull();
    }

    @Test
    void testCreateAndUpdate() {
        var createRequest = new OwnerRequest("Bill", "Jobs", "111 W. Liberty St.", "Madison", "0123456789");
        var createResponse = client.create(createRequest);
        assertThat(createResponse.getId()).isNotNull();
        var updateRequest = new OwnerRequest("Mark", "Jobs", "111 W. Liberty St.", "Madison", "0123456789");
        var updateResponse = client.update(createResponse.getId(), updateRequest);
        assertThat(updateResponse.getFirstName()).isEqualTo("Mark");
    }

    @Test
    void testCreateAndUpdatePets() {
        var createRequest = new PetRequest("Candy", LocalDate.now().minusYears(2), 2);
        var createResponse = client.createPet(1, createRequest);
        assertThat(createResponse.getId()).isNotNull();
        var updateRequest = new PetRequest("Melody", LocalDate.now().minusYears(2), 2);
        var updateResponse = client.updatePet(1, createResponse.getId(), updateRequest);
        assertThat(updateResponse.getName()).isEqualTo("Melody");
    }

    @Test
    void testCreateVisit() {
        var request = new VisitRequest(LocalDate.now().plusWeeks(1), "rabies shot");
        var response = client.createVisit(1, 1, request);
        var visits = visitRepository.findAll().stream()
            .filter(x -> x.getPetId().equals(1)).collect(Collectors.toList());
        assertThat(response).isNotNull();
        assertThat(visits).hasSize(1);
    }

    @Client("/api/owners")
    interface OwnerClient {

        @Get
        List<OwnerDTO> findAll(@Nullable @QueryValue String lastName);

        @Get("/{id}")
        OwnerDTO findOne(Integer id);

        @Post
        Owners create(@Body OwnerRequest request);

        @Put("/{id}")
        Owners update(Integer id, @Body OwnerRequest request);

        @Post("/{id}/pets")
        Pets createPet(Integer id, @Body PetRequest request);

        @Put("/{id}/pets/{petId}")
        Pets updatePet(Integer id, Integer petId, @Body PetRequest request);

        @Post("/{id}/pets/{petId}/visits")
        Visits createVisit(Integer id, Integer petId, @Body VisitRequest request);

    }

}
