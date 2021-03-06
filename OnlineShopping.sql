USE [OnlineShopping]
GO
ALTER TABLE [dbo].[SliderContent] DROP CONSTRAINT [FK_SliderContent_Slider]
GO
ALTER TABLE [dbo].[SliderContent] DROP CONSTRAINT [FK_SliderContent_Product]
GO
ALTER TABLE [dbo].[ProductImage] DROP CONSTRAINT [FK_ProductImage_ProductAttachedImage]
GO
ALTER TABLE [dbo].[ProductImage] DROP CONSTRAINT [FK_ProductImage_Product]
GO
ALTER TABLE [dbo].[Product] DROP CONSTRAINT [FK_Product_ProductCategory]
GO
ALTER TABLE [dbo].[Post] DROP CONSTRAINT [FK_Post_PostCategory]
GO
ALTER TABLE [dbo].[OrderDetail] DROP CONSTRAINT [FK_OrderDetail_Product]
GO
ALTER TABLE [dbo].[OrderDetail] DROP CONSTRAINT [FK_OrderDetail_Order]
GO
ALTER TABLE [dbo].[Order] DROP CONSTRAINT [FK_Order_User1]
GO
ALTER TABLE [dbo].[Order] DROP CONSTRAINT [FK_Order_User]
GO
ALTER TABLE [dbo].[FeedbackImage] DROP CONSTRAINT [FK_FeedbackImage_FeedbackAttachedImage]
GO
ALTER TABLE [dbo].[FeedbackImage] DROP CONSTRAINT [FK_FeedbackImage_FeedBack]
GO
ALTER TABLE [dbo].[FeedBack] DROP CONSTRAINT [FK_FeedBack_Product]
GO
ALTER TABLE [dbo].[CustomerOldDetails] DROP CONSTRAINT [FK_CustomerOldDetails_User]
GO
/****** Object:  Index [IX_User]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP INDEX [IX_User] ON [dbo].[User]
GO
/****** Object:  Table [dbo].[User]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP TABLE [dbo].[User]
GO
/****** Object:  Table [dbo].[SliderContent]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP TABLE [dbo].[SliderContent]
GO
/****** Object:  Table [dbo].[Slider]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP TABLE [dbo].[Slider]
GO
/****** Object:  Table [dbo].[ProductImage]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP TABLE [dbo].[ProductImage]
GO
/****** Object:  Table [dbo].[ProductCategory]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP TABLE [dbo].[ProductCategory]
GO
/****** Object:  Table [dbo].[ProductAttachedImage]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP TABLE [dbo].[ProductAttachedImage]
GO
/****** Object:  Table [dbo].[Product]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP TABLE [dbo].[Product]
GO
/****** Object:  Table [dbo].[PostCategory]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP TABLE [dbo].[PostCategory]
GO
/****** Object:  Table [dbo].[Post]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP TABLE [dbo].[Post]
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP TABLE [dbo].[OrderDetail]
GO
/****** Object:  Table [dbo].[Order]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP TABLE [dbo].[Order]
GO
/****** Object:  Table [dbo].[FeedbackImage]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP TABLE [dbo].[FeedbackImage]
GO
/****** Object:  Table [dbo].[FeedbackAttachedImage]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP TABLE [dbo].[FeedbackAttachedImage]
GO
/****** Object:  Table [dbo].[FeedBack]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP TABLE [dbo].[FeedBack]
GO
/****** Object:  Table [dbo].[CustomerOldDetails]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP TABLE [dbo].[CustomerOldDetails]
GO
/****** Object:  User [longtt]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP USER [longtt]
GO
USE [master]
GO
/****** Object:  Database [OnlineShopping]    Script Date: 03-Jun-21 10:15:41 PM ******/
DROP DATABASE [OnlineShopping]
GO
/****** Object:  Database [OnlineShopping]    Script Date: 03-Jun-21 10:15:41 PM ******/
CREATE DATABASE [OnlineShopping]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'OnlineShopping', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\OnlineShopping.mdf' , SIZE = 4096KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'OnlineShopping_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL12.MSSQLSERVER\MSSQL\DATA\OnlineShopping_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [OnlineShopping] SET COMPATIBILITY_LEVEL = 120
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [OnlineShopping].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [OnlineShopping] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [OnlineShopping] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [OnlineShopping] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [OnlineShopping] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [OnlineShopping] SET ARITHABORT OFF 
GO
ALTER DATABASE [OnlineShopping] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [OnlineShopping] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [OnlineShopping] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [OnlineShopping] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [OnlineShopping] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [OnlineShopping] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [OnlineShopping] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [OnlineShopping] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [OnlineShopping] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [OnlineShopping] SET  DISABLE_BROKER 
GO
ALTER DATABASE [OnlineShopping] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [OnlineShopping] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [OnlineShopping] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [OnlineShopping] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [OnlineShopping] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [OnlineShopping] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [OnlineShopping] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [OnlineShopping] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [OnlineShopping] SET  MULTI_USER 
GO
ALTER DATABASE [OnlineShopping] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [OnlineShopping] SET DB_CHAINING OFF 
GO
ALTER DATABASE [OnlineShopping] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [OnlineShopping] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
ALTER DATABASE [OnlineShopping] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'OnlineShopping', N'ON'
GO
USE [OnlineShopping]
GO
/****** Object:  User [longtt]    Script Date: 03-Jun-21 10:15:42 PM ******/
CREATE USER [longtt] WITHOUT LOGIN WITH DEFAULT_SCHEMA=[dbo]
GO
ALTER ROLE [db_owner] ADD MEMBER [longtt]
GO
ALTER ROLE [db_accessadmin] ADD MEMBER [longtt]
GO
ALTER ROLE [db_securityadmin] ADD MEMBER [longtt]
GO
ALTER ROLE [db_ddladmin] ADD MEMBER [longtt]
GO
ALTER ROLE [db_backupoperator] ADD MEMBER [longtt]
GO
ALTER ROLE [db_datareader] ADD MEMBER [longtt]
GO
ALTER ROLE [db_datawriter] ADD MEMBER [longtt]
GO
ALTER ROLE [db_denydatareader] ADD MEMBER [longtt]
GO
ALTER ROLE [db_denydatawriter] ADD MEMBER [longtt]
GO
/****** Object:  Table [dbo].[CustomerOldDetails]    Script Date: 03-Jun-21 10:15:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CustomerOldDetails](
	[OldID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nchar](100) NOT NULL,
	[Gender] [int] NOT NULL,
	[Address] [nchar](100) NOT NULL,
	[Phone] [nchar](10) NOT NULL,
	[DateCreated] [datetime] NOT NULL,
	[CustomerID] [int] NOT NULL,
 CONSTRAINT [PK_CustomerOldDetails] PRIMARY KEY CLUSTERED 
(
	[OldID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FeedBack]    Script Date: 03-Jun-21 10:15:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FeedBack](
	[FeedBackID] [int] NOT NULL,
	[Name] [nchar](100) NOT NULL,
	[FeedbackContent] [nchar](100) NOT NULL,
	[Email] [nchar](100) NOT NULL,
	[Phone] [nchar](10) NOT NULL,
	[Status] [int] NOT NULL,
	[RatedStar] [int] NOT NULL,
	[ProductID] [int] NOT NULL,
 CONSTRAINT [PK_FeedBack] PRIMARY KEY CLUSTERED 
(
	[FeedBackID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FeedbackAttachedImage]    Script Date: 03-Jun-21 10:15:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FeedbackAttachedImage](
	[ImageID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nchar](100) NULL,
 CONSTRAINT [PK_FeedbackAttachedImage] PRIMARY KEY CLUSTERED 
(
	[ImageID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FeedbackImage]    Script Date: 03-Jun-21 10:15:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FeedbackImage](
	[FeedBackID] [int] IDENTITY(1,1) NOT NULL,
	[ImageID] [int] NOT NULL,
 CONSTRAINT [PK_FeedbackImage_1] PRIMARY KEY CLUSTERED 
(
	[FeedBackID] ASC,
	[ImageID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Order]    Script Date: 03-Jun-21 10:15:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Order](
	[OrderID] [int] NOT NULL,
	[Status] [int] NOT NULL,
	[OrderedDate] [datetime] NOT NULL,
	[CustomerID] [int] NOT NULL,
	[ReceiverName] [nchar](100) NOT NULL,
	[ReceiverAddress] [nchar](100) NOT NULL,
	[ReceiverEmail] [nchar](100) NOT NULL,
	[ReceiverGender] [int] NOT NULL,
	[Note] [nchar](100) NOT NULL,
	[ReceiverPhone] [nchar](10) NOT NULL,
	[SaleMemberID] [int] NOT NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 03-Jun-21 10:15:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[OrderID] [int] NOT NULL,
	[ProductID] [int] NOT NULL,
	[Quantity] [int] NOT NULL,
 CONSTRAINT [PK_OrderDetail_1] PRIMARY KEY CLUSTERED 
(
	[OrderID] ASC,
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Post]    Script Date: 03-Jun-21 10:15:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Post](
	[PostID] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nchar](100) NOT NULL,
	[Thumbnail] [nchar](100) NOT NULL,
	[BriefInfo] [nchar](100) NOT NULL,
	[Author] [nchar](100) NOT NULL,
	[Description] [nchar](100) NOT NULL,
	[Featured] [int] NOT NULL,
	[Status] [int] NOT NULL,
	[PostCategoryID] [int] NOT NULL,
	[DateCreated] [datetime] NOT NULL,
 CONSTRAINT [PK_Post] PRIMARY KEY CLUSTERED 
(
	[PostID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[PostCategory]    Script Date: 03-Jun-21 10:15:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[PostCategory](
	[PostCategoryID] [int] NOT NULL,
	[Name] [nchar](100) NOT NULL,
 CONSTRAINT [PK_PostCategory] PRIMARY KEY CLUSTERED 
(
	[PostCategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Product]    Script Date: 03-Jun-21 10:15:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Product](
	[ProductID] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nchar](100) NOT NULL,
	[ProductCategoryID] [int] NOT NULL,
	[Thumbnail] [nchar](100) NOT NULL,
	[BriefInfo] [nchar](100) NOT NULL,
	[Description] [nchar](100) NOT NULL,
	[Quantity] [float] NOT NULL,
	[ListPrice] [float] NOT NULL,
	[SalePrice] [float] NOT NULL,
	[Featured] [int] NOT NULL,
	[Status] [int] NOT NULL,
	[DateCreated] [datetime] NOT NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ProductAttachedImage]    Script Date: 03-Jun-21 10:15:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductAttachedImage](
	[ImageID] [int] NOT NULL,
	[Name] [nchar](100) NOT NULL,
 CONSTRAINT [PK_ProductAttachedImage] PRIMARY KEY CLUSTERED 
(
	[ImageID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ProductCategory]    Script Date: 03-Jun-21 10:15:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductCategory](
	[ProductCategoryID] [int] NOT NULL,
	[Name] [nchar](100) NOT NULL,
 CONSTRAINT [PK_ProductCategory] PRIMARY KEY CLUSTERED 
(
	[ProductCategoryID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ProductImage]    Script Date: 03-Jun-21 10:15:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ProductImage](
	[ProductID] [int] NOT NULL,
	[ImageID] [int] NOT NULL,
 CONSTRAINT [PK_ProductImage_1] PRIMARY KEY CLUSTERED 
(
	[ProductID] ASC,
	[ImageID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Slider]    Script Date: 03-Jun-21 10:15:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Slider](
	[SliderID] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nchar](100) NOT NULL,
	[Description] [nchar](100) NOT NULL,
	[Status] [int] NOT NULL,
 CONSTRAINT [PK_Slider] PRIMARY KEY CLUSTERED 
(
	[SliderID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[SliderContent]    Script Date: 03-Jun-21 10:15:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SliderContent](
	[SliderID] [int] NOT NULL,
	[ProductID] [int] NOT NULL,
 CONSTRAINT [PK_SliderContent_1] PRIMARY KEY CLUSTERED 
(
	[SliderID] ASC,
	[ProductID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[User]    Script Date: 03-Jun-21 10:15:42 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[UserID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nchar](100) NOT NULL,
	[Gender] [int] NOT NULL,
	[Address] [nchar](100) NOT NULL,
	[Email] [nchar](100) NOT NULL,
	[Phone] [nchar](10) NOT NULL,
	[Status] [int] NOT NULL,
	[DateCreated] [datetime] NOT NULL,
	[Avatar] [nchar](100) NOT NULL,
	[Role] [int] NOT NULL,
	[Password] [nchar](100) NOT NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Index [IX_User]    Script Date: 03-Jun-21 10:15:42 PM ******/
