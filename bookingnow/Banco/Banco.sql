 create table Restaurante(NomeRestaurante varchar(30),id serial,NumeroRestaurante int(9),CnpjReservante int(11));
 
 create table reserva(id serial, NomeReservante varchar(30),NumeroReservante int(9),CpfReservante int(11) primary key);