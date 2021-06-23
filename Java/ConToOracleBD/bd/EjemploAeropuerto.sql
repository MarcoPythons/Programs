DROP TABLE avion CASCADE CONSTRAINTS ;
DROP TABLE linea CASCADE CONSTRAINTS ;
DROP TABLE vuelo CASCADE CONSTRAINTS ;
DROP TABLE piloto CASCADE CONSTRAINTS ;
DROP TABLE sobrecargo CASCADE CONSTRAINTS ;
DROP TABLE pasajero CASCADE CONSTRAINTS ;
DROP TABLE vuelo_pasajero CASCADE CONSTRAINTS ;
DROP TABLE sobrecargo_vuelo CASCADE CONSTRAINTS ;
DROP TABLE tipo_pasajero CASCADE CONSTRAINTS ;
DROP TABLE incentivo_hrs_vuelo CASCADE CONSTRAINTS;
DROP TABLE incentivo_piloto CASCADE CONSTRAINTS;
DROP TABLE errores CASCADE CONSTRAINTS;

create table errores 
 (	
    codigo number,
    descripcion_error varchar2(255 byte),
	programa varchar2(50)
 );
 
CREATE TABLE avion
  (
    cod_avion INT NOT NULL ,
    cod_linea INT,
    num_asientos INT,
    num_motores INT
  ) ;
ALTER TABLE avion ADD CONSTRAINT avion_PK PRIMARY KEY ( cod_avion ) ;

CREATE TABLE linea
  (
    cod_linea INT,
    nombre NVARCHAR2 (15) 
  ) ;
ALTER TABLE linea ADD CONSTRAINT linea_PK PRIMARY KEY ( cod_linea ) ;

CREATE TABLE piloto
  (
    rut NVARCHAR2 (8) NOT NULL ,
    dv NCHAR (1) ,
    ape_pat NVARCHAR2 (20) ,
    ape_mat NVARCHAR2 (20) ,
    nombres NVARCHAR2 (30) ,
    direccion NVARCHAR2 (50),
    sueldo INT,
    hrs_vuelo INT
  ) ;
ALTER TABLE piloto ADD CONSTRAINT piloto_PK PRIMARY KEY ( rut ) ;

CREATE TABLE pasajero
  (
    rut NVARCHAR2 (8) NOT NULL ,
    dv NCHAR (1) ,
    ape_pat NVARCHAR2 (20) ,
    ape_mat NVARCHAR2 (20) ,
    nombres NVARCHAR2 (30) ,
    direccion NVARCHAR2 (50) ,
    mail NVARCHAR2 (50) ,
    fecha_nac  DATE,
    cod_tipo INT,
    kms int
  ) ;
ALTER TABLE pasajero ADD CONSTRAINT pasajero_PK PRIMARY KEY ( rut ) ;

CREATE TABLE tipo_pasajero
  (
    cod_tipo int ,
    descripcion NVARCHAR2 (15) NOT NULL 
  ) ;
ALTER TABLE tipo_pasajero ADD CONSTRAINT tipo_PK PRIMARY KEY ( cod_tipo ) ;

CREATE TABLE sobrecargo
  (
    rut NVARCHAR2 (8) NOT NULL ,
    dv NCHAR (1) ,
    ape_pat NVARCHAR2 (20) ,
    ape_mat NVARCHAR2 (20) ,
    nombres NVARCHAR2 (30) ,
    direccion NVARCHAR2 (50),
    sueldo INT,
    sexo CHAR (1)
  ) ;
ALTER TABLE sobrecargo ADD CONSTRAINT sobrecargo_PK PRIMARY KEY ( rut ) ;

CREATE TABLE vuelo
  (
    cod_vuelo INT NOT NULL ,
    cod_avion INT NOT NULL ,
    rut_piloto NVARCHAR2 (8) NOT NULL ,
    fecha_vuelo DATE 
  ) ;
