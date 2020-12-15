
CREATE TABLE users(
	code int (5) primary key not null unique,
    user_name varchar(20) not null unique,
    pasword varchar(100) not null 
    
	
);

CREATE TABLE tipopago (
	code int not null,
    FOREIGN KEY (code) REFERENCES users(code),
    fecha varchar(20) not null,
    metodo_pago varchar(10) not null,
    gasto float not null,
    notas varchar(100)
);

select * from users;
select * from tipopago;


select 	fecha, metodo_pago,gasto , notas from tipopago;



select * from users