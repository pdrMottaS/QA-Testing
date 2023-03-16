drop table if exists Usuario;

create table Usuario (
  usr_id bigint not null auto_increment,
  usr_nome varchar(20) not null,
  usr_senha varchar(100) not null,
  primary key (usr_id),
  unique (usr_nome)
);