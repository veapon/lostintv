create table device
(
    id integer primary key autoincrement,
    type text not null,
    host text,
    port integer,
    user text,
    password text,
    alias text,
    created_at datetime,
    updated_at datetime,
    deleted_at datetime
);

create table folder
(
    id integer primary key autoincrement,
    device_id integer not null,
    type text not null,
    path text not null,
    mount_point text not null,
    created_at datetime,
    updated_at datetime,
    deleted_at datetime
);

create table file
(
    id integer primary key autoincrement,
    device_id integer not null,
    folder_id integer not null,
    name text not null,
    path text not null,
    extension text not null,
    size text,
    bitrate text,
    last_scan_time datetime,
    created_at datetime,
    updated_at datetime,
    deleted_at datetime
);

create table system_file
(
    id integer primary key autoincrement,
    origin_name text not null,
    path text not null,
    size text,
    created_at datetime,
    updated_at datetime,
    deleted_at datetime
);

create table artist
(
    id integer primary key autoincrement,
    name text not null,
    type text,
    region text,
    poster integer,
    created_at datetime,
    updated_at datetime,
    deleted_at datetime
);

create table album
(
    id integer primary key autoincrement,
    name text not null,
    artist_id integer not null,
    release_date date,
    poster integer,
    genres text,
    music_brainz_id text,
    douban_id text,
    created_at datetime,
    updated_at datetime,
    deleted_at datetime
);

create table track
(
    id integer primary key autoincrement,
    file_id integer not null,
    disc_no integer not null,
    title integer not null,
    artist_id integer not null,
    artist text not null,
    album_id integer not null,
    album text not null,
    duration integer,
    created_at datetime,
    updated_at datetime,
    deleted_at datetime
);
