-- MySQL dump 10.13  Distrib 5.5.42, for Win32 (x86)
--
-- Host: localhost    Database: LandBranch
-- ------------------------------------------------------
-- Server version	5.5.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `NIC` varchar(12) NOT NULL,
  `ClientName` varchar(10) DEFAULT NULL,
  `Birthday` date DEFAULT NULL,
  `Telephone` int(10) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `AnnualIncome` decimal(10,2) DEFAULT NULL,
  `GrantOwnershipPosition` int(2) DEFAULT NULL,
  `PermitOwnershipPosition` int(2) DEFAULT NULL,
  `MarriedStatus` int(1) DEFAULT NULL,
  `NumberOfMarriedSons` int(2) DEFAULT NULL,
  `NumberOfUnmarriedSons` int(2) DEFAULT NULL,
  PRIMARY KEY (`NIC`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES ('200045423','sujeewa','2000-08-03',712345634,'no 45',50000.00,3,0,0,0,0),('200123434V','galunanda','2000-08-09',723456565,'no 435 weligama',80003.00,4,0,1,2,0),('200456342V','binuwa','2000-08-11',893442124,'no 56 rf',67788.00,2,4,1,4,0),('200567434','dilum','2000-08-17',443121324,'no 56 weligama',6700.00,4,0,1,3,0),('650134235v','Sujatha','1965-04-01',710454287,'no  65, Gammudawa ,Weligama',30000.00,1,1,1,0,4),('710134253v','Mlinda','1971-04-01',750454245,'no 75, 5e kanuwa ,Weligama',25600.00,1,1,1,0,1),('730134253v','Sujitha','1973-04-05',720456245,'no 65, 6e kanuwa ,Weligama',23000.00,0,1,1,2,1),('730134267v','Nimalasena','1973-04-05',720456321,'no 05, 6e kanuwa ,Weligama',23000.00,0,0,1,2,1),('740134243v','Guanadasa','1974-04-01',720454279,'no 11, 5e kanuwa ,Weligama',25200.00,0,1,1,0,1),('740134253v','Pavithra','1974-04-01',720454257,'no 95, 5e kanuwa ,Weligama',25200.00,1,1,1,0,1),('760134253v','Akila','1976-04-22',72012245,'no 65, 8e kanuwa ,Weligama',27000.00,0,1,1,2,1),('760134298v','Adikari','1976-04-22',72012211,'no 15, 8e kanuwa ,Weligama',27000.00,0,0,1,0,1),('770134253v','Ganga','1977-04-01',720454245,'no 65, 5e kanuwa ,Weligama',27000.00,1,1,1,0,1),('780134243v','Ganga','1978-04-01',770454245,'no 34,Piliwatta ,Weligama',28000.00,1,1,0,0,0),('790134253v','Madusha','1979-04-26',720454515,'no 65, pansalagoda ,Weligama',27000.00,0,0,1,1,1),('800134235v','Kalum','1980-04-01',710874231,'no 64, Gammudawa ,Weligama',10000.00,1,1,0,0,0),('800134253v','Ranga','1979-04-26',780454515,'no 89, pansalagoda ,Weligama',27000.00,0,0,1,1,1),('8002342354v','Sumanadasa','1980-06-06',710454231,'no 45, Galbokka ,Weligama',20000.00,1,1,1,0,0),('8302532365v','Gunasekara','1983-03-07',710454456,'no 70, Galbokka ,Weligama',25000.00,2,2,1,2,1),('907834322','sumana','1990-08-07',784334344,'no 8453',67676.00,3,0,1,3,0),('920434354','gamunu','1993-08-18',72345643,'no 834',6700.00,2,0,1,2,1);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `currentresidence`
--

DROP TABLE IF EXISTS `currentresidence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `currentresidence` (
  `NIC` varchar(12) NOT NULL,
  `CurrentResidence` varchar(100) DEFAULT NULL,
  `IsOwner` int(1) DEFAULT NULL,
  `IsLandIllegal` int(1) DEFAULT NULL,
  `IsAppliedBefore` int(1) DEFAULT NULL,
  `IsInApplicantList` int(1) DEFAULT NULL,
  PRIMARY KEY (`NIC`),
  CONSTRAINT `currentresidence_ibfk_1` FOREIGN KEY (`NIC`) REFERENCES `client` (`NIC`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `currentresidence`
--

LOCK TABLES `currentresidence` WRITE;
/*!40000 ALTER TABLE `currentresidence` DISABLE KEYS */;
INSERT INTO `currentresidence` VALUES ('650134235v','no  65, Gammudawa ,Weligama',1,1,0,0),('710134253v','no 75, 5e kanuwa ,Weligama',1,1,0,1),('730134253v','no 65, 6e kanuwa ,Weligama',1,1,1,1),('730134267v','no 05, 6e kanuwa ,Weligama',0,1,0,1),('740134243v','no 11, 5e kanuwa ,Weligama',0,1,0,1),('740134253v','no 95, 5e kanuwa ,Weligama',1,1,0,1),('760134253v','no 65, 8e kanuwa ,Weligama',1,1,1,1),('760134298v','no 15, 8e kanuwa ,Weligama',0,1,0,1),('770134253v','no 65, 5e kanuwa ,Weligama',1,1,0,1),('780134243v','no 34,Piliwatta ,Weligama',1,0,0,0),('790134253v','no 65, pansalagoda ,Weligama',1,1,1,1),('800134235v','no 64, Gammudawa ,Weligama',1,0,0,0),('800134253v','no 89, pansalagoda ,Weligama',0,1,0,1),('8002342354v','no 45, Galbokka ,Weligama',1,1,0,0),('8302532365v','no 70, Galbokka ,Weligama',0,1,1,1);
/*!40000 ALTER TABLE `currentresidence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `gnd`
--

DROP TABLE IF EXISTS `gnd`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `gnd` (
  `DivisionNumber` varchar(10) NOT NULL,
  `DivisionName` varchar(30) DEFAULT NULL,
  `GramaNiladariName` varchar(30) DEFAULT NULL,
  `ZoneName` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`DivisionNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `gnd`
--

LOCK TABLES `gnd` WRITE;
/*!40000 ALTER TABLE `gnd` DISABLE KEYS */;
INSERT INTO `gnd` VALUES ('382','Mahavdiya','Sumana','Weligama'),('382A','Paranakade','Sunila','Weligama'),('382B','Hettivdiya','Lankathilaka','Weligama'),('385','Galbokka East','Chandisena','Weligama'),('385B','Galbokka West','Thanura','Weligama'),('388','Polwatta','Ranil','Weligama'),('405','Mirissa North','Sumudu','Polathumodara'),('405A','Udupila','Nalaka','Polathumodara'),('405B','Udumulla','Nimalasena','Polathumodara'),('406','Mirissa South 1','Chandana','Polathumodara'),('406A','Mirissa South 2','Namal','Polathumodara'),('407','Thalaraba South','Gamage','Polathumodara'),('407A','Bandaramulla','Sumudu','Polathumodara'),('407C','Thalaraba East','Charith','Kaburugamuwa'),('408','Kaburugamuwa North','Nadun','Kaburugamuwa'),('408A','Kaburugamuwa West','Sandeepa','Kaburugamuwa'),('408B','Garaduwa','Gayan','Kaburugamuwa'),('408C','Kaburugamuwa South','Asela','Kaburugamuwa'),('408D','Thudalla','Nimal','Kaburugamuwa'),('479A','Pitiduwa','Sanka','Midigama'),('480','Midigama East','Sankalpa','Midigama'),('486A','Walliwala West','Ganga','Midigama'),('486B','Walliwala South','Nirmal','Midigama'),('486C','Kapparathota South','Nipuna','Midigama'),('486D','Kapparathota North','Nisal','Midigama');
/*!40000 ALTER TABLE `gnd` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grant1`
--

DROP TABLE IF EXISTS `grant1`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grant1` (
  `GrantNumber` varchar(50) NOT NULL,
  `GrantIssueDate` date DEFAULT NULL,
  `PermitNumber` varchar(50) NOT NULL,
  `LotNumber` varchar(10) NOT NULL,
  `NIC` varchar(12) NOT NULL,
  `NIC_Successor` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`GrantNumber`,`NIC`),
  KEY `NIC` (`NIC`),
  KEY `NIC_Successor` (`NIC_Successor`),
  KEY `LotNumber` (`LotNumber`),
  KEY `PermitNumber` (`PermitNumber`),
  CONSTRAINT `grant1_ibfk_1` FOREIGN KEY (`NIC`) REFERENCES `client` (`NIC`),
  CONSTRAINT `grant1_ibfk_2` FOREIGN KEY (`NIC_Successor`) REFERENCES `nominatedsuccessor` (`NIC_S`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `grant1_ibfk_3` FOREIGN KEY (`LotNumber`) REFERENCES `lot` (`LotNumber`),
  CONSTRAINT `grant1_ibfk_4` FOREIGN KEY (`PermitNumber`) REFERENCES `permit` (`PermitNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grant1`
--

LOCK TABLES `grant1` WRITE;
/*!40000 ALTER TABLE `grant1` DISABLE KEYS */;
INSERT INTO `grant1` VALUES ('G222','2011-06-05','407/ENC/02','L002','780134243v','983442354'),('G232','2011-06-05','388/ENC/01','L001','200567434','940569211v'),('G232','2011-06-05','388/ENC/01','L001','8002342354v','940569211v'),('G232','2011-06-05','388/ENC/01','L001','8302532365v','940569211v'),('G243','2011-06-05','388/ENC/02','L010','800134235v','900569211v'),('G345','2012-06-05','388/ENC/03','L004','650134235v','910569211v'),('G467','2013-06-05','388/ENC/06','L009','770134253v','940569611v'),('G488','2013-06-05','388/ENC/04','L003','740134253v','910569211v'),('G500','2013-06-05','388/ENC/05','L012','710134253v','920569211v');
/*!40000 ALTER TABLE `grant1` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `land`
--

DROP TABLE IF EXISTS `land`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `land` (
  `PlanNumber` varchar(10) NOT NULL,
  `LandName` varchar(30) DEFAULT NULL,
  `DivisionNumber` varchar(10) NOT NULL,
  `WestBound` varchar(30) DEFAULT NULL,
  `EastBound` varchar(30) DEFAULT NULL,
  `NorthBound` varchar(30) DEFAULT NULL,
  `SouthBound` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`PlanNumber`),
  KEY `DivisionNumber` (`DivisionNumber`),
  CONSTRAINT `land_ibfk_1` FOREIGN KEY (`DivisionNumber`) REFERENCES `gnd` (`DivisionNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `land`
--

LOCK TABLES `land` WRITE;
/*!40000 ALTER TABLE `land` DISABLE KEYS */;
INSERT INTO `land` VALUES ('PL01','Punchiwatta','388','Walukaramaya','Sumangale','','Paluwatta'),('PL02','Sumuduwatta','407','Gangaramaya','Sumithywatta','Main rood',''),('PL03','Dewalawatta','388','kajjukale','Raksawatta','','Rsbutankale'),('PL04','Sirilwatta','408C','Somawansha para','Nelum kale','Patuwatta Kubura',''),('PL05','Charlywatta','406','','','','Salinda Ground'),('PL06','Suriyawatta','486B','Rathu Kubura','Maligawaththa Ground','Malnga Ground','Ruwanikaramaya');
/*!40000 ALTER TABLE `land` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lot`
--

DROP TABLE IF EXISTS `lot`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lot` (
  `LotNumber` varchar(5) NOT NULL,
  `NumberOfAcres` int(3) DEFAULT NULL,
  `NumberOfRoods` int(3) DEFAULT NULL,
  `NumberOfPerches` int(13) DEFAULT NULL,
  `PlanNumber` varchar(10) NOT NULL,
  `isAvailabal` int(2) DEFAULT NULL,
  PRIMARY KEY (`LotNumber`),
  KEY `PlanNumber` (`PlanNumber`),
  CONSTRAINT `lot_ibfk_1` FOREIGN KEY (`PlanNumber`) REFERENCES `land` (`PlanNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lot`
--

LOCK TABLES `lot` WRITE;
/*!40000 ALTER TABLE `lot` DISABLE KEYS */;
INSERT INTO `lot` VALUES ('L001',4,5,3,'PL01',1),('L002',0,5,1,'PL02',1),('L003',4,0,3,'PL03',1),('L004',1,5,3,'PL01',1),('L005',0,10,0,'PL01',0),('L006',0,5,0,'PL01',1),('L007',7,0,0,'PL01',0),('L008',10,0,0,'PL01',0),('L009',0,0,7,'PL01',1),('L010',0,0,20,'PL01',1),('L011',8,0,0,'PL02',0),('L012',0,0,34,'PL03',1),('L013',0,8,0,'PL04',1),('L014',6,0,0,'PL04',0),('L015',0,5,0,'PL05',0),('L016',12,5,0,'PL05',0),('L017',7,5,0,'PL02',0),('L018',0,8,3,'PL03',0),('L019',0,0,22,'PL04',0),('L020',0,10,0,'PL05',0),('L021',14,0,0,'PL02',0),('L022',0,15,0,'PL03',0),('L023',0,0,17,'PL04',1),('L024',0,0,21,'PL05',0),('L025',32,5,3,'PL05',0),('L026',32,5,7,'PL05',0),('L027',0,6,3,'PL03',0);
/*!40000 ALTER TABLE `lot` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nominatedsuccessor`
--

DROP TABLE IF EXISTS `nominatedsuccessor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nominatedsuccessor` (
  `Name` varchar(30) NOT NULL,
  `NIC_S` varchar(11) NOT NULL DEFAULT '',
  `Address` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`NIC_S`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nominatedsuccessor`
--

LOCK TABLES `nominatedsuccessor` WRITE;
/*!40000 ALTER TABLE `nominatedsuccessor` DISABLE KEYS */;
INSERT INTO `nominatedsuccessor` VALUES ('Madusanka','200045678v','no 56 '),('Sunil','900569211v','no 34'),('Gayashan','910569211v','no 47'),('Sudira','920569211v','no 45B'),('Amara','940569211v','no 45'),('Amarapala','9405692145v','no 75'),('Pawan','940569611v','no 32'),('Paala','940669211v','no 89'),('vidya','983442354','no 78 , urubokka'),('nimalaaa','9884545673','no 56');
/*!40000 ALTER TABLE `nominatedsuccessor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `permit`
--

DROP TABLE IF EXISTS `permit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `permit` (
  `PermitNumber` varchar(50) NOT NULL,
  `PermitIssueDate` date DEFAULT NULL,
  `LotNumber` varchar(10) NOT NULL,
  `NIC` varchar(12) NOT NULL,
  `NIC_Successor` varchar(11) DEFAULT NULL,
  `haveGrant` int(1) DEFAULT NULL,
  PRIMARY KEY (`PermitNumber`,`NIC`),
  KEY `NIC` (`NIC`),
  KEY `NIC_Successor` (`NIC_Successor`),
  KEY `LotNumber` (`LotNumber`),
  CONSTRAINT `permit_ibfk_1` FOREIGN KEY (`NIC`) REFERENCES `client` (`NIC`),
  CONSTRAINT `permit_ibfk_2` FOREIGN KEY (`NIC_Successor`) REFERENCES `nominatedsuccessor` (`NIC_S`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `permit_ibfk_3` FOREIGN KEY (`LotNumber`) REFERENCES `lot` (`LotNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `permit`
--

LOCK TABLES `permit` WRITE;
/*!40000 ALTER TABLE `permit` DISABLE KEYS */;
INSERT INTO `permit` VALUES ('','2015-08-17','L006','740134243v','9884545673',0),('388/ENC/01','2010-06-05','L001','8002342354v','940569211v',1),('388/ENC/01','2010-06-05','L001','8302532365v','940569211v',1),('388/ENC/02','2011-06-05','L010','800134235v','900569211v',1),('388/ENC/03','2011-06-05','L004','650134235v','9405692145v',1),('388/ENC/04','2012-06-05','L003','740134253v','910569211v',1),('388/ENC/05','2012-06-05','L012','710134253v','920569211v',1),('388/ENC/06','2012-06-05','L009','770134253v','940569611v',0),('407/ENC/02','2010-06-05','L002','780134243v','940669211v',1),('408C/ENC/01','2015-06-05','L013','760134253v','200045678v',0),('408C/ENC/01','2015-06-05','L013','920434354','200045678v',0);
/*!40000 ALTER TABLE `permit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `username` varchar(20) NOT NULL,
  `password` varchar(400) NOT NULL,
  `power` int(1) NOT NULL,
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-08-17 15:00:49
