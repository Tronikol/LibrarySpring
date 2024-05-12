CREATE TABLE reader(
    id int generated by default as identity primary key,
    full_name varchar(100) NOT NULL UNIQUE,
    birth_year int not null check ( birth_year>1900 )
);
CREATE TABLE book(
    id int generated by default as identity primary key,
    title varchar(100) not null,
    author varchar(100) not null,
    year int not null,
    person_id int REFERENCES reader(id) on DELETE set null
)
