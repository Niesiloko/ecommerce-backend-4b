insert into categoria (nome, descricao) values ('Informática', 'Produtos de Informática');
insert into categoria (nome, descricao) values ('Livros', 'Livros Técnicos');

insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Código Limpo', 'Livro do Autor Robert C. Martin', 87.34, 20, 2);

INSERT INTO clientes (nome, email, telefone) VALUES ('Ana Beatriz', 'ana@email.com', '11999999999');
INSERT INTO clientes (nome, email, telefone) VALUES ('João Marcos', 'joao@email.com', '11988888888');
INSERT INTO clientes (nome, email, telefone) VALUES ('Mariana Silva', 'mariana@email.com', '11977777777');
INSERT INTO clientes (nome, email, telefone) VALUES ('Carlos Eduardo', 'carlos@email.com', '11966666666');
INSERT INTO clientes (nome, email, telefone) VALUES ('Lucas Lima', 'Lucas@email.com', '11955555555');

INSERT INTO pedidos (data, status, valor_total, cliente_id) VALUES ('2026-09-01T10:00:00', 'AGUARDANDO', 4500.00, 1);
INSERT INTO pedidos (data, status, valor_total, cliente_id) VALUES ('2026-09-01T11:30:00', 'PAGO', 2500.00, 2);
INSERT INTO pedidos (data, status, valor_total, cliente_id) VALUES ('2026-09-02T09:15:00', 'ENVIADO', 3000.00, 3);
INSERT INTO pedidos (data, status, valor_total, cliente_id) VALUES ('2026-09-02T14:20:00', 'ENTREGUE', 4000.00, 4);
INSERT INTO pedidos (data, status, valor_total, cliente_id) VALUES ('2026-09-02T16:45:00', 'CANCELADO', 1200.00, 5);

INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id) VALUES (1, 4500.00, 1, 1);
INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id) VALUES (1, 2500.00, 2, 2);
INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id) VALUES (1, 3000.00, 3, 3);
INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id) VALUES (1, 4000.00, 4, 4);
INSERT INTO item_pedido (quantidade, valor_unitario, pedido_id, produto_id) VALUES (1, 1200.00, 5, 5);

INSERT INTO pagamento (valor, data, status, tipo, pedido_id) VALUES (4500.00, '2026-09-01T10:05:00', 'PENDENTE', 'BOLETO', 1);
INSERT INTO pagamento (valor, data, status, tipo, pedido_id) VALUES (2500.00, '2026-09-01T11:35:00', 'APROVADO', 'PIX', 2);
INSERT INTO pagamento (valor, data, status, tipo, pedido_id) VALUES (3000.00, '2026-09-02T09:20:00', 'APROVADO', 'CARTAO', 3);
INSERT INTO pagamento (valor, data, status, tipo, pedido_id) VALUES (4000.00, '2026-09-02T14:25:00', 'APROVADO', 'PIX', 4);
INSERT INTO pagamento (valor, data, status, tipo, pedido_id) VALUES (1200.00, '2026-09-02T16:50:00', 'RECUSADO', 'CARTAO', 5);

insert into categoria (nome, descricao) values ('Informática', 'Produtos de Informática');
insert into categoria (nome, descricao) values ('Livros', 'Livros Técnicos');
insert into categoria (nome, descricao) values ('Eletrônicos', 'Aparelhos Eletrônicos');
insert into categoria (nome, descricao) values ('Casa e Decoração', 'Produtos para casa e decoração');
insert into categoria (nome, descricao) values ('Acessórios', 'Acessórios e itens de uso pessoal');

insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Código Limpo', 'Livro do Autor Robert C. Martin', 100.00, 20, 2);
insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Notebook Dell Inspiron', 'Notebook com processador Intel Core i5 e 16GB de memória RAM', 3499.90, 15, 1);
insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Fone de Ouvido Bluetooth', 'Fone de ouvido sem fio com conexão Bluetooth', 129.90, 40, 3);
insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Luminária de Mesa LED', 'Luminária de mesa com iluminação LED ajustável', 89.90, 35, 4);
insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Mochila para Notebook', 'Mochila para notebook de até 15,6 polegadas', 149.90, 25, 5);