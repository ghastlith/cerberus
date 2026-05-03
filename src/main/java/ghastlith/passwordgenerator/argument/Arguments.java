package ghastlith.passwordgenerator.argument;

import java.util.List;

import lombok.Getter;
import picocli.CommandLine.Option;
import picocli.CommandLine.Unmatched;

@Getter
public class Arguments {

  @Option(names = "--alphanumeric", defaultValue = "false")
  private boolean isAlphanumeric;

  @Option(names = "--length", defaultValue = "20")
  private int length;

  @Unmatched
  private List<String> unmatched;

}
