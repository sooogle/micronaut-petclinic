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

import static io.micronaut.example.petclinic.Tables.PETS;

import io.micronaut.example.petclinic.core.AbstractJooqRepository;
import io.micronaut.example.petclinic.tables.pojos.Pets;
import io.micronaut.example.petclinic.tables.records.PetsRecord;
import jakarta.inject.Singleton;
import org.jooq.Configuration;

@Singleton
public class PetRepositoryImpl extends AbstractJooqRepository<PetsRecord, Pets, Integer> implements PetRepository {

    protected PetRepositoryImpl(Configuration configuration) {
        super(PETS, Pets.class, configuration);
    }

    @Override
    public Integer getId(Pets object) {
        return object.getId();
    }

}
