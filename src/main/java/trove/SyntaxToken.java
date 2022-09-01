package trove;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SyntaxToken {
    private final String content;
    private final TokenType tokenType;

    public SyntaxToken(String content, TokenType tokenType) {
        this.content = content;
        this.tokenType = tokenType;
    }

    public static List<SyntaxToken> tokens(String... toks) {
        return Arrays.stream(toks).map(tok -> {
            char firstChar = tok.charAt(0);
            String content = tok.substring(1);
            if ('!' == firstChar) {
                return new SyntaxToken(content, TokenType.ABSTRACT);
            } else if ('_' == firstChar) {
                return new SyntaxToken(content, TokenType.CONCRETE);
            } else if ('.' == firstChar) {
                return new SyntaxToken(content, TokenType.METASYNTAX);
            } else {
                throw new IllegalArgumentException("Tokens must start with '!' or '_' or '.'");
            }
        }).collect(Collectors.toList());
    }

    public String getContent() {
        return content;
    }

    public TokenType getTokenType() {
        return tokenType;
    }
}
