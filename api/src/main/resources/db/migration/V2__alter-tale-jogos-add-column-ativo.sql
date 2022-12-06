alter table jogos add ativo tinyint;
update jogos set ativo = 1;
alter table jogos modify column ativo tinyint not null;
