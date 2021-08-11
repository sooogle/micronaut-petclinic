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

import io.micronaut.core.annotation.Introspected;
import io.micronaut.example.petclinic.tables.pojos.Pets;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

@Introspected
public record PetRequest(@NotNull @Size(max = 30) @Schema(description = "The name of the pet") String name,
                         @NotNull @Past @Schema(description = "The birthday of the pet") LocalDate birthDate,
                         @NotNull @Min(1) @Schema(description = "The type id of the pet") Integer typeId) {

    public Pets toEntity(Integer ownerId) {
        return toEntity(null, ownerId);
    }

    public Pets toEntity(Integer petId, Integer ownerId) {
        return new Pets(petId, name, birthDate, typeId, ownerId);
    }

}
