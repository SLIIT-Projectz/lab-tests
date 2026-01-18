-- IT Number : IT22097156
-- Name : Darshan R
-- Lab : 04
-- 1)
-- a)
ALTER TYPE stocks_tp
ADD MEMBER FUNCTION calculate_yield RETURN NUMBER CASCADE;
/

CREATE OR REPLACE TYPE BODY stocks_tp AS
    MEMBER FUNCTION calculate_yield RETURN NUMBER IS
    BEGIN
        RETURN (SELF.last_dividend/SELF.current_price) * 100;
    END;
END;
/

-- b)
ALTER TYPE stocks_tp
ADD MEMBER FUNCTION price_in_usd(aud_to_usd NUMBER) RETURN NUMBER CASCADE;
/

CREATE OR REPLACE TYPE BODY stocks_tp AS
    MEMBER FUNCTION calculate_yield RETURN NUMBER IS
    BEGIN
        RETURN (SELF.last_dividend/SELF.current_price) * 100;
    END;
    
    MEMBER FUNCTION price_in_usd(aud_to_usd NUMBER) RETURN NUMBER IS
    BEGIN
        RETURN SELF.current_price * aud_to_usd;
    END;
END;
/

-- c)
ALTER TYPE stocks_tp
ADD MEMBER FUNCTION count_exchanges RETURN NUMBER CASCADE;
/

CREATE OR REPLACE TYPE BODY stocks_tp AS
    MEMBER FUNCTION calculate_yield RETURN NUMBER IS
    BEGIN
        RETURN (SELF.last_dividend/SELF.current_price) * 100;
    END;
    
    MEMBER FUNCTION price_in_usd(aud_to_usd NUMBER) RETURN NUMBER IS
    BEGIN
        RETURN SELF.current_price * aud_to_usd;
    END;
    
    MEMBER FUNCTION count_exchanges RETURN NUMBER IS
    BEGIN
        RETURN SELF.exchanges_traded.COUNT;
    END;
END;
/

-- d)
ALTER TYPE clients_tp
ADD MEMBER FUNCTION total_purchase_value RETURN NUMBER CASCADE;
/

CREATE OR REPLACE TYPE BODY clients_tp AS
    MEMBER FUNCTION total_purchase_value RETURN NUMBER IS
        t_purchase NUMBER;
    BEGIN
        SELECT SUM(i.purchase_price * i.qty)
        INTO t_purchase
        FROM TABLE(SELF.investments) i;
        
        RETURN NVL(t_purchase, 0);
    END;
END;
/

-- e)
ALTER TYPE clients_tp
ADD MEMBER FUNCTION total_profit RETURN NUMBER CASCADE;
/

CREATE OR REPLACE TYPE BODY clients_tp AS
    MEMBER FUNCTION total_purchase_value RETURN NUMBER IS
        t_purchase NUMBER;
    BEGIN
        SELECT SUM(i.purchase_price * i.qty)
        INTO t_purchase
        FROM TABLE(SELF.investments) i;
        
        RETURN NVL(t_purchase, 0);
    END;
    
    MEMBER FUNCTION total_profit RETURN NUMBER IS
        t_profit NUMBER;
    BEGIN
        SELECT SUM((DEREF(i.company).current_price - i.purchase_price) * i.qty)
        INTO t_profit
        FROM TABLE(SELF.investments) i;
        
        RETURN NVL(t_profit, 0);
    END;
END;
/



-- 2)
-- a)
SELECT 
    s.company AS "Stock Name", 
    e.COLUMN_VALUE AS "Exchanges Traded", 
    s.calculate_yield() AS "Yield", 
    s.price_in_usd(0.74) AS "Price in USD"
FROM 
    stocks_tb s, 
    TABLE(s.exchanges_traded) e
/

-- b)
SELECT
    s.company,
    s.current_price,
    s.count_exchanges() AS "Number of Exchanges"
FROM
    stocks_tb s
WHERE
    s.count_exchanges() > 1
/

-- c)
SELECT 
    c.name AS "Client Name",
    i.company.company AS "Stock Name",
    i.company.calculate_yield() AS "Yield",
    i.company.current_price AS "Current Price",
    i.company.earning_per_share AS "Earnings Per Share"
FROM 
    clients_tb c,
    TABLE(c.investments) i
/

-- d)
SELECT
    c.name AS "Client Name",
    c.total_purchase_value() AS "Total Purchase Value"
FROM
    clients_tb c
/

-- e)
SELECT
    c.name AS "Client Name",
    c.total_profit() AS "Book Profit"
FROM
    clients_tb c
/