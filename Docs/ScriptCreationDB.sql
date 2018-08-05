Use moumoutedotnet;

Create table User (
	username varchar(100) primary key,
    password varchar(60) not null,
    lastname varchar(50) not null,
    firstname varchar(50) not null,
    email varchar(255) not null check(email regexp '^[a-zA-Z0-9][a-zA-Z0-9._-]*@[a-zA-Z0-9][a-zA-Z0-9._-]*\\.[a‌​-zA-Z]{2,4}$'),
    street varchar(100) not null,
    postalCode numeric(5) not null check (postalCode > 1000),
    city varchar(60) not null,
    country varchar(50) not null,
    authorities varchar(50),
    non_Expired boolean not null,
    non_Locked boolean not null,
    credentials_Non_Expired boolean not null,
    enabled boolean not null
);


Create table Category (
	id int primary key,
    name varchar(100) not null
);


Create table Wig (
	Id int primary key,
    EVATPrice decimal(15,2) not null,
    VATrate decimal(2,2) not null check (VATrate > 0),
    isMan boolean not null,
    category int not null,
    foreign key (category) references Category(id)
);


Create table PictureLink (
	link varchar(255) primary key,
    wigId int not null,
    foreign key (wigId) references Wig(Id)
);



Create table Language (
	languageCode varchar(10) primary key
);


Create table TradPerruque (
	languageCode varchar(10) not null,
    wigId int not null,
    wigName varchar(50) not null,
    description varchar(500) not null,
    primary key (languageCode, wigId),
    foreign key (languageCode) references Language(languageCode),
    foreign key (wigId) references Wig(Id)
);


Create table Color (
	id int primary key,
    RGB varchar(10) not null
);


Create table ColorTrad (
	languageCode varchar(10) not null,
    ColorId int not null,
    couleur varchar(30) not null,
    primary key (languageCode, ColorId),
    foreign key (languageCode) references Language(languageCode),
    foreign key (ColorId) references Color(id)
);


Create table WigColor (
	wigId int not null,
    ColorId int not null,
    primary key (wigId, ColorId),
    foreign key (wigId) references Wig(Id),
    foreign key (ColorId) references Color(id)
);


Create table Order (
	id int primary key,
    orderDate datetime not null,
    userName varchar(100) not null,
    foreign key (userName) references User(userName)
);


Create table OrderLine (
	number int not null,
    quantity int not null check (quantity > 0),
    unitPriceEVAT decimal(15,2)  not null,
    orderId int not null,
    wigId int not null,
    primary key (number, orderId),
    foreign key (orderId) references Order(id),
    foreign key (wigId) references Wig(Id)
);


