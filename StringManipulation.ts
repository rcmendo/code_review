const letterRegex: RegExp = /[a-zA-Z]/

  const findLetters = (s:string): string => {
    let chars:string[] = s.split('');
    let charList = [];
    for ( const  c of chars)
    {
      charList.push(c);
    }
    let strings = charList.map((character)=>character)
    let letters = strings.filter((str)=>{return isLetter(letterRegex, str)})
    let letterString = letters.reduce((s1: any, s2: any)=>{return s1 + s2},"");

    let reversedString = reverseThisString(letterString);
    for (let i = 0; i < strings.length; i++)
    {
      if (isNotLetter(strings[i]))
      {
        reversedString = reversedString.substring(0,i) + strings[i] + reversedString.substring(i);
      }
    }
    return reversedString;
  }

  const isNotLetter = (test:string): boolean => {
    let p = /[a-zA-Z]/;
    return p.test(test) != true;
  }

  const isLetter = (p:RegExp, test:string): boolean =>{
    return p.test(test);
  }

  const reverseString = (result:string, s:string): string => {
    if (s.length == 0)
    {
      return result;
    }

    let sub = s.substring(s.length - 1);
    result += sub;
    return reverseString(result, sub);
  }

  const reverseThisString = (s:string): string => {
    let chars:string[] = s.split('');
    let charList = [];
    for (let i = chars.length - 1; i >= 0; i--)
    {
      charList.push(chars[i]);
    }
    let r = "";
    for ( const  c of charList)
    {
      r += c;
    }
    return reverseString("", s);
  }