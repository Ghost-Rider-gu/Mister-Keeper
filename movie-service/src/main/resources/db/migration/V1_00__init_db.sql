DROP TABLE IF EXISTS Movie;
CREATE TABLE Movie
(
    id bigint NOT NULL,
    title character varying(50) NOT NULL,
    summary character varying(300) default '',
    "pathToPoster" character varying(80) default '',
    "imdbRating" character varying(5) default '',
    "releaseYear" smallint,
    duration character varying(10) default '',
    "trailerLink" character varying(100) default '',
    CONSTRAINT movie_primary_key PRIMARY KEY (id),
    CONSTRAINT movie_title_unique UNIQUE (title)
);

DROP TABLE IF EXISTS Genre;
CREATE TABLE Genre
(
    id bigint NOT NULL,
    name character varying(100) default NOT NULL,
    CONSTRAINT genre_primary_key PRIMARY KEY (id),
    CONSTRAINT genre_name_unique UNIQUE (name)
)
