Use moumoute;

INSERT INTO Language VALUE ("FR");
INSERT INTO Language VALUE ("EN");

INSERT INTO category VALUES(1);
INSERT INTO category VALUES(2);

INSERT INTO CategoryTrad VALUES(1,"EN",1,"Superheroes");
INSERT INTO CategoryTrad VALUES(2,"FR",1,"Super-héros");
INSERT INTO CategoryTrad VALUES(3,"EN",2,"Famous people");
INSERT INTO CategoryTrad VALUES(4,"FR",2,"Personnalités connues");

INSERT INTO Wig     VALUES(1,10.50,21,"https://i.imgur.com/7IrTks5.jpg",1);
INSERT INTO WigTrad VALUES(1,"FR",1,"Harley Quinn","Perruque d'Harley Quinn pour déguisements");
INSERT INTO WigTrad VALUES(2,"EN",1,"Harley Quinn","Harley Quinn's Wig for disguise");

INSERT INTO Wig     VALUES(2,8.50,21,"https://i.imgur.com/V3nxNeb.jpg",1);
INSERT INTO WigTrad VALUES(3,"FR",2,"Clark Kent","Perruque de Clark Kent pour déguisements");
INSERT INTO WigTrad VALUES(4,"EN",2,"Clark Kent","Clark Kent's Wig for disguise");

INSERT INTO Wig     VALUES(3,11.30,21,"https://i.imgur.com/lE8M8Xc.jpg",1);
INSERT INTO WigTrad VALUES(5,"FR",3,"Kick-Ass","Perruque de Kick-Ass pour déguisements");
INSERT INTO WigTrad VALUES(6,"EN",3,"Kick-Ass","Kick-Ass's Wig for disguise");

INSERT INTO Wig     VALUES(4,11.30,21,"https://i.imgur.com/nfo2y6A.jpg",1);
INSERT INTO WigTrad VALUES(7,"FR",4,"Musclor","Perruque de Musclor pour déguisements");
INSERT INTO WigTrad VALUES(8,"EN",4,"Musclor","Musclor's Wig for disguise");

INSERT INTO Wig     VALUES(5,14,21,"https://i.imgur.com/JjxYtyg.jpg",1);
INSERT INTO WigTrad VALUES(9,"FR",5,"Thor","Perruque de Thor pour déguisements");
INSERT INTO WigTrad VALUES(10,"EN",5,"Thor","Thor's Wig for disguise");

INSERT INTO Wig     VALUES(6,14,21,"https://i.imgur.com/MkjcPyT.jpg",1);
INSERT INTO WigTrad VALUES(11,"FR",6,"Wonder woman","Perruque de Wonder woman pour déguisements");
INSERT INTO WigTrad VALUES(12,"EN",6,"Wonder woman","Wonder woman's Wig for disguise");

INSERT INTO Wig     VALUES(7,14,21,"https://i.imgur.com/3fR8bSm.jpg",2);
INSERT INTO WigTrad VALUES(13,"FR",7,"Amy Winehouse","Perruque de Amy Winehouse pour déguisements");
INSERT INTO WigTrad VALUES(14,"EN",7,"Amy WineHouse","Amy Winehouse's Wig for disguise");

INSERT INTO Wig     VALUES(8,14,21,"https://i.imgur.com/wACoEYh.jpg",2);
INSERT INTO WigTrad VALUES(15,"FR",8,"Elvis le chanteur","Perruque d' Elvis pour déguisements");
INSERT INTO WigTrad VALUES(16,"EN",8,"Elvis the singer","Elvis's Wig for disguise");


INSERT INTO Wig     VALUES(9,14,21,"https://i.imgur.com/zQS3OzZ.jpg",2);
INSERT INTO WigTrad VALUES(17,"FR",9,"Sia noir et blanc","Perruque de Sia pour déguisements");
INSERT INTO WigTrad VALUES(18,"EN",9,"Sia black and white","Sia's Wig for disguise");

INSERT INTO Promotion VALUES(1,'2018-12-31','2018-01-01',25.00,9);
INSERT INTO Promotion VALUES(2,'2018-02-28','2018-01-01',33.33,8);


Create table Promotion(
	id int primary key, 
	endDate    DATETIME(6) not null,
	startDate  DATETIME(6) not null,
	percRed  DECIMAL(5,2) not null ,
	wigId int not null,
	foreign key(wigId) references Wig(id)  	
);
