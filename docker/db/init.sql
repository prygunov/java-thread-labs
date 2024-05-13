CREATE TABLE IF NOT EXISTS cinemas
(
    cinema_id   SERIAL PRIMARY KEY,
    name        VARCHAR(255) NOT NULL,
    location    VARCHAR(255) NOT NULL,
    total_halls INT          NOT NULL
);

CREATE TABLE IF NOT EXISTS halls
(
    hall_id       SERIAL PRIMARY KEY,
    cinema_id     INT NOT NULL,
    hall_number   INT NOT NULL,
    seat_capacity INT NOT NULL,
    FOREIGN KEY (cinema_id) REFERENCES cinemas (cinema_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS movies
(
    movie_id SERIAL PRIMARY KEY,
    title    VARCHAR(255) NOT NULL,
    duration INT          NOT NULL,
    rating   VARCHAR(50),
    genre    VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS showtimes
(
    showtime_id SERIAL PRIMARY KEY,
    movie_id    INT       NOT NULL,
    hall_id     INT       NOT NULL,
    start_time  TIMESTAMP NOT NULL,
    end_time    TIMESTAMP NOT NULL,
    FOREIGN KEY (movie_id) REFERENCES movies (movie_id) ON DELETE CASCADE,
    FOREIGN KEY (hall_id) REFERENCES halls (hall_id) ON DELETE CASCADE
);

CREATE TABLE IF NOT EXISTS tickets
(
    ticket_id   SERIAL PRIMARY KEY,
    showtime_id INT NOT NULL,
    seat_number INT NOT NULL,
    price       INT NOT NULL,
    FOREIGN KEY (showtime_id) REFERENCES showtimes (showtime_id) ON DELETE CASCADE
);