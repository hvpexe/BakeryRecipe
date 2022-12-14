USE [master]
GO
/****** Object:  Database [BakeryRecipe]    Script Date: 11/3/2022 11:19:58 PM ******/
CREATE DATABASE [BakeryRecipe]
 CONTAINMENT = NONE
GO
ALTER DATABASE [BakeryRecipe] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [BakeryRecipe].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [BakeryRecipe] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [BakeryRecipe] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [BakeryRecipe] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [BakeryRecipe] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [BakeryRecipe] SET ARITHABORT OFF 
GO
ALTER DATABASE [BakeryRecipe] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [BakeryRecipe] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [BakeryRecipe] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [BakeryRecipe] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [BakeryRecipe] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [BakeryRecipe] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [BakeryRecipe] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [BakeryRecipe] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [BakeryRecipe] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [BakeryRecipe] SET  ENABLE_BROKER 
GO
ALTER DATABASE [BakeryRecipe] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [BakeryRecipe] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [BakeryRecipe] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [BakeryRecipe] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [BakeryRecipe] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [BakeryRecipe] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [BakeryRecipe] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [BakeryRecipe] SET RECOVERY FULL 
GO
ALTER DATABASE [BakeryRecipe] SET  MULTI_USER 
GO
ALTER DATABASE [BakeryRecipe] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [BakeryRecipe] SET DB_CHAINING OFF 
GO
ALTER DATABASE [BakeryRecipe] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [BakeryRecipe] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [BakeryRecipe] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [BakeryRecipe] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'BakeryRecipe', N'ON'
GO
ALTER DATABASE [BakeryRecipe] SET QUERY_STORE = OFF
GO
USE [BakeryRecipe]
GO
/****** Object:  FullTextCatalog [recipe_ctlg]    Script Date: 11/3/2022 11:19:58 PM ******/
CREATE FULLTEXT CATALOG [recipe_ctlg] WITH ACCENT_SENSITIVITY = OFF
GO
/****** Object:  Table [dbo].[Comment]    Script Date: 11/3/2022 11:19:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Comment](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Comment] [nvarchar](500) NOT NULL,
	[DateComment] [datetime] NOT NULL,
	[LastDateEdit] [datetime] NULL,
	[IsDeleted] [bit] NOT NULL,
	[UserID] [int] NOT NULL,
	[RecipeID] [int] NOT NULL,
 CONSTRAINT [PK__Comments__C3B4DFAABAE3DA4F] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Follow]    Script Date: 11/3/2022 11:19:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Follow](
	[UserID] [int] NOT NULL,
	[UserID2] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[UserID] ASC,
	[UserID2] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Ingredient]    Script Date: 11/3/2022 11:19:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ingredient](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Img] [varchar](100) NULL,
	[Point] [int] NULL,
 CONSTRAINT [PK_Ingredient] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[IngredientRecipe]    Script Date: 11/3/2022 11:19:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[IngredientRecipe](
	[RecipeID] [int] NOT NULL,
	[IngredientID] [int] NOT NULL,
	[Amount] [nvarchar](50) NULL,
 CONSTRAINT [PK__Ingredie__A1732AF709FB3F20] PRIMARY KEY CLUSTERED 
(
	[IngredientID] ASC,
	[RecipeID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Instruction]    Script Date: 11/3/2022 11:19:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Instruction](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[InsStep] [int] NOT NULL,
	[Detail] [text] NOT NULL,
	[Img] [varchar](100) NULL,
	[RecipeID] [int] NOT NULL,
 CONSTRAINT [PK_Instruction] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Like]    Script Date: 11/3/2022 11:19:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Like](
	[RecipeID] [int] NOT NULL,
	[UserID] [int] NOT NULL,
 CONSTRAINT [PK_Like] PRIMARY KEY CLUSTERED 
(
	[RecipeID] ASC,
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Picture]    Script Date: 11/3/2022 11:19:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Picture](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Img] [varchar](100) NOT NULL,
	[IsCover] [bit] NOT NULL,
	[RecipeID] [int] NOT NULL,
 CONSTRAINT [PK_PostImg] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Recipe]    Script Date: 11/3/2022 11:19:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Recipe](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](100) NOT NULL,
	[Description] [nvarchar](500) NULL,
	[Like] [int] NOT NULL,
	[Save] [int] NOT NULL,
	[Comment] [int] NOT NULL,
	[Video] [varchar](100) NULL,
	[DatePost] [datetime] NOT NULL,
	[LastDateEdit] [datetime] NULL,
	[PrepTime] [int] NULL,
	[CookTime] [int] NULL,
	[IsDeleted] [bit] NOT NULL,
	[UserID] [int] NOT NULL,
 CONSTRAINT [PK__Posts__AA1260380751D4EE] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ReportComment]    Script Date: 11/3/2022 11:19:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ReportComment](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Detail] [nvarchar](500) NULL,
	[CommentID] [int] NOT NULL,
	[UserID] [int] NOT NULL,
	[DateReport] [datetime] NOT NULL,
	[ReportType] [nvarchar](50) NOT NULL,
	[Status] [varchar](15) NOT NULL,
 CONSTRAINT [PK_ReportComment] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ReportRecipe]    Script Date: 11/3/2022 11:19:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ReportRecipe](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Detail] [nvarchar](500) NULL,
	[RecipeID] [int] NOT NULL,
	[UserID] [int] NOT NULL,
	[DateReport] [datetime] NOT NULL,
	[ReportType] [nvarchar](50) NOT NULL,
	[Status] [varchar](15) NOT NULL,
 CONSTRAINT [PK__ReportRe__3214EC277AFF1799] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[ReportUser]    Script Date: 11/3/2022 11:19:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ReportUser](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Detail] [nvarchar](500) NULL,
	[UserID] [int] NOT NULL,
	[UserID2] [int] NOT NULL,
	[DateReport] [datetime] NOT NULL,
	[ReportType] [nvarchar](50) NOT NULL,
	[Status] [varchar](15) NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Save]    Script Date: 11/3/2022 11:19:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Save](
	[RecipeID] [int] NOT NULL,
	[UserID] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[RecipeID] ASC,
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 11/3/2022 11:19:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Role] [nvarchar](10) NOT NULL,
	[Email] [varchar](100) NOT NULL,
	[Password] [varchar](50) NULL,
	[Avatar] [varchar](300) NULL,
	[FirstName] [nvarchar](50) NOT NULL,
	[LastName] [nvarchar](50) NULL,
	[Gender] [nvarchar](10) NULL,
	[Phone] [varchar](15) NULL,
	[Address] [nvarchar](100) NULL,
	[Follower] [int] NULL,
	[Following] [int] NULL,
	[DateRegister] [date] NOT NULL,
	[IsActive] [bit] NOT NULL,
	[StoreID] [int] NULL,
	[Birthday] [date] NULL,
 CONSTRAINT [PK__Users__1788CCAC6665F995] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Comment] ON 

INSERT [dbo].[Comment] ([ID], [Comment], [DateComment], [LastDateEdit], [IsDeleted], [UserID], [RecipeID]) VALUES (2, N'Very good ! I added some chocolate chips inside of them as well. I also didn''t put them in the fridge for 2 hours as the instructions said I just just made them. :)', CAST(N'2022-07-01T00:00:00.000' AS DateTime), NULL, 0, 11, 9)
INSERT [dbo].[Comment] ([ID], [Comment], [DateComment], [LastDateEdit], [IsDeleted], [UserID], [RecipeID]) VALUES (4, N'I can never make them look as pretty as they do in the pictures, but they taste nice 😂
I skipped the refrigeration because I''m impatient so maybe that''s why', CAST(N'2022-07-08T00:00:00.000' AS DateTime), NULL, 0, 13, 9)
INSERT [dbo].[Comment] ([ID], [Comment], [DateComment], [LastDateEdit], [IsDeleted], [UserID], [RecipeID]) VALUES (5, N'The dough for this is extremely crumbly I don’t know if it’s supposed to be that way or what. But I followed the recipe and checked over and over to see if I did something wrong but I can’t figure out why. They also never fell I had to flatten them myself.', CAST(N'2022-07-09T00:00:00.000' AS DateTime), NULL, 0, 14, 9)
INSERT [dbo].[Comment] ([ID], [Comment], [DateComment], [LastDateEdit], [IsDeleted], [UserID], [RecipeID]) VALUES (6, N'I love peanut butter cookies so this is a permanent go to in my household', CAST(N'2022-07-10T00:00:00.000' AS DateTime), NULL, 0, 3, 9)
INSERT [dbo].[Comment] ([ID], [Comment], [DateComment], [LastDateEdit], [IsDeleted], [UserID], [RecipeID]) VALUES (7, N'It is so good', CAST(N'2022-07-07T00:00:00.000' AS DateTime), NULL, 0, 3, 2)
INSERT [dbo].[Comment] ([ID], [Comment], [DateComment], [LastDateEdit], [IsDeleted], [UserID], [RecipeID]) VALUES (8, N'It is so good', CAST(N'2022-07-07T00:00:00.000' AS DateTime), NULL, 0, 15, 4)
INSERT [dbo].[Comment] ([ID], [Comment], [DateComment], [LastDateEdit], [IsDeleted], [UserID], [RecipeID]) VALUES (9, N'So delicious and easy! Great rich chocolate flavor, and easy to veganize. All family members liked.', CAST(N'2022-07-07T00:00:00.000' AS DateTime), NULL, 1, 15, 5)
SET IDENTITY_INSERT [dbo].[Comment] OFF
GO
INSERT [dbo].[Follow] ([UserID], [UserID2]) VALUES (3, 5)
INSERT [dbo].[Follow] ([UserID], [UserID2]) VALUES (3, 11)
INSERT [dbo].[Follow] ([UserID], [UserID2]) VALUES (15, 3)
GO
SET IDENTITY_INSERT [dbo].[Ingredient] ON 

INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (1, N'egg', N'egg.png', 3)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (2, N'flour', N'flour.png', 1)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (3, N'butter', N'butter.jpg', 3)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (4, N'sugar', N'salt.jpg', 1)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (5, N'salt', N'sugar.jpg', 1)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (6, N'milk', N'milk.png', 3)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (7, N'baking soda', N'bakingsoda.jpg', 3)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (8, N'all-purpose flour', N'all-purposeflour.jpg', 3)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (9, N'baking powder', N'bakingpowder.jpg', 3)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (10, N'unsalted butter', N'unsaltedbutter.jpg', 5)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (11, N'granulated sugar', N'granulatedsugar.jpg', 3)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (12, N'buttermilk', N'buttermilk.jpg', 3)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (13, N'vanilla extract', N'vanillaextract.jpg', 5)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (14, N'semi-sweet chocolate chips', N'semi-sweet.jpg', 8)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (15, N'almond flour', N'almondflour.jpg', 3)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (16, N'unsweetened almond milk', N'unsweetenedalmondmilk.jpg', 5)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (17, N'lemon', N'lemon.jpg', 1)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (18, N'banana', N'banana.png', 3)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (19, N'chilli pepper', N'chilli_pepper.png', 1)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (20, N'golden caster sugar', N'Goldencastersugar.jpg', 3)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (21, N'self raising flour', N'Selfraisingflour.jpg', 3)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (22, N'ground almond', N'Groundalmond.jpg', 5)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (23, N'ground cinnamon', N'groundcinnamon.jpg', 5)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (24, N'nutmeg', N'nutmeg.jpg', 5)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (25, N'apple cider', N'applecider.jpg', 8)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (30, N'smooth peanut butter', N'e82a41a72062df5fe568461b87b52372.jpg', 5)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (31, N'Brown sugar', N'cbf086e8c3e5542c06e094f36cea1378.jpg', 3)
INSERT [dbo].[Ingredient] ([ID], [Name], [Img], [Point]) VALUES (32, N'all-purpose bleached', N'f9fbc23db97a0b2cbd8e99dff7f851f1.jpg', 5)
SET IDENTITY_INSERT [dbo].[Ingredient] OFF
GO
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (4, 1, N'3')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (5, 1, N'3')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (6, 1, N'2')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (9, 1, N'1')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (17, 1, N'1 ')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (2, 2, N'2')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (4, 2, N'1/2 cup')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (4, 3, N'1/2 cup')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (5, 3, N'175g')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (2, 5, N'2.5g')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (4, 5, N'1/2 tsp')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (6, 5, N'1 teaspoon')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (9, 5, N'1/2 teaspoon')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (18, 5, N'1')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (2, 7, N'5g')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (6, 7, N'1/2 teaspoon')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (2, 8, N'315g')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (6, 8, N'2 and 1/2 cups')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (2, 9, N'13g')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (4, 9, N'1 and 1/2 tsp')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (6, 9, N'2 teaspoons')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (2, 10, N'1/2 cup')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (9, 10, N'1/2 cup')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (2, 11, N'1 cup')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (6, 11, N'1 cup')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (9, 11, N'1/2 cup')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (2, 12, N'1 cup')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (2, 13, N'15ml')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (4, 13, N'1 tsp')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (5, 13, N'3 drops')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (9, 13, N'teaspoon')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (2, 14, N'275g')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (4, 15, N'2 and 1/2 cup')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (4, 16, N'1/3 cup')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (4, 17, N'1/2')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (5, 17, N'1')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (5, 20, N'175g')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (5, 21, N'200g')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (5, 22, N'50g')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (6, 22, N'1 teaspoon')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (6, 23, N'1 teaspoon')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (6, 24, N'1/2 teaspoon')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (6, 25, N'3/4 cup')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (9, 30, N'1/2 cup')
INSERT [dbo].[IngredientRecipe] ([RecipeID], [IngredientID], [Amount]) VALUES (9, 31, N'1/2 cup')
GO
SET IDENTITY_INSERT [dbo].[Instruction] ON 

INSERT [dbo].[Instruction] ([ID], [InsStep], [Detail], [Img], [RecipeID]) VALUES (2, 1, N'Preheat oven to 425°F. Spray a 12 cup muffin tray with non-stick cooking spray or line with paper liners.', NULL, 2)
INSERT [dbo].[Instruction] ([ID], [InsStep], [Detail], [Img], [RecipeID]) VALUES (3, 2, N'In a large bowl, toss together the flour, baking powder, baking soda, salt and chocolate chips. Set aside.', NULL, 2)
INSERT [dbo].[Instruction] ([ID], [InsStep], [Detail], [Img], [RecipeID]) VALUES (4, 3, N'In a medium bowl, whisk together the melted butter, sugar, eggs, milk and vanilla. Slowly add to the dry ingredients. Gently fold together until JUST combined.', NULL, 2)
INSERT [dbo].[Instruction] ([ID], [InsStep], [Detail], [Img], [RecipeID]) VALUES (5, 4, N'Divide the batter into the 12 muffin cups and bake at 425°F for 5 minutes. Then reduce the oven temperature to 375°F and continue to bake for another 12-15 minutes or until a toothpick inserted into the center comes out clean. Do not overbake or the muffins will be dry. Let cool for about 5-10 minutes and enjoy warm.', NULL, 2)
INSERT [dbo].[Instruction] ([ID], [InsStep], [Detail], [Img], [RecipeID]) VALUES (6, 1, N'Preheat oven to 350° and line a 12-cup muffin pan with cupcake liners.', NULL, 4)
INSERT [dbo].[Instruction] ([ID], [InsStep], [Detail], [Img], [RecipeID]) VALUES (7, 2, N'In a large bowl, whisk to combine almond flour, Swerve, baking powder, baking soda, and salt. Whisk in melted butter, almond milk, eggs, and vanilla until just combined.', NULL, 4)
INSERT [dbo].[Instruction] ([ID], [InsStep], [Detail], [Img], [RecipeID]) VALUES (9, 3, N'Gently fold blueberries and lemon zest (if using) until evenly distributed. Scoop equal amounts of batter into each cupcake liner and bake until slightly golden and a toothpick inserted into the center of a muffin comes out clean, 23 minutes. Let cool slightly before serving.', NULL, 4)
INSERT [dbo].[Instruction] ([ID], [InsStep], [Detail], [Img], [RecipeID]) VALUES (10, 1, N'In a large mixing bowl, cream softened butter and peanut butter together with a hand mixer. Mix for 30 seconds. Add both sugars and beat for 3 minutes until light and fluffy. Add egg and vanilla and mix just until combined.', NULL, 9)
INSERT [dbo].[Instruction] ([ID], [InsStep], [Detail], [Img], [RecipeID]) VALUES (11, 2, N'In a medium mixing bowl, whisk together flour, salt and baking soda. Add to butter and sugar mixture in 3 additions, mixing just until combined. If desired, you can add chocolate chips or chopped nuts to the cookie dough. Cover the bowl with dough and place in the fridge for at least 2 hours.', NULL, 9)
INSERT [dbo].[Instruction] ([ID], [InsStep], [Detail], [Img], [RecipeID]) VALUES (14, 3, N'Preheat oven to 350 degrees F. Scoop 1.5 tablespoon size balls of dough, roll in your hands in balls and roll in sugar. Place on baking sheet, about 2" apart, and bake for 8 to 9 minutes. Cool on sheet for 3 to 5 minutes, then remove onto a cooling rack.', NULL, 9)
SET IDENTITY_INSERT [dbo].[Instruction] OFF
GO
INSERT [dbo].[Like] ([RecipeID], [UserID]) VALUES (2, 13)
INSERT [dbo].[Like] ([RecipeID], [UserID]) VALUES (4, 4)
INSERT [dbo].[Like] ([RecipeID], [UserID]) VALUES (15, 3)
GO
SET IDENTITY_INSERT [dbo].[Picture] ON 

INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (2, N'22.jpg', 0, 2)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (3, N'21.jpg', 1, 2)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (4, N'51.jpg', 1, 5)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (5, N'41.jpg', 1, 4)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (6, N'61.jpg', 1, 6)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (8, N'71.jpg', 1, 7)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (9, N'81.jpg', 1, 8)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (10, N'91.jpg', 1, 9)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (11, N'101.jpg', 1, 10)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (12, N'bbgbw3fwezgpzx6hjlzk.jpg', 1, 15)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (13, N'474b9866d66f07462cc5236d2f8d1e69.jpg', 1, 13)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (14, N'chocolate-chip-muffins-3.jpg', 0, 2)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (15, N'The-Best-Keto-Low-Carb-Blueberry-Muffins.jpg', 0, 4)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (16, N'keto-blueberry-muffins-1-of-1.jpg', 0, 4)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (17, N'Madeira loaf cake', 0, 5)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (19, N'picture_0_16.jpg', 1, 16)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (20, N'picture_1_16.jpg', 0, 16)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (21, N'picture_0_17.jpg', 1, 17)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (22, N'picture_1_17.jpg', 0, 17)
INSERT [dbo].[Picture] ([ID], [Img], [IsCover], [RecipeID]) VALUES (23, N'picture_2_17.jpg', 0, 17)
SET IDENTITY_INSERT [dbo].[Picture] OFF
GO
SET IDENTITY_INSERT [dbo].[Recipe] ON 

INSERT [dbo].[Recipe] ([ID], [Name], [Description], [Like], [Save], [Comment], [Video], [DatePost], [LastDateEdit], [PrepTime], [CookTime], [IsDeleted], [UserID]) VALUES (2, N'Bakery Style Chocolate Chip Muffins', N'The BEST chocolate chip muffin recipe - soft, moist, fluffy, loaded with chocolate chips, and a perfect crispy sky-high muffin top!', 1, 6, 1, N'Yu5roFU5EXk', CAST(N'2022-01-01T12:01:03.123' AS DateTime), NULL, 10, 20, 0, 3)
INSERT [dbo].[Recipe] ([ID], [Name], [Description], [Like], [Save], [Comment], [Video], [DatePost], [LastDateEdit], [PrepTime], [CookTime], [IsDeleted], [UserID]) VALUES (4, N'Keto Blueberry Muffins', N'Have a bright morning with Keto Blueberry Muffins from Delish.com.', 1, 2, 1, N'Xp7SMFWiB4I', CAST(N'2022-01-02T02:10:33.000' AS DateTime), NULL, 15, 40, 0, 4)
INSERT [dbo].[Recipe] ([ID], [Name], [Description], [Like], [Save], [Comment], [Video], [DatePost], [LastDateEdit], [PrepTime], [CookTime], [IsDeleted], [UserID]) VALUES (5, N'Madeira loaf cake', N'A classic English sponge cake, delicately flavoured with lemon and almond - perfect for afternoon tea.', 9, 0, 0, N'yKMhlzrHDV4', CAST(N'2022-01-03T00:00:00.000' AS DateTime), NULL, 20, 60, 0, 3)
INSERT [dbo].[Recipe] ([ID], [Name], [Description], [Like], [Save], [Comment], [Video], [DatePost], [LastDateEdit], [PrepTime], [CookTime], [IsDeleted], [UserID]) VALUES (6, N'Cinnamon Vanilla Glazed Apple Cider Donuts', N'These Cinnamon Vanilla Glazed Donuts are baked to perfection with hints of fall spices and sweet apple cider. Covered in a vanilla glaze that''s sweetened with cinnamon, these donuts are easy to make and the perfect treat for fall!', 33, 0, 6, N'h9WGq0y95Dc', CAST(N'2022-01-04T00:00:00.000' AS DateTime), NULL, 10, 15, 0, 3)
INSERT [dbo].[Recipe] ([ID], [Name], [Description], [Like], [Save], [Comment], [Video], [DatePost], [LastDateEdit], [PrepTime], [CookTime], [IsDeleted], [UserID]) VALUES (7, N'PUMPKIN CINNAMON ROLLS', N'These Easy Pumpkin Cinnamon Rolls are a fun twist on the classic kind and ready in just 30 minutes. Filled with sweet pumpkin, cozy spices and topped with the most delicious cream cheese frosting, these rolls are perfect for breakfast or dessert!', 4, 1, 2, N'_-_uSvStZEE', CAST(N'2022-02-05T00:00:00.000' AS DateTime), NULL, 5, 10, 0, 5)
INSERT [dbo].[Recipe] ([ID], [Name], [Description], [Like], [Save], [Comment], [Video], [DatePost], [LastDateEdit], [PrepTime], [CookTime], [IsDeleted], [UserID]) VALUES (8, N'Peanut Butter Blondies', N'This Peanut Butter Blondie recipe is naturally gluten-free, and is sweetened with honey for a healthy dessert. I love that they are flourless and oil-free!', 4, 0, 7, N'tfHSUP4_8i0', CAST(N'2022-04-02T00:00:00.000' AS DateTime), NULL, 10, 20, 0, 3)
INSERT [dbo].[Recipe] ([ID], [Name], [Description], [Like], [Save], [Comment], [Video], [DatePost], [LastDateEdit], [PrepTime], [CookTime], [IsDeleted], [UserID]) VALUES (9, N'Soft and Chewy Peanut Butter Cookies', N'Soft and Chewy Peanut Butter Cookies that taste like roasted peanuts and have slightly crunchy exterior thanks to being rolled in sugar before baking. Easy cookies that will quickly become your favorite. Try dipping in dark chocolate.', 0, 0, 4, N'KKXAYIKkRao', CAST(N'2022-05-06T00:00:00.000' AS DateTime), NULL, 8, 8, 0, 4)
INSERT [dbo].[Recipe] ([ID], [Name], [Description], [Like], [Save], [Comment], [Video], [DatePost], [LastDateEdit], [PrepTime], [CookTime], [IsDeleted], [UserID]) VALUES (10, N'Lemon Bars', N'Ina Garten''s classic Lemon Bars start out with a shortbread crust and are topped with a super lemony curd filling. They''re so easy to make and are the perfect, packable picnic dessert, from Barefoot Contessa on Food Network.', 5, 0, 6, N'Ovg49EvVlaM', CAST(N'2022-04-21T00:00:00.000' AS DateTime), NULL, 10, 55, 0, 3)
INSERT [dbo].[Recipe] ([ID], [Name], [Description], [Like], [Save], [Comment], [Video], [DatePost], [LastDateEdit], [PrepTime], [CookTime], [IsDeleted], [UserID]) VALUES (13, N'Apple Butter Pie', N'The texture of pumpkin pie with the taste of apple! Apple Butter Pie has a 5 minute filling bursting with traditional fall flavor.', 2, 1, 2, N'6R17vK-6-e4', CAST(N'2022-05-11T00:00:00.000' AS DateTime), NULL, 5, 10, 0, 9)
INSERT [dbo].[Recipe] ([ID], [Name], [Description], [Like], [Save], [Comment], [Video], [DatePost], [LastDateEdit], [PrepTime], [CookTime], [IsDeleted], [UserID]) VALUES (15, N'No Bake Tiramisu', N'Coffee lovers, this one is for you. Try this delicious, creamy, and easy Italian no-bake tiramisu for dessert tonight to indulge in by yourself or with the family.', 1, 1, 1, N'6R17vK-6-e4', CAST(N'2022-06-23T00:00:00.000' AS DateTime), NULL, 15, 20, 1, 11)
INSERT [dbo].[Recipe] ([ID], [Name], [Description], [Like], [Save], [Comment], [Video], [DatePost], [LastDateEdit], [PrepTime], [CookTime], [IsDeleted], [UserID]) VALUES (16, N'test title', N'test descirption', 0, 0, 0, N'RLuGJGyCS90', CAST(N'2022-10-26T18:20:28.547' AS DateTime), NULL, 15, 30, 1, 3)
INSERT [dbo].[Recipe] ([ID], [Name], [Description], [Like], [Save], [Comment], [Video], [DatePost], [LastDateEdit], [PrepTime], [CookTime], [IsDeleted], [UserID]) VALUES (17, N'tieu de', N'mo ta', 0, 0, 0, N'DGRRQzUGWto', CAST(N'2022-10-28T08:29:49.480' AS DateTime), NULL, 15, 30, 0, 3)
INSERT [dbo].[Recipe] ([ID], [Name], [Description], [Like], [Save], [Comment], [Video], [DatePost], [LastDateEdit], [PrepTime], [CookTime], [IsDeleted], [UserID]) VALUES (18, N'title ne', N'des ne', 0, 0, 0, N'GSPUUN4nDGE', CAST(N'2022-10-28T10:18:13.880' AS DateTime), NULL, 15, 30, 0, 3)
SET IDENTITY_INSERT [dbo].[Recipe] OFF
GO
INSERT [dbo].[Save] ([RecipeID], [UserID]) VALUES (2, 3)
INSERT [dbo].[Save] ([RecipeID], [UserID]) VALUES (2, 4)
INSERT [dbo].[Save] ([RecipeID], [UserID]) VALUES (2, 5)
INSERT [dbo].[Save] ([RecipeID], [UserID]) VALUES (2, 9)
INSERT [dbo].[Save] ([RecipeID], [UserID]) VALUES (2, 11)
INSERT [dbo].[Save] ([RecipeID], [UserID]) VALUES (2, 13)
INSERT [dbo].[Save] ([RecipeID], [UserID]) VALUES (4, 3)
INSERT [dbo].[Save] ([RecipeID], [UserID]) VALUES (4, 4)
INSERT [dbo].[Save] ([RecipeID], [UserID]) VALUES (7, 3)
INSERT [dbo].[Save] ([RecipeID], [UserID]) VALUES (13, 3)
INSERT [dbo].[Save] ([RecipeID], [UserID]) VALUES (15, 3)
GO
SET IDENTITY_INSERT [dbo].[User] ON 

INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (3, N'admin', N'admin0@gmail.com', N'25f9e794323b453885f5181f1b624d0b', N'admin0.jpg', N'Phú', N'Huỳnh', N'Male', N'0398550944', N'41 le khiet', 1, 2, CAST(N'2022-01-01' AS Date), 1, NULL, CAST(N'2002-05-02' AS Date))
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (4, N'user', N'admin1@gmail.com', N'25f9e794323b453885f5181f1b624d0b', N'image-16@2x.png', N'Mẫn', N'Võ', N'Female', N'033333333', N'Hóc Môn', 0, 0, CAST(N'2022-01-01' AS Date), 1, NULL, CAST(N'2002-05-02' AS Date))
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (5, N'admin', N'admin2@gmail.com', N'25f9e794323b453885f5181f1b624d0b', N'image-151@2x.png', N'Bình', N'Nguyễn', N'Other', NULL, NULL, 1, 0, CAST(N'2022-02-02' AS Date), 1, NULL, CAST(N'2002-05-02' AS Date))
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (9, N'admin', N'admin3@gmail.com', N'25f9e794323b453885f5181f1b624d0b', N'image-17@2x.png', N'Tú', N'Nguyễn', N'Male', NULL, NULL, 0, NULL, CAST(N'2022-02-01' AS Date), 1, NULL, CAST(N'2002-01-02' AS Date))
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (11, N'baker', N'user0@gmail.com', N'25f9e794323b453885f5181f1b624d0b', N'image-19@2x.png', N'Quân', N'Tướng', N'Male', NULL, NULL, 1, NULL, CAST(N'2022-01-01' AS Date), 0, NULL, CAST(N'1999-05-03' AS Date))
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (13, N'baker', N'user1@gmail.com', N'25f9e794323b453885f5181f1b624d0b', N'image-17@2x.png', N'Phương', N'Trần Nguyễn', N'Female', NULL, NULL, NULL, NULL, CAST(N'2022-02-03' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (14, N'baker', N'user2@gmail.com', N'25f9e794323b453885f5181f1b624d0b', N'pass.jpg', N'Tiến', N'Trần Quang', N'Male', NULL, NULL, NULL, NULL, CAST(N'2021-12-30' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (15, N'baker', N'user3@gmail.com', N'25f9e794323b453885f5181f1b624d0b', N'artworks.jpg', N'Dũng', N'Hồ Quang', N'Male', NULL, NULL, NULL, 1, CAST(N'2020-03-02' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (16, N'baker', N'user4@gmail.com', N'25f9e794323b453885f5181f1b624d0b', N'HuHjKSJI_400x400.jpg', N'Liên', N'Giao', N'Female', NULL, NULL, NULL, NULL, CAST(N'2022-01-01' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (18, N'baker', N'user5@gmail.com', N'25f9e794323b453885f5181f1b624d0b', N'yabai.jpg', N'Tấn', N'Nguyễn', N'Male', NULL, NULL, NULL, NULL, CAST(N'2022-04-23' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (20, N'baker', N'user6@gmail.com', N'25f9e794323b453885f5181f1b624d0b', N'ee6939.jpg', N'Tài', N'Tạ Tấn', N'Male', NULL, NULL, NULL, NULL, CAST(N'2022-05-04' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (21, N'baker', N'user7@gmail.com', N'25f9e794323b453885f5181f1b624d0b', N'download.png', N'Hiệp', N'Tấn', N'Other', NULL, NULL, NULL, NULL, CAST(N'2022-05-06' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (22, N'baker', N'user8@gmail.com', N'25f9e794323b453885f5181f1b624d0b', N'avatar-cute-2-560x560.jpg', N'Khánh', N'Mai Quốc', N'Male', NULL, NULL, NULL, NULL, CAST(N'2022-02-21' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (23, N'baker', N'user9@gmail.com', N'25f9e794323b453885f5181f1b624d0b', N'M0000.jpg', N'Ảo', N'Lung Linh Huyền', N'Female', NULL, NULL, NULL, NULL, CAST(N'2022-04-30' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (24, N'baker', N'user10@gmail.com', N'25f9e794323b453885f5181f1b624d0b', NULL, N'Hán', N'Hảo', N'Male', NULL, NULL, NULL, NULL, CAST(N'2022-06-12' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (26, N'baker', N'user11@gmail.com', N'25f9e794323b453885f5181f1b624d0b', NULL, N'Anya', N'Forger', N'Female', NULL, NULL, NULL, NULL, CAST(N'2022-07-03' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (27, N'baker', N'user12@gmail.com', N'25f9e794323b453885f5181f1b624d0b', NULL, N'Lan', N'Trương Mỹ', N'Female', NULL, NULL, NULL, NULL, CAST(N'2022-04-05' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (28, N'baker', N'user13@gmail.com', N'25f9e794323b453885f5181f1b624d0b', NULL, N'Elon', N'Musk', N'Male', NULL, NULL, NULL, NULL, CAST(N'2022-08-04' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (29, N'baker', N'user14@gmail.com', N'25f9e794323b453885f5181f1b624d0b', NULL, N'Haaland', N'Erling', N'Male', NULL, NULL, NULL, NULL, CAST(N'2022-03-08' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (30, N'baker', N'user15@gmail.com', N'25f9e794323b453885f5181f1b624d0b', NULL, N'Ronaldo', N'Cristiano', N'Male', NULL, NULL, NULL, NULL, CAST(N'2022-03-14' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (31, N'baker', N'user16@gmail.com', N'25f9e794323b453885f5181f1b624d0b', NULL, N'Hiếu ', N'PC', N'Male', NULL, NULL, NULL, NULL, CAST(N'2022-03-18' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (32, N'baker', N'user17@gmail.com', N'25f9e794323b453885f5181f1b624d0b', NULL, N'Hà', N'Hồ Ngọc', N'Female', NULL, NULL, NULL, NULL, CAST(N'2022-03-10' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (33, N'baker', N'user18@gmail.com', N'25f9e794323b453885f5181f1b624d0b', NULL, N'Steve', N'Jobs', N'Male', NULL, NULL, NULL, NULL, CAST(N'2022-06-04' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (34, N'baker', N'user19@gmail.com', N'25f9e794323b453885f5181f1b624d0b', NULL, N'Liêm', N'Lê Quang', N'Male', NULL, NULL, NULL, NULL, CAST(N'2022-07-10' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (35, N'baker', N'user20@gmail.com', N'25f9e794323b453885f5181f1b624d0b', NULL, N'Oanh', N'Phương', N'Female', NULL, NULL, NULL, NULL, CAST(N'2022-03-23' AS Date), 1, NULL, NULL)
INSERT [dbo].[User] ([ID], [Role], [Email], [Password], [Avatar], [FirstName], [LastName], [Gender], [Phone], [Address], [Follower], [Following], [DateRegister], [IsActive], [StoreID], [Birthday]) VALUES (36, N'baker', N'phuhuynh923@gmail.com', N'', N'https://lh3.googleusercontent.com/a/ALm5wu2HduidEXPx0EQgusTFwrKsHeuLkH2j6ndKA8HiKw=s96-c', N'Phú', N'Huỳnh', NULL, NULL, NULL, NULL, NULL, CAST(N'2022-10-11' AS Date), 1, NULL, NULL)
SET IDENTITY_INSERT [dbo].[User] OFF
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Ingredie__737584F63BC3FBCA]    Script Date: 11/3/2022 11:19:58 PM ******/
ALTER TABLE [dbo].[Ingredient] ADD UNIQUE NONCLUSTERED 
(
	[Name] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
SET ANSI_PADDING ON
GO
/****** Object:  Index [UQ__Users__A9D10534B9A735C3]    Script Date: 11/3/2022 11:19:58 PM ******/
ALTER TABLE [dbo].[User] ADD  CONSTRAINT [UQ__Users__A9D10534B9A735C3] UNIQUE NONCLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
GO
/****** Object:  FullTextIndex     Script Date: 11/3/2022 11:19:58 PM ******/
CREATE FULLTEXT INDEX ON [dbo].[Recipe](
[Name] LANGUAGE 'English')
KEY INDEX [PK__Posts__AA1260380751D4EE]ON ([recipe_ctlg], FILEGROUP [PRIMARY])
WITH (CHANGE_TRACKING = AUTO, STOPLIST = SYSTEM)

GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FKComment537260] FOREIGN KEY([UserID])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FKComment537260]
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FKComment816296] FOREIGN KEY([RecipeID])
REFERENCES [dbo].[Recipe] ([ID])
GO
ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FKComment816296]
GO
ALTER TABLE [dbo].[Follow]  WITH CHECK ADD  CONSTRAINT [FKFollow361093] FOREIGN KEY([UserID])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[Follow] CHECK CONSTRAINT [FKFollow361093]
GO
ALTER TABLE [dbo].[Follow]  WITH CHECK ADD  CONSTRAINT [FKFollow945429] FOREIGN KEY([UserID2])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[Follow] CHECK CONSTRAINT [FKFollow945429]
GO
ALTER TABLE [dbo].[IngredientRecipe]  WITH CHECK ADD  CONSTRAINT [FKIngredient453484] FOREIGN KEY([IngredientID])
REFERENCES [dbo].[Ingredient] ([ID])
GO
ALTER TABLE [dbo].[IngredientRecipe] CHECK CONSTRAINT [FKIngredient453484]
GO
ALTER TABLE [dbo].[IngredientRecipe]  WITH CHECK ADD  CONSTRAINT [FKIngredient611333] FOREIGN KEY([RecipeID])
REFERENCES [dbo].[Recipe] ([ID])
GO
ALTER TABLE [dbo].[IngredientRecipe] CHECK CONSTRAINT [FKIngredient611333]
GO
ALTER TABLE [dbo].[Instruction]  WITH CHECK ADD  CONSTRAINT [FK_Instruction_Recipe] FOREIGN KEY([RecipeID])
REFERENCES [dbo].[Recipe] ([ID])
GO
ALTER TABLE [dbo].[Instruction] CHECK CONSTRAINT [FK_Instruction_Recipe]
GO
ALTER TABLE [dbo].[Like]  WITH CHECK ADD  CONSTRAINT [FK_Like_Recipe] FOREIGN KEY([RecipeID])
REFERENCES [dbo].[Recipe] ([ID])
GO
ALTER TABLE [dbo].[Like] CHECK CONSTRAINT [FK_Like_Recipe]
GO
ALTER TABLE [dbo].[Like]  WITH CHECK ADD  CONSTRAINT [FK_Like_User] FOREIGN KEY([UserID])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[Like] CHECK CONSTRAINT [FK_Like_User]
GO
ALTER TABLE [dbo].[Picture]  WITH CHECK ADD  CONSTRAINT [FKPicture325360] FOREIGN KEY([RecipeID])
REFERENCES [dbo].[Recipe] ([ID])
GO
ALTER TABLE [dbo].[Picture] CHECK CONSTRAINT [FKPicture325360]
GO
ALTER TABLE [dbo].[Recipe]  WITH CHECK ADD  CONSTRAINT [FKRecipe405040] FOREIGN KEY([UserID])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[Recipe] CHECK CONSTRAINT [FKRecipe405040]
GO
ALTER TABLE [dbo].[ReportComment]  WITH CHECK ADD  CONSTRAINT [FKReportComm316353] FOREIGN KEY([UserID])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[ReportComment] CHECK CONSTRAINT [FKReportComm316353]
GO
ALTER TABLE [dbo].[ReportComment]  WITH CHECK ADD  CONSTRAINT [FKReportComm762006] FOREIGN KEY([CommentID])
REFERENCES [dbo].[Comment] ([ID])
GO
ALTER TABLE [dbo].[ReportComment] CHECK CONSTRAINT [FKReportComm762006]
GO
ALTER TABLE [dbo].[ReportRecipe]  WITH CHECK ADD  CONSTRAINT [FKReportReci461494] FOREIGN KEY([RecipeID])
REFERENCES [dbo].[Recipe] ([ID])
GO
ALTER TABLE [dbo].[ReportRecipe] CHECK CONSTRAINT [FKReportReci461494]
GO
ALTER TABLE [dbo].[ReportRecipe]  WITH CHECK ADD  CONSTRAINT [FKReportReci740530] FOREIGN KEY([UserID])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[ReportRecipe] CHECK CONSTRAINT [FKReportReci740530]
GO
ALTER TABLE [dbo].[ReportUser]  WITH CHECK ADD FOREIGN KEY([UserID])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[ReportUser]  WITH CHECK ADD FOREIGN KEY([UserID2])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[Save]  WITH CHECK ADD  CONSTRAINT [FKSave303065] FOREIGN KEY([RecipeID])
REFERENCES [dbo].[Recipe] ([ID])
GO
ALTER TABLE [dbo].[Save] CHECK CONSTRAINT [FKSave303065]
GO
ALTER TABLE [dbo].[Save]  WITH CHECK ADD  CONSTRAINT [FKSave947561] FOREIGN KEY([UserID])
REFERENCES [dbo].[User] ([ID])
GO
ALTER TABLE [dbo].[Save] CHECK CONSTRAINT [FKSave947561]
GO
/****** Object:  Trigger [dbo].[trg_Comment]    Script Date: 11/3/2022 11:19:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[trg_Comment] ON [dbo].[Comment] AFTER INSERT, DELETE, UPDATE AS 
BEGIN 
	declare @vRecipeID int
	IF EXISTS(SELECT * FROM inserted) 
	BEGIN
		select @vRecipeID = RecipeID
		from inserted
	END
	ELSE IF EXISTS(SELECT * FROM deleted) 
	BEGIN
		select @vRecipeID = RecipeID
		from deleted
	END

	UPDATE Recipe
	SET [Comment] = (
		SELECT COUNT(UserID)
		FROM [Comment]
		WHERE RecipeID = @vRecipeID AND IsDeleted = 0
	)
	WHERE ID = @vRecipeID 
END
GO
ALTER TABLE [dbo].[Comment] ENABLE TRIGGER [trg_Comment]
GO
/****** Object:  Trigger [dbo].[trg_Following]    Script Date: 11/3/2022 11:19:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[trg_Following] ON [dbo].[Follow] AFTER INSERT, DELETE AS 
BEGIN 
	declare @vUserID int
	declare @vUserID2 int
	IF EXISTS(SELECT * FROM inserted) 
	BEGIN
		select @vUserID = UserID, @vUserID2 = UserID2
		from inserted
	END
	ELSE 
	BEGIN
		select @vUserID = UserID, @vUserID2 = UserID2
		from deleted
	END

	UPDATE [User]
	SET [Following] = (
		SELECT COUNT(UserID)
		FROM [Follow]
		WHERE UserID = @vUserID
	)
	WHERE ID = @vUserID

	UPDATE [User]
	SET [Follower] = (
		SELECT COUNT(UserID2)
		FROM [Follow]
		WHERE UserID2 = @vUserID2
	)
	WHERE ID = @vUserID2
END
GO
ALTER TABLE [dbo].[Follow] ENABLE TRIGGER [trg_Following]
GO
/****** Object:  Trigger [dbo].[trg_Like]    Script Date: 11/3/2022 11:19:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[trg_Like] ON [dbo].[Like] AFTER INSERT, DELETE AS 
BEGIN 
	declare @vRecipeID int
	IF EXISTS(SELECT * FROM inserted) 
	BEGIN
		select @vRecipeID = RecipeID
		from inserted
	END
	ELSE 
	BEGIN
		select @vRecipeID = RecipeID
		from deleted
	END

	UPDATE Recipe
	SET [Like] = (
		SELECT COUNT(UserID)
		FROM [Like]
		WHERE RecipeID = @vRecipeID
	)
	WHERE ID = @vRecipeID
END
GO
ALTER TABLE [dbo].[Like] ENABLE TRIGGER [trg_Like]
GO
/****** Object:  Trigger [dbo].[trg_Save]    Script Date: 11/3/2022 11:19:58 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TRIGGER [dbo].[trg_Save] ON [dbo].[Save] AFTER INSERT, DELETE AS 
BEGIN 
	declare @vRecipeID int
	IF EXISTS(SELECT * FROM inserted) 
	BEGIN
		select @vRecipeID = RecipeID
		from inserted
	END
	ELSE 
	BEGIN
		select @vRecipeID = RecipeID
		from deleted
	END

	UPDATE Recipe
	SET [Save] = (
		SELECT COUNT(UserID)
		FROM [Save]
		WHERE RecipeID = @vRecipeID
	)
	WHERE ID = @vRecipeID
END
GO
ALTER TABLE [dbo].[Save] ENABLE TRIGGER [trg_Save]
GO
USE [master]
GO
ALTER DATABASE [BakeryRecipe] SET  READ_WRITE 
GO
