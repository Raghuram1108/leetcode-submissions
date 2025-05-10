int uniqueMorseRepresentations(char** words, int wordsSize) {
     const char *morse[] = {
        ".-","-...","-.-.","-..",".","..-.","--.","....","..",
        ".---","-.-",".-..","--","-.","---",".--.","--.-",".-.",
        "...","-","..-","...-",".--","-..-","-.--","--.."
    };
    char *set[100] = {0};
    int setSize = 0;

    for (int i = 0; i < wordsSize; ++i) {
        char buffer[100] = "";
        for (int j = 0; words[i][j]; ++j) {
            strcat(buffer, morse[words[i][j] - 'a']);
        }
        int found = 0;
        for (int k = 0; k < setSize; ++k) {
            if (strcmp(set[k], buffer) == 0) {
                found = 1;
                break;
            }
        }
        if (!found) {
            set[setSize] = strdup(buffer);
            setSize++;
        }
    }
    return setSize; 
}