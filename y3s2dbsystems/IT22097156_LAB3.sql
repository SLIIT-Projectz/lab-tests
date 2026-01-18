-- 1)

CREATE TYPE address_tp AS OBJECT(
    street_no VARCHAR2(5),
    street_name VARCHAR2(20),
    suburb VARCHAR2(20),
    state VARCHAR2(20),
    pin VARCHAR2(20)
);
/

CREATE TYPE exchanges_tp AS VARRAY(5) OF VARCHAR2(29);
/

CREATE TYPE stocks_tp AS OBJECT(
    company VARCHAR2(10),
    current_price NUMBER(6, 2),
    exchanges_traded exchanges_tp,
    last_dividend NUMBER(6, 2),
    earning_per_share NUMBER(6, 2)
);
/

CREATE TABLE stocks_tb OF stocks_tp(
    CONSTRAINT stocks_tb_pk PRIMARY KEY(company)
);
/

CREATE TYPE investments_tp AS OBJECT(
    company REF stocks_tp,
    purchase_price NUMBER(6, 2),
    purchase_date DATE,
    qty NUMBER(10)
);
/

CREATE TYPE investments_nt AS TABLE OF investments_tp;
/

CREATE TYPE clients_tp AS OBJECT(
    client_id CHAR(4),
    name VARCHAR2(30),
    address address_tp,
    investments investments_nt
);
/

CREATE TABLE clients_tb OF clients_tp(
    CONSTRAINT clients_tb_pk PRIMARY KEY(client_id)
) NESTED TABLE investments STORE AS investments_sys;
/


-- 2)

-- Insert Datas into stocks

INSERT INTO stocks_tb(company, current_price, exchanges_traded, last_dividend, earning_per_share) 
VALUES('BHP', 10.50, exchanges_tp('Sydney', 'New York'), 1.50, 3.20);

INSERT INTO stocks_tb(company, current_price, exchanges_traded, last_dividend, earning_per_share) 
VALUES('IBM', 70.00, exchanges_tp('New York', 'London', 'Tokyo'), 4.25, 10.00);

INSERT INTO stocks_tb(company, current_price, exchanges_traded, last_dividend, earning_per_share) 
VALUES('INTEL', 76.50, exchanges_tp('New York', 'London'), 5.00, 12.40);

INSERT INTO stocks_tb(company, current_price, exchanges_traded, last_dividend, earning_per_share) 
VALUES('FORD', 40.00, exchanges_tp('New York'), 2.00, 8.50);

INSERT INTO stocks_tb(company, current_price, exchanges_traded, last_dividend, earning_per_share) 
VALUES('GM', 60.00, exchanges_tp('New York'), 3.00, 7.80);

INSERT INTO stocks_tb(company, current_price, exchanges_traded, last_dividend, earning_per_share) 
VALUES('INFOSYS', 45.00, exchanges_tp('New York'), 3.00, 7.80);


-- Insert Datas into clients

INSERT INTO clients_tb(client_id, name, address, investments)
VALUES('C001',
        'John Smith', 
        address_tp('3', 'East Av', 'Bentley', 'W A', '6102'), 
        investments_nt(
            investments_tp(
                (SELECT REF(s) FROM stocks_tb s WHERE s.company = 'BHP'), 
                12.00, 
                TO_DATE('02-10-2001', 'DD-MM-YYYY'), 
                1000
            ),
            investments_tp(
                (SELECT REF(s) FROM stocks_tb s WHERE company = 'BHP'),
                10.50,
                TO_DATE('08-06-2002', 'DD-MM-YYYY'),
                2000
            ),
            investments_tp(
                (SELECT REF(s) FROM stocks_tb s WHERE company = 'IBM'),
                58.00,
                TO_DATE('12-02-2000', 'DD-MM-YYYY'),
                500
            ),
            investments_tp(
                (SELECT REF(s) FROM stocks_tb s WHERE company = 'IMB'),
                65.00,
                TO_DATE('10-04-2001', 'DD-MM-YYYY'),
                1200
            ),
            investments_tp(
                (SELECT REF(s) FROM stocks_tb s WHERE company = 'INFOSYS'),
                64.00,
                TO_DATE('11-08-2001', 'DD-MM-YYYY'),
                1000
            )
        )
    );


