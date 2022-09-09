import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


public class StringManipulation {

  final Pattern LETTER_REGEX = Pattern.compile("[a-zA-Z]");

  String findLetters(String s){
    char[] chars = s.toCharArray();
    List<Character> charList = new ArrayList<>();
    for(char c : chars){
      charList.add(c);
    }

    List<String> strings = charList.stream()
        .map(character -> character.toString())
        .collect(Collectors.toList());

    List<String> letters = strings.stream().filter(str -> {
      return isLetter(LETTER_REGEX, str);
    }).collect(Collectors.toList());


    String letterString = letters.stream().reduce("", (s1, s2) -> {
      return s1 + s2;
    });

    String reversedString = reverseString( letterString);

    for(int i = 0; i < strings.size(); i++){
      if(isNotLetter(strings.get(i))){
        reversedString = reversedString.substring(0, i) + strings.get(i) + reversedString.substring(i);
      }
    }

    return reversedString;

  }

  boolean isNotLetter(String test){
    Pattern p = Pattern.compile("[a-zA-Z]");
    return p.matcher(test).matches() != true;
  }

  boolean isLetter(Pattern p, String test){
    return p.matcher(test).matches();
  }

  String reverseString(String result, String string){
    if(string.length() == 0) return result;

    String sub = string.substring(string.length()-1);
    result += sub;

    return reverseString(result, sub );
  }

  String reverseString(String string){
    char[] chars = string.toCharArray();
    List<Character> charList = new ArrayList<>();
    for(int i = chars.length - 1 ; i >=0; i--){
      charList.add(chars[i]);
    }

    String r = "";

    for(Character c : charList){
      r += c.toString();
    }

    return reverseString("", string);
  }


}