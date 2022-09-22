-- GET User by ID
Select ID from [User]
where Email = ? and Password = ?
-- Update Password
 UPDATE [User]
 SET 
 Password = ?
 WHERE ID= ?
-- Insert new User Register 
INSERT INTO [dbo].[User]
           ([Role],[Email],[Password],[Avatar]
           ,[FirstName],[LastName],[Gender]
           ,[Phone],[Address],[DateRegister]
           ,[IsActive],[StoreID])
     VALUES
           (?,?,?,?,?,?,?,?,?,?,?,?)
GO