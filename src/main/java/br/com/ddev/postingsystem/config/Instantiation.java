package br.com.ddev.postingsystem.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.ddev.postingsystem.domain.Post;
import br.com.ddev.postingsystem.domain.User;
import br.com.ddev.postingsystem.dto.AuthorDTO;
import br.com.ddev.postingsystem.repositories.PostRepository;
import br.com.ddev.postingsystem.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		/*userRepository.deleteAll();
		postRepository.deleteAll();
		
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, LocalDate.parse("2022-08-15"), "Novo Destino!", "Viajarei para São Paulo está semana!", new AuthorDTO(maria));
		Post post2 = new Post(null, LocalDate.parse("2022-08-20"), "Partiu viagem!", "Vou viajar para São Paulo. Abraços!", new AuthorDTO(maria));
		Post post3 = new Post(null, LocalDate.parse("2022-08-22"), "Cheguei SP!", "Houve alguns atrasos na viagem mas deu tudo certo!", new AuthorDTO(maria));
		Post post4 = new Post(null, LocalDate.parse("2022-08-23"), "Dia de reunião!", "Primeiro dia de reunião na minha nova empresa. Me desejem sorte!", new AuthorDTO(maria));
		Post post5 = new Post(null, LocalDate.parse("2022-08-25"), "Bom dia!", "Acordei faliz hoje!", new AuthorDTO(maria));
		
		postRepository.saveAll(Arrays.asList(post1, post2, post3, post4, post5));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2, post3, post4, post5));
		
		userRepository.save(maria);*/

	}

}
