
drop table if exists contrato;
drop table if exists cliente;
drop table if exists TipoEmpresa;
drop table if exists ActividadEmpresa;
drop table if exists TipoEvento;
drop table if exists Valorizador;

--alter database OnBrake set single_user with rollback immediate;

--alter database OnBrake modify name = OnBrakeZ;

--alter database OnBrakeZ set multi_user with rollback immediate;

create table Contrato (
id int primary key  identity (1,1) not null,
NumeroContrato bigint ,
Creacion date not null,
Termino date ,
FechaHoraInicio time,
FechaHoraTermino time,
Direccion varchar(100),
EstaVigente bit not null,
Tipo int not null,
Observaciones varchar(250),
idCliente int not null unique

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
Tipo int not null
);

create table TipoEmpresa(
id int primary key not null,
Descripcion varchar(100));

create table ActividadEmpresa(
id  int primary key  not null,
Descripcion varchar(100)
);



create table TipoEvento(
id int primary key   not null,
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

insert into Cliente ( rut, DV, RazonSocial, NombreContacto, MailContacto, Direccion, Telefono, Actividad, Tipo )
values( 202038050, '0', 'Contraando', 'Marco peña', 'marco@gmail.com', 'tu puta casa', 65753352, 1, 1);

insert into Cliente ( rut, DV, RazonSocial, NombreContacto, MailContacto, Direccion, Telefono, Actividad, Tipo )
values( 19802992, 'k', 'Papa Jhons', 'Mario Castañeda', 'mario@gmail.com', 'Av. grecia # 728', 987627365, 2, 2);

SET IDENTITY_INSERT Cliente OFF;

--select * from Cliente;
--delete from Cliente where id = 1;
--DBCC CHECKIDENT  (cliente, RESEED,1)

SET IDENTITY_INSERT contrato ON;

insert into Contrato ( NumeroContrato, Creacion, Termino , FechaHoraInicio, FechaHoraTermino, Direccion, EstaVigente, Tipo, Observaciones, idCliente)
values( 180620201810 ,convert(date,'18/06/2020',105), convert(date, '20/05/2021',105),CAST('6:10 PM' AS DATETIME2), CAST('6:20 AM' AS DATETIME2), 'tu puta casa', 1, 1, 'Tu puta familia', 1);


--delete from Contrato where id = 3;
--select * from Contrato;
--DBCC CHECKIDENT  (contrato, RESEED,1)

SET IDENTITY_INSERT contrato OFF;


--select * from valorizador;




insert into TipoEmpresa values(1,  'SPA');
insert into TipoEmpresa values(2, 'EIRL');
insert into TipoEmpresa values(3, 'Limitada');
insert into TipoEmpresa values(4 ,'Sociedad Anónima');

--delete from TipoEmpresa where id = 5
--select * from TipoEmpresa


insert into ActividadEmpresa values( 1,'Agropecuaria');
insert into ActividadEmpresa values(2, 'Minería');
insert into ActividadEmpresa values(3, 'Manufactura');
insert into ActividadEmpresa values(4, 'Hoteleria ');
insert into ActividadEmpresa values(5, 'Alimentos');
insert into ActividadEmpresa values(6, 'Transporte');
insert into ActividadEmpresa values(7, 'Servicios');
insert into ActividadEmpresa values(8, 'Comercio');

--select * from ActividadEmpresa;






insert into TipoEvento values(1,'Matrimonio', 10 , 30);
insert into TipoEvento values(2,'Reuniones de empresas', 20 , 50);

select * from TipoEvento


--select * from TipoEvento;





