-- IT Number: IT22097156
-- Name: Darshan R

-- Example: Untyped XML Column in Table
CREATE TABLE AdminDocs (
    id NUMBER PRIMARY KEY,
    xDoc XMLTYPE NOT NULL
);

-- Insert catalog example
INSERT INTO AdminDocs (id, xDoc)
VALUES (
    6,
    XMLTYPE('
        <catalog>
            <product dept="WMN">
                <number>557</number>
                <name language="en">Fleece Pullover</name>
                <colorChoices>navy black</colorChoices>
            </product>
            <product dept="ACC">
                <number>563</number>
                <name language="en">Floppy Sun Hat</name>
            </product>
            <product dept="ACC">
                <number>443</number>
                <name language="en">Deluxe Travel Bag</name>
            </product>
            <product dept="MEN">
                <number>784</number>
                <name language="en">Cotton Dress Shirt</name>
                <colorChoices>white gray</colorChoices>
                <desc>Our <i>favorite</i> shirt!</desc>
            </product>
        </catalog>'
    )
);

-- Insert doc example
INSERT INTO AdminDocs (id, xDoc)
VALUES (
    2,
    XMLTYPE('
        <doc id="123">
            <sections>
                <section num="1"><title>XML Schema</title></section>
                <section num="3"><title>Benefits</title></section>
                <section num="4"><title>Features</title></section>
            </sections>
        </doc>'
    )
);


SELECT * FROM AdminDocs;

-- Example: Using Query() Method
SELECT id, XMLQUERY('/catalog' PASSING xDoc RETURNING CONTENT) FROM AdminDocs;
SELECT id, XMLQUERY('/catalog/product' PASSING xDoc RETURNING CONTENT) FROM AdminDocs;
SELECT id, XMLQUERY('//product' PASSING xDoc RETURNING CONTENT) FROM AdminDocs;
SELECT id, XMLQUERY('/*/product' PASSING xDoc RETURNING CONTENT) FROM AdminDocs;
SELECT id, XMLQUERY('/*/product[@dept="WMN"]' PASSING xDoc RETURNING CONTENT) FROM AdminDocs;
SELECT id, XMLQUERY('/*/child::product[attribute::dept="WMN"]' PASSING xDoc RETURNING CONTENT) FROM AdminDocs;
SELECT id, XMLQUERY('/*/child::product[attribute::dept="WMN"]' PASSING xDoc RETURNING CONTENT) FROM AdminDocs;
SELECT id, XMLQUERY('//product[dept="WMN"]' PASSING xDoc RETURNING CONTENT) FROM AdminDocs;
SELECT id, XMLQUERY('descendant-or-self::product[attribute::dept="WMN"]' PASSING xDoc RETURNING CONTENT) FROM AdminDocs;
SELECT id, XMLQUERY('//product[number > 500]' PASSING xDoc RETURNING CONTENT) FROM AdminDocs WHERE id=6;

SELECT id,
       XMLQUERY('//product[number(xs:decimal(.)) > 500]'
                 PASSING xDoc RETURNING CONTENT)
FROM AdminDocs
WHERE id=6;


SELECT id, XMLQUERY('/catalog/product[4]' PASSING xDoc RETURNING CONTENT) FROM AdminDocs WHERE id=6;
SELECT id, XMLQUERY('//product[number > 500][@dept="ACC"]' PASSING xDoc RETURNING CONTENT) FROM AdminDocs WHERE id=6;
SELECT id, XMLQUERY('//product[number > 500][1]' PASSING xDoc RETURNING CONTENT) FROM AdminDocs WHERE id=6;

SELECT XMLQUERY(' for $prod in //product 
let $x:=$prod/number
return $x' PASSING xDoc RETURNING CONTENT)
FROM AdminDocs
WHERE id=6;

SELECT XMLQUERY(' for $prod in //product 
let $x:=$prod/number
where $x>500
return $x' PASSING xDoc RETURNING CONTENT)
FROM AdminDocs
WHERE id=6;

SELECT XMLQUERY(' for $prod in //product 
let $x:=$prod/number
return $x' PASSING xDoc RETURNING CONTENT)
FROM AdminDocs
WHERE id=6;

SELECT XMLQUERY('for $prod in //product 
let $x:=$prod/number
where $x>500
return (<Item>{$x}</Item>)' PASSING xDoc RETURNING CONTENT)
FROM AdminDocs
WHERE id=6;

SELECT XMLQUERY(' for $prod in //product[number > 500] 
let $x:=$prod/number
where $x>500
return (<Item>{$x}</Item>)' PASSING xDoc RETURNING CONTENT)
FROM AdminDocs
WHERE id=6;

SELECT XMLQUERY('for $prod in //product 
let $x:=$prod/number
where $x>500
return (<Item>{data($x)}</Item>)' PASSING xDoc RETURNING CONTENT)
FROM AdminDocs
WHERE id=6;

SELECT XMLQUERY('for $prod in //product 
let $x:=$prod/number
return if ($x>500) 
then <book>{$x}</book>
else <paper>{$x}</paper>' PASSING xDoc RETURNING CONTENT)
FROM AdminDocs
WHERE id=6;

SELECT XMLQUERY('for $prod in //product 
let $x:=$prod/number
return if ($x>500) 
then <book>{data($x)}</book>
else <paper>{data($x)}</paper>' PASSING xDoc RETURNING CONTENT)
FROM AdminDocs
WHERE id=6;

-- Example: Using Exist() Method
SELECT id
FROM AdminDocs
WHERE XMLExists('/doc[@id="123"]' PASSING xDoc);


-- Example: Using Value() Method
SELECT XMLCast(
         XMLQuery('/doc//section[@num=3]/title/text()'
                  PASSING xDoc RETURNING CONTENT)
         AS VARCHAR2(100)
       ) AS Section3Title
FROM AdminDocs
WHERE id = 2;

-- Example: Insertion of Subtree into XML Instances
SELECT * FROM AdminDocs WHERE id=2;

SET DEFINE OFF;

UPDATE AdminDocs
SET xDoc = XMLPatch(
              xDoc,
              XMLType('
                <diff>
                  <insert context="/doc/sections/section[@num=&quot;1&quot;]">
                    <section num="2">
                      <title>Background</title>
                    </section>
                  </insert>
                </diff>')
           )
WHERE id = 2;

UPDATE AdminDocs
SET xDoc = XMLPatch(
    xDoc,
    XMLType('
      <diff>
        <delete select="/doc/sections/section[@num=&quot;2&quot;]"/>
      </diff>')
)
WHERE id = 2;
