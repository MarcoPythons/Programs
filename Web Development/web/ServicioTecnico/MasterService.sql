drop table usuario;



create table usuario(

    rut varchar2(10),
    nombre varchar2(30) not null,
    email varchar2(20) not null, 
    telefono varchar2(20) not null,
    mensaje varchar2(100) not null
    
);


alter table usuario add constraint run_pk primary key(run);

