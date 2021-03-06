USE [master]
GO
/****** Object:  Database [finnegans]    Script Date: 5/4/2022 23:25:32 ******/
CREATE DATABASE [finnegans]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'finnegans', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\finnegans.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'finnegans_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\finnegans_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [finnegans] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [finnegans].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [finnegans] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [finnegans] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [finnegans] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [finnegans] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [finnegans] SET ARITHABORT OFF 
GO
ALTER DATABASE [finnegans] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [finnegans] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [finnegans] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [finnegans] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [finnegans] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [finnegans] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [finnegans] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [finnegans] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [finnegans] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [finnegans] SET  DISABLE_BROKER 
GO
ALTER DATABASE [finnegans] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [finnegans] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [finnegans] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [finnegans] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [finnegans] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [finnegans] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [finnegans] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [finnegans] SET RECOVERY FULL 
GO
ALTER DATABASE [finnegans] SET  MULTI_USER 
GO
ALTER DATABASE [finnegans] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [finnegans] SET DB_CHAINING OFF 
GO
ALTER DATABASE [finnegans] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [finnegans] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [finnegans] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [finnegans] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'finnegans', N'ON'
GO
ALTER DATABASE [finnegans] SET QUERY_STORE = OFF
GO
USE [finnegans]
GO
/****** Object:  Table [dbo].[cliente]    Script Date: 5/4/2022 23:25:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[cliente](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[apellido] [varchar](255) NULL,
	[dni] [varchar](255) NULL,
	[nombre] [varchar](255) NULL,
	[tipo] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[detallePedido]    Script Date: 5/4/2022 23:25:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[detallePedido](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](255) NULL,
	[precio] [float] NULL,
	[total] [float] NULL,
	[pedido_id] [int] NULL,
	[producto_id] [int] NULL,
	[servicio_id] [int] NULL,
	[producto_itemVentaId] [int] NULL,
	[servicio_itemVentaId] [int] NULL,
	[producto_itemVenta_Id] [int] NULL,
	[servicio_itemVenta_Id] [int] NULL,
	[item_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[itemVenta]    Script Date: 5/4/2022 23:25:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[itemVenta](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[costo] [float] NULL,
	[nombre] [varchar](255) NULL,
	[DTYPE] [varchar](31) NOT NULL,
	[esEspecial] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[pedido]    Script Date: 5/4/2022 23:25:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[pedido](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[fechaCreacion] [date] NULL,
	[fechaRecibido] [date] NULL,
	[numeroPedido] [varchar](255) NULL,
	[total] [float] NULL,
	[cliente_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[producto]    Script Date: 5/4/2022 23:25:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[producto](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[nombre] [varchar](255) NULL,
	[costo] [float] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[servicio]    Script Date: 5/4/2022 23:25:33 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[servicio](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[costo] [float] NULL,
	[esEspecial] [bit] NOT NULL,
	[nombre] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[detallePedido]  WITH CHECK ADD  CONSTRAINT [FK34imvt84feyrxtfjk49cr80lm] FOREIGN KEY([pedido_id])
REFERENCES [dbo].[pedido] ([id])
GO
ALTER TABLE [dbo].[detallePedido] CHECK CONSTRAINT [FK34imvt84feyrxtfjk49cr80lm]
GO
ALTER TABLE [dbo].[detallePedido]  WITH CHECK ADD  CONSTRAINT [FK3n6ppgeqfg3h9tckb3vbxgtye] FOREIGN KEY([producto_id])
REFERENCES [dbo].[producto] ([id])
GO
ALTER TABLE [dbo].[detallePedido] CHECK CONSTRAINT [FK3n6ppgeqfg3h9tckb3vbxgtye]
GO
ALTER TABLE [dbo].[detallePedido]  WITH CHECK ADD  CONSTRAINT [FK4sh41jyxicsdo9j3rnu3lbgv6] FOREIGN KEY([servicio_id])
REFERENCES [dbo].[servicio] ([id])
GO
ALTER TABLE [dbo].[detallePedido] CHECK CONSTRAINT [FK4sh41jyxicsdo9j3rnu3lbgv6]
GO
ALTER TABLE [dbo].[detallePedido]  WITH CHECK ADD  CONSTRAINT [FK6l3j83mqcqc3ufrt6es9xamdi] FOREIGN KEY([producto_itemVenta_Id])
REFERENCES [dbo].[producto] ([id])
GO
ALTER TABLE [dbo].[detallePedido] CHECK CONSTRAINT [FK6l3j83mqcqc3ufrt6es9xamdi]
GO
ALTER TABLE [dbo].[detallePedido]  WITH CHECK ADD  CONSTRAINT [FK7pem7h3l66v06kv7g58hccymn] FOREIGN KEY([producto_id])
REFERENCES [dbo].[itemVenta] ([id])
GO
ALTER TABLE [dbo].[detallePedido] CHECK CONSTRAINT [FK7pem7h3l66v06kv7g58hccymn]
GO
ALTER TABLE [dbo].[detallePedido]  WITH CHECK ADD  CONSTRAINT [FKdlq06jucu9bov9a371sui7x7a] FOREIGN KEY([producto_itemVentaId])
REFERENCES [dbo].[producto] ([id])
GO
ALTER TABLE [dbo].[detallePedido] CHECK CONSTRAINT [FKdlq06jucu9bov9a371sui7x7a]
GO
ALTER TABLE [dbo].[detallePedido]  WITH CHECK ADD  CONSTRAINT [FKffio0bccs8ckyk5wdt7kypx9s] FOREIGN KEY([servicio_itemVenta_Id])
REFERENCES [dbo].[servicio] ([id])
GO
ALTER TABLE [dbo].[detallePedido] CHECK CONSTRAINT [FKffio0bccs8ckyk5wdt7kypx9s]
GO
ALTER TABLE [dbo].[detallePedido]  WITH CHECK ADD  CONSTRAINT [FKljeg3xs6hhx39iiegsw9ooete] FOREIGN KEY([servicio_itemVentaId])
REFERENCES [dbo].[servicio] ([id])
GO
ALTER TABLE [dbo].[detallePedido] CHECK CONSTRAINT [FKljeg3xs6hhx39iiegsw9ooete]
GO
ALTER TABLE [dbo].[detallePedido]  WITH CHECK ADD  CONSTRAINT [FKn8su0gol7bklkrt2a8lrxlv1p] FOREIGN KEY([item_id])
REFERENCES [dbo].[itemVenta] ([id])
GO
ALTER TABLE [dbo].[detallePedido] CHECK CONSTRAINT [FKn8su0gol7bklkrt2a8lrxlv1p]
GO
ALTER TABLE [dbo].[detallePedido]  WITH CHECK ADD  CONSTRAINT [FKqi2c8lb1jt3p1ub2rn1k6mlsb] FOREIGN KEY([servicio_id])
REFERENCES [dbo].[itemVenta] ([id])
GO
ALTER TABLE [dbo].[detallePedido] CHECK CONSTRAINT [FKqi2c8lb1jt3p1ub2rn1k6mlsb]
GO
ALTER TABLE [dbo].[pedido]  WITH CHECK ADD  CONSTRAINT [FK30s8j2ktpay6of18lbyqn3632] FOREIGN KEY([cliente_id])
REFERENCES [dbo].[cliente] ([id])
GO
ALTER TABLE [dbo].[pedido] CHECK CONSTRAINT [FK30s8j2ktpay6of18lbyqn3632]
GO
USE [master]
GO
ALTER DATABASE [finnegans] SET  READ_WRITE 
GO
