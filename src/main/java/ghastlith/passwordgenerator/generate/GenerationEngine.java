package ghastlith.passwordgenerator.generate;

import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import jakarta.validation.Valid;

@Component
@Validated
public class GenerationEngine {

  public String generatePassword(@Valid final GenerationStrategy strategy) {
    throw new RuntimeException("method not implemented");
  }

}
