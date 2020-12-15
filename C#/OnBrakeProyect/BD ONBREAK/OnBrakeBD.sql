USE [master]
GO
/****** Object:  Database [OnBrakeZ]    Script Date: 26-05-2020 15:39:31 ******/
CREATE DATABASE [OnBrakeZ]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'OnBrake', FILENAME = N'D:\SQL SERVER\MSSQL15.MSSQLSERVER\MSSQL\DATA\OnBrake.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'OnBrake_log', FILENAME = N'D:\SQL SERVER\MSSQL15.MSSQLSERVER\MSSQL\DATA\OnBrake_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [OnBrakeZ] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [OnBrakeZ].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [OnBrakeZ] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [OnBrakeZ] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [OnBrakeZ] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [OnBrakeZ] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [OnBrakeZ] SET ARITHABORT OFF 
GO
ALTER DATABASE [OnBrakeZ] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [OnBrakeZ] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [OnBrakeZ] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [OnBrakeZ] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [OnBrakeZ] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [OnBrakeZ] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [OnBrakeZ] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [OnBrakeZ] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [OnBrakeZ] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [OnBrakeZ] SET  DISABLE_BROKER 
GO
ALTER DATABASE [OnBrakeZ] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [OnBrakeZ] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [OnBrakeZ] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [OnBrakeZ] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [OnBrakeZ] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [OnBrakeZ] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [OnBrakeZ] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [OnBrakeZ] SET RECOVERY FULL 
GO
ALTER DATABASE [OnBrakeZ] SET  MULTI_USER 
GO
ALTER DATABASE [OnBrakeZ] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [OnBrakeZ] SET DB_CHAINING OFF 
GO
ALTER DATABASE [OnBrakeZ] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [OnBrakeZ] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [OnBrakeZ] SET DELAYED_DURABILITY = DISABLED 
GO
EXEC sys.sp_db_vardecimal_storage_format N'OnBrakeZ', N'ON'
GO
ALTER DATABASE [OnBrakeZ] SET QUERY_STORE = OFF
GO
USE [OnBrakeZ]
GO
/****** Object:  Table [dbo].[ActividadEmpresa]    Script Date: 26-05-2020 15:39:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ActividadEmpresa](
	[id] [int] NOT NULL,
	[Descripcion] [varchar](100) NULL,
 CONSTRAINT [PK__Activida__3213E83F57FA80FE] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Cliente]    Script Date: 26-05-2020 15:39:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cliente](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[rut] [int] NOT NULL,
	[DV] [char](1) NOT NULL,
	[RazonSocial] [varchar](100) NULL,
	[NombreContacto] [varchar](100) NULL,
	[MailContacto] [varchar](100) NULL,
	[Direccion] [varchar](100) NULL,
	[Telefono] [int] NULL,
	[Actividad] [int] NOT NULL,
	[Tipo] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Contrato]    Script Date: 26-05-2020 15:39:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contrato](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[NumeroContrato] [bigint] NULL,
	[Creacion] [date] NOT NULL,
	[Termino] [date] NULL,
	[FechaHoraInicio] [time](7) NULL,
	[FechaHoraTermino] [time](7) NULL,
	[Direccion] [varchar](100) NULL,
	[EstaVigente] [bit] NOT NULL,
	[Tipo] [int] NOT NULL,
	[Observaciones] [varchar](250) NULL,
	[idCliente] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[idCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TipoEmpresa]    Script Date: 26-05-2020 15:39:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TipoEmpresa](
	[id] [int]  NOT NULL,
	[Descripcion] [varchar](100) NULL,
 CONSTRAINT [PK__TipoEmpr__3213E83F36D3DEA5] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TipoEvento]    Script Date: 26-05-2020 15:39:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TipoEvento](
	[id] [int] NOT NULL,
	[Nombre] [varchar](100) NOT NULL,
	[ValorBase] [int] NOT NULL,
	[PersonalBase] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Valorizador]    Script Date: 26-05-2020 15:39:31 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Valorizador](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[ValorContratoCliente] [int] NULL,
	[RecargoAsistentes] [int] NULL,
	[RecargoPersonal] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [FK_Cliente_ActividadEmpresa] FOREIGN KEY([Actividad])
REFERENCES [dbo].[ActividadEmpresa] ([id])
GO
ALTER TABLE [dbo].[Cliente] CHECK CONSTRAINT [FK_Cliente_ActividadEmpresa]
GO
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [FK_Cliente_TipoEmpresa] FOREIGN KEY([Tipo])
REFERENCES [dbo].[TipoEmpresa] ([id])
GO
ALTER TABLE [dbo].[Cliente] CHECK CONSTRAINT [FK_Cliente_TipoEmpresa]
GO
ALTER TABLE [dbo].[Contrato]  WITH CHECK ADD  CONSTRAINT [FK_Contrato_Cliente] FOREIGN KEY([idCliente])
REFERENCES [dbo].[Cliente] ([id])
GO
ALTER TABLE [dbo].[Contrato] CHECK CONSTRAINT [FK_Contrato_Cliente]
GO
ALTER TABLE [dbo].[Contrato]  WITH CHECK ADD  CONSTRAINT [FK_Contrato_TipoEvento] FOREIGN KEY([Tipo])
REFERENCES [dbo].[TipoEvento] ([id])
GO
ALTER TABLE [dbo].[Contrato] CHECK CONSTRAINT [FK_Contrato_TipoEvento]
GO
ALTER TABLE [dbo].[Valorizador]  WITH CHECK ADD  CONSTRAINT [FK_Valorizador_Contrato] FOREIGN KEY([id])
REFERENCES [dbo].[Contrato] ([id])
GO
ALTER TABLE [dbo].[Valorizador] CHECK CONSTRAINT [FK_Valorizador_Contrato]
GO
USE [master]
GO
ALTER DATABASE [OnBrakeZ] SET  READ_WRITE 
GO
USE [OnBrakeZ]
insert into TipoEmpresa values(1,  'SPA');
insert into TipoEmpresa values(2, 'EIRL');
insert into TipoEmpresa values(3, 'Limitada');
insert into TipoEmpresa values(4 ,'Sociedad Anónima');
GO
insert into ActividadEmpresa values( 1,'Agropecuaria');
insert into ActividadEmpresa values(2, 'Minería');
insert into ActividadEmpresa values(3, 'Manufactura');
insert into ActividadEmpresa values(4, 'Hoteleria ');
insert into ActividadEmpresa values(5, 'Alimentos');
insert into ActividadEmpresa values(6, 'Transporte');
insert into ActividadEmpresa values(7, 'Servicios');
insert into ActividadEmpresa values(8, 'Comercio');
GO
insert into TipoEvento values(1,'Matrimonio', 10 , 30);
insert into TipoEvento values(2,'Reuniones de empresas', 20 , 50);

