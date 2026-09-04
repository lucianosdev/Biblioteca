-- ============================================================
-- EXERCÍCIO 3 - CONSULTAS SQL
-- SISTEMA DE BIBLIOTECA
-- ============================================================


-- ============================================================
-- 1. LISTAR TODO O ACERVO
-- Código, título, tipo e disponibilidade
-- ============================================================

SELECT
    codigo,
    titulo,
    tipo,
    disponivel
FROM item
ORDER BY codigo;


-- ============================================================
-- 2. LISTAR OS EMPRÉSTIMOS EM ABERTO
-- Nome do usuário e título do item
-- ============================================================

SELECT
    usuario.nome AS usuario,
    item.titulo AS item
FROM emprestimo
INNER JOIN usuario
    ON emprestimo.usuario_id = usuario.id
INNER JOIN item
    ON emprestimo.item_id = item.id
WHERE emprestimo.data_devolucao IS NULL;


-- ============================================================
-- 3. CALCULAR O TOTAL DE MULTAS ACUMULADAS POR USUÁRIO
-- ============================================================

SELECT
    usuario.nome AS usuario,
    SUM(emprestimo.valor_multa) AS total_multas
FROM emprestimo
INNER JOIN usuario
    ON emprestimo.usuario_id = usuario.id
GROUP BY
    usuario.id,
    usuario.nome
ORDER BY
    usuario.nome;


-- ============================================================
-- 4. LISTAR OS ITENS QUE NUNCA FORAM EMPRESTADOS
-- ============================================================

SELECT
    item.codigo,
    item.titulo,
    item.tipo
FROM item
LEFT JOIN emprestimo
    ON item.id = emprestimo.item_id
WHERE emprestimo.item_id IS NULL
ORDER BY item.codigo;