drop table if exists Anotacao;
drop table if exists Usuario;

create table usuario (
  usr_id bigint not null auto_increment,
  usr_nome varchar(20) not null,
  usr_senha varchar(100) not null,
  primary key (usr_id),
  unique (usr_nome)
);

create table anotacao (
  ant_id bigint not null auto_increment,
  ant_text varchar(20) not null,
  usr_id bigint not null,
  primary key (ant_id),
  foreign key (usr_id) references Usuario(usr_id)
);