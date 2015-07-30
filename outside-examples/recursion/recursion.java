// Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit, except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4. Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6), while divide (/) by 10 removes the rightmost digit (126 / 10 is 12). 

// count8(8) → 1
// count8(818) → 2
// count8(8818) → 4

public int count8(int n) {
  if (n==0) {
    return 0;
  }
  
  return count8(n, false);
}

public int count8(int n, boolean seen) {
  if (n==0) {
    return 0;
  }

  if (n%10 == 8 && seen) {
    return 2+count8(n/10, true);
  }
  
  else if(n%10 == 8) {
    return 1+count8(n/10, true);
  }
  
  return count8(n/10, false);
}


// Given base and n that are both 1 or more, compute recursively (no loops) the value of base to the n power, so powerN(3, 2) is 9 (3 squared). 

// powerN(3, 1) → 3
// powerN(3, 2) → 9
// powerN(3, 3) → 27

public int powerN(int base, int n) {
  if (n == 1) {
    return base;
  }
  
  return base * powerN(base, n-1);
}



// Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string. 

// countX("xxhixx") → 4
// countX("xhixhix") → 3
// countX("hi") → 0

public int countX(String str) {
  if (str == null || str.length() == 0) {
    return 0;
  }
  
  if (str.length() == 1) {
    if (str.charAt(0) == 'x') {
      return 1;
    }
    return 0;
  }
  
  if (str.charAt(str.length()-1) == 'x') {
    return 1 + countX(str.substring(0, str.length()-1));
  }
  
  return countX(str.substring(0, str.length()-1));
}


// Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string. 

// countHi("xxhixx") → 1
// countHi("xhixhix") → 2
// countHi("hi") → 1

public int countHi(String str) {
  if (str == null || str.length() <= 1) {
    return 0;
  }
  
  if (str.charAt(0) != 'h') {
    return countHi(str.substring(1, str.length()));
  }
  
  if (str.indexOf("hi") == 0) {
    return 1 + countHi(str.substring(2, str.length()));
  }
  
  return countHi(str.substring(1, str.length()));
}

// Given a string, compute recursively (no loops) a new string where all the lowercase 'x' chars have been changed to 'y' chars. 

// changeXY("codex") → "codey"
// changeXY("xxhixx") → "yyhiyy"
// changeXY("xhixhix") → "yhiyhiy"

public String changeXY(String str) {
  if (str == null || str.length() == 0) {
    return "";
  }
  
  if (str.charAt(0) == 'x') {
    return "y" + changeXY(str.substring(1, str.length()));
  }
  
  return str.charAt(0) + changeXY(str.substring(1, str.length()));
}

// Given a string, compute recursively (no loops) a new string where all appearances of "pi" have been replaced by "3.14". 

// changePi("xpix") → "x3.14x"
// changePi("pipi") → "3.143.14"
// changePi("pip") → "3.14p"

public String changePi(String str) {
  if (str == null || str.length() == 0) {
    return "";
  }
  
  if (str.indexOf("pi") == 0) {
    return "3.14" + changePi(str.substring(2, str.length()));
  }
  
  return str.charAt(0) + changePi(str.substring(1, str.length()));
}


// Given a string, compute recursively a new string where all the 'x' chars have been removed. 

// noX("xaxb") → "ab"
// noX("abc") → "abc"
// noX("xx") → ""

public String noX(String str) {
  if (str == null || str.length() == 0) {
    return "";
  }
  
  if (str.charAt(0) == 'x') {
    return noX(str.substring(1, str.length()));
  }
  
  return str.charAt(0) + noX(str.substring(1, str.length()));
}


// Given an array of ints, compute recursively if the array contains a 6. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0. 

// array6({1, 6, 4}, 0) → true
// array6({1, 4}, 0) → false
// array6({6}, 0) → true

public boolean array6(int[] nums, int index) {
  if (nums == null || nums.length == 0) {
    return false;
  }
  
  if (index == nums.length-1) {
    return nums[index] == 6;
  }
  
  return nums[index] == 6 || array6(nums, index+1);
}


