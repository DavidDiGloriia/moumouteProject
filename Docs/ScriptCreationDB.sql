Use moumoute;

Create table User (
	username varchar(100) primary key,
    password varchar(60) not null,
    lastname varchar(50) not null,
    firstname varchar(50) not null,
    email varchar(255) not null check(email regexp '^[a-zA-Z0-9][a-zA-Z0-9._-]*@[a-zA-Z0-9][a-zA-Z0-9._-]*\\.[a‌​-zA-Z]{2,4}$'),
    street varchar(100) not null,
    postalCode numeric(5) not null check (postalCode >= 1000),
    city varchar(60) not null,
    country varchar(50) not null,
    authorities varchar(50),
    non_Expired boolean not null,
    non_Locked boolean not null,
    credentials_Non_Expired boolean not null,
    enabled boolean not null
);


Create table Language (
	code varchar(10) primary key
);


Create table Category (
	id int primary key
);
Create table CategoryTrad (
	id int primary key,
	languageCode varchar(10) not null,
	categoryId int not null,
	categoryName varchar(100) not null,
	foreign key (languageCode) references Language(code),
	foreign key (categoryId) references Category(id)
);


Create table Color (
	id int primary key,
    RGB varchar(10) not null
);
Create table ColorTrad (
	id int primary key,
	colorName varchar(30) not null,
	languageCode varchar(10) not null,
    colorId int not null,
    foreign key (languageCode) references Language(code),
    foreign key (colorId) references Color(id)
);


Create table Wig (
	id int primary key,
    EVATPrice decimal(15,2) not null,
    VATrate decimal(2,2) not null check (VATrate > 0),
    isMan boolean not null,
    categoryId int not null,
    foreign key (categoryId) references Category(id)
);
Create table WigTrad (
	id int primary key,
	languageCode varchar(10) not null,
    wigId int not null,
    wigName varchar(50) not null,
    description varchar(500) not null,
    foreign key (languageCode) references Language(code),
    foreign key (wigId) references Wig(id)
);
Create table PictureLink (
	link varchar(255) primary key,
    wigId int not null,
    foreign key (wigId) references Wig(id)
);
Create table WigColor (
	id int primary key,
	wigId int not null,
    colorId int not null,
    foreign key (wigId) references Wig(id),
    foreign key (colorId) references Color(id)
);


Create table OrderTicket (
	id int primary key,
    orderDate datetime not null,
    username varchar(100) not null,
    foreign key (username) references User(username)
);
Create table OrderLine (
	id int primary key,
	lineNumber int not null,
    quantity int not null check (quantity > 0),
    unitPriceEVAT decimal(15,2)  not null,
    orderId int not null,
    wigId int not null,
    foreign key (orderId) references OrderTicket(id),
    foreign key (wigId) references Wig(id)
);


ALTER TABLE CategoryTrad ADD CONSTRAINT uq_CategoryTrad UNIQUE(languageCode, categoryId);
ALTER TABLE ColorTrad ADD CONSTRAINT uq_ColorTrad UNIQUE(languageCode, colorId);
ALTER TABLE WigTrad ADD CONSTRAINT uq_WigTrad UNIQUE(languageCode, wigId);
ALTER TABLE WigColor ADD CONSTRAINT uq_WigColor UNIQUE(wigId, colorId);