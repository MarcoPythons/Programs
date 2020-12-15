drop table if exists contrato;
drop table if exists cliente;
drop table if exists TipoEmpresa;
drop table if exists ActividadEmpresa;
drop table if exists TipoEvento;
drop table if exists Valorizador;

create table Contrato (
id int primary key  identity (1,1) not null,
NumeroContrato int,
Creacion date not null,
Termino date ,
FechaHoraInicio time,
FechaHoraTermino time,
Direccion varchar(100),
EstaVigente bit not null,
Tipo int not null,
Observaciones varchar(250)

);

 										--date (fecha ejemplo: 20/13/2010)
										--datatime (fecha, tiempo ejemplo : 20/13/2010 18:00:00)
										--time (tiempo, ejemplo: 18:00:00)

create table Cliente(
id int primary key identity (1,1) not null,
rut int not null,
DV char(1) not null,
RazonSocial varchar(100),
NombreContacto varchar(100),
MailContacto varchar(100),
Direccion varchar(100),
Telefono int ,
Actividad int not null,
Tipo int not null,
NumeroContrato int );


create table TipoEmpresa(
id int primary key identity (1,1) not null,
Descripcion varchar(100));

create table ActividadEmpresa(
id  int primary key  identity (1,1) not null,
Descripcion varchar(100)
);

create table TipoEvento(
id int primary key  identity (1,1) not null,
Nombre varchar(100) not null,
ValorBase int not null,
PersonalBase int not null);


create table Valorizador(
id int primary key identity (1,1) not null,
ValorContratoCliente int ,
RecargoAsistentes int,
RecargoPersonal int
);




SET IDENTITY_INSERT Cliente ON

insert into Cliente (id, rut, DV, RazonSocial, NombreContacto, MailContacto, Direccion, Telefono, Actividad, Tipo )
values(1, 20203805, '0', 'Contraando', 'Marco peña', 'marco@gmail.com', 'tu puta casa', 65753352, 1, 1);

SET IDENTITY_INSERT Cliente OFF;


SET IDENTITY_INSERT contrato ON

insert into Contrato (id, NumeroContrato, Creacion, Termino, FechaHoraInicio, FechaHoraTermino, Direccion, EstaVigente, Tipo, Observaciones )
values(1, 20203805,convert(date,'18/06/2020',105), convert(date, '20/05/2021',105),CAST('6:10 PM' AS DATETIME2), CAST('6:20 AM' AS DATETIME2), 'tu puta casa', 1, 1, 'Tu puta familia');


SET IDENTITY_INSERT contrato OFF;



