insert into user_details(id, birth_date, name)
values ( 10001, current_date(), 'Ranga');

insert into user_details(id, birth_date, name)
values ( 10002, current_date(), 'Ravi');

insert into user_details(id, birth_date, name)
values ( 10003, current_date(), 'Sam');

insert into post(id, description, user_id)
values (20001, 'I want to learn AWS', 10001);

insert into post(id, description, user_id)
values (20002, 'I want to Get AWS Certified', 10002);

insert into post(id, description, user_id)
values (20003, 'I want to learn Google Cloud', 10002);