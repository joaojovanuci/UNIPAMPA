enum tipo{frios=1, carnes=2, salgados=3, doces=4};

struct produtos{
    char nome[15];
    enum tipo setor;
    int quantidade;
    float preco;
};

struct produtos * inserirProdutos(struct produtos *meusProdutos, int totalProdutos, int q);
void apresentaUm(struct produtos *meusProdutos, int totalProdutos, int i);
void apresentaTodos(struct produtos *meusProdutos, int totalProdutos);
float balanco(struct produtos *meusProdutos, int totalProdutos, float soma);
void buscaporNome(struct produtos *meusProdutos, int totalProdutos);
void buscaporSetor(struct produtos *meusProdutos, int totalProdutos);
struct produtos * venda(struct produtos *meusProdutos, int totalProdutos);

