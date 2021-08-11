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

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;

public record VetDTO(@Schema(description = "The id of the vet") Integer id,
                     @Schema(description = "The first name of the vet") String firstName,
                     @Schema(description = "The last name of the vet") String lastName,
                     @Schema(description = "Specialities of the vet") List<SpecialityDTO> specialities) {

    @Schema(name = "SpecialityDTO", description = "Speciality information of the vet.")
    public record SpecialityDTO(@Schema(description = "The id of the speciality") Integer id,
                                @Schema(description = "The name of the speciality") String name) {

    }

}
