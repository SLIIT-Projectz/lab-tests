-- IT umber: IT22097156
-- Name : Darshan R

-- Task 01
-- a)
CREATE TYPE student_type AS OBJECT(
    sid CHAR(8),
    sname VARCHAR2(15),
    phone CHAR(10)
) NOT FINAL;
/

CREATE TYPE ug_type UNDER student_type(
    gpa REAL,
    deptid CHAR(6),
    course VARCHAR2(10)
);
/

-- b)
CREATE TABLE students OF student_type(
    CONSTRAINT students_pk PRIMARY KEY(sid)
);
/

INSERT INTO students VALUES(
    ug_type('CS01', 'Janet Paeres', null, 3.2, '123556', 'InfoTech')
);

INSERT INTO students VALUES(
    ug_type('CS02', 'Alex Brown', '0771234567', 3.6, '987654', 'AI')
);

INSERT INTO students VALUES(
    ug_type('IT02', 'Mary Jane', '0779876543', 2.9, '876543', 'Networks')
);


-- c)
SELECT s.sid, s.sname
FROM students s
WHERE s.sid = 'CS01'

-- Task 02

-- Create Object Types
CREATE TYPE customer_t AS OBJECT(
    cid CHAR(6),
    name VARCHAR2(12),
    bithdate DATE,
    phone CHAR(10),
    address VARCHAR2(50)
) NOT FINAL;
/

CREATE TYPE car_t AS OBJECT(
    regno CHAR(9),
    make VARCHAR2(12),
    model VARCHAR2(10),
    mdate DATE,
    owner REF customer_t,
    value NUMBER(8, 2)
) NOT FINAL;
/

CREATE TYPE claim_t AS OBJECT(
    claimno CHAR(12),
    cdate DATE,
    amount NUMBER(8, 2),
    claimant ref customer_t
);
/

CREATE TYPE claim_ntab AS TABLE OF claim_t;
/

CREATE TYPE policy_t AS OBJECT(
    pid CHAR(7),
    sdate DATE,
    edate DATE,
    inscar ref car_t,
    premium NUMBER(6, 2),
    claims claim_ntab
);
/


-- Create Tables
CREATE TABLE customers OF customer_t(
    CONSTRAINT customers_pk PRIMARY KEY(cid)
);
/

INSERT INTO customers VALUES(
    customer_t('S25431', 'Alice Smith', DATE '1990-05-12', '0771112222', '12 King St')
);

INSERT INTO customers VALUES(
    customer_t('S25432', 'Bob Johnson', DATE '1999-03-10', '0773334444', '34 Queen Rd')
);

INSERT INTO customers VALUES(
    customer_t('S25433', 'Charlie Doe', DATE '2002-09-20', '0775556666', '56 Duke Ave')
);


CREATE TABLE cars OF car_t(
    SCOPE FOR (owner) IS customers,
    CONSTRAINT cars_pk PRIMARY KEY(regno)
);
/

INSERT INTO cars VALUES(
    car_t('CAR123456', 'Toyota', 'Corolla', DATE '2001-07-01',
        (SELECT REF(c) FROM customers c WHERE c.cid = 'S25431'),
        15000.00)
);

INSERT INTO cars VALUES(
    car_t('CAR654321', 'Honda', 'Civic', DATE '2002-05-15',
        (SELECT REF(c) FROM customers c WHERE c.cid = 'S25432'),
        18000.00)
);

INSERT INTO cars VALUES(
    car_t('SLA984', 'Ford', 'Focus', DATE '2003-10-10',
        (SELECT REF(c) FROM customers c WHERE c.cid = 'S25433'),
        20000.00)
);


CREATE TABLE policies OF policy_t(
    SCOPE FOR (inscar) IS cars,
    CONSTRAINT policies_pk PRIMARY KEY(pid)
) NESTED TABLE claims STORE AS claims_ntable;
/

INSERT INTO policies VALUES(
    policy_t('SL12354', DATE '2003-01-01', DATE '2004-12-31',
        (SELECT REF(ca) FROM cars ca WHERE ca.regno = 'CAR123456'),
        1200.00,
        claim_ntab() -- empty nested table initially
    )
);

INSERT INTO policies VALUES(
    policy_t('SL56789', DATE '2003-06-01', DATE '2004-11-30',
        (SELECT REF(ca) FROM cars ca WHERE ca.regno = 'CAR654321'),
        1500.00,
        claim_ntab()
    )
);

INSERT INTO policies VALUES(
    policy_t('SL99999', DATE '2004-01-15', DATE '2004-12-15',
        (SELECT REF(ca) FROM cars ca WHERE ca.regno = 'SLA984'),
        1700.00,
        claim_ntab()
    )
);


-- a)
--    i)

SELECT AVG(p.premium)
FROM policies p
WHERE EXISTS (
    SELECT 1
    FROM customers c
    WHERE c.cid = DEREF(DEREF(p.inscar).owner).cid AND 
    (months_between(SYSDATE, c.bithdate) / 12) BETWEEN 20 AND 25
);
/

--    ii)
SELECT DEREF(p.inscar).make AS make,
       DEREF(p.inscar).model AS model,
       SUM(c.amount) AS total_claims
FROM policies p, TABLE(p.claims) c
WHERE p.edate BETWEEN DATE '2004-01-01' AND DATE '2004-12-31'
GROUP BY DEREF(p.inscar).make, DEREF(p.inscar).model;


-- b)
INSERT INTO TABLE(
    SELECT p.claims
    FROM policies p
    WHERE p.pid = 'SL12354'
)
VALUES (
    Claim_t(
        '001',
        DATE '2004-07-12',
        2000,
        (SELECT REF(c) FROM customers c WHERE c.cid = 'S25431')
    )
);

-- c)
ALTER TYPE policy_t
ADD MEMBER FUNCTION renewal_premium RETURN NUMBER CASCADE;


CREATE OR REPLACE TYPE BODY policy_t AS
    MEMBER FUNCTION renewal_premium RETURN NUMBER IS
        total_claims NUMBER := 0;
    BEGIN
        SELECT NVL(SUM(c.amount), 0)
        INTO total_claims
        FROM TABLE(SELF.claims) c;

        IF total_claims < 1000 THEN
            RETURN SELF.premium;
        ELSE
            RETURN SELF.premium * 1.2;
        END IF;
    END;
END;
/

-- d)
SELECT p.renewal_premium() AS new_premium
FROM policies p
WHERE DEREF(p.inscar).regno = 'SLA984';
