drop table empleado;

create table empleado 
(
    idempleado number(10) not null ,
    nombres varchar2(50) not null,
    apellidos varchar2(50) not null,
    rut varchar(10) not null,
    estado_civil varchar2(1)
    
);

ALTER TABLE empleado ADD CONSTRAINT idempleado_PK PRIMARY KEY (idempleado);
