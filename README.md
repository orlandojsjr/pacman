Pacman search

Neste jogo o Pacman (P) está posicionado em um grid, ele deve encontrar um caminho para a comida (.) utilizando alguma estratégia de busca

Input Format

    3 9  
    5 1  
    7 20  
    %%%%%%%%%%%%%%%%%%%%
    %--------------%---%  
    %-%%-%%-%%-%%-%%-%-%  
    %--------P-------%-%  
    %%%%%%%%%%%%%%%%%%-%  
    %.-----------------%  
    %%%%%%%%%%%%%%%%%%%%  

A primeira linha identifica a coordenada do Pacman na grid no formato linha coluna
A segunda linha identifica a coordenada da comida na grid no formato linha coluna
A terceira linha determina o tamanho da grid indicando o número de linhas e colunas. O tamanho máximo da grid deve ser 30x30.

O símbolo "%" representa as paredes enquanto que o "-" representa o espaços por onde o Pacman pode percorrer.
A partir do input informado devolva como output um possível caminho para o Pacman chegar até a comida.


A partir desse input devolva um output no seguinte formato:

    3 9  
    5 1  
    7 20  
    %%%%%%%%%%%%%%%%%%%%
    %--------------%***%  
    %-%%-%%-%%-%%-%%*%*%  
    %--------P*******%*%  
    %%%%%%%%%%%%%%%%%%*%  
    %.*****************%  
    %%%%%%%%%%%%%%%%%%%%  

O Output obedece os mesmos parâmetros do input com a diferença que o caractere "*" deve indicar o caminho a ser percorrido pelo pacman para chegar até a comida.
