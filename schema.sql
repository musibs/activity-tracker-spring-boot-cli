create table ACTIVITIES (
    id identity not null,
    activityName varchar(100) not null,
    completed varchar(1) not null,
    activityDate timestamp not null
);