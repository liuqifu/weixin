/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2016/2/27 11:11:36                           */
/*==============================================================*/


drop table if exists tb_diary;

drop table if exists tb_user;

/*==============================================================*/
/* Table: tb_diary                                              */
/*==============================================================*/
create table tb_diary
(
   id                   int(10) not null,
   title                varchar(60),
   path                 varchar(50),
   userid               int(10),
   status               smallint,
   deleted              smallint,
   lastModifyTime       timestamp,
   createTime           timestamp,
   primary key (id)
);

/*==============================================================*/
/* Table: tb_user                                               */
/*==============================================================*/
create table tb_user
(
   id                   int(10) not null,
   username             varchar(50),
   pwd                  varchar(50),
   email                varchar(100),
   question             varchar(45),
   answer               varchar(45),
   city                 varchar(30),
   deleted              smallint,
   primary key (id)
);

alter table tb_diary add constraint FK_Reference_1 foreign key (userid)
      references tb_user (id) on delete restrict on update restrict;

