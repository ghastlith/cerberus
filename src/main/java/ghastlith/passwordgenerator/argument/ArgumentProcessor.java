package ghastlith.passwordgenerator.argument;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import picocli.CommandLine;

@Component
@RequiredArgsConstructor
@Slf4j
public class ArgumentProcessor {

  private static final String UNMATCHED_LOG_FORMAT = "unrecognized argument: {}";

  public Arguments parse(final String... args) {
    final var input = new Arguments();

    parserFor(input).parseArgs(args);

    input.getUnmatched()
        .forEach(arg -> log.warn(UNMATCHED_LOG_FORMAT, arg));

    return input;
  }

  private CommandLine parserFor(final Object input) {
    return new CommandLine(input)
        .setOptionsCaseInsensitive(true)
        .setAbbreviatedOptionsAllowed(true);
  }

}
