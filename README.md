# Projeto Fuctura - Sistema Gerenciador de Veículos

### Versão Java - 17

### Dependências do pom.xml
```bash
	    <dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<version>42.7.3</version>
		</dependency>

		<dependency>
			<groupId>com.github.javafaker</groupId>
			<artifactId>javafaker</artifactId>
			<version>1.0.2</version>
		</dependency>

		<dependency>
			<groupId>com.google.code.gson</groupId>
			<artifactId>gson</artifactId>
			<version>2.10.1</version>
		</dependency>
```
### Banco PostgreSQL

```sql
create table veiculo(
	codigo serial primary key not null,
	placa varchar(8) not null,
	modelo varchar(100) not null,
	ano integer not null,
	valor float
);

create table endereco(
	codigo serial primary key not null,
	cep varchar(20),
	logadouro varchar(100),
	complemento varchar(200),
	numero numeric,
	cod_cliente integer
);


create table loja(
	codigo serial primary key not null,
	nome varchar(100),
	cod_veiculo integer,
	cod_endereco integer,
	foreign key (cod_veiculo) references veiculo(codigo),
	foreign key (cod_endereco) references endereco(codigo)
);


insert into veiculo(placa, modelo, ano, valor) values ('OYT4467', 'Fiesta', 2014, 28000);
insert into loja(nome, cod_veiculo, cod_endereco) values ('Auto Nunes', 1, 1);

insert into cliente (nome, cpf, celular) values ('Roberto Dantas', '00012345678', '81988762089');
insert into endereco (cep, logadouro, complemento, numero, cod_cliente)values ('54500000', 'Rua xpto', '', 100, 1 );


--select * from veiculo;
-- select * from endereco;
--select * from loja;

select * from endereco;

create table tipo(
	codigo serial primary key not null,
	descricao varchar(200) not null,
	cod_veiculo integer,
	foreign key (cod_veiculo) references veiculo(codigo)
);

create table venda(
	codigo serial primary key not null,
	valor float,
	cod_loja integer,
	cod_vendedor integer,
	cod_cliente integer
); 

--insert into tipo (descricao, cod_veiculo) values ('Passeio', 1);
--select * from tipo;

create table vendedor(
	codigo serial primary key not null,
	nome varchar(60),
	cod_venda integer,
	foreign key(cod_venda) references venda(codigo)
);


alter table endereco add column cod_cliente integer;


create table cliente(
	codigo serial primary key not null,
	nome text,
	cpf text,
	celular text
);

ALTER TABLE endereco ADD FOREIGN KEY (cod_cliente) REFERENCES cliente(codigo);

-- ALTER TABLE tabela_filha
-- ADD CONSTRAINT nome_constraint FOREIGN KEY (coluna) REFERENCES tabela-pai(coluna);



ALTER TABLE venda ADD FOREIGN KEY (cod_cliente) REFERENCES cliente(codigo);
alter table venda add foreign key (cod_loja) references loja(codigo);

```

### ER Diagrama

![image](https://github.com/robertocajueiro/SistemaGerenciadordeVeiculos/assets/28118980/b34851ac-6913-498e-b670-5512d8eaaa94)


# Exemplo
