<h1>Aula 1 - Fundamentos</h1>
<p>É um framework open source desenvolvido para a plataforma Java baseado nos padrões de projeto, inversão de controle e injeção de dependência.</p>
<p>Sua estrutura é composta por módulos afins de reduzir a complexidade no desenvolvimento de aplicações simples ou corporativa.
</p>

<h2>Inversão de Controle</h2>
<p>ou IoC trata-se do redirecionamento do fluxo de execução de um código retirando parcialmente o controle sobre ele e delegando-o para um container.</p>
<p>O principal propósito é minimizar o aclopamento do código.</p>

<p>Antes do IoC precisavamos criar o objeto para utiliza-lo, após a criação do IoC o container é configurado e todos os objetos que precisam existir previamente já estao no container e quando a aplicação necessitar ela faz a requisição ao container as respectivas instancias.</p>

<h2>Injeção de Dependências</h2>
<p>É um padrão de desenvolvimento com a finalidade de manter baixo o nível de aclopamento entre módulos de um sistema.</p>
<p>Deixa a necessidade de ter a implementação, tenho a interface, tenho um tipo correspondente e atraves do tipo, que foi carregado pelo meu container, eu consigo injetar uma especificação para as minhas interfaces. O conceito de injeção é nos prover a nossas referencias sem tornar-lo definitivamente tão explicito.</p>
<p>A aplicação ao ser inicializada carrega o container que contém o objeto real e mediante ao uso de boas práticas os objetos que contem as caracteristicas seram injetados atraves do recuros de injeção de dependência que é provida pelo container.</p>

<h2>Beans</h2>
<p>Objeto que é instanciado, montado e gerenciado por um container através do princípio da inversão de controle.</p>

<h2>Escopos</h2>
<p>Temos 5 tipos de escopos que daremos mais ênfase:
<br><b>Singleton</b> ter um unico objeto compartilhado por toda a aplicação quando for solicitado. 
<br><b>Prototype</b>: criado uma nova instancia a cada requisição de um objeto ao container.
<br><b>HTTP</b>: sao escopos de 
<li>Request: cria um bean será criado para cada requisição HTTP</li>
<li>Session: cria um bean será criado para a sessão de usuário</li>
<li>Global: cria um bean para o ciclo de vida do contexto da aplicação</li>
</p>

<h2>AutoWired</h2>
<p>Uma anotação onde deverá ocorrer uma injeção automática de dependência.</p>
<li>byName: é buscado um método set que corresponde ao nome do Bean.</li>
<li>byType: é considerado o tipo da classe para inclusão do Bean.</li>
<li>byConstructor: usamos o construtor para incluir a dependência.</li>

