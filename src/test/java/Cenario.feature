# language: pt
Funcionalidade: Busca no blog
  Como um usuário do blog
  Eu quero ser capaz de pesquisar por conteúdo no blog
  Para encontrar informação

  Cenario: Pesquisar por um termo específico no blog
    Dado que estou na página inicial do blog
    Quando eu clico em busca
    E digito "automação de testes"
    E pressiono a tecla enter 
    Então vejo os resultados da pesquisa relacionados a "automação de testes"

