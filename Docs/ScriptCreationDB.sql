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
	phoneNumber varchar(15),
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


Create table Wig (
	id int primary key,
    EVATPrice decimal(15,2) not null,
    VATrate decimal(4,2) not null check (VATrate > 0),
	pictureLink varchar(255),
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

Create table Promotion(
    id int primary key, 
    endDate DATETIME(6) not null,
    startDate DATETIME(6) not null,
    percRed decimal(5.2) not null ,
    wigId int not null,
    foreign key(wigId) references Wig(id)
);

Create table Sale (
	id int primary key auto_increment,
    saleDate datetime not null,
    username varchar(100) not null,
    foreign key (username) references User(username)
);

Create table SaleLine (
	id int  primary key auto_increment,
    quantity int not null check (quantity > 0),
    unitPrice decimal(15,2)  not null,
    saleId int not null,
    wigId int not null,
    foreign key (saleId) references Sale(id),
    foreign key (wigId) references Wig(id)
);

ALTER TABLE CategoryTrad ADD CONSTRAINT uq_CategoryTrad UNIQUE(languageCode, categoryId);
ALTER TABLE WigTrad ADD CONSTRAINT uq_WigTrad UNIQUE(languageCode, wigId);