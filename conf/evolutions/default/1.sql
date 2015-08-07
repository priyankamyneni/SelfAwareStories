# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table admin (
  id                        bigserial not null,
  email                     varchar(255),
  user_name                 varchar(255),
  password                  varchar(255),
  salt                      varchar(255),
  constraint uq_admin_email unique (email),
  constraint uq_admin_user_name unique (user_name),
  constraint pk_admin primary key (id))
;

create table answer (
  id                        bigserial not null,
  question_id               bigint,
  option1expl               varchar(255),
  option2expl               varchar(255),
  option3expl               varchar(255),
  option4expl               varchar(255),
  selected_answer           varchar(255),
  correct_answer            varchar(255),
  un_answer                 varchar(255),
  constraint uq_answer_question_id unique (question_id),
  constraint pk_answer primary key (id))
;

create table app_user (
  id                        bigserial not null,
  first_name                varchar(255),
  last_name                 varchar(255),
  photo                     bytea,
  email                     varchar(255),
  user_name                 varchar(255),
  password                  varchar(255),
  salt                      varchar(255),
  constraint uq_app_user_email unique (email),
  constraint uq_app_user_user_name unique (user_name),
  constraint pk_app_user primary key (id))
;

create table badges (
  id                        bigserial not null,
  badge_name                varchar(255),
  number_of_points          integer,
  image                     bytea,
  appuser_id                bigint,
  constraint uq_badges_appuser_id unique (appuser_id),
  constraint pk_badges primary key (id))
;

create table blog (
  id                        bigserial not null,
  app_user_id               bigint not null,
  name                      varchar(255),
  description               TEXT,
  constraint pk_blog primary key (id))
;

create table certificate (
  id                        bigserial not null,
  certificate               bytea,
  app_user_id               bigint,
  constraint uq_certificate_app_user_id unique (app_user_id),
  constraint pk_certificate primary key (id))
;

create table college (
  id                        bigserial not null,
  admin_id                  bigint not null,
  name                      varchar(255),
  address                   varchar(255),
  constraint pk_college primary key (id))
;

create table comment (
  id                        bigserial not null,
  forum_id                  bigint not null,
  comment                   TEXT,
  constraint pk_comment primary key (id))
;

create table feed_back (
  id                        bigserial not null,
  app_user_id               bigint,
  user_name                 varchar(255),
  mail_id                   varchar(255),
  message                   TEXT,
  constraint uq_feed_back_app_user_id unique (app_user_id),
  constraint uq_feed_back_user_name unique (user_name),
  constraint uq_feed_back_mail_id unique (mail_id),
  constraint pk_feed_back primary key (id))
;

create table forum (
  id                        bigserial not null,
  topic                     varchar(255),
  constraint pk_forum primary key (id))
;

create table manage_reading (
  id                        bigserial not null,
  name                      varchar(255),
  file                      bytea,
  description               TEXT,
  constraint pk_manage_reading primary key (id))
;

create table myjournal (
  id                        bigserial not null,
  app_user_id               bigint not null,
  topic_tittle              varchar(255),
  description               TEXT,
  constraint pk_myjournal primary key (id))
;

create table point (
  id                        bigserial not null,
  option                    varchar(9),
  points                    integer,
  constraint ck_point_option check (option in ('CORRECT','PARTIALLY','WRONG')),
  constraint pk_point primary key (id))
;

create table question (
  id                        bigserial not null,
  questionarie_id           bigint not null,
  question                  TEXT,
  option1                   varchar(255),
  option2                   varchar(255),
  option3                   varchar(255),
  option4                   varchar(255),
  correct_answer            varchar(255),
  points                    integer,
  constraint pk_question primary key (id))
;

create table questionarie (
  id                        bigserial not null,
  name                      varchar(255),
  constraint pk_questionarie primary key (id))
;

create table quiz (
  id                        bigserial not null,
  quiz_id                   bigint not null,
  description               varchar(255),
  scenario                  varchar(9),
  constraint ck_quiz_scenario check (scenario in ('SCENARIO1','SCENARIO2')),
  constraint pk_quiz primary key (id))
