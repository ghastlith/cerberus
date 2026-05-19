package ghastlith.babel.generation;

/**
 * Sets containing the lists of characters allowed during password generation.
 */
public enum CharacterSet {

  LETTERS("ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"),
  NUMBERS("0123456789"),
  SPECIAL("!#$%&()*+,-./:;<=>?@[]^_{}~");

  public final String characters;

  private CharacterSet(final String characters) {
    this.characters = characters;
  }

}