ALTER TABLE vuelo ADD CONSTRAINT vuelo_PK PRIMARY KEY ( cod_vuelo ) ;

CREATE TABLE vuelo_pasajero
  (
    cod_vuelo INT NOT NULL ,
    rut_pasajero NVARCHAR2 (8) NOT NULL ,
    asiento  NVARCHAR2 (3),
    precio int
  ) ;

CREATE TABLE sobrecargo_vuelo
  (
    rut_sobrecargo NVARCHAR2 (8) NOT NULL ,
	cod_vuelo INT NOT NULL 
  ) ;

create table incentivo_hrs_vuelo
  (
    horas_inf number,
    horas_sup number,
    porcentaje number
  );

create table incentivo_piloto
  (
    rut NVARCHAR2 (8),
    hrs_vuelo number,
    cant_vuelos number,
    sobre_hombre number,
    aviones number,
    total number
  );

ALTER TABLE vuelo ADD CONSTRAINT vuelo_avion_FK FOREIGN KEY ( cod_avion ) REFERENCES avion ( cod_avion ) ;
ALTER TABLE vuelo ADD CONSTRAINT vuelo_piloto_FK FOREIGN KEY ( rut_piloto ) REFERENCES piloto ( rut ) ;
ALTER TABLE vuelo_pasajero ADD CONSTRAINT vuelo_pasajero_vuelo_FK FOREIGN KEY ( cod_vuelo ) REFERENCES vuelo ( cod_vuelo ) ;
ALTER TABLE vuelo_pasajero ADD CONSTRAINT vuelo_pasajero_FK FOREIGN KEY ( rut_pasajero ) REFERENCES pasajero ( rut ) ;
ALTER TABLE sobrecargo_vuelo ADD CONSTRAINT sobrecargo_vuelo_rut_FK FOREIGN KEY ( rut_sobrecargo ) REFERENCES sobrecargo ( rut ) ;
ALTER TABLE sobrecargo_vuelo ADD CONSTRAINT sobrecargo_vuelo_vuelo_FK FOREIGN KEY ( cod_vuelo ) REFERENCES vuelo ( cod_vuelo ) ;
ALTER TABLE avion ADD CONSTRAINT avion_linea_FK FOREIGN KEY ( cod_linea ) REFERENCES linea ( cod_linea ) ;
ALTER TABLE pasajero ADD CONSTRAINT pasajero_tipo_FK FOREIGN KEY ( cod_tipo ) REFERENCES tipo_pasajero ( cod_tipo ) ;

Insert into tipo_pasajero values (1,'PREMIUM');
Insert into tipo_pasajero values (2,'gold');
Insert into tipo_pasajero values (3,'Silver');
Insert into tipo_pasajero values (4,'STANDARD');

Insert into linea values (1,'LATAM');
Insert into linea values (2,'SKY');
Insert into linea values (3,'Copa');
Insert into linea values (4,'Panam');
Insert into linea values (5,'JetLAN');
  
Insert into avion values (1,2,50,2);
Insert into avion values (2,1,50,4);
Insert into avion values (3,3,100,2);
Insert into avion values (4,4,200,4);
Insert into avion values (5,4,250,2);
Insert into avion values (6,3,50,4);
Insert into avion values (7,2,100,2);
Insert into avion values (8,null,200,4);
Insert into avion values (9,1,null,2);
Insert into avion values (10,4,null,4);
  
