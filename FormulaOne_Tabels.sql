USE FormulaOne;

/*
****************************
CREATE TABLES
****************************
*/

CREATE TABLE Seasons
(
	ID INT NOT NULL,
	SeasonRefID  INT NOT NULL,
	Season INT,
    PRIMARY KEY (SeasonRefID)
);
ALTER TABLE `Seasons` ADD INDEX(`ID`);
ALTER TABLE `Seasons` CHANGE `ID` `ID` INT NOT NULL AUTO_INCREMENT;

CREATE TABLE Country
(
	ID INT NOT NULL,
	CountryID INT NOT NULL,
	Country	varchar(50),
    PRIMARY KEY (CountryID)
);
ALTER TABLE `Country` ADD INDEX(`ID`);
ALTER TABLE `Country` CHANGE `ID` `ID` INT NOT NULL AUTO_INCREMENT;

CREATE TABLE CircuitType
(
	ID INT NOT NULL,
	TypeRefID INT NOT NULL,
	CircuitType varchar(30) NOT NULL,	
    PRIMARY KEY (TypeRefID)
);
ALTER TABLE `CircuitType` ADD INDEX(`ID`);
ALTER TABLE `CircuitType` CHANGE `ID` `ID` INT NOT NULL AUTO_INCREMENT;

CREATE TABLE CircuitDirections
(
	ID INT AUTO_INCREMENT NOT NULL,
	DirectionRefID INT NOT NULL,
	Direction varchar(100),	
    PRIMARY KEY (DirectionRefID)
);
ALTER TABLE `CircuitDirections` ADD INDEX(`ID`);
ALTER TABLE `CircuitDirections` CHANGE `ID` `ID` INT NOT NULL AUTO_INCREMENT;


CREATE TABLE Drivers
(
	ID INT NOT NULL,
	DriverID INT NOT NULL,
	DriverName nvarchar(50),	
	CountryID INT,
	RaceEntries	INT,
	RaceStarts INT,
	PolePositions INT,
	RaceWins INT,
	Podiums INT,
	FastestLaps INT,	
	Points DECIMAL(6,2),
    PRIMARY KEY (DriverID)
);
ALTER TABLE `Drivers` ADD INDEX(`ID`);
ALTER TABLE `Drivers` CHANGE `ID` `ID` INT NOT NULL AUTO_INCREMENT;

CREATE TABLE DriversStandings
(
	DriverStandingID INT NOT NULL,
	DriverID INT,
	SeasonID INT,
	Points DECIMAL(6,2) DEFAULT 0,
	DateAdded DATETIME DEFAULT NULL,
	LastUpdated DATETIME, 
    PRIMARY KEY (DriverStandingID)
);
ALTER TABLE `DriversStandings` ADD INDEX(`DriverStandingID`);
ALTER TABLE `DriversStandings` CHANGE `DriverStandingID` `DriverStandingID` INT NOT NULL AUTO_INCREMENT;

CREATE TABLE DriversSeasons
(
	ID INT NOT NULL,
	DriverID INT NOT NULL,	
	SeasonRefID INT,
    PRIMARY KEY (ID)
);
ALTER TABLE `DriversSeasons` ADD INDEX(`ID`);
ALTER TABLE `DriversSeasons` CHANGE `ID` `ID` INT NOT NULL AUTO_INCREMENT;

CREATE TABLE DriversChampionships
(
	ID INT NOT NULL,
	DriverID  INT NOT NULL,	
	SeasonRefID INT,
    PRIMARY KEY (ID)
);
ALTER TABLE `DriversChampionships` ADD INDEX(`ID`);
ALTER TABLE `DriversChampionships` CHANGE `ID` `ID` INT NOT NULL AUTO_INCREMENT;

CREATE TABLE Constructors
(
	ID INT NOT NULL,
	ConstructorID INT NOT NULL,
	Constructor varchar(100),		
	CountryID INT,	
	RacesEntered INT,	
	RacesStarted INT, 	
	Drivers INT,	
	TotalEntries INT,	
	Wins INT,	
	Points INT,	
	Poles INT,	
	FL INT,	
	Podiums INT,	
	WCC INT,
	WDC INT,
    PRIMARY KEY (ConstructorID)
);
ALTER TABLE `Constructors` ADD INDEX(`ID`);
ALTER TABLE `Constructors` CHANGE `ID` `ID` INT NOT NULL AUTO_INCREMENT;

CREATE TABLE ConstructorsSeasons
(
	ID INT NOT NULL,
	ConstructorID INT,
	SeasonID INT,
    PRIMARY KEY (ID)
);
ALTER TABLE `ConstructorsSeasons` ADD INDEX(`ID`);
ALTER TABLE `ConstructorsSeasons` CHANGE `ID` `ID` INT NOT NULL AUTO_INCREMENT;

CREATE TABLE ConstructorStandings
(
	ConstructorStandingID INT NOT NULL,
	ConstructorID INT,
	SeasonID INT,
	Points DECIMAL(6,2) DEFAULT 0,
	DateAdded DATETIME DEFAULT NULL,
	LastUpdated DATETIME, 
    PRIMARY KEY (ConstructorStandingID)
);
ALTER TABLE `ConstructorStandings` ADD INDEX(`ConstructorStandingID`);
ALTER TABLE `ConstructorStandings` CHANGE `ConstructorStandingID` `ConstructorStandingID` INT NOT NULL AUTO_INCREMENT;

