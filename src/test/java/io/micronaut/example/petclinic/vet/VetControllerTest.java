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

import static org.assertj.core.api.Assertions.assertThat;

import io.micronaut.core.annotation.Nullable;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.QueryValue;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import java.util.List;
import javax.inject.Inject;
import org.junit.jupiter.api.Test;

@MicronautTest
public class VetControllerTest {

    @Inject
    VetClient client;

    @Inject
    VetRepository repository;

    @Test
    void testFindAll() {
        var response = client.findAll( null, null);
        assertThat(response).hasSize((int) repository.count());
    }

    @Test
    void testFindByLastName() {
        var response = client.findAll("c", null);
        var expected = (int) repository.findAll().stream()
            .filter(x -> x.getLastName().toLowerCase().startsWith("c")).count();
        assertThat(response).hasSize(expected);
    }

    @Test
    void testFindBySpecialityId() {
        var response = client.findAll(null, 2);
        assertThat(response.stream().allMatch(x -> x.specialities().stream().anyMatch(y -> y.id().equals(2)))).isTrue();
    }

    @Client("/api/vets")
    interface VetClient {

        @Get
        List<VetDTO> findAll(@Nullable @QueryValue String lastName, @Nullable @QueryValue Integer specialityId);
    }

}
