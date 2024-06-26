CREATE TABLE public.usuario (
    id SERIAL PRIMARY KEY,
    login VARCHAR(100) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    situacao VARCHAR(20) NOT NULL
);


CREATE TABLE public.skill (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    descricao TEXT,
    url VARCHAR(255)
);

	
CREATE TABLE public.usuario_skill (
    id SERIAL PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_skill INT NOT NULL,
    level INT,
    CONSTRAINT fk_usuario FOREIGN KEY (id_usuario) REFERENCES public.usuario(id),
    CONSTRAINT fk_skill FOREIGN KEY (id_skill) REFERENCES public.skill(id)
);

INSERT INTO public.usuario(id, login, senha, situacao) VALUES 
	(1, 'julia', '123', "P"),
	(2, 'mateus', '123', "A"),
	(3, 'liz', '123', "I");
	
INSERT INTO public.skill(id, nome, descricao, url) VALUES 
	(1, 'Python', 'Linguagem de programação interpretada', 'https://www.python.org/'),
	(2, 'JavaScript', 'Linguagem de programação de alto nível', 'https://developer.mozilla.org/pt-BR/docs/Web/JavaScript'),
	(3, 'Java', 'Linguagem de programação de propósito geral', 'https://www.java.com/pt-BR/'),
	(4, 'HTML', 'Linguagem de marcação utilizada na criação de páginas web', 'https://developer.mozilla.org/pt-BR/docs/Web/HTML'),
	(5, 'CSS', 'Linguagem de estilo utilizada para estilizar elementos HTML', 'https://developer.mozilla.org/pt-BR/docs/Web/CSS'),
	(6, 'SQL', 'Linguagem de consulta estruturada para manipular bancos de dados', 'https://www.w3schools.com/sql/');

INSERT INTO public.usuario_skill (id, id_usuario, id_skill, level) VALUES 
	(1, 1, 1, '9/10'),
	(2, 2, 2, '2/10'),
	(3, 3, 3, '5/10'),
	(4, 1, 4, '1/10'),
	(5, 2, 5, '7/10'),
	(6, 3, 6, '3/10');