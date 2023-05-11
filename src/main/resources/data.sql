create table campaign
(
    id                bigint       not null,
    campaign_category varchar(255) not null,
    campaign_state    varchar(255) not null,
    description       varchar(200) not null,
    name              varchar(50)  not null,
    primary key (id)
);

insert into campaign (id, name, description, campaign_category, campaign_state)
values (1001, '1-campaign_name', '1 - campaign descripition lorem ipsum', 'TSS', 'ACTIVE');

insert into campaign (id, name, description, campaign_category, campaign_state)
values (1002, '2-campaign_name', '2 - campaign descripition lorem ipsum', 'TSS', 'PENDING');

insert into campaign (id, name, description, campaign_category, campaign_state)
values (1003, '3-campaign_name', '3 - campaign descripition lorem ipsum', 'OSS', 'ACTIVE');

insert into campaign (id, name, description, campaign_category, campaign_state)
values (1004, '4-campaign_name', '4 - campaign descripition lorem ipsum', 'OSS', 'PENDING');

insert into campaign (id, name, description, campaign_category, campaign_state)
values (1005, '5-campaign_name', '5 - campaign descripition lorem ipsum', 'OTHER', 'NOT_ACTIVE');
