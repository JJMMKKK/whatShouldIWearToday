create table gptAnswervo(
    id serial primary key,
    username varchar(50) not null,
    question VARCHAR(50000) not null,
    answer VARCHAR(50000) not null
)