Insert into pasajero values ('9863013','9','ARELLANO','GARNHAM','ALEJANDRO ERNESTO','Pasaje 10 N° 15','arellano@yahoo.com','21/8/1999',1,1151);
Insert into pasajero values ('5459735','5','ARAVENA','TORM','MARIA ELINA','Gabriela Mistral N° s/n',null,'27/9/1997',1,389);
Insert into pasajero values ('5518715','0','GARCIA','AGUILAR','DEBORAH ANDREA','San Pedro (Manzan f lote 1) N° 20',null,'11/8/1990',null,1256);
Insert into pasajero values ('10013498','4','GARRIDO','LLONA','ISABEL MARGARITA','Los Copihues N° s/n','garrido@hotmail.com','01/8/2000',2,812);
Insert into pasajero values ('5555474','9','FREILE','CARMONA','HERNAN','Sector Estación sitio 7, Mz A N° s/n','freile@yahoo.com','21/9/2000',3,888);
Insert into pasajero values ('10029708','6','ALVAREZ','MACHADO','GONZALO','Alberto Blest Gana N° 29','alvarez@hotmail.com','11/04/2005',1,507);
Insert into pasajero values ('10062891','0','FERNANDEZ','BRAVO','ALEJANDRO MARTIN','Psje. Los Acacios N° 3',null,'13/05/1990',null,1255);
Insert into pasajero values ('5705278','3','ABARCA','CASTILLO','MARIA TERESA','Israel N° s/n','abarca@gmail.com',null,null,2258);
Insert into pasajero values ('2764231','4','AGUILAR','ESCOBAR','SILVIA GLADYS','Israel N° s/n','aguilar@hotmail.com',null,null,1330);
Insert into pasajero values ('5708360','3','HERRERA','MENESES','MIGUEL HERIBERTO','Psje. Jerusalén N° s/n','herrera@gmail.com','14/05/2000',3,856);
Insert into pasajero values ('10194260','0','DEL VALLE','SANCHEZ','MARIA GABRIELA','Nazaret N° s/n',null,null,null,725);
Insert into pasajero values ('10276591','5','BUSCAGLIONE','CIVIT','CETTINA ANTONELLA','Psje. Galilea N° s/n','buscaglione@hotmail.com','02/08/1996',1,1000);

Insert into piloto values ('9296759','K','ARANCIBIA','CASTILLO','SANTIAGO HORACIO','Lleu- Lleu N° 34-B',800000,800);
Insert into piloto values ('9535488','2','CELEDON','BESNIER','ANA PAOLA','Calafquen N° 675',1200000,600);
Insert into piloto values ('5359317','8','CERPA','GONZALEZ','MACARENA','Lleu- Lleu N° 34-A',2400000,400);
Insert into piloto values ('6823198','1','DURAN','BENITEZ','NELLA','California N° 54',780000,450);
Insert into piloto values ('6908327','7','ARAVENA','TORRES','HECTOR','San Martín N° 13',1250000,1200);
Insert into piloto values ('7225083','4','CACERES','CERDA','NORA','Psje. Bolivia N° 45',null,1500);
Insert into piloto values ('7242947','8','FIGUEROA','SANTOS','LORETO VALENTINA','Vicente Millan N° 260',4000000,2000);
Insert into piloto values ('5677491','7','ESPINOZA','GUENDELMAN','ANDREA PAZ','Vicente Millan N° 191',4500000,2300);
Insert into piloto values ('8026728','2','HERRERA','BARRIENTOS','KARINA DEL','Psje. Bolivia N° 48',null,100);
Insert into piloto values ('8280474','9','DIAZ','CAROCA','MARIA XIMENA','El salvador N° 56',950000,700);
Insert into piloto values ('8385436','7','BURGOS','BRAVO','MIGUEL ANDRES','Los acacios Oriente N° 743',2750000,null);
Insert into piloto values ('8445131','2','BIRKNER','PINTO','ROSA REGINA','California N° 23',null,null);
Insert into piloto values ('3790142','3','LEYTON','MADARIAGA','ROBERTO','PASAJE 1 CASA N° 62',null,null);
Insert into piloto values ('8599593','6','FLORES','ULLOA','CLEOFE GUILLERMO','California N° 24',null,null);
Insert into piloto values ('8685364','7','CAVIERES','RODRIGUEZ','FRANCISCA ANTONINA','Psje. Argentina N° 1',null,null);

