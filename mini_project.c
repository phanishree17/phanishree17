#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
int main()
{
    char items[3] = {'a', 'z', 'p'};
    int i;
    char input;
    bool found = false;
    printf("enter an items to search :");
    scanf("%c",&input);
    for(i=0;i<3;i++)
    {
        if(items[i] == input)
        {
            printf("items found");
            found = true;
            break;
        }
    }
    if(found == false)
    {
        printf("enter items not found ");
    }
    return 0;
}
