package ghastlith.passwordgenerator.generation;

import ghastlith.passwordgenerator.argument.Arguments;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Builder;

@Builder
public record GenerationPolicy(
    @Min(value = 16, message = "Length must be at least 16")
    @Max(value = 32, message = "Length must be at most 32")
    int length,
    boolean hasSymbols
) {

  private static final float NON_ALPHANUMERIC_WEIGHT = 0.25f;
  private static final int BASE_LENGTH = 0;

  public static GenerationPolicy fromArguments(final Arguments arguments) {
    return GenerationPolicy.builder()
        .length(arguments.getLength())
        .hasSymbols(!arguments.isAlphanumeric())
        .build();
  }

  public int lettersLength() {
    final var numbers = numbersLength();
    final var special = specialLength();

    return length() - numbers - special;
  }

  public int numbersLength() {
    return (int) Math.ceil(length() * NON_ALPHANUMERIC_WEIGHT);
  }

  public int specialLength() {
    return hasSymbols ? numbersLength() : BASE_LENGTH;
  }

}
