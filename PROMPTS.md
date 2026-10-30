# PROMPTS: Grupo ____

**Integrantes:**

1.miguel
2.felippe
3. 3ºA ti

**Prova:** API em MVC (Reserva de Salas)

**Usamos IA?** (X) Sim  ( ) Não

**Qual ferramenta e modelo (se usaram):** Claude (Anthropic), em claude.ai

> Quem não usou IA: troque "prompt" por "passo". Em cada bloco abaixo, descreva o que vocês fizeram naquele passo, na ordem em que aconteceu, e preencha os outros campos do mesmo jeito.

## Registro, na ordem

Copie o bloco abaixo para cada prompt. Escreva o prompt exatamente como foi enviado.

### Prompt 1

**O prompt (cópia exata):**

> Estou fazendo uma prova de programação em Java com Spring Boot e preciso desenvolver uma API para reservas de salas de uma escola.
> Quero que você me ajude a fazer essa atividade utilizando o projeto Escola-base que o professor disponibilizou. Não crie outro projeto, pois esse já vem com as dependências necessárias, incluindo Spring Web, Spring Data JPA, validação e banco H2.
> Primeiro, analise os arquivos do projeto para entender como ele está organizado. Depois, me ajude a desenvolver a API seguindo exatamente o que o professor pediu.
> Preciso criar os pacotes model, repository, service e controller dentro de src/main/java/escola.
> A API precisa permitir:
>
> * Cadastrar uma sala.
> * Listar todas as salas.
> * Buscar uma sala pelo ID.
> * Excluir uma sala.
> * Reservar uma sala.
> * Liberar uma sala.
>
> A classe Sala deve ter id, código, nome, capacidade e um atributo para indicar se está reservada.
> Também preciso respeitar todas as regras:
>
> * Toda sala começa livre.
> * Não pode existir mais de uma sala com o mesmo código.
> * Código e nome são obrigatórios.
> * A capacidade precisa ser maior que zero.
> * Não pode reservar uma sala que já esteja reservada.
> * Não pode liberar uma sala que já esteja livre.
> * Não pode excluir uma sala reservada.
> * Quando uma sala não existir, a API deve informar isso corretamente.
>
> Quero que cada camada tenha sua responsabilidade:
>
> * Model representa os dados da sala.
> * Repository faz a comunicação com o banco.
> * Service contém as regras de negócio.
> * Controller recebe as requisições e retorna as respostas HTTP.
>
> Não coloque regras de negócio no Controller e não faça o Controller acessar o Repository diretamente.
> Utilize rotas REST e os status HTTP corretos:
>
> * 200 para operações realizadas com sucesso.
> * 201 para cadastro.
> * 204 para exclusão.
> * 400 para dados inválidos.
> * 404 quando a sala não existir.
> * 409 para conflitos, como código duplicado ou tentativa de reservar uma sala já reservada.
>
> Também preciso que você me ajude a testar os mesmos 10 passos que estão no enunciado da prova, respeitando a ordem e os resultados esperados.
> Quero que o código seja simples, organizado e fácil de entender, sem complicações desnecessárias. Utilize nomes claros para as classes e métodos e siga o padrão do Spring Boot.
> Não faça tudo de qualquer jeito. Confira se cada funcionalidade está funcionando antes de considerar a atividade pronta.
> Também preciso atualizar o README.md com as rotas utilizadas e os resultados reais dos testes, além de preencher o PROMPTS.md durante o desenvolvimento, registrando os prompts que realmente foram enviados e o que foi feito com cada resposta.
> Não invente testes realizados nem resultados. Se alguma coisa não funcionar, me explique o problema e me ajude a corrigir.
> Quero que você faça a atividade comigo, explicando de maneira simples o que está sendo criado e por que está sendo feito daquela forma, para que eu consiga entender e explicar o código ao professor.
> Comece analisando o projeto e depois vamos desenvolvendo e conferindo cada parte, sem pular os requisitos do enunciado.
>

**O que a IA devolveu (uma ou duas linhas):** Analisou o projeto (Spring Boot 3.5.14, Java 17, H2; avisou que o EscolaApplication.java chegou vazio). Gerou as classes Sala, SalaRepository, SalaService (com duas exceções), SalaController, TratadorDeErros, o roteiro.http e o README/PROMPTS preenchidos.

**O que fizemos com a resposta:** (x) usamos como veio  () alteramos  ( ) descartamos

**Por quê (o que conferimos, o que mudamos):** Usamos a resposta como base para fazer o projeto. Fomos conferindo as classes e se cada uma estava no pacote certo. Também verificamos se as funções estavam funcionando e se o Controller chamava a Service corretamente. Depois que terminamos o código, rodamos o projeto e usamos o Postman para fazer os testes.

Fizemos os 10 passos da prova na ordem que o professor passou e conferimos os códigos que apareciam em cada requisição.

(continuem com quantos blocos precisarem)

## Como conferimos

Como conferimos

Rodamos o projeto e fizemos os testes pelo Postman, seguindo a ordem que o professor passou.

No primeiro teste, cadastramos uma sala com o código LAB-01 e recebemos 201, como esperado.

No segundo, tentamos cadastrar outra sala com o mesmo código e recebemos 409, pois o código já estava sendo utilizado.

No terceiro, tentamos cadastrar uma sala sem nome e recebemos 400, porque o nome é obrigatório.

No quarto, reservamos a sala de ID 1 e recebemos 200.

No quinto, tentamos reservar a mesma sala novamente e recebemos 409, porque ela já estava reservada.

No sexto, tentamos excluir a sala enquanto estava reservada e recebemos 409.

No sétimo, liberamos a sala e recebemos 200.

No oitavo, tentamos liberar a sala novamente e recebemos 409, pois ela já estava livre.

No nono, excluímos a sala e recebemos 204.

No décimo, tentamos buscar a sala excluída e recebemos 404, porque ela não existia mais.

No final, os resultados bateram com o que estava previsto na prova e as operações funcionaram como esperado.

## Onde a IA errou, ou onde nós erramos
Durante os testes, percebemos que Identificamos o problema ao comparar o resultado da requisição com o status esperado na prova.

Para resolver, revisamos [classe ou arquivo envolvido] e fizemos [alteração realizada]. Depois executamos o teste novamente e verificamos se o resultado estava correto.

## Respostas finais, sem consultar a IA

Respondam com as suas palavras, nos últimos 5 minutos. Não copiem de lugar nenhum.

**Pergunta 1:**
Quando alguém pede para reservar uma sala, o Controller recebe a requisição e chama a Service. A Service verifica se a sala existe e se está livre. Depois, o Repository faz a alteração no banco de dados. O Model representa as informações da sala. No final, o Controller devolve a resposta para quem fez o pedido.

**Pergunta 2:**
Porque a Service é a parte responsável pelas regras do sistema. O Controller serve para receber os pedidos e chamar a Service. Se colocássemos as regras no Controller, o código ficaria mais desorganizado e seria mais difícil de manter.

**Pergunta 3:**
Precisaríamos mudar as configurações do banco de dados e talvez algumas dependências do projeto. Como usamos JPA, o Repository provavelmente continuaria funcionando. A Service e o Controller não precisariam mudar, porque não dependem diretamente do H2.
