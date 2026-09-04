-- ============================================================
-- EXERCÍCIO 2 - SISTEMA DE BIBLIOTECA
-- Modelagem do Banco de Dados - PostgreSQL
-- ============================================================


-- ============================================================
-- 1. TABELA ITEM
-- ============================================================

CREATE TABLE item (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    codigo VARCHAR(20) NOT NULL UNIQUE,
    titulo VARCHAR(200) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    autor VARCHAR(150),
    edicao VARCHAR(50),
    disponivel BOOLEAN NOT NULL DEFAULT TRUE,

    CONSTRAINT chk_item_tipo
        CHECK (tipo IN ('LIVRO', 'REVISTA'))
);


-- ============================================================
-- 2. TABELA USUARIO
-- ============================================================

CREATE TABLE usuario (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    nome VARCHAR(150) NOT NULL,
    tipo VARCHAR(20) NOT NULL,
    limite_itens INTEGER NOT NULL,

    CONSTRAINT chk_usuario_tipo
        CHECK (tipo IN ('ALUNO', 'PROFESSOR')),

    CONSTRAINT chk_usuario_limite
        CHECK (limite_itens > 0)
);


-- ============================================================
-- 3. TABELA EMPRESTIMO
-- ============================================================

CREATE TABLE emprestimo (
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    item_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    data_retirada DATE NOT NULL DEFAULT CURRENT_DATE,
    data_devolucao_prevista DATE NOT NULL,
    data_devolucao DATE,
    valor_multa NUMERIC(10,2) NOT NULL DEFAULT 0.00,

    CONSTRAINT fk_emprestimo_item
        FOREIGN KEY (item_id)
        REFERENCES item(id),

    CONSTRAINT fk_emprestimo_usuario
        FOREIGN KEY (usuario_id)
        REFERENCES usuario(id),

    CONSTRAINT chk_valor_multa
        CHECK (valor_multa >= 0)
);


-- ============================================================
-- 4. DADOS DE TESTE - ITENS
-- Pelo menos 4 itens
-- ============================================================

INSERT INTO item (codigo, titulo, tipo, autor, edicao, disponivel)
VALUES
    ('L001', 'Java para Iniciantes', 'LIVRO',
     'Herbert Schildt', '5ª edição', TRUE),

    ('L002', 'Programação Orientada a Objetos', 'LIVRO',
     'Robert C. Martin', '2ª edição', TRUE),

    ('R001', 'Tecnologia Hoje', 'REVISTA',
     NULL, 'Edição 45', TRUE),

    ('R002', 'Mundo da Programação', 'REVISTA',
     NULL, 'Edição 12', TRUE);


-- ============================================================
-- 5. DADOS DE TESTE - USUÁRIOS
-- Pelo menos 2 usuários
-- ============================================================

INSERT INTO usuario (nome, tipo, limite_itens)
VALUES
    ('João', 'ALUNO', 3),

    ('Professor Pedro', 'PROFESSOR', 5);


-- ============================================================
-- 6. DADOS DE TESTE - EMPRÉSTIMOS
-- Um empréstimo em aberto
-- Um empréstimo já devolvido
-- ============================================================

-- Empréstimo em aberto
INSERT INTO emprestimo (
    item_id,
    usuario_id,
    data_retirada,
    data_devolucao_prevista,
    data_devolucao,
    valor_multa
)
VALUES (
    (SELECT id FROM item WHERE codigo = 'L001'),
    (SELECT id FROM usuario WHERE nome = 'João'),
    CURRENT_DATE,
    CURRENT_DATE + 14,
    NULL,
    0.00
);


-- Empréstimo já devolvido
INSERT INTO emprestimo (
    item_id,
    usuario_id,
    data_retirada,
    data_devolucao_prevista,
    data_devolucao,
    valor_multa
)
VALUES (
    (SELECT id FROM item WHERE codigo = 'R001'),
    (SELECT id FROM usuario WHERE nome = 'Professor Pedro'),
    CURRENT_DATE - 10,
    CURRENT_DATE - 3,
    CURRENT_DATE,
    0.00
);