CREATE UNIQUE NONCLUSTERED INDEX [IX_User] ON [dbo].[User]
(
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, IGNORE_DUP_KEY = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[CustomerOldDetails]  WITH CHECK ADD  CONSTRAINT [FK_CustomerOldDetails_User] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[User] ([UserID])
GO
ALTER TABLE [dbo].[CustomerOldDetails] CHECK CONSTRAINT [FK_CustomerOldDetails_User]
GO
ALTER TABLE [dbo].[FeedBack]  WITH CHECK ADD  CONSTRAINT [FK_FeedBack_Product] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Product] ([ProductID])
GO
ALTER TABLE [dbo].[FeedBack] CHECK CONSTRAINT [FK_FeedBack_Product]
GO
ALTER TABLE [dbo].[FeedbackImage]  WITH CHECK ADD  CONSTRAINT [FK_FeedbackImage_FeedBack] FOREIGN KEY([FeedBackID])
REFERENCES [dbo].[FeedBack] ([FeedBackID])
GO
ALTER TABLE [dbo].[FeedbackImage] CHECK CONSTRAINT [FK_FeedbackImage_FeedBack]
GO
ALTER TABLE [dbo].[FeedbackImage]  WITH CHECK ADD  CONSTRAINT [FK_FeedbackImage_FeedbackAttachedImage] FOREIGN KEY([ImageID])
REFERENCES [dbo].[FeedbackAttachedImage] ([ImageID])
GO
ALTER TABLE [dbo].[FeedbackImage] CHECK CONSTRAINT [FK_FeedbackImage_FeedbackAttachedImage]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_User] FOREIGN KEY([CustomerID])
REFERENCES [dbo].[User] ([UserID])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_User]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FK_Order_User1] FOREIGN KEY([SaleMemberID])
REFERENCES [dbo].[User] ([UserID])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FK_Order_User1]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Order] FOREIGN KEY([OrderID])
REFERENCES [dbo].[Order] ([OrderID])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Order]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FK_OrderDetail_Product] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Product] ([ProductID])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FK_OrderDetail_Product]
GO
ALTER TABLE [dbo].[Post]  WITH CHECK ADD  CONSTRAINT [FK_Post_PostCategory] FOREIGN KEY([PostCategoryID])
REFERENCES [dbo].[PostCategory] ([PostCategoryID])
GO
ALTER TABLE [dbo].[Post] CHECK CONSTRAINT [FK_Post_PostCategory]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_ProductCategory] FOREIGN KEY([ProductCategoryID])
REFERENCES [dbo].[ProductCategory] ([ProductCategoryID])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_ProductCategory]
GO
ALTER TABLE [dbo].[ProductImage]  WITH CHECK ADD  CONSTRAINT [FK_ProductImage_Product] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Product] ([ProductID])
GO
ALTER TABLE [dbo].[ProductImage] CHECK CONSTRAINT [FK_ProductImage_Product]
GO
ALTER TABLE [dbo].[ProductImage]  WITH CHECK ADD  CONSTRAINT [FK_ProductImage_ProductAttachedImage] FOREIGN KEY([ImageID])
REFERENCES [dbo].[ProductAttachedImage] ([ImageID])
GO
ALTER TABLE [dbo].[ProductImage] CHECK CONSTRAINT [FK_ProductImage_ProductAttachedImage]
GO
ALTER TABLE [dbo].[SliderContent]  WITH CHECK ADD  CONSTRAINT [FK_SliderContent_Product] FOREIGN KEY([ProductID])
REFERENCES [dbo].[Product] ([ProductID])
GO
ALTER TABLE [dbo].[SliderContent] CHECK CONSTRAINT [FK_SliderContent_Product]
GO
ALTER TABLE [dbo].[SliderContent]  WITH CHECK ADD  CONSTRAINT [FK_SliderContent_Slider] FOREIGN KEY([SliderID])
REFERENCES [dbo].[Slider] ([SliderID])
GO
ALTER TABLE [dbo].[SliderContent] CHECK CONSTRAINT [FK_SliderContent_Slider]
GO
USE [master]
GO
ALTER DATABASE [OnlineShopping] SET  READ_WRITE 
GO