INSERT INTO clients_tb(client_id, name, address, investments)
VALUES('C002',
        'Jill Brody',
        address_tp('42', 'Bent St', 'Perth', 'W A', '6001'),
        investments_nt(
            investments_tp(
                (SELECT REF(s) FROM stocks_tb s WHERE s.company = 'INTEL'),
                35.00,
                TO_DATE('30-01-2000', 'DD-MM-YYYY'),
                300
            ),
            investments_tp(
                (SELECT REF(s) FROM stocks_tb s WHERE company = 'INTEL'),
                54.00,
                TO_DATE('30-01-2001', 'DD-MM-YYYY'),
                400
            ),
            investments_tp(
                (SELECT REF(s) FROM stocks_tb s WHERE company = 'INTEL'),
                60.00,
                TO_DATE('02-10-2001', 'DD-MM-YYYY'),
                200
            ),
            investments_tp(
                (SELECT REF(s) FROM stocks_tb s WHERE company = 'FORD'),
                40.00,
                TO_DATE('05-10-1999', 'DD-MM-YYYY'),
                300
            ),
            investments_tp(
                (SELECT REF(s) FROM stocks_tb s WHERE company = 'GM'),
                55.50,
                TO_DATE('12-12-2000', 'DD-MM-YYYY'),
                500
            )
        )
    );


-- 3)
-- a)
SELECT name, s.company, s.current_price, s.last_dividend, s.earning_per_share
FROM clients_tb c, TABLE(c.investments) i, stocks_tb s
WHERE i.company.company = s.company

-- b)
SELECT c.name, s.company, SUM(i.qty), SUM(i.purchase_price * i.qty) / SUM(i.qty) 
FROM clients_tb c, TABLE(c.investments) i, stocks_tb s
WHERE i.company.company = s.company
GROUP BY(c.name, s.company)

-- c)
SELECT 
    i.company.company AS "Company Name", 
    c.name AS "Client Name", 
    SUM(i.qty) AS "Shares held", 
    SUM(i.company.current_price * i.qty) AS "Current Value of Shares"
FROM 
    clients_tb c, 
    TABLE(c.investments) i, 
    TABLE(i.company.exchanges_traded) e
WHERE 
    e.COLUMN_VALUE = 'New York'
GROUP BY 
    (c.name, i.company.company, 
    i.company.current_price);
    
-- d)
SELECT c.name, SUM(i.qty * i.purchase_price) AS "Total Purchase Value"
FROM clients_tb c, TABLE(c.investments) i
GROUP BY (c.name)

-- e)
SELECT c.name, SUM(i.company.current_price * i.qty) - SUM(i.purchase_price * i.qty)
FROM clients_tb c, TABLE(c.investments) i
GROUP BY (c.name)


-- 4)
-- Insert infosys stock to Jill Brody
INSERT INTO TABLE(
    SELECT c.investments
    FROM clients_tb c
    WHERE c.name = 'Jill Brody'
)
SELECT investments_tp(
    (SELECT REF(s) FROM stocks_tb s WHERE s.company = 'INFOSYS'),
    (SELECT current_price FROM stocks_tb s WHERE s.company = 'INFOSYS'),
    SYSDATE,
    qty
)
FROM TABLE(
    SELECT c.investments
    FROM clients_tb c
    WHERE c.name = 'John Smith'
) i
WHERE DEREF(i.company).company = 'INFOSYS';


-- Delete the infosys row from John Smith
DELETE FROM TABLE(
    SELECT c.investments FROM clients_tb c WHERE c.name = 'John Smith'
) i
WHERE DEREF(i.company).company = 'INFOSYS';


-- Insert gm stock to John Smith
INSERT INTO TABLE(
    SELECT c.investments
    FROM clients_tb c
    WHERE c.name = 'John Smith'
)
SELECT investments_tp(
    (SELECT REF(s) FROM stocks_tb s WHERE s.company = 'GM'),
    (SELECT current_price FROM stocks_tb s WHERE s.company = 'GM'),
    SYSDATE,
    qty
)
FROM TABLE(
    SELECT c.investments
    FROM clients_tb c
    WHERE c.name = 'Jill Brody'
) i
WHERE DEREF(i.company).company = 'GM';


-- Delete gm stock from Jill Brody
DELETE FROM TABLE(
    SELECT c.investments FROM clients_tb c WHERE c.name = 'Jill Brody'
) i
WHERE DEREF(i.company).company = 'INFOSYS';



