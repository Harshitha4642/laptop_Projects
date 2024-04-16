create database instagram;

use instagram;

create table people_ids(
	id int primary key, 
	id_name text not null
);

insert into people_ids values(1, "rocky");
insert into people_ids values(2, "amar");
insert into people_ids values(3, "tej");
insert into people_ids values(4, "jwala");
insert into people_ids values(5, "sita");
insert into people_ids values(6, "vicky");
insert into people_ids values(7, "swati");
insert into people_ids values(8, "priya");
insert into people_ids values(9, "komali");
insert into people_ids values(10, "jai");
insert into people_ids values(11, "sri");
insert into people_ids values(12, "vijay");

create table posts(
post_id int primary key, 
user_id int not null,
content text not null, 
foreign key(user_id) references people_ids(id)
);

insert into posts values(1,1,"Going to paris, will you join? ");
insert into posts values(2,5,"It's a nice rainy day");
insert into posts values(3,7,"Having pani puri");
insert into posts values(4,10,"Got into a relationship :)");

create table likes (
	post_id int, 
	liked_id int, 
	primary key(post_id, liked_id),
	foreign key(post_id) references posts(post_id),
	foreign key(liked_id) references people_ids(id)
);

insert into likes values(1,2);
insert into likes values(2,3);
insert into likes values(3,3);
insert into likes values(4,3);
insert into likes values(1,1);
insert into likes values(2,4);
insert into likes values(2,5);
insert into likes values(4,9);
insert into likes values(4,10);
insert into likes values(4,12);
insert into likes values(4,6);
insert into likes values(4,11);
insert into likes values(3,9);
insert into likes values(2,12);
insert into likes values(1,7);
insert into likes values(1,10);

create table comments(
	commented_id int not null, 
	post_id int not null, 
	comment text not null, 
	foreign key(commented_id) references people_ids(id), 
	foreign key(post_id) references posts(post_id)
);

insert into comments values(2,1,"get me some chocolates");
insert into comments values(5,2,"you will catch cold for sure");
insert into comments values(2,4,"Mama party");
insert into comments values(7,4,"I want biriyani in marriage");
insert into comments values(10,3,"you cheat, you went to have panipuri without me");
insert into comments values(3,1,"send pics here");

select id_name from people_ids 
	where id in (
		select liked_id from likes 
			where post_id = post_id
	);

select comment from comments where post_id = post_id;

insert into comments values (commented_id, post_id, comment);

insert into likes values(post_id, user_id);