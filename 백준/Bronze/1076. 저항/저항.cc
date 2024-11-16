#include <stdio.h>
#include <string.h>

int main(){
    char S[7];
    long long result = 0;
    
    scanf("%s", S);
    
    if(strcmp(S, "black") == 0){
        result = 0;
    }else if(strcmp(S, "brown") == 0){
        result = 1 * 10;
    }else if(strcmp(S, "red") == 0){
        result = 2 * 10;
    }else if(strcmp(S, "orange") == 0){
        result = 3 * 10;
    }else if(strcmp(S, "yellow") == 0){
        result = 4 * 10;
    }else if(strcmp(S, "green") == 0){
        result = 5 * 10;
    }else if(strcmp(S, "blue") == 0){
        result = 6 * 10;
    }else if(strcmp(S, "violet") == 0){
        result = 7 * 10;
    }else if(strcmp(S, "grey") == 0){
        result = 8 * 10;
    }else {
        result = 9 * 10;
    }
    
    scanf("%s", S);
    
    if(strcmp(S, "black") == 0){
        result += 0;
    }else if(strcmp(S, "brown") == 0){
        result += 1;
    }else if(strcmp(S, "red") == 0){
        result += 2;
    }else if(strcmp(S, "orange") == 0){
        result += 3;
    }else if(strcmp(S, "yellow") == 0){
        result += 4;
    }else if(strcmp(S, "green") == 0){
        result += 5;
    }else if(strcmp(S, "blue") == 0){
        result += 6;
    }else if(strcmp(S, "violet") == 0){
        result += 7;
    }else if(strcmp(S, "grey") == 0){
        result += 8;
    }else if(strcmp(S, "white") == 0){
        result += 9;
    }
    
    scanf("%s", S);
    
    if(strcmp(S, "black") == 0){
        result *= 1;
    }else if(strcmp(S, "brown") == 0){
        result *= 10;
    }else if(strcmp(S, "red") == 0){
        result *= 100;
    }else if(strcmp(S, "orange") == 0){
        result *= 1000;
    }else if(strcmp(S, "yellow") == 0){
        result *= 10000;
    }else if(strcmp(S, "green") == 0){
        result *= 100000;
    }else if(strcmp(S, "blue") == 0){
        result *= 1000000;
    }else if(strcmp(S, "violet") == 0){
        result *= 10000000;
    }else if(strcmp(S, "grey") == 0){
        result *= 100000000;
    }else if(strcmp(S, "white") == 0){
        result *= 1000000000;
    }
    
    printf("%lld", result);
}