CREATE TABLE ConstructorNationality
(
	ID INT NOT NULL,
	ContructorID INT,	
	CountryID INT,
    PRIMARY KEY (ID)
);
ALTER TABLE `ConstructorNationality` ADD INDEX(`ID`);
ALTER TABLE `ConstructorNationality` CHANGE `ID` `ID` INT NOT NULL AUTO_INCREMENT;

CREATE TABLE Circuits
(
	CircuitID INT NOT NULL,
	Circuit varchar(200) NOT NULL,	
	GrandPrix varchar(200) NOT NULL,		
	TypeRefID INT,	
	DirectionRefID INT,	
	LastLengthUsed DECIMAL(5,3),	
	GrandPrixHeld INT,
    PRIMARY KEY (CircuitID)
);

CREATE TABLE CircuitImages
(
	ImageID INT NOT NULL,
	CircuitID INT,
	ImageURL nvarchar(1000),
    PRIMARY KEY (ImageID)
);
ALTER TABLE `CircuitImages` ADD INDEX(`ImageID`);
ALTER TABLE `CircuitImages` CHANGE `ImageID` `ImageID` INT NOT NULL AUTO_INCREMENT;

CREATE TABLE CircuitsLocation
(
	LocationID INT AUTO_INCREMENT NOT NULL,
	CircuitID INT,
	CircuitLocation varchar(50),
	CountryID INT,
	Locale varchar(50),
	Longitude varchar(100),
	Latitude varchar(100),
	PRIMARY KEY (LocationID)
);
ALTER TABLE `CircuitsLocation` ADD INDEX(`LocationID`);
ALTER TABLE `CircuitsLocation` CHANGE `LocationID` `LocationID` INT NOT NULL AUTO_INCREMENT;

CREATE TABLE CircuitSeasons
(
	ID INT AUTO_INCREMENT NOT NULL,
	CircuitID INT,	
	SeasonID INT,
	PRIMARY KEY (ID)
);
ALTER TABLE `CircuitSeasons` ADD INDEX(`ID`);
ALTER TABLE `CircuitSeasons` CHANGE `ID` `ID` INT NOT NULL AUTO_INCREMENT;

/*
****************************
CREATE THE RELATIONSHIPS 
****************************
*/

ALTER TABLE Drivers ADD CONSTRAINT FK_Drivers_CountryID FOREIGN KEY (CountryID) REFERENCES Country(CountryID);

ALTER TABLE DriversSeasons ADD CONSTRAINT FK_DriversSeasons_DriverID  FOREIGN KEY (DriverID) REFERENCES Drivers(DriverID);
ALTER TABLE DriversSeasons ADD CONSTRAINT FK_DriversSeasons_SeasonRefID  FOREIGN KEY (SeasonRefID) REFERENCES Seasons(SeasonRefID);

ALTER TABLE DriversChampionships ADD CONSTRAINT FK_DriversChampionships_DriverID  FOREIGN KEY (DriverID) REFERENCES Drivers(DriverID);
ALTER TABLE DriversChampionships ADD CONSTRAINT FK_DriversChampionships_SeasonRefID  FOREIGN KEY (SeasonRefID) REFERENCES Seasons(SeasonRefID);

ALTER TABLE CircuitsLocation ADD CONSTRAINT FK_CircuitsLocation_CountryID  FOREIGN KEY (CountryID) REFERENCES Country(CountryID);
ALTER TABLE CircuitsLocation ADD CONSTRAINT FK_CircuitsLocation_CircuitID  FOREIGN KEY (CircuitID) REFERENCES Circuits(CircuitID);

ALTER TABLE CircuitImages ADD CONSTRAINT FK_CircuitImages_CircuitID  FOREIGN KEY (CircuitID) REFERENCES Circuits(CircuitID);

ALTER TABLE Circuits ADD CONSTRAINT FK_Circuits_TypeRefID  FOREIGN KEY (TypeRefID) REFERENCES CircuitType(TypeRefID);
ALTER TABLE Circuits ADD CONSTRAINT FK_Circuits_DirectionRefID  FOREIGN KEY (DirectionRefID) REFERENCES CircuitDirections(DirectionRefID);

ALTER TABLE ConstructorNationality ADD CONSTRAINT FK_ConstructorNationality_ConstructorID  FOREIGN KEY (ContructorID) REFERENCES Constructors(ConstructorID);
ALTER TABLE ConstructorNationality ADD CONSTRAINT FK_ConstructorNationality_CountryID  FOREIGN KEY (CountryID) REFERENCES Country(CountryID);

ALTER TABLE ConstructorsSeasons ADD CONSTRAINT FK_ConstructorsSeasons_ConstructorID  FOREIGN KEY (ConstructorID) REFERENCES Constructors(ConstructorID);
ALTER TABLE ConstructorsSeasons ADD CONSTRAINT FK_ConstructorsSeasons_SeasonRefID  FOREIGN KEY (SeasonID) REFERENCES Seasons(SeasonRefID);

ALTER TABLE Constructors ADD CONSTRAINT FK_Constructors_CountryID  FOREIGN KEY (CountryID) REFERENCES Country(CountryID);

ALTER TABLE CircuitSeasons ADD CONSTRAINT FK_CircuitSeasons_CircuitID  FOREIGN KEY (CircuitID) REFERENCES Circuits(CircuitID);
ALTER TABLE CircuitSeasons ADD CONSTRAINT FK_CircuitSeasons_SeasonRefID  FOREIGN KEY (SeasonID) REFERENCES Seasons(SeasonRefID);