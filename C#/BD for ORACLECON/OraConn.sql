drop table empelado; 


create table empleado
(
    idEmpleado number not null,
    nombreEmpleado varchar2(20),
    apellidoEmpleado varchar2(20),
    rutEmpelado varchar2(10),
    estadoCivil varchar2(1)

);



alter table empleado add constraint id_pk primary key (idEmpleado);



insert into empleado values(1, 'marco', 'peña' , '20203805-0', 'S');

select * from empleado;


commit;