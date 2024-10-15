create table if not exists groups
(
    id               bigserial,
    name             varchar(255),
    description      text,
    path             ltree              not null,
    status           smallint default 1 not null,
    created_by       bigint             null,
    created_at       timestamp          null,
    last_modified_by bigint             null,
    last_modified_at timestamp          null,
    constraint groups_pk
        primary key (id)
);

create index if not exists groups_name_index
    on groups (name);

create index if not exists groups_status_index
    on groups (status);

create table if not exists users
(
    id                 bigserial,
    group_id           bigint                  not null,
    username           varchar(100)            not null,
    preferred_username varchar(64)             not null,
    email              varchar(255)            not null,
    email_verified     boolean   default false not null,
    password           varchar(255)            not null,
    name               varchar(255)            not null,
    unsigned_name      varchar(255)            not null,
    sex                smallint  default 0     not null,
    birthdate          timestamp,
    language           smallint  default 0,
    locked             boolean   default false not null,
    expired_date       timestamp default now() not null,
    status             smallint  default 1     not null,
    created_by         bigint                  null,
    created_at         timestamp               null,
    last_modified_by   bigint                  null,
    last_modified_at   timestamp               null,
    constraint users_pk
        primary key (id),
    constraint users_unique_username
        unique (username),
    constraint users_unique_preferred_username
        unique (preferred_username),
    constraint users_unique_email
        unique (email),
    constraint users_groups_id_fk
        foreign key (group_id) references groups
);

create index if not exists users_status_index
    on users (status);

create index if not exists users_unsigned_name_index
    on users (unsigned_name);

create table if not exists permissions
(
    id     serial,
    code   varchar(10),
    name   varchar(255),
    status integer default 1 not null,
    constraint permissions_pk
        primary key (id)
);

comment on table permissions is 'Auto generated data, do not insert new data';

create table if not exists group_roles
(
    group_id      bigint  not null,
    permission_id integer not null,
    constraint group_roles_pk
        primary key (group_id, permission_id),
    constraint group_roles_groups_id_fk
        foreign key (group_id) references groups,
    constraint group_roles_permissions_id_fk
        foreign key (permission_id) references permissions
);

create table if not exists user_roles
(
    user_id       bigint  not null,
    permission_id integer not null,
    constraint user_roles_pk
        primary key (permission_id, user_id),
    constraint user_roles_permissions_id_fk
        foreign key (permission_id) references permissions,
    constraint user_roles_users_id_fk
        foreign key (user_id) references users
);

ALTER SEQUENCE users_id_seq RESTART WITH 1000;
ALTER SEQUENCE groups_id_seq RESTART WITH 1000;