// Given an array of ints, compute recursively the number of times that the value 11 appears in the array. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0. 

// array11({1, 2, 11}, 0) → 1
// array11({11, 11}, 0) → 2
// array11({1, 2, 3, 4}, 0) → 0

public int array11(int[] nums, int index) {
  if (nums == null || nums.length == 0) {
    return 0;
  }
  
  if (index == nums.length-1) {
    return ((nums[index] == 11) ? 1 : 0);
  }
  
  return ((nums[index] == 11) ? 1 + array11(nums, index+1) : array11(nums, index+1));
}


// Given an array of ints, compute recursively if the array contains somewhere a value followed in the array by that value times 10. We'll use the convention of considering only the part of the array that begins at the given index. In this way, a recursive call can pass index+1 to move down the array. The initial call will pass in index as 0. 

// array220({1, 2, 20}, 0) → true
// array220({3, 30}, 0) → true
// array220({3}, 0) → false

public boolean array220(int[] nums, int index) {
  if (nums == null || nums.length <= 1) {
    return false;
  }
  
  if(index == nums.length-1) {
    return false;
  }
  
  if (nums[index+1] == 10*nums[index]) {
    return true;
  }
  
  return array220(nums, index+1);
}


// Given a string, compute recursively a new string where all the adjacent chars are now separated by a "*".

// allStar("hello") → "h*e*l*l*o"
// allStar("abc") → "a*b*c"
// allStar("ab") → "a*b"

public String allStar(String str) {
  if (str == null || str.length() == 0) {
    return "";
  }
  
  if (str.length() == 1) {
    return str;
  }
  
  return str.charAt(0) + "*" + allStar(str.substring(1, str.length()));
}



// Given a string, compute recursively a new string where identical chars that are adjacent in the original string are separated from each other by a "*". 

// pairStar("hello") → "hel*lo"
// pairStar("xxyy") → "x*xy*y"
// pairStar("aaaa") → "a*a*a*a"

public String pairStar(String str) {
  if (str==null || str.length() == 0) {
    return "";
  }
  
  if (str.length() == 1) {
    return str;
  }
  
  if (str.charAt(0) == str.charAt(1)) {
    return str.charAt(0) + "*" + pairStar(str.substring(1, str.length()));
  }
  
  return str.charAt(0) + pairStar(str.substring(1, str.length()));
}


// Given a string, compute recursively a new string where all the lowercase 'x' chars have been moved to the end of the string. 

// endX("xxre") → "rexx"
// endX("xxhixx") → "hixxxx"
// endX("xhixhix") → "hihixxx"

public String endX(String str) {
  if (str == null || str.length() == 0) {
    return "";
  }
  
  if (str.length() == 1) {
    return str;
  }
  
  if (str.charAt(0) == 'x') {
    return endX(str.substring(1,str.length())) + "x";
  }
  
  return str.charAt(0) + endX(str.substring(1,str.length()));
}


// We'll say that a "pair" in a string is two instances of a char separated by a char. So "AxA" the A's make a pair. Pair's can overlap, so "AxAxA" contains 3 pairs -- 2 for A and 1 for x. Recursively compute the number of pairs in the given string. 

// countPairs("axa") → 1
// countPairs("axax") → 2
// countPairs("axbx") → 1

public int countPairs(String str) {
  if (str == null || str.length() <= 2) {
    return 0;
  }
  
  if (str.charAt(0) == str.charAt(2)) {
    return 1 + countPairs(str.substring(1, str.length()));
  }
  
  return countPairs(str.substring(1, str.length()));
}



// Count recursively the total number of "abc" and "aba" substrings that appear in the given string. 

// countAbc("abc") → 1
// countAbc("abcxxabc") → 2
// countAbc("abaxxaba") → 2

public int countAbc(String str) {
  if (str == null || str.length() <= 2) {
    return 0;
  }
  
  if (str.indexOf("abc") == 0 || str.indexOf("aba") == 0) {
    return 1 + countAbc(str.substring(2, str.length()));
  }
  
  return countAbc(str.substring(1, str.length()));
}

