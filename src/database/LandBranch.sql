Drop database LandBranch;
CREATE DATABASE LandBranch;

USE LandBranch;

CREATE TABLE NominatedSuccessor(
	Name VARCHAR(30) NOT NULL,
	NIC_S VARCHAR(11),
	Address VARCHAR(60),
	CONSTRAINT PRIMARY KEY (NIC_S)
);


CREATE TABLE GND(
	DivisionNumber VARCHAR(10) NOT NULL,
	DivisionName VARCHAR(30),
	GramaNiladariName VARCHAR(30),
	ZoneName VARCHAR(20),
	CONSTRAINT PRIMARY KEY (DivisionNumber)
);



CREATE TABLE Land(
	PlanNumber VARCHAR(10) NOT NULL,
	LandName VARCHAR(30),
	DivisionNumber VARCHAR(10) NOT NULL,
	WestBound VARCHAR(30),
	EastBound VARCHAR(30),
	NorthBound VARCHAR(30),
	SouthBound VARCHAR(30),
	CONSTRAINT PRIMARY KEY (PlanNumber),
	CONSTRAINT FOREIGN KEY(DivisionNumber) REFERENCES  GND(DivisionNumber)
	ON UPDATE CASCADE ON DELETE CASCADE
);



CREATE TABLE Lot(
	LotNumber VARCHAR(5) NOT NULL,
	NumberOfAcres INT(3),
	NumberOfRoods INT(3),
	NumberOfPerches INT(13),
	PlanNumber VARCHAR(10) NOT NULL,
	CONSTRAINT PRIMARY KEY (LotNumber),
	CONSTRAINT FOREIGN KEY(PlanNumber) REFERENCES  Land(PlanNumber)
	ON UPDATE CASCADE ON DELETE CASCADE
	
);



CREATE TABLE Client(
	NIC VARCHAR(12) NOT NULL,
	ClientName VARCHAR(10),
	Birthday DATE,
	Telephone INT(10),
	Address VARCHAR(100),
	AnnualIncome DECIMAL(10,2),
	GrantOwnershipPosition INT(2),
	PermitOwnershipPosition INT(2),
        MarriedStatus INT(1),
	NumberOfMarriedSons INT(2),
	NumberOfUnmarriedSons INT(2),
	CONSTRAINT PRIMARY KEY (NIC)
);




