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

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;
import java.util.List;

public record OwnerDTO(@Schema(description = "The id of the owner") Integer id,
                       @Schema(description = "The first name of the owner") String firstName,
                       @Schema(description = "The last name of the owner") String lastName,
                       @Schema(description = "The address of the owner") String address,
                       @Schema(description = "The city name of the owner") String city,
                       @Schema(description = "The telephone no of the owner") String telephone,
                       @Schema(description = "The list of pets of the owner") List<PetDTO> pets) {

    @Schema(name = "PetDTO", description = "Pet information of the owner.")
    public static record PetDTO(@Schema(description = "The id of the pet") Integer id,
                                @Schema(description = "The name of the pet") String name,
                                @Schema(description = "The birthday of the pet") LocalDate birthDate,
                                @Schema(description = "The type id of the pet") Integer typeId,
                                @Schema(description = "The type name of the pet") String typeName) {

    }

}
