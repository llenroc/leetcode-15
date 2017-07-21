# Read from the file words.txt and output the word frequency list to stdout.
grep -Eo "[a-z]*" words.txt | sort -k1 | uniq -c | sort -rn | awk '{print $2" "$1}'
