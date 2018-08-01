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



Create table Categorie (
	id int primary key,
    nom varchar(100) not null
);



Create table Perruque (
	numPerruque int primary key,
    prixHTVA decimal(15,2) not null,
    tauxTVA decimal(2,2) not null check (tauxTVA > 0),
    estHomme boolean not null,
    categorie int not null,
    foreign key (categorie) references Categorie(id)
);


Create table LienImage (
	lien varchar(255) primary key,
    numPerruque int not null,
    foreign key (numPerruque) references Perruque(numPerruque)
);



Create table Langue (
	codeLangue varchar(10) primary key
);



Create table TradPerruque (
	codeLangue varchar(10) not null,
    numPerruque int not null,
    nomPerruque varchar(50) not null,
    description varchar(500) not null,
    primary key (codeLangue, numPerruque),
    foreign key (codeLangue) references Langue(codeLangue),
    foreign key (numPerruque) references Perruque(numPerruque)
);



Create table Couleur (
	id int primary key,
    codeRGB varchar(10) not null
);



Create table TradCouleur (
	codeLangue varchar(10) not null,
    idCouleur int not null,
    couleur varchar(30) not null,
    primary key (codeLangue, idCouleur),
    foreign key (codeLangue) references Langue(codeLangue),
    foreign key (idCouleur) references Couleur(id)
);



Create table Coloris (
	numPerruque int not null,
    idCouleur int not null,
    primary key (numPerruque, idCouleur),
    foreign key (numPerruque) references Perruque(numPerruque),
    foreign key (idCouleur) references Couleur(id)
);



Create table Commande (
	id int primary key,
    dateCommande datetime not null,
    userName varchar(100) not null,
    foreign key (userName) references User(userName)
);



Create table LigneCommande (
	numero int not null,
    quantite int not null check (quantite > 0),
    prixUnitaireHTVA decimal(15,2)  not null,
    idCommande int not null,
    numPerruque int not null,
    primary key (numero, idCommande),
    foreign key (idCommande) references Commande(id),
    foreign key (numPerruque) references Perruque(numPerruque)
);


