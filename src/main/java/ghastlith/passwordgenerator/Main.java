package ghastlith.passwordgenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ghastlith.passwordgenerator.argument.ArgumentProcessor;
import ghastlith.passwordgenerator.generate.GenerationEngine;
import ghastlith.passwordgenerator.generate.GenerationStrategy;
import lombok.AllArgsConstructor;

@SpringBootApplication
@AllArgsConstructor
public class Main implements CommandLineRunner {

  @Autowired private ArgumentProcessor argumentProcessor;
  @Autowired private GenerationEngine generationEngine;

  public static void main(final String[] args) {
    SpringApplication.run(Main.class, args);
  }

  @Override
  public void run(final String... args) throws Exception {
    final var arguments = argumentProcessor.parse(args);
    final var strategy = GenerationStrategy.fromInputArguments(arguments);
    final var password = generationEngine.generatePassword(strategy);
  }

}
