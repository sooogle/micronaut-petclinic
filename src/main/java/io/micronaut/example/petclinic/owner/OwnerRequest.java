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
import io.micronaut.example.petclinic.tables.pojos.Owners;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Introspected
record OwnerRequest(@NotEmpty @Size(max = 30) @Schema(name = "The first name of the owner") String firstName,
                    @NotEmpty @Size(max = 30) @Schema(description = "The last name of the owner") String lastName,
                    @NotEmpty @Size(max = 255) @Schema(description = "The address of the owner") String address,
                    @NotEmpty @Size(max = 80) @Schema(description = "The city name of the owner") String city,
                    @NotEmpty @Size(max = 20) @Digits(fraction = 0, integer = 10) @Schema(description = "The telephone no of the owner") String telephone) {

    public Owners toEntity() {
        return toEntity(null);
    }

    public Owners toEntity(Integer id) {
        return new Owners(id, firstName, lastName, address, city, telephone);
    }

}
