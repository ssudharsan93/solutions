def backspace_compare(str1, str2):
  real_str1 = ""
  real_str2 = ""

  real_str1 = real_str(str1)
  real_str2 = real_str(str2)

  print(str1 + " is actually : " + real_str1)
  print(str2 + " is actually : " + real_str2)

  if (real_str1 == real_str2): return True
  return False

def real_str(current_str):
  i = len(current_str) - 1
  num_hashes = 0
  
  real_str = ""
  
  while ( i >= 0 ):
      if ( current_str[i] == '#' ):
          num_hashes += 1
      else:
          while (num_hashes > 0):
              i -= 1
              num_hashes -= 1
          real_str = current_str[i] + real_str
      i -= 1

  return real_str