Insert into sobrecargo values ('8605075','7','BERTOLONE','GALAZ','MARIA RAQUEL',null,410000,'F');
Insert into sobrecargo values ('4530976','2','GUZMAN','MIRANDA','MARIELA ALEJANDRA',null,790000,'F');
Insert into sobrecargo values ('4590086','k','CACERES','FRAILE','MARGARITA',null,990000,'F');
Insert into sobrecargo values ('8942677','4','DEL VALLE','SANZANA','JULIO DAVID',null,null,'M');
Insert into sobrecargo values ('9086608','7','BRSTILO','MADARIAGA','RACHELLE DOMINIQUE',null,610000,'F');
Insert into sobrecargo values ('4659368','5','GUTIERREZ','RIQUELME','CONSUELO BEATRIZ',null,320000,'F');
Insert into sobrecargo values ('4798766','0','ALFARO','GUERRA','DANIEL ALEJANDRO',null,550000,'M');
Insert into sobrecargo values ('9148848','5','CIENFUEGOS','SAAVEDRA','CRISTIAN',null,null,'M');
Insert into sobrecargo values ('4876452','5','CERPA','PARRA','MARIA CAROLINA',null,null,'F');
Insert into sobrecargo values ('9228243','0','CRUZ','SARNO','CESAR ALEJANDRO',null,null,'M');
Insert into sobrecargo values ('5286551','4','BAEZA','ALVAREZ','CARLA CECILIA',null,null,'F');
Insert into sobrecargo values ('9285197','4','ARENAS','ALVAREZ','CLAUDIA ADA',null,null,'F');

Insert into vuelo values (1,3,'9296759','21/01/2016');
Insert into vuelo values (2,1,'6908327','12/05/2016');
Insert into vuelo values (3,5,'8026728','03/07/2016');
Insert into vuelo values (4,3,'5677491','07/09/2016');
Insert into vuelo values (5,5,'6908327','28/01/2017');
Insert into vuelo values (6,4,'5677491','14/05/2017');
Insert into vuelo values (7,1,'6908327','05/07/2017');
Insert into vuelo values (8,4,'5677491','11/08/2017');
Insert into vuelo values (9,5,'6908327','20/09/2017');
Insert into vuelo values (10,3,'8026728','10/09/2017');

Insert into sobrecargo_vuelo values ('8605075',1);
Insert into sobrecargo_vuelo values ('4659368',2);
Insert into sobrecargo_vuelo values ('9086608',3);
Insert into sobrecargo_vuelo values ('8605075',4);
Insert into sobrecargo_vuelo values ('4798766',5);
Insert into sobrecargo_vuelo values ('9086608',6);
Insert into sobrecargo_vuelo values ('9086608',7);
Insert into sobrecargo_vuelo values ('9285197',8);
Insert into sobrecargo_vuelo values ('4659368',9);

Insert into vuelo_pasajero values (1,'5555474',2,67000);
Insert into vuelo_pasajero values (1,'5708360',6,75000);
Insert into vuelo_pasajero values (1,'10276591',7,120000);

Insert into vuelo_pasajero values (3,'10276591',1,100000);
Insert into vuelo_pasajero values (3,'10194260',2,69000);
Insert into vuelo_pasajero values (3,'5708360',3,55000);
Insert into vuelo_pasajero values (3,'9863013',4,89000);

Insert into vuelo_pasajero values (4,'10013498',4,67000);
Insert into vuelo_pasajero values (4,'5555474',5,100000);
Insert into vuelo_pasajero values (4,'10029708',6,175000);
Insert into vuelo_pasajero values (4,'10062891',7,120000);

insert into incentivo_hrs_vuelo values (201,500,10);  
insert into incentivo_hrs_vuelo values (501,1000,15);  
insert into incentivo_hrs_vuelo values (1001,2000,25);
insert into incentivo_hrs_vuelo values (2001,3000,35);  

COMMIT;