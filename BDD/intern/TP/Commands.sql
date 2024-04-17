---------------------- SELECT VARIANTS --------------------------
SELECT
  *
FROM
  person2
ORDER BY
  country_of_birth;

SELECT
  *
FROM
  person2 firstname,
  email;

SELECT
  *
FROM
  person2 firstname,
  email;

SELECT
  *
FROM
  person2
ORDER BY
  firstname,
  email;

SELECT
  *
FROM
  person2
ORDER BY
  firstname,
  email;

SELECT
  *
FROM
  person2
ORDER BY
  firstname,
  email;

SELECT
  *
FROM
  person2
ORDER BY
  country_of_birth;

SELECT
  *
FROM
  person2
ORDER BY
  first_name;

SELECT
  *
FROM
  person2
ORDER BY
  first_name,
  email;

SELECT DISTINCT
  country_of_birth
FROM
  person2
ORDER BY
  county_of_birth;

SELECT
  *
FROM
  person2
WHERE
  gender = female;

SELECT
  *
FROM
  person2
WHERE
  gender = 'female';

SELECT
  *
FROM
  person2
WHERE
  gender = 'Female';

SELECT
  *
FROM
  person2
WHERE
  gender = 'Male'
  AND country_of_birth = 'Russia';

SELECT
  *
FROM
  person2
WHERE
  gender = 'Male'
  AND country_of_birth = 'Russia'
  OR country_of_birth = 'China';

SELECT
  *
FROM
  person2
WHERE
  gender = 'Male'
  AND country_of_birth = 'Russia'
  OR country_of_birth = 'China'
  AND gender = 'Male';

SELECT
  *
FROM
  person2
WHERE
  gender = 'Male'
  AND (
    country_of_birth = 'Russia'
    OR country_of_birth = 'China'
  );

SELECT
  1 <> 1;

SELECT
  1 <> 2;

SELECT
  'PROF' <> 'prof';

SELECT
  'PROF' = 'prof';

SELECT
  *
FROM
  person2
LIMIT
  10;

SELECT
  *
FROM
  person2
WHERE
  country_of_birth IN ('China', 'Russia', 'Algeria');

SELECT
  *
FROM
  person2
WHERE
  date_of_birth BETWEEN '2021-1-1' AND '2021-12-31';

SELECT
  *
FROM
  person2
WHERE
  date_of_birth BETWEEN '2021-1-1' AND '2021-5-31';

SELECT
  *
FROM
  person2
WHERE
  date_of_birth BETWEEN '2021-1-1' AND '2021-12-31';

SELECT
  *
FROM
  person2
WHERE
  date_of_birth BETWEEN '2021-1-1' AND '2031-12-31';

SELECT
  *
FROM
  person2
WHERE
  date_of_birth BETWEEN '2021-1-1' AND '2022-12-31';

SELECT
  *
FROM
  person2
WHERE
  date_of_birth BETWEEN '2021-1-1' AND '2007-12-31';

SELECT
  *
FROM
  person2
WHERE
  date_of_birth BETWEEN '2007-1-1' AND '2007-12-31';

SELECT
  *
FROM
  person2
WHERE
  date_of_birth BETWEEN '2021-1-1' AND '2021-12-31';

SELECT
  *
FROM
  person2
WHERE
  date_of_birth BETWEEN '2021-1-1' AND '2021-12-31'
ORDER BY
  date_of_birth;

SELECT
  *
FROM
  person2
WHERE
  email LIKE '%.com';

SELECT
  *
FROM
  person2
WHERE
  email LIKE '%';

SELECT
  *
FROM
  person2
WHERE
  email LIKE 'a%';

SELECT
  *
FROM
  person2
WHERE
  email LIKE '%@google.%';

SELECT
  *
FROM
  person2
WHERE
  country_of_birth LIKE 'p%';

SELECT
  *
FROM
  person2
WHERE
  country_of_birth LIKE 'P%';

SELECT
  *
FROM
  person2
WHERE
  country_of_birth LIKE 'p%';

SELECT
  *
FROM
  person2
WHERE
  country_of_birth ILIKE 'p%';

SELECT
  *
FROM
  person2
WHERE
  country_of_birth ILIKE 'p%';

SELECT
  country_of_birth,
  COUNT(*)
GROUP BY
  country_of_birth;

SELECT
  country_of_birth,
  COUNT(*)
FROM
  person2
GROUP BY
  country_of_birth;

SELECT
  country_of_birth,
  COUNT(*)
FROM
  person2
GROUP BY
  email;

SELECT
  country_of_birth,
  COUNT(*)
FROM
  person2
GROUP BY
  country_of_birth
ORDER BY
  COUNT(*);

SELECT
  country_of_birth,
  COUNT(*)
FROM
  person2
GROUP BY
  country_of_birth;

SELECT
  country_of_birth,
  COUNT(*)
FROM
  person2
GROUP BY
  country_of_birth
WHERE
  COUNT(*) > 5;

SELECT
  country_of_birth,
  COUNT(*)
FROM
  person2
WHERE
  COUNT(*) > 5
GROUP BY
  country_of_birth;

SELECT
  country_of_birth,
  COUNT(*)
FROM
  person2
WHERE
  COUNT(*) > 5
  AND
GROUP BY
  country_of_birth;

SELECT
  country_of_birth,
  COUNT(*)
FROM
  person2
GROUP BY
  country_of_birth;

SELECT
  country_of_birth,
  COUNT(*)
FROM
  person2
GROUP BY
  country_of_birth;

SELECT
  country_of_birth,
  COUNT(*)
FROM
  person2;

SELECT
  country_of_birth,
  COUNT(*)
FROM
  person2;

SELECT
  country_of_birth,
  COUNT(5)
FROM
  person2
GROUP BY
  country_of_birth;

SELECT
  country_of_birth,
  COUNT(*)
FROM
  person2
GROUP BY
  country_of_birth
HAVING
  COUNT(*) > 5;

SELECT
  country_of_birth,
  COUNT(*)
FROM
  person2
GROUP BY
  country_of_birth
HAVING
  COUNT(*) > 5
ORDER BY
  COUNT(*);

-------------------------- CREATE car TABLE ----------------------------
CREATE TABLE car (
  id SERIAL PRIMARY KEY NOT NULL,
  make VARCHAR,
  model VARCHAR,
  price NUMERIC(15, 2)
);

INSERT INTO
  car (make, model, price)
VALUES
  ('a', 'b', '32,5');

INSERT INTO
  car (make, model, price)
VALUES
  ('a', 'b', 32, 5);

INSERT INTO
  car (make, model, price)
VALUES
  ('a', 'b', 32, 5,);

INSERT INTO
  car (make, model, price)
VALUES
  ('a', 'b', 32.5);

INSERT INTO
  car (make, model, price)
VALUES
  ('d', 'c', 432.51);

INSERT INTO
  car (make, model, price)
VALUES
  ('d', 'c', 432.65);

SELECT
  max(price)
FROM
  car;

SELECT
  AVG(price)
FROM
  car;

SELECT
  ROUND(AVG(price))
FROM
  car;

SELECT
  make,
  min(price)
FROM
  car
GROUP BY
  make;

SELECT
  make,
  MIN(price)
FROM
  car
GROUP BY
  make;

SELECT
  *
FROM
  car;
