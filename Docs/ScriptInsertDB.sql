Use moumoute;

INSERT INTO Language VALUE ("FR");
INSERT INTO Language VALUE ("EN");

INSERT INTO category VALUES(1);
INSERT INTO category VALUES(1);

INSERT INTO CategoryTrad VALUES(1,"EN",1,"Ginger");
INSERT INTO CategoryTrad VALUES(2,"FR",1,"Roux");
INSERT INTO CategoryTrad VALUES(3,"EN",2,"Women");
INSERT INTO CategoryTrad VALUES(4,"FR",2,"Femmes");

INSERT INTO Wig     VALUES(1,10.50,21,false,5);
INSERT INTO WigTrad VALUES(1,"FR",1,"Harley Quinn","Perruque d'Harley Quinn pour déguisements");
INSERT INTO WigTrad VALUES(1,"EN",1,"Harley Quinn","Harley Quinn's Wig for disguise");



Create table WigTrad (
	id int primary key,
	languageCode varchar(10) not null,
    wigId int not null,
    wigName varchar(50) not null,
    description varchar(500) not null,
    foreign key (languageCode) references Language(code),
    foreign key (wigId) references Wig(id)
);


Create table Wig (
	id int primary key,
    EVATPrice decimal(15,2) not null,
    VATrate decimal(2,2) not null check (VATrate > 0),
    isMan boolean not null,
    categoryId int not null,
    foreign key (categoryId) references Category(id)
);

Create table PictureLink (
	link varchar(255) primary key,
    wigId int not null,
    foreign key (wigId) references Wig(id)
);