
-- Inserir na tabela skill
INSERT INTO public.Tab_Skill(nome_skill, descricao_skill, url_skill) VALUES 
    ('Python', 'Linguagem de programação interpretada', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/0a/Python.svg/640px-Python.svg.png'),
    ('JavaScript', 'Linguagem de programação de alto nível', 'https://cdn3d.iconscout.com/3d/free/thumb/free-javascript-9294848-7577991.png?f=webp'),
    ('Java', 'Linguagem de programação de propósito geral', 'https://cdn-icons-png.flaticon.com/512/5968/5968282.png'),
    ('HTML', 'Linguagem de marcação utilizada na criação de páginas web', 'https://static-00.iconduck.com/assets.00/html-5-icon-224x256-1b5ud2sy.png'),
    ('CSS', 'Linguagem de estilo utilizada para estilizar elementos HTML', 'https://lh4.googleusercontent.com/proxy/B-1PQKUCbPfJqXQaFmm1Y0Verbi9yQ8cw2cta17IXFKeqPP6gJcPs0fu-ASH2q_REfsZWwTXT92Om0BbrQlwsx0hwwF5jneLUr-r1EQ'),
    ('SQL', 'Linguagem de consulta estruturada para manipular bancos de dados', 'https://desenvolvimentoaberto.org/wp-content/uploads/2016/11/logoazuresql.png'),
	('React', 'Biblioteca JavaScript para criar interfaces de usuário', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/React-icon.svg/2300px-React-icon.svg.png'),
	('Node.js', 'Ambiente de execução JavaScript do lado do servidor',  'https://miro.medium.com/v2/resize:fit:900/1*TY9uBBO9leUbRtlXmQBiug.png'),
	('Django', 'Framework para desenvolvimento rápido de aplicações web em Python',  'https://www.svgrepo.com/show/353657/django-icon.svg'),
	('Angular', 'Plataforma de desenvolvimento de aplicações web em TypeScript/JavaScript',  'https://seeklogo.com/images/A/angular-icon-logo-9946B9795D-seeklogo.com.png');
	
INSERT INTO public.Tab_Usuario(login_usuario, senha_usuario) 
VALUES 
	('juliafclima', '$2a$10$rI8vT21xvy.H6fN42DTASu.jL1W4mPvIHWorJNDgPvzNCgXi8vVg2');
	
INSERT INTO public.Tab_Usuario_Skill(id, level_usuario_skill, id_skill, id_usuario) 
VALUES 
	(11, '10', 1, 1),
	(12, '5', 2, 1),
	(13, '7', 3, 1),
	(14, '8', 4, 1),
	(15, '9', 5, 1),
	(16, '2', 6, 1),
	(17, '5', 7, 1),
	(18, '6', 8, 1),
	(19, '3', 9, 1),
	(20, '7', 10, 1);
	
INSERT INTO public.tab_Anotacao(data_anotacao, usuario_id, descricao_anotacao) 
VALUES 
	('2024-07-18T14:00:00', 1, 'Revisar padrões de design em Java'),
	('2024-07-18T10:06:00', 1, 'Pesquisar sobre psicologia das cores'),
    ('2024-07-18T09:25:00', 1, 'Estudar JWT Token'),
    ('2024-07-17T11:18:00', 1, 'Ler documentação de Hibernate'),
    ('2024-07-16T16:12:00', 1, 'Preparar apresentação de React'),
	('2024-07-16T10:06:00', 1, 'Estudar Spring boot'),
	('2024-07-15T14:25:00', 1, 'Fazer exercícios de Java');
