create database pokemon;
use pokemon;
create table pokemon_type(poke_name text, poke_type text);

insert into pokemon_type values("bulbasaur", "grass");
insert into pokemon_type values("charmander", "fire");
insert into pokemon_type values("squirtle", "water");
insert into pokemon_type values("eevee", "normal");
insert into pokemon_type values("pidgey", "normal");
insert into pokemon_type values("pidgey", "flying");

create table learning_ability(poke_name text, learn text);

insert into learning_ability values("bulbasaur", "tackle");
insert into learning_ability values("bulbasaur", "vine whip");
insert into learning_ability values("bulbasaur", "return");

insert into learning_ability values("charmander", "tackle");
insert into learning_ability values("charmander", "ember");
insert into learning_ability values("charmander", "return");

insert into learning_ability values("squirtle", "tackle");
insert into learning_ability values("squirtle", "water gun");
insert into learning_ability values("squirtle", "return");

insert into learning_ability values("eevee", "tackle");
insert into learning_ability values("eevee", "headbutt");
insert into learning_ability values("eevee", "return");

insert into learning_ability values("pidgey", "tackle");
insert into learning_ability values("pidgey", "wing attack");
insert into learning_ability values("pidgey", "return");

create table skills(learn text, powers int, skill_type text);

insert into skills values("tackle", 35, "normal");
insert into skills values("water gun",40,"water");
insert into skills values("ember",40,"fire");
insert into skills values("vine whip",40,"grass");
insert into skills values("wing attack",65,"flying");
insert into skills values("headbutt",70,"normal");
insert into skills values("return",100,"normal");

create table powers(powerful text, against text);

insert into powers values("fire", "grass");
insert into powers values("grass", "water");
insert into powers values("water", "fire");
insert into powers values("normal", "none");
insert into powers values("flying", "grass");

create table weak(weak text, against text);

insert into weak values("fire","water");
insert into weak values("grass","fire");
insert into weak values("grass","flying");
insert into weak values("water","grass");
insert into weak values("normal","none");
insert into weak values("flying","none");

//Write an SQL query that returns all the pokemon who can learn ‘Return’.

select 
	poke_name as "Pokemon", learn as "Can Learn" 
	from learning_ability where learn = "return";

//Write an SQL query that returns all the moves in the game that are powerful against Grass.

select 
	powerful as "powerfull moves", against 
	from powers where against = "grass";

select 
poke_name, poke_type ,learn, powers from pokemon_type, skills 
where skills.skill_type  = pokemon_type.poke_type ;