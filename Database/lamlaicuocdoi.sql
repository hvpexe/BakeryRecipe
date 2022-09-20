CREATE DATABASE BakeryRecipe
USE BakeryRecipe
-- DROP DATABASE BakeryRecipe
DBCC FREEPROCCACHE
DBCC DROPCLEANBUFFERS
CREATE TABLE Comment (ID int IDENTITY(1, 1) NOT NULL, Comment nvarchar(500) NOT NULL, Rate bit NOT NULL, DateComment datetime NOT NULL, LastDateEdit datetime NULL, IsDeleted bit NOT NULL, UserID int NOT NULL, RecipeID int NOT NULL, CONSTRAINT PK__Comments__C3B4DFAABAE3DA4F PRIMARY KEY (ID));
CREATE TABLE Follow (UserID int NOT NULL, UserID2 int NOT NULL, PRIMARY KEY (UserID, UserID2));
CREATE TABLE Ingredient (ID int IDENTITY(1, 1) NOT NULL, Name nvarchar(50) NOT NULL, Img varchar(100) NOT NULL, CONSTRAINT PK_Ingredient PRIMARY KEY (ID));
CREATE TABLE IngredientRecipe (IngredientID int NOT NULL, RecipeID int NOT NULL, PRIMARY KEY (IngredientID, RecipeID));
CREATE TABLE Instruction (ID int IDENTITY(1, 1) NOT NULL, InsStep int NOT NULL, Detail text NOT NULL, Img varchar(100) NULL, CONSTRAINT PK_Instruction PRIMARY KEY (ID));
CREATE TABLE InstructionRecipe (InstructionID int NOT NULL, RecipeID int NOT NULL, PRIMARY KEY (InstructionID, RecipeID));
CREATE TABLE [Order] (ID int IDENTITY(1, 1) NOT NULL, DateOrder int NOT NULL, Total int NOT NULL, Phone varchar(15) NOT NULL, Address nvarchar(100) NOT NULL, Shipper nvarchar(20) NOT NULL, IsDeleted bit NOT NULL, IsFullfilled bit NOT NULL, UserID int NOT NULL, CONSTRAINT PK__Orders__C3905BAFF16F0529 PRIMARY KEY (ID));
CREATE TABLE Picture (ID int IDENTITY(1, 1) NOT NULL, img varchar(100) NOT NULL, RecipeID int NOT NULL, CONSTRAINT PK_PostImg PRIMARY KEY (ID));
CREATE TABLE Product (ID int IDENTITY(1, 1) NOT NULL, Name nvarchar(50) NOT NULL, Price int NOT NULL, Quantity int NOT NULL, Detail text NULL, img varchar(100) NOT NULL, type nvarchar(50) NOT NULL, IsDeleted bit NOT NULL, IngredientID int NULL, StoreID int NOT NULL, CONSTRAINT PK__Products__B40CC6ED11F92BC5 PRIMARY KEY (ID));
CREATE TABLE ProductOrder (ProductID int NOT NULL, OrderID int NOT NULL, Price int NOT NULL, Quantity int NOT NULL, PRIMARY KEY (ProductID, OrderID));
CREATE TABLE Recipe (ID int IDENTITY(1, 1) NOT NULL, Name nvarchar(100) NOT NULL, Description nvarchar(500) NULL, [Like] int NOT NULL, Dislike int NOT NULL, DatePost datetime NOT NULL, LastDateEdit datetime NULL, PrepTime int NULL, CookTime int NULL, Saved int NOT NULL, IsDeleted bit NOT NULL, UserID int NOT NULL, CONSTRAINT PK__Posts__AA1260380751D4EE PRIMARY KEY (ID));
CREATE TABLE ReportComment (ID int NOT NULL, DateReport datetime NOT NULL, Detail nvarchar(500) NOT NULL, CommentID int NOT NULL, UserID int NOT NULL, CONSTRAINT PK_ReportComments PRIMARY KEY (ID, CommentID, UserID));
CREATE TABLE ReportRecipe (ID int NOT NULL, DateReport datetime NOT NULL, Detail nvarchar(500) NOT NULL, RecipeID int NOT NULL, UserID int NOT NULL, CONSTRAINT PK_ReportPosts PRIMARY KEY (ID, RecipeID, UserID));
CREATE TABLE [Save] (RecipeID int NOT NULL, UserID int NOT NULL, PRIMARY KEY (RecipeID, UserID));
CREATE TABLE Store (ID int IDENTITY(1, 1) NOT NULL, Name nvarchar(50) NOT NULL, DateRegister date NOT NULL, Logo varchar(100) NOT NULL, Address nvarchar(100) NOT NULL, Email varchar(100) NOT NULL, Phone varchar(15) NOT NULL, IsActive bit NOT NULL, UserID int NOT NULL, CONSTRAINT PK_Stores PRIMARY KEY (ID));
CREATE TABLE [User] (ID int IDENTITY(1, 1) NOT NULL, Role nvarchar(10) NOT NULL, Email varchar(100) NOT NULL, Password varchar(50) NOT NULL, Avatar varchar(100) NULL, FirstName nvarchar(50) NOT NULL, LastName nvarchar(50) NOT NULL, Gender nvarchar(10) NOT NULL, Phone varchar(15) NULL, Address nvarchar(100) NULL, DateRegister date NOT NULL, IsActive bit NOT NULL, StoreID int NULL, CONSTRAINT PK__Users__1788CCAC6665F995 PRIMARY KEY (ID), CONSTRAINT UQ__Users__A9D10534B9A735C3 UNIQUE (Email));
CREATE TABLE Video (ID int IDENTITY NOT NULL, link varchar(100) NOT NULL, RecipeID int NOT NULL, PRIMARY KEY (ID));
ALTER TABLE Product ADD CONSTRAINT FKProduct215436 FOREIGN KEY (IngredientID) REFERENCES Ingredient (ID);
ALTER TABLE Video ADD CONSTRAINT FKVideo383719 FOREIGN KEY (RecipeID) REFERENCES Recipe (ID);
ALTER TABLE Picture ADD CONSTRAINT FKPicture325360 FOREIGN KEY (RecipeID) REFERENCES Recipe (ID);
ALTER TABLE Store ADD CONSTRAINT FKStore298808 FOREIGN KEY (UserID) REFERENCES [User] (ID);
ALTER TABLE [Save] ADD CONSTRAINT FKSave947561 FOREIGN KEY (UserID) REFERENCES [User] (ID);
ALTER TABLE [Save] ADD CONSTRAINT FKSave303065 FOREIGN KEY (RecipeID) REFERENCES Recipe (ID);
ALTER TABLE IngredientRecipe ADD CONSTRAINT FKIngredient611333 FOREIGN KEY (RecipeID) REFERENCES Recipe (ID);
ALTER TABLE IngredientRecipe ADD CONSTRAINT FKIngredient453484 FOREIGN KEY (IngredientID) REFERENCES Ingredient (ID);
ALTER TABLE InstructionRecipe ADD CONSTRAINT FKInstructio103000 FOREIGN KEY (RecipeID) REFERENCES Recipe (ID);
ALTER TABLE InstructionRecipe ADD CONSTRAINT FKInstructio407154 FOREIGN KEY (InstructionID) REFERENCES Instruction (ID);
ALTER TABLE Follow ADD CONSTRAINT FKFollow945429 FOREIGN KEY (UserID2) REFERENCES [User] (ID);
ALTER TABLE Follow ADD CONSTRAINT FKFollow361093 FOREIGN KEY (UserID) REFERENCES [User] (ID);
ALTER TABLE ProductOrder ADD CONSTRAINT FKProductOrd41715 FOREIGN KEY (OrderID) REFERENCES [Order] (ID);
ALTER TABLE ProductOrder ADD CONSTRAINT FKProductOrd608164 FOREIGN KEY (ProductID) REFERENCES Product (ID);
ALTER TABLE [Order] ADD CONSTRAINT FKOrder63439 FOREIGN KEY (UserID) REFERENCES [User] (ID);
ALTER TABLE Product ADD CONSTRAINT FKProduct783174 FOREIGN KEY (StoreID) REFERENCES Store (ID);
ALTER TABLE ReportComment ADD CONSTRAINT FKReportComm316353 FOREIGN KEY (UserID) REFERENCES [User] (ID);
ALTER TABLE ReportRecipe ADD CONSTRAINT FKReportReci740530 FOREIGN KEY (UserID) REFERENCES [User] (ID);
ALTER TABLE Comment ADD CONSTRAINT FKComment816296 FOREIGN KEY (RecipeID) REFERENCES Recipe (ID);
ALTER TABLE Recipe ADD CONSTRAINT FKRecipe405040 FOREIGN KEY (UserID) REFERENCES [User] (ID);
ALTER TABLE Comment ADD CONSTRAINT FKComment537260 FOREIGN KEY (UserID) REFERENCES [User] (ID);
ALTER TABLE ReportComment ADD CONSTRAINT FKReportComm762006 FOREIGN KEY (CommentID) REFERENCES Comment (ID);
ALTER TABLE ReportRecipe ADD CONSTRAINT FKReportReci461494 FOREIGN KEY (RecipeID) REFERENCES Recipe (ID);

INSERT INTO [User](Role, Email, Password, Avatar, FirstName, LastName, Gender, Phone, Address, DateRegister, IsActive, StoreID) 
VALUES 
('admin', 'admin0@gmail.com', '123456789', NULL, 'phu', 'huynh', 'male', '0398550944', null, '2022-01-01', 1, null),
('user', 'user0@gmail.com', '123456789', NULL, 'man', 'vo', 'female', '033333333', null, '2022-01-01', 1, null);

