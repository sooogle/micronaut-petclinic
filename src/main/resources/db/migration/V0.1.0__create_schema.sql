drop table if exists vet_specialties cascade;
drop table if exists vets cascade;
drop table if exists specialties cascade;
drop table if exists visits cascade;
drop table if exists pets cascade;
drop table if exists types cascade;
drop table if exists owners cascade;

create table vets
(
    id         serial primary key,
    first_name varchar(30) not null,
    last_name  varchar(30) not null,
    created_at timestamp not null default current_date,
    updated_at timestamp not null default current_date
);
create index vets_last_name on vets (last_name);

create table specialties
(
    id         serial primary key,
    name       varchar(80) not null,
    created_at timestamp not null default current_date,
    updated_at timestamp not null default current_date
);
create index specialties_name on specialties (name);

create table vet_specialties
(
    vet_id       integer     not null,
    specialty_id integer     not null,
    created_at   timestamp not null default current_date,
    updated_at   timestamp not null default current_date
);
alter table vet_specialties
    add constraint fk_vet_specialties_vets foreign key (vet_id) references vets (id);
alter table vet_specialties
    add constraint fk_vet_specialties_specialties foreign key (specialty_id) references specialties (id);

create table types
(
    id         serial primary key,
    name       varchar(80) not null,
    created_at timestamp not null default current_date,
    updated_at timestamp not null default current_date
);
create index types_name on types (name);

create table owners
(
    id         serial primary key,
    first_name varchar(30)  not null,
    last_name  varchar(30)  not null,
    address    varchar(255) not null,
    city       varchar(80)  not null,
    telephone  varchar(20)  not null,
    created_at timestamp  not null default current_date,
    updated_at timestamp  not null default current_date
);
create index owners_last_name on owners (last_name);

create table pets
(
    id         serial primary key,
    name       varchar(30) not null,
    birth_date date        not null,
    type_id    integer     not null,
    owner_id   integer     not null,
    created_at timestamp not null default current_date,
    updated_at timestamp not null default current_date
);
alter table pets
    add constraint fk_pets_owners foreign key (owner_id) references owners (id);
alter table pets
    add constraint fk_pets_types foreign key (type_id) references types (id);
create index pets_name on pets (name);

create table visits
(
    id          serial primary key,
    pet_id      integer     not null,
    visit_date  date        not null,
    description varchar(255),
    created_at  timestamp not null default current_date,
    updated_at  timestamp not null default current_date
);
alter table visits
    add constraint fk_visits_pets foreign key (pet_id) references pets (id);
create index visits_pet_id on visits (pet_id);
