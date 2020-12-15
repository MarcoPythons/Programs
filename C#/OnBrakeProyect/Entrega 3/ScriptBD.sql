USE [master]
GO
/****** Object:  Database [OnBreak]    ******/
CREATE DATABASE [OnBreak2] 
GO

USE [OnBreak2]
GO

/****** Object:  Table [dbo].[ActividadEmpresa]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ActividadEmpresa](
	[IdActividadEmpresa] [int] NOT NULL,
	[Descripcion] [nvarchar](20) NOT NULL,
 CONSTRAINT [ActividadEmpresa_PK] PRIMARY KEY CLUSTERED 
(
	[IdActividadEmpresa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Cenas]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cenas](
	[Numero] [nvarchar](12) NOT NULL,
	[IdTipoAmbientacion] [int] NOT NULL,
	[MusicaAmbiental] [bit] NOT NULL,
	[LocalOnBreak] [bit] NOT NULL,
	[OtroLocalOnBreak] [bit] NOT NULL,
	[ValorArriendo] [float] NOT NULL,
 CONSTRAINT [Key15] PRIMARY KEY CLUSTERED 
(
	[Numero] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Cliente]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cliente](
	[RutCliente] [nvarchar](10) NOT NULL,
	[RazonSocial] [nvarchar](50) NOT NULL,
	[NombreContacto] [nvarchar](50) NOT NULL,
	[MailContacto] [nvarchar](30) NOT NULL,
	[Direccion] [nvarchar](30) NOT NULL,
	[Telefono] [nvarchar](15) NOT NULL,
	[IdActividadEmpresa] [int] NOT NULL,
	[IdTipoEmpresa] [int] NOT NULL,
 CONSTRAINT [Cliente_PK] PRIMARY KEY CLUSTERED 
(
	[RutCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Cocktail]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Cocktail](
	[Numero] [nvarchar](12) NOT NULL,
	[IdTipoAmbientacion] [int] NOT NULL,
	[Ambientacion] [bit] NOT NULL,
	[MusicaAmbiental] [bit] NOT NULL,
	[MusicaCliente] [bit] NOT NULL,
 CONSTRAINT [Key14] PRIMARY KEY CLUSTERED 
(
	[Numero] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[CoffeeBreak]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[CoffeeBreak](
	[Numero] [nvarchar](12) NOT NULL,
	[Vegetariana] [bit] NOT NULL,
 CONSTRAINT [Key13] PRIMARY KEY CLUSTERED 
(
	[Numero] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Contrato]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contrato](
	[Numero] [nvarchar](12) NOT NULL,
	[Creacion] [datetime] NOT NULL,
	[Termino] [datetime] NOT NULL,
	[RutCliente] [nvarchar](10) NOT NULL,
	[IdModalidad] [nvarchar](5) NOT NULL,
	[IdTipoEvento] [int] NOT NULL,
	[FechaHoraInicio] [datetime] NOT NULL,
	[FechaHoraTermino] [datetime] NOT NULL,
	[Asistentes] [int] NOT NULL,
	[PersonalAdicional] [int] NOT NULL,
	[Realizado] [bit] NOT NULL,
	[ValorTotalContrato] [float] NOT NULL,
	[Observaciones] [nvarchar](250) NOT NULL,
 CONSTRAINT [Key1] PRIMARY KEY CLUSTERED 
(
	[Numero] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[ModalidadServicio]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[ModalidadServicio](
	[IdModalidad] [nvarchar](5) NOT NULL,
	[IdTipoEvento] [int] NOT NULL,
	[Nombre] [nvarchar](20) NOT NULL,
	[ValorBase] [float] NOT NULL,
	[PersonalBase] [int] NOT NULL,
 CONSTRAINT [Key2] PRIMARY KEY CLUSTERED 
(
	[IdModalidad] ASC,
	[IdTipoEvento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TipoAmbientacion]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TipoAmbientacion](
	[IdTipoAmbientacion] [int] NOT NULL,
	[Descripcion] [nvarchar](15) NOT NULL,
 CONSTRAINT [Key16] PRIMARY KEY CLUSTERED 
(
	[IdTipoAmbientacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

CREATE TABLE dbo.Respaldo
	(
	Id real NOT NULL,
	RazonSocial nvarchar(MAX) NULL,
	fecha_inicio nvarchar(MAX) NULL,
	hora_inicio nvarchar(MAX) NULL,
	evento_realizado nvarchar(MAX) NULL,
	Tipo_evento nvarchar(MAX) NULL,
	Modalidad_evento nvarchar(MAX) NULL,
	Tipo_ambientacion nvarchar(MAX) NULL,
	Musica_ambiental nvarchar(MAX) NULL,
	Musica_cliente nvarchar(MAX) NULL,
	Fecha_termino nvarchar(MAX) NULL,
	local_o nvarchar(MAX) NULL,
	Hora_termino nvarchar(MAX) NULL,
	Observaciones nvarchar(MAX) NULL,
	Asistentes_evento nvarchar(MAX) NULL,
	Personal_adicional nvarchar(MAX) NULL,
	Valor_contrato nvarchar(MAX) NULL
	)  ON [PRIMARY]
	 TEXTIMAGE_ON [PRIMARY]
GO
ALTER TABLE dbo.Respaldo ADD CONSTRAINT
	PK_Respaldo PRIMARY KEY CLUSTERED 
	(
	Id
	) WITH( STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[TipoEmpresa]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TipoEmpresa](
	[IdTipoEmpresa] [int] NOT NULL,
	[Descripcion] [nvarchar](20) NOT NULL,
 CONSTRAINT [TipoEmpresa_PK] PRIMARY KEY CLUSTERED 
(
	[IdTipoEmpresa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[TipoEvento]    ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[TipoEvento](
	[IdTipoEvento] [int] NOT NULL,
	[Descripcion] [nvarchar](15) NOT NULL,
 CONSTRAINT [Key3] PRIMARY KEY CLUSTERED 
(
	[IdTipoEvento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
INSERT [dbo].[ActividadEmpresa] ([IdActividadEmpresa], [Descripcion]) VALUES (1, N'Agropecuaria')
INSERT [dbo].[ActividadEmpresa] ([IdActividadEmpresa], [Descripcion]) VALUES (2, N'Miner�a')
INSERT [dbo].[ActividadEmpresa] ([IdActividadEmpresa], [Descripcion]) VALUES (3, N'Manufactura')
INSERT [dbo].[ActividadEmpresa] ([IdActividadEmpresa], [Descripcion]) VALUES (4, N'Comercio')
INSERT [dbo].[ActividadEmpresa] ([IdActividadEmpresa], [Descripcion]) VALUES (5, N'Hoteler�a')
INSERT [dbo].[ActividadEmpresa] ([IdActividadEmpresa], [Descripcion]) VALUES (6, N'Alimentos')
INSERT [dbo].[ActividadEmpresa] ([IdActividadEmpresa], [Descripcion]) VALUES (7, N'Transporte')
INSERT [dbo].[ActividadEmpresa] ([IdActividadEmpresa], [Descripcion]) VALUES (8, N'Servicios')
INSERT [dbo].[ModalidadServicio] ([IdModalidad], [IdTipoEvento], [Nombre], [ValorBase], [PersonalBase]) VALUES (N'CB001', 10, N'Light Break', 3, 2)
INSERT [dbo].[ModalidadServicio] ([IdModalidad], [IdTipoEvento], [Nombre], [ValorBase], [PersonalBase]) VALUES (N'CB002', 10, N'	Journal Break', 8, 6)
INSERT [dbo].[ModalidadServicio] ([IdModalidad], [IdTipoEvento], [Nombre], [ValorBase], [PersonalBase]) VALUES (N'CB003', 10, N'	Day Break', 12, 6)
INSERT [dbo].[ModalidadServicio] ([IdModalidad], [IdTipoEvento], [Nombre], [ValorBase], [PersonalBase]) VALUES (N'CE001', 30, N'	Ejecutiva', 25, 10)
INSERT [dbo].[ModalidadServicio] ([IdModalidad], [IdTipoEvento], [Nombre], [ValorBase], [PersonalBase]) VALUES (N'CE002', 30, N'Celebraci�n', 35, 14)
INSERT [dbo].[ModalidadServicio] ([IdModalidad], [IdTipoEvento], [Nombre], [ValorBase], [PersonalBase]) VALUES (N'CO001', 20, N'	Quick Cocktail', 6, 4)
INSERT [dbo].[ModalidadServicio] ([IdModalidad], [IdTipoEvento], [Nombre], [ValorBase], [PersonalBase]) VALUES (N'CO002', 20, N'	Ambient Cocktail', 10, 5)
INSERT [dbo].[TipoAmbientacion] ([IdTipoAmbientacion], [Descripcion]) VALUES (10, N'B�sica')
INSERT [dbo].[TipoAmbientacion] ([IdTipoAmbientacion], [Descripcion]) VALUES (20, N'Personalizada')
INSERT [dbo].[TipoEmpresa] ([IdTipoEmpresa], [Descripcion]) VALUES (10, N'SPA')
INSERT [dbo].[TipoEmpresa] ([IdTipoEmpresa], [Descripcion]) VALUES (20, N'EIRL')
INSERT [dbo].[TipoEmpresa] ([IdTipoEmpresa], [Descripcion]) VALUES (30, N'Limitada')
INSERT [dbo].[TipoEmpresa] ([IdTipoEmpresa], [Descripcion]) VALUES (40, N'Sociedad An�nima')
INSERT [dbo].[TipoEvento] ([IdTipoEvento], [Descripcion]) VALUES (10, N'Coffee Break')
INSERT [dbo].[TipoEvento] ([IdTipoEvento], [Descripcion]) VALUES (20, N'Cocktail')
INSERT [dbo].[TipoEvento] ([IdTipoEvento], [Descripcion]) VALUES (30, N'Cenas')
/****** Object:  Index [IX_Cena_TipoAmbentacion_FK1]    ******/
CREATE NONCLUSTERED INDEX [IX_Cena_TipoAmbentacion_FK1] ON [dbo].[Cenas]
(
	[IdTipoAmbientacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
/****** Object:  Index [IX_Cocktail_TipoAmbentacion_FK1]    ******/
CREATE NONCLUSTERED INDEX [IX_Cocktail_TipoAmbentacion_FK1] ON [dbo].[Cocktail]
(
	[IdTipoAmbientacion] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_Contrato_Cliente_FK1]    ******/
CREATE NONCLUSTERED INDEX [IX_Contrato_Cliente_FK1] ON [dbo].[Contrato]
(
	[RutCliente] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
SET ANSI_PADDING ON

GO
/****** Object:  Index [IX_Contrato_ModalidadEvento_FK1]    ******/
CREATE NONCLUSTERED INDEX [IX_Contrato_ModalidadEvento_FK1] ON [dbo].[Contrato]
(
	[IdModalidad] ASC,
	[IdTipoEvento] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, SORT_IN_TEMPDB = OFF, DROP_EXISTING = OFF, ONLINE = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Cenas]  WITH CHECK ADD  CONSTRAINT [Cena_TipoAmbientacion_FK1] FOREIGN KEY([IdTipoAmbientacion])
REFERENCES [dbo].[TipoAmbientacion] ([IdTipoAmbientacion])
GO
ALTER TABLE [dbo].[Cenas] CHECK CONSTRAINT [Cena_TipoAmbientacion_FK1]
GO
ALTER TABLE [dbo].[Cenas]  WITH CHECK ADD  CONSTRAINT [Contrato_Cenas_FK1] FOREIGN KEY([Numero])
REFERENCES [dbo].[Contrato] ([Numero])
GO
ALTER TABLE [dbo].[Cenas] CHECK CONSTRAINT [Contrato_Cenas_FK1]
GO
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [Cliente_ActividadEmpresa_FK1] FOREIGN KEY([IdActividadEmpresa])
REFERENCES [dbo].[ActividadEmpresa] ([IdActividadEmpresa])
GO
ALTER TABLE [dbo].[Cliente] CHECK CONSTRAINT [Cliente_ActividadEmpresa_FK1]
GO
ALTER TABLE [dbo].[Cliente]  WITH CHECK ADD  CONSTRAINT [Cliente_TipoEmpresa_FK1] FOREIGN KEY([IdTipoEmpresa])
REFERENCES [dbo].[TipoEmpresa] ([IdTipoEmpresa])
GO
ALTER TABLE [dbo].[Cliente] CHECK CONSTRAINT [Cliente_TipoEmpresa_FK1]
GO
ALTER TABLE [dbo].[Cocktail]  WITH CHECK ADD  CONSTRAINT [Cocktail_TipoAmbientacion_FK1] FOREIGN KEY([IdTipoAmbientacion])
REFERENCES [dbo].[TipoAmbientacion] ([IdTipoAmbientacion])
GO
ALTER TABLE [dbo].[Cocktail] CHECK CONSTRAINT [Cocktail_TipoAmbientacion_FK1]
GO
ALTER TABLE [dbo].[Cocktail]  WITH CHECK ADD  CONSTRAINT [Contrato_Cocktail_FK1] FOREIGN KEY([Numero])
REFERENCES [dbo].[Contrato] ([Numero])
GO
ALTER TABLE [dbo].[Cocktail] CHECK CONSTRAINT [Contrato_Cocktail_FK1]
GO
ALTER TABLE [dbo].[CoffeeBreak]  WITH CHECK ADD  CONSTRAINT [Contrato_CoffeeBreak_FK1] FOREIGN KEY([Numero])
REFERENCES [dbo].[Contrato] ([Numero])
GO
ALTER TABLE [dbo].[CoffeeBreak] CHECK CONSTRAINT [Contrato_CoffeeBreak_FK1]
GO
ALTER TABLE [dbo].[Contrato]  WITH CHECK ADD  CONSTRAINT [Contrato_Cliente_FK1] FOREIGN KEY([RutCliente])
REFERENCES [dbo].[Cliente] ([RutCliente])
GO
ALTER TABLE [dbo].[Contrato] CHECK CONSTRAINT [Contrato_Cliente_FK1]
GO
ALTER TABLE [dbo].[Contrato]  WITH CHECK ADD  CONSTRAINT [Contrato_ModalidadEvento_FK1] FOREIGN KEY([IdModalidad], [IdTipoEvento])
REFERENCES [dbo].[ModalidadServicio] ([IdModalidad], [IdTipoEvento])
GO
ALTER TABLE [dbo].[Contrato] CHECK CONSTRAINT [Contrato_ModalidadEvento_FK1]
GO
ALTER TABLE [dbo].[ModalidadServicio]  WITH CHECK ADD  CONSTRAINT [ModalidadServicio_TipoEvento_FK1] FOREIGN KEY([IdTipoEvento])
REFERENCES [dbo].[TipoEvento] ([IdTipoEvento])
GO
ALTER TABLE [dbo].[ModalidadServicio] CHECK CONSTRAINT [ModalidadServicio_TipoEvento_FK1]
GO
USE [master]
GO
ALTER DATABASE [OnBreak] SET  READ_WRITE 
GO