CREATE TABLE Permit(
	PermitNumber VARCHAR(50) NOT NULL,
	PermitIssueDate DATE,
	LotNumber VARCHAR(10) NOT NULL,
	NIC VARCHAR(12) NOT NULL,
	NIC_Successor VARCHAR(11),
	CONSTRAINT PRIMARY KEY (PermitNumber,NIC),
	CONSTRAINT FOREIGN KEY(NIC) REFERENCES  Client(NIC),
	CONSTRAINT FOREIGN KEY(NIC_Successor) REFERENCES  NominatedSuccessor(NIC_S)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FOREIGN KEY(LotNumber) REFERENCES  Lot(LotNumber)
	ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE Grant1(
	GrantNumber VARCHAR(50) NOT NULL,
	GrantIssueDate DATE,
	PermitNumber VARCHAR(50) NOT NULL,
	LotNumber VARCHAR(10) NOT NULL,
	NIC VARCHAR(12) NOT NULL,
	NIC_Successor VARCHAR(11),	
	CONSTRAINT PRIMARY KEY (GrantNumber,NIC),
	CONSTRAINT FOREIGN KEY(NIC) REFERENCES  Client(NIC),
	CONSTRAINT FOREIGN KEY(NIC_Successor) REFERENCES  NominatedSuccessor(NIC_S)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FOREIGN KEY(LotNumber) REFERENCES  Lot(LotNumber)
	ON UPDATE CASCADE ON DELETE CASCADE,
	CONSTRAINT FOREIGN KEY(PermitNumber) REFERENCES  Permit(PermitNumber)
);



/*kaburugamuwa kalapaya*/
INSERT INTO GND values("408C","Kaburugamuwa South","Asela","Kaburugamuwa");
INSERT INTO GND values("408","Kaburugamuwa North","Nadun","Kaburugamuwa");
INSERT INTO GND values("408A","Kaburugamuwa West","Sandeepa","Kaburugamuwa");
INSERT INTO GND values("408D","Thudalla","Nimal","Kaburugamuwa");
INSERT INTO GND values("408B","Garaduwa","Gayan","Kaburugamuwa");
INSERT INTO GND values("407C","Thalaraba East","Charith","Kaburugamuwa");

/*Midigama kalapaya*/
INSERT INTO GND values("486D","Kapparathota North","Nisal","Midigama");
INSERT INTO GND values("486C","Kapparathota South","Nipuna","Midigama");
INSERT INTO GND values("486B","Walliwala South","Nirmal","Midigama");
INSERT INTO GND values("486A","Walliwala West","Ganga","Midigama");
INSERT INTO GND values("479A","Pitiduwa","Sanka","Midigama");
INSERT INTO GND values("480","Midigama East","Sankalpa","Midigama");

/*Polathumodara kalapaya*/
INSERT INTO GND values("407","Thalaraba South","Gamage","Polathumodara");
INSERT INTO GND values("407A","Bandaramulla","Sumudu","Polathumodara");
INSERT INTO GND values("406","Mirissa South 1","Chandana","Polathumodara");
INSERT INTO GND values("406A","Mirissa South 2","Namal","Polathumodara");
INSERT INTO GND values("405","Mirissa North","Sumudu","Polathumodara");
INSERT INTO GND values("405A","Udupila","Nalaka","Polathumodara");
INSERT INTO GND values("405B","Udumulla","Nimalasena","Polathumodara");

/*Weligama kalapaya*/
INSERT INTO GND values("388","Polwatta","Ranil","Weligama");
INSERT INTO GND values("382A","Paranakade","Sunila","Weligama");
INSERT INTO GND values("382B","Hettivdiya","Lankathilaka","Weligama");
INSERT INTO GND values("382","Mahavdiya","Sumana","Weligama");
INSERT INTO GND values("385","Galbokka East","Chandisena","Weligama");
INSERT INTO GND values("385B","Galbokka West","Thanura","Weligama");

/*insert land values*/

INSERT INTO Land values("PL01","Punchiwatta","388","Walukaramaya","Sumangale","","Paluwatta");
INSERT INTO Land values("PL02","Sumuduwatta","407","Gangaramaya","Sumithywatta","Main rood","");
INSERT INTO Land values("PL03","Dewalawatta","388","kajjukale","Raksawatta","","Rsbutankale");
INSERT INTO Land values("PL04","Sirilwatta","408C","Somawansha para","Nelum kale","Patuwatta Kubura","");
INSERT INTO Land values("PL05","Charlywatta","406","","","","Salinda Ground");
INSERT INTO Land values("PL06","Suriyawatta","486B","Rathu Kubura","Maligawaththa Ground","Malnga Ground","Ruwanikaramaya");

/*inset lot values*/

INSERT INTO Lot values('L001','4','5','3','PL01');
INSERT INTO Lot values('L002','0','5','1','PL02');
INSERT INTO Lot values('L003','4','0','3','PL03');
INSERT INTO Lot values('L004','1','5','3','PL01');
INSERT INTO Lot values('L005','0','10','0','PL01');
INSERT INTO Lot values('L006','0','5','0','PL01');
INSERT INTO Lot values('L007','7','0','0','PL01');
INSERT INTO Lot values('L008','10','0','0','PL01');
INSERT INTO Lot values('L009','0','0','7','PL01');
INSERT INTO Lot values('L010','0','0','20','PL01');
INSERT INTO Lot values('L011','8','0','0','PL02');
INSERT INTO Lot values('L012','0','0','34','PL03');
INSERT INTO Lot values('L013','0','8','0','PL04');
INSERT INTO Lot values('L014','6','0','0','PL04');
INSERT INTO Lot values('L015','0','5','0','PL05');
INSERT INTO Lot values('L016','12','5','0','PL05');
INSERT INTO Lot values('L017','7','5','0','PL02');
INSERT INTO Lot values('L018','0','8','3','PL03');
INSERT INTO Lot values('L019','0','0','22','PL04');
INSERT INTO Lot values('L020','0','10','0','PL05');
INSERT INTO Lot values('L021','14','0','0','PL02');
INSERT INTO Lot values('L022','0','15','0','PL03');
INSERT INTO Lot values('L023','0','0','17','PL04');
INSERT INTO Lot values('L024','0','0','21','PL05');
INSERT INTO Lot values('L025','32','5','3','PL05');
INSERT INTO Lot values('L026','32','5','7','PL05');
INSERT INTO Lot values('L027','0','6','3','PL03');

/*nominate successor values*/

INSERT INTO NominatedSuccessor values('Amara','940569211v','no 45');
INSERT INTO NominatedSuccessor values('Sunil','900569211v','no 34');
INSERT INTO NominatedSuccessor values('Amarapala','9405692145v','no 75');
INSERT INTO NominatedSuccessor values('Gayashan','910569211v','no 47');
INSERT INTO NominatedSuccessor values('Sudira','920569211v','no 45B');
INSERT INTO NominatedSuccessor values('Pawan','940569611v','no 32');
INSERT INTO NominatedSuccessor values('Suran','940569271v','no 77');
INSERT INTO NominatedSuccessor values('Paala','940669211v','no 89');
INSERT INTO NominatedSuccessor values('Jayathilaka','890569211v','no 4');
INSERT INTO NominatedSuccessor values('Sudipa','940511211v','no 7');

/*client values*/
INSERT INTO Client values('8002342354v','Sumanadasa','1980/06/06','0710454231','no 45, Galbokka ,Weligama','20000.00','1','1','1','0','0');
INSERT INTO Client values('8302532365v','Gunasekara','1983/03/07','0710454456','no 70, Galbokka ,Weligama','25000.00','2','2','1','2','1');
INSERT INTO Client values('800134235v','Kalum','1980/04/01','0710874231','no 64, Gammudawa ,Weligama','10000.00','1','1','0','0','0');
INSERT INTO Client values('650134235v','Sujatha','1965/04/01','0710454287','no  65, Gammudawa ,Weligama','30000.00','1','1','1','0','4');
INSERT INTO Client values('780134243v','Ganga','1978/04/01','0770454245','no 34,Piliwatta ,Weligama','28000.00','1','1','0','0','0');
INSERT INTO Client values('770134253v','Ganga','1977/04/01','0720454245','no 65, 5e kanuwa ,Weligama','27000.00','1','1','1','0','1');
INSERT INTO Client values('710134253v','Mlinda','1971/04/01','0750454245','no 75, 5e kanuwa ,Weligama','25600.00','1','1','1','0','1');
INSERT INTO Client values('740134253v','Pavithra','1974/04/01','0720454257','no 95, 5e kanuwa ,Weligama','25200.00','1','1','1','0','1');
INSERT INTO Client values('730134253v','Sujitha','1973/04/05','0720456245','no 65, 6e kanuwa ,Weligama','23000.00','0','1','1','2','1');
INSERT INTO Client values('760134253v','Akila','1976/04/22','072012245','no 65, 8e kanuwa ,Weligama','27000.00','0','1','1','2','1');
INSERT INTO Client values('790134253v','Madusha','1979/04/26','0720454515','no 65, pansalagoda ,Weligama','27000.00','0','1','1','1','1');
INSERT INTO Client values('740134243v','Guanadasa','1974/04/01','0720454279','no 11, 5e kanuwa ,Weligama','25200.00','0','0','1','0','1');
INSERT INTO Client values('730134267v','Nimalasena','1973/04/05','0720456321','no 05, 6e kanuwa ,Weligama','23000.00','0','0','1','2','1');
INSERT INTO Client values('760134298v','Adikari','1976/04/22','072012211','no 15, 8e kanuwa ,Weligama','27000.00','0','0','1','0','1');
INSERT INTO Client values('800134253v','Ranga','1979/04/26','0780454515','no 89, pansalagoda ,Weligama','27000.00','0','0','1','1','1');



/*permit values*/
INSERT INTO permit values('388/ENC/01','2010/06/05','L001','8002342354v','940569211v');
INSERT INTO permit values('388/ENC/01','2010/06/05','L001','8302532365v','940569211v');
INSERT INTO permit values('388/ENC/02','2011/06/05','L010','800134235v','900569211v');
INSERT INTO permit values('388/ENC/03','2011/06/05','L004','650134235v','9405692145v');
INSERT INTO permit values('388/ENC/04','2012/06/05','L003','740134253v','910569211v');
INSERT INTO permit values('388/ENC/05','2012/06/05','L012','710134253v','920569211v');
INSERT INTO permit values('388/ENC/06','2012/06/05','L009','770134253v','940569611v');
INSERT INTO permit values('408C/ENC/01','2015/06/05','L013','760134253v','940569271v');
INSERT INTO permit values('408C/ENC/02','2015/06/05','L023','790134253v','890569211v');
INSERT INTO permit values('406/ENC/01','2010/04/05','L024','740134243v','940511211v');
INSERT INTO permit values('407/ENC/02','2010/06/05','L002','780134243v','940669211v');

/*Grant values*/
INSERT INTO Grant1 values('G232','2011/06/05','388/ENC/01','L001','8302532365v','940569211v');
INSERT INTO Grant1 values('G232','2011/06/05','388/ENC/01','L001','8002342354v','940569211v');
INSERT INTO Grant1 values('G243','2011/06/05','388/ENC/02','L010','800134235v','900569211v');
INSERT INTO Grant1 values('G345','2012/06/05','388/ENC/03','L004','650134235v','910569211v');
INSERT INTO Grant1 values('G222','2011/06/05','407/ENC/02','L002','780134243v','940669211v');
INSERT INTO Grant1 values('G467','2013/06/05','388/ENC/06','L009','770134253v','940569611v');
INSERT INTO Grant1 values('G500','2013/06/05','388/ENC/05','L012','710134253v','920569211v');
INSERT INTO Grant1 values('G488','2013/06/05','388/ENC/04','L003','740134253v','910569211v');































