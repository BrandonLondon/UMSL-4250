/*
Author: Brandon London 
Created: 09/11/19
Class: 4250 Programming Languages
Assignment: Project 1
*/
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

/* lexical analyzer */
public class Lexemes {

    //Character Classes
    public enum CharacterClass {
        LETTER(0), DIGIT(1), UNKNOWN(99), EOF(-1);
        private final int val;

        CharacterClass(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }

    /* Token codes */
    public enum TokenCodes {
        INT_LIT(10), IDENT(11), ASSIGN_OP(20), ADD_OP(21), SUB_OP(22), MULT_OP(23), DIV_OP(24), LEFT_PAREN(25),
        RIGHT_PEREN(26), EOF(-1);

        private final int val;

        TokenCodes(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }
    }
/***************************************************************************************************************************************************************/
    /* Global Declaration */
    /* Variables */
    static CharacterClass charClass;
    static StringBuffer Lexeme = new StringBuffer();
    static char nextChar;
    static TokenCodes token;
    static TokenCodes nextToken;
    static BufferedReader reader;

/***************************************************************************************************************************************************************/
    /* Main Driver */
    public static void main(String[] args) throws Exception {
        /* Open the input data file and process its content */
        try {
            reader = new BufferedReader(new FileReader(new File("front.txt")));
        } catch (Exception e) {
            System.err.println("ERROR - cannot open front.in");
        }
        getChar();
        do{
            lex();
        } while (nextToken != TokenCodes.EOF);
        
    }

/***************************************************************************************************************************************************************/
    /* lookup - A function to lookup operators and parentheses and retunr the token */

    static TokenCodes lookup(char ch) {
        switch (ch) {
            case '(':
                addChar();
                nextToken = TokenCodes.LEFT_PAREN;
                break;
            case ')':
                addChar();
                nextToken = TokenCodes.RIGHT_PEREN;
                break;
            case '+':
                addChar();
                nextToken = TokenCodes.ADD_OP;
                break;
            case '-':
                addChar();
                nextToken = TokenCodes.SUB_OP;
                break;
            case '*':
                addChar();
                nextToken = TokenCodes.MULT_OP;
                break;
            case '/':
                addChar();
                nextToken = TokenCodes.DIV_OP;
                break;
            default:
                addChar();
                nextToken = TokenCodes.EOF;
                break;
        }
        return nextToken;
    }

/***************************************************************************************************************************************************************/
/* addChar - A function to add nextChar to lexeme */
static void addChar() {
    Lexeme.append(nextChar);
}

static void getChar() throws IOException {
    int c = reader.read();
    nextChar = (char) c;
    if (c != -1) {
        if(Character.isLetter(nextChar))
            charClass = CharacterClass.LETTER;
        else if (Character.isDigit(nextChar))
            charClass = CharacterClass.DIGIT;
        else 
            charClass = CharacterClass.UNKNOWN;
    } else
        charClass = CharacterClass.EOF;
}

/* getNonBlank - A function to call getChar until its not whitespace */

static void getNonBlank() throws IOException {
    while (Character.isWhitespace(nextChar))
        getChar();
}

/* lex - a simple lexical analyzer for arithmetic expressions*/

static TokenCodes lex() throws IOException {
    Lexeme = new StringBuffer();
    getNonBlank();;
    switch(charClass) {
/* Parse Identifiers */
        case LETTER:
            addChar();
            getChar();
            while (charClass == CharacterClass.LETTER || charClass == CharacterClass.DIGIT) {
                addChar();
                getChar();
            }
            nextToken = TokenCodes.IDENT;
            break;
    /* Parse Integer literals */
    case DIGIT:
        addChar();
        getChar();
        while(charClass == CharacterClass.DIGIT) {
            addChar();
            getChar();
        }
        nextToken = TokenCodes.INT_LIT;
        break;
    /* Parentheses and Operators */

    case UNKNOWN:
        lookup(nextChar);
        getChar();
        break;
    /* EOF */
    case EOF:
        nextToken = TokenCodes.EOF;
        Lexeme.append("EOF");
        break;


    }
    System.out.printf("Next token is: %d, Next Lexeme is %s\n", nextToken.getVal(), Lexeme.toString());
    return nextToken;
}/* End of function lex */

}