// Given a string, compute recursively (no loops) the number of "11" substrings in the string. The "11" substrings should not overlap. 

// count11("11abc11") → 2
// count11("abc11x11x11") → 3
// count11("111") → 1

public int count11(String str) {
  if (str == null || str.length() <= 1) {
    return 0;
  }
  
  if (str.indexOf("11") == 0) {
    return 1 + count11(str.substring(2, str.length()));
  }
  
  return count11(str.substring(1, str.length()));
}


// Given a string, return recursively a "cleaned" string where adjacent chars that are the same have been reduced to a single char. So "yyzzza" yields "yza". 

// stringClean("yyzzza") → "yza"
// stringClean("abbbcdd") → "abcd"
// stringClean("Hello") → "Helo"

public String stringClean(String str) {
  if (str == null || str.length() == 0) {
    return "";
  }
  
  if (str.length() == 1) {
    return str;
  }
  
  if (str.charAt(0) == str.charAt(1)) {
    return stringClean(str.substring(1, str.length()));
  }
  
  return str.charAt(0) + stringClean(str.substring(1, str.length()));
}


// Given a string that contains a single pair of parenthesis, compute recursively a new string made of only of the parenthesis and their contents, so "xyz(abc)123" yields "(abc)". 

// parenBit("xyz(abc)123") → "(abc)"
// parenBit("x(hello)") → "(hello)"
// parenBit("(xy)1") → "(xy)"

public String parenBit(String str) {
  if (str == null || str.length() <= 2) {
    return "()";
  }
  
  if (str.charAt(0) == '(') {
    if (str.charAt(str.length()-1) == ')') {
      return str;
    }
    return parenBit(str.substring(0,str.length()-1));
  }
  return parenBit(str.substring(1,str.length()));
}


// Given a string, return true if it is a nesting of zero or more pairs of parenthesis, like "(())" or "((()))". Suggestion: check the first and last chars, and then recur on what's inside them. 

// nestParen("(())") → true
// nestParen("((()))") → true
// nestParen("(((x))") → false

public boolean nestParen(String str) {
  if (str == null || str.length() == 0) {
    return true;
  }
  
  if (str.charAt(0)=='(' && str.charAt(str.length()-1) == ')') {
    return true && nestParen(str.substring(1, str.length()-1));
  }
  
  if (str.charAt(0) == '(' || str.charAt(str.length()-1) == ')') {
    return false;
  }
  
  return true;
}


// Given a string and a non-empty substring sub, compute recursively the number of times that sub appears in the string, without the sub strings overlapping. 

// strCount("catcowcat", "cat") → 2
// strCount("catcowcat", "cow") → 1
// strCount("catcowcat", "dog") → 0

public int strCount(String str, String sub) {
  if (str == null || sub == null || str.length() < sub.length()) {
    return 0;
  }
  
  if (str.indexOf(sub) == 0) {
    return 1 + strCount(str.substring(sub.length(), str.length()), sub);  
  }
  
  return strCount(str.substring(1, str.length()), sub);
}


// Given a string and a non-empty substring sub, compute recursively if at least n copies of sub appear in the string somewhere, possibly with overlapping. N will be non-negative. 

// strCopies("catcowcat", "cat", 2) → true
// strCopies("catcowcat", "cow", 2) → false
// strCopies("catcowcat", "cow", 1) → true

public boolean strCopies(String str, String sub, int n) {
  if (str == null || str.length() == 0) {
    return false;
  }
  
  return n <= strCopiesHelper(str, sub);
}


public int strCopiesHelper(String str, String sub) {
  if (str.length() == 0) {
    return 0;
  }
  
  if(str.indexOf(sub) == 0) {
    return 1 + strCopiesHelper(str.substring(1, str.length()), sub);
  }
  
  return strCopiesHelper(str.substring(1, str.length()), sub);
}