;

create table quiz_answer (
  id                        bigserial not null,
  option1expl               varchar(255),
  option2expl               varchar(255),
  option3expl               varchar(255),
  selected_answer           varchar(255),
  correct_answer            varchar(255),
  un_answer                 varchar(255),
  constraint pk_quiz_answer primary key (id))
;

create table report (
  id                        bigserial not null,
  app_user_id               bigint not null,
  answer_id                 bigint,
  constraint uq_report_answer_id unique (answer_id),
  constraint pk_report primary key (id))
;

create table social_awareness (
  id                        bigserial not null,
  description               TEXT,
  image                     bytea,
  constraint pk_social_awareness primary key (id))
;

create table theme_teaser (
  id                        bigserial not null,
  title                     varchar(255),
  teaser_vimeo_code         bigint,
  description               TEXT,
  constraint pk_theme_teaser primary key (id))
;

create table user_quiz (
  id                        bigserial not null,
  app_user_id               bigint,
  quiz_id                   bigint,
  constraint uq_user_quiz_app_user_id unique (app_user_id),
  constraint uq_user_quiz_quiz_id unique (quiz_id),
  constraint pk_user_quiz primary key (id))
;

create table user_reading (
  id                        bigserial not null,
  app_user_id               bigint,
  manage_reading_id         bigint,
  constraint uq_user_reading_app_user_id unique (app_user_id),
  constraint uq_user_reading_manage_reading_i unique (manage_reading_id),
  constraint pk_user_reading primary key (id))
;

create table user_theme (
  id                        bigserial not null,
  app_user_id               bigint,
  constraint uq_user_theme_app_user_id unique (app_user_id),
  constraint pk_user_theme primary key (id))
;

create table video (
  id                        bigserial not null,
  name                      varchar(255),
  description               TEXT,
  type_of_video             varchar(16),
  vimeo_code                bigint,
  constraint ck_video_type_of_video check (type_of_video in ('COPINGVIDEO','SITUATIONALVIDEO')),
  constraint pk_video primary key (id))
;

create table video_questionarie (
  id                        bigserial not null,
  video_id                  bigint,
  questionarie_id           bigint,
  constraint uq_video_questionarie_video_id unique (video_id),
  constraint uq_video_questionarie_questionar unique (questionarie_id),
  constraint pk_video_questionarie primary key (id))
;


create table app_user_video (
  app_user_id                    bigint not null,
  video_id                       bigint not null,
  constraint pk_app_user_video primary key (app_user_id, video_id))
;

create table APPUSER_COMMENT (
  COMMENT_ID                     bigint not null,
  APPUSER_ID                     bigint not null,
  constraint pk_APPUSER_COMMENT primary key (COMMENT_ID, APPUSER_ID))
;

create table feed_back_app_user (
  feed_back_id                   bigint not null,
  app_user_id                    bigint not null,
  constraint pk_feed_back_app_user primary key (feed_back_id, app_user_id))
;
alter table answer add constraint fk_answer_question_1 foreign key (question_id) references question (id);
create index ix_answer_question_1 on answer (question_id);
alter table badges add constraint fk_badges_appuser_2 foreign key (appuser_id) references app_user (id);
create index ix_badges_appuser_2 on badges (appuser_id);
alter table blog add constraint fk_blog_app_user_3 foreign key (app_user_id) references app_user (id);
create index ix_blog_app_user_3 on blog (app_user_id);
alter table certificate add constraint fk_certificate_appUser_4 foreign key (app_user_id) references app_user (id);
create index ix_certificate_appUser_4 on certificate (app_user_id);
alter table college add constraint fk_college_admin_5 foreign key (admin_id) references admin (id);
create index ix_college_admin_5 on college (admin_id);
alter table comment add constraint fk_comment_forum_6 foreign key (forum_id) references forum (id);
create index ix_comment_forum_6 on comment (forum_id);
alter table feed_back add constraint fk_feed_back_appUser_7 foreign key (app_user_id) references app_user (id);
create index ix_feed_back_appUser_7 on feed_back (app_user_id);
alter table myjournal add constraint fk_myjournal_app_user_8 foreign key (app_user_id) references app_user (id);
create index ix_myjournal_app_user_8 on myjournal (app_user_id);
alter table question add constraint fk_question_questionarie_9 foreign key (questionarie_id) references questionarie (id);
create index ix_question_questionarie_9 on question (questionarie_id);
alter table quiz add constraint fk_quiz_quiz_10 foreign key (quiz_id) references quiz (id);
create index ix_quiz_quiz_10 on quiz (quiz_id);
alter table report add constraint fk_report_app_user_11 foreign key (app_user_id) references app_user (id);
create index ix_report_app_user_11 on report (app_user_id);
alter table report add constraint fk_report_answer_12 foreign key (answer_id) references answer (id);
create index ix_report_answer_12 on report (answer_id);
alter table user_quiz add constraint fk_user_quiz_appUser_13 foreign key (app_user_id) references app_user (id);
create index ix_user_quiz_appUser_13 on user_quiz (app_user_id);
alter table user_quiz add constraint fk_user_quiz_quiz_14 foreign key (quiz_id) references quiz (id);
create index ix_user_quiz_quiz_14 on user_quiz (quiz_id);
alter table user_reading add constraint fk_user_reading_appUser_15 foreign key (app_user_id) references app_user (id);
create index ix_user_reading_appUser_15 on user_reading (app_user_id);
alter table user_reading add constraint fk_user_reading_manageReading_16 foreign key (manage_reading_id) references manage_reading (id);
create index ix_user_reading_manageReading_16 on user_reading (manage_reading_id);
alter table user_theme add constraint fk_user_theme_appUser_17 foreign key (app_user_id) references app_user (id);
create index ix_user_theme_appUser_17 on user_theme (app_user_id);
alter table video_questionarie add constraint fk_video_questionarie_video_18 foreign key (video_id) references video (id);
create index ix_video_questionarie_video_18 on video_questionarie (video_id);
alter table video_questionarie add constraint fk_video_questionarie_questio_19 foreign key (questionarie_id) references questionarie (id);
create index ix_video_questionarie_questio_19 on video_questionarie (questionarie_id);



alter table app_user_video add constraint fk_app_user_video_app_user_01 foreign key (app_user_id) references app_user (id);

alter table app_user_video add constraint fk_app_user_video_video_02 foreign key (video_id) references video (id);

alter table APPUSER_COMMENT add constraint fk_APPUSER_COMMENT_comment_01 foreign key (COMMENT_ID) references comment (id);

alter table APPUSER_COMMENT add constraint fk_APPUSER_COMMENT_app_user_02 foreign key (APPUSER_ID) references app_user (id);

alter table feed_back_app_user add constraint fk_feed_back_app_user_feed_ba_01 foreign key (feed_back_id) references feed_back (id);

alter table feed_back_app_user add constraint fk_feed_back_app_user_app_use_02 foreign key (app_user_id) references app_user (id);

# --- !Downs

drop table if exists admin cascade;

drop table if exists answer cascade;

drop table if exists app_user cascade;

drop table if exists APPUSER_COMMENT cascade;

drop table if exists app_user_video cascade;

drop table if exists badges cascade;

drop table if exists blog cascade;

drop table if exists certificate cascade;

drop table if exists college cascade;

drop table if exists comment cascade;

drop table if exists feed_back cascade;

drop table if exists feed_back_app_user cascade;

drop table if exists forum cascade;

drop table if exists manage_reading cascade;

drop table if exists myjournal cascade;

drop table if exists point cascade;

drop table if exists question cascade;

drop table if exists questionarie cascade;

drop table if exists quiz cascade;

drop table if exists quiz_answer cascade;

drop table if exists report cascade;

drop table if exists social_awareness cascade;

drop table if exists theme_teaser cascade;

drop table if exists user_quiz cascade;

drop table if exists user_reading cascade;

drop table if exists user_theme cascade;

drop table if exists video cascade;

drop table if exists video_questionarie cascade;

