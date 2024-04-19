package br.com.julia.projeto.service;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import br.com.julia.projeto.dto.UsuarioDTO;

@Configuration
@Service
public class EmailService {

	@Autowired
	static UsuarioService usuarioService;
	
	private static JavaMailSender emailSender;

	@Autowired
	public void setJavaMailSender(JavaMailSender emailSender) {
		EmailService.emailSender = emailSender;
	}

	@Value("${spring.mail.host}")
	private String host;

	@Value("${spring.mail.port}")
	private Integer port;

	@Value("${spring.mail.username}")
	private String username;

	@Value("${spring.mail.password}")
	private String password;
	
	@Bean
	public JavaMailSender javaMailSender() {
		JavaMailSenderImpl emailSender = new JavaMailSenderImpl();
		Properties prop = new Properties();
		emailSender.setHost(host);
		emailSender.setPort(port);
		emailSender.setUsername(username);
		emailSender.setPassword(password);
		prop.put("mail.transport.protocol", "smtp");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		emailSender.setJavaMailProperties(prop);
		return emailSender;
	}
	
	public void envioEmailCadastro(UsuarioDTO usuario) {
		jakarta.mail.internet.MimeMessage mensagemCadastro = emailSender.createMimeMessage();

		try {
			MimeMessageHelper helper = new MimeMessageHelper(mensagemCadastro, true);
			helper.setFrom("julialimafc048@gmail.com");
			helper.setTo("juliafclima@hotmail.com");
			helper.setSubject("Cadastro concluido com sucesso!");

			StringBuilder builder = new StringBuilder();
			builder.append("<html>\r\n"
					+ "  <body\r\n"
					+ "    style=\"\r\n"
					+ "      font-family: Arial, Helvetica, sans-serif;\r\n"
					+ "      margin-top: 50px;\r\n"
					+ "    \"\r\n"
					+ "  >\r\n"
					+ "    <div style=\"max-width: 800px\">\r\n"
					+ "      <h1 style=\"text-align: center\">Cadastro realizado com sucesso!</h1>\r\n"
					+ "      <h2 style=\"text-align: center; margin-bottom: 50px\">\r\n"
					+ "        Bem-vindo à nossa comunidade!\r\n"
					+ "      </h2>\r\n"
					+ "      <div\r\n"
					+ "        style=\"\r\n"
					+ "          display: flex;\r\n"
					+ "          flex-direction: column;\r\n"
					+ "          align-items: center;\r\n"
					+ "          justify-content: center;\r\n"
					+ "        \"\r\n"
					+ "      >\r\n"
					+ "        <p>\r\n"
					+ "          Estamos muito felizes em tê-lo conosco e esperamos que você aproveite\r\n"
					+ "          ao máximo nossa plataforma.\r\n"
					+ "        </p>\r\n"
					+ "        <p style=\"margin-bottom: 50px\">\r\n"
					+ "          Em caso de erro, favor contatar o suporte:\r\n"
					+ "          <strong style=\"color: #eba417\">julialimafc048@gmail.com</strong>\r\n"
					+ "        </p>\r\n"
					+ "      </div>\r\n"
					+ "      <div\r\n"
					+ "        style=\"\r\n"
					+ "          display: flex;\r\n"
					+ "          flex-direction: column;\r\n"
					+ "          align-items: flex-end;\r\n"
					+ "          justify-content: center;\r\n"
					+ "        \"\r\n"
					+ "      >\r\n"
					+ "        <p>Atenciosamente,</p>\r\n"
					+ "        <p>Júlia Lima</p>\r\n"
					+ "      </div>\r\n"
					+ "    </div>\r\n"
					+ "  </body>\r\n"
					+ "</html>\r\n"
					+ "");

			helper.setText(builder.toString(), true);

			emailSender.send(mensagemCadastro);

		} catch (jakarta.mail.MessagingException e) {
			e.printStackTrace();
		}
	}
}
