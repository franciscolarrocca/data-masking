INSERT INTO app_user (name, phone_number, age, username, password) VALUES
('Juan Pérez'      ,'1234567890', 25, 'juanito123','juanpwd123'   ),
('María García'    ,'9876543210', 30, 'maria89'   ,'mariapass456' ),
('Luis Hernández'  ,'5554443333', 40, 'luish'     ,'luish456'     ),
('Ana López'       ,'7778889999', 22, 'analop'    ,'analop22'     ),
('Pedro Ramirez'   ,'1112223333', 28, 'pedroram'  ,'pedropass789' ),
('Sofía Martinez'  ,'9998887777', 35, 'sofiam'    ,'sofiapwd567'  ),
('Carlos Fernández','4445556666', 29, 'carlosf'   ,'carlospass999'),
('Laura González'  ,'6667778888', 27, 'laurag'    ,'laurapwd333'  ),
('Pablo Sánchez'   ,'2223334444', 32, 'pablos'    ,'pablopwd111'  ),
('Elena Castro'    ,'8889990000', 33, 'elenac'    ,'elenapass222' );

INSERT INTO bank_account (account_number, balance, user_id) VALUES
('12345678910111213', 1500.50 , 1),
('10111213123456721', 34500.50, 1),
('88711213123456788', 34500.50, 2),
('10111215463456779', 34500.50, 3),
('10111214574567808', 34500.50, 4),
('23453432110111213', 2300.25 , 5);

INSERT INTO card (type, number, expiration_date, user_id) VALUES
('VISTA'     ,'9999-5678-9101-1121', CURRENT_DATE(), 1),
('VISTA'     ,'1234-6666-9101-5555', CURRENT_DATE(), 1),
('MISTERCARD','1234-5678-4444-7777', CURRENT_DATE(), 2),
('VISTA'     ,'1234-5555-9101-3333', CURRENT_DATE(), 3),
('MISTERCARD','1234-5678-9101-5555', CURRENT_DATE(), 4),
('VISTA'     ,'1234-5678-9101-3333', CURRENT_DATE(), 5);