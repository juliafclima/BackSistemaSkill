
-- Inserir na tabela skill
INSERT INTO public.Tab_Skill(nome_skill, descricao_skill, url_skill) VALUES 
    ('Python', 'Linguagem de programação interpretada', 'https://th.bing.com/th/id/OIP.dJToM1TiZiJA0GYwzDHwjQHaHY?rs=1&pid=ImgDetMain'),
    ('JavaScript', 'Linguagem de programação de alto nível', 'https://th.bing.com/th/id/R.f6302414f1a97b960efbc44cd0b7bf5e?rik=TQ%2bfMsswbcgl3w&pid=ImgRaw&r=0'),
    ('Java', 'Linguagem de programação de propósito geral', 'https://th.bing.com/th/id/OIP.n8pa_ux7uUyU9CJrzb1scAHaHa?rs=1&pid=ImgDetMain'),
    ('HTML', 'Linguagem de marcação utilizada na criação de páginas web', 'https://th.bing.com/th/id/OIP.lxMbLFRw0sgOlOwjC62ySwHaKc?rs=1&pid=ImgDetMain'),
    ('CSS', 'Linguagem de estilo utilizada para estilizar elementos HTML', 'https://th.bing.com/th/id/R.7c12764796349bfb505d4c5d73489c3d?rik=bM4AFS0UAqY17g&pid=ImgRaw&r=0'),
    ('SQL', 'Linguagem de consulta estruturada para manipular bancos de dados', 'https://th.bing.com/th/id/OIP.7P45uhOM8sYH2dZVY_9XpQHaFk?rs=1&pid=ImgDetMain'),
	('React', 'Biblioteca JavaScript para criar interfaces de usuário', 'https://upload.wikimedia.org/wikipedia/commons/thumb/a/a7/React-icon.svg/2300px-React-icon.svg.png'),
	('Node.js', 'Ambiente de execução JavaScript do lado do servidor',  'https://th.bing.com/th/id/OIP.Vegzcdv1Cl8Cex_jGgVK0wAAAA?rs=1&pid=ImgDetMain'),
	('Django', 'Framework para desenvolvimento rápido de aplicações web em Python',  'https://www.svgrepo.com/show/353657/django-icon.svg'),
	('Angular', 'Plataforma de desenvolvimento de aplicações web em TypeScript/JavaScript',  'https://seeklogo.com/images/A/angular-icon-logo-9946B9795D-seeklogo.com.png');
	
INSERT INTO public.Tab_Usuario(login_usuario, senha_usuario) 
VALUES 
	('juliafclima', '$2a$10$rI8vT21xvy.H6fN42DTASu.jL1W4mPvIHWorJNDgPvzNCgXi8vVg2');
	
INSERT INTO public.Tab_Usuario_Skill(id, level_usuario_skill, id_skill, id_usuario) 
VALUES 
	(1, '10', 1, 1),
	(2, '5', 2, 1),
	(3, '7', 3, 1),
	(4, '8', 4, 1),
	(5, '9', 5, 1),
	(6, '2', 6, 1),
	(7, '5', 7, 1),
	(8, '6', 8, 1),
	(0, '3', 9, 1);
	
INSERT INTO public.tab_Anotacao(data_anotacao, id, usuario_id, descricao_anotacao) 
VALUES 
	('2024-07-15T14:25:00', 1, 1, 'Fazer exercícios de Java'),
	('2024-07-16T10:06:00', 2, 1, 'Estudar Spring boot'),
    ('2024-07-16T16:12:00', 3, 1, 'Preparar apresentação de React'),
    ('2024-07-17T11:18:00', 4, 1, 'Ler documentação de Hibernate'),
    ('2024-07-18T09:25:00', 5, 1, 'Estudar JWT Token'),
	('2024-07-18T10:06:00', 6, 1, 'Pesquisar sobre psicologia das cores'),
	('2024-07-18T14:00:00', 7, 1, 'Revisar padrões de design em Java');
