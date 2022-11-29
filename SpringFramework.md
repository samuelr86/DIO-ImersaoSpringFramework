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

<h1>Aula 2 - Projeto Springboot</h1>

<h2>Conhecendo o Spring Boot</h2>
<p>Enquanto o Spring Framework é baseado no padrão de injeção de dependências, o Springboot foca na produtividade e configuração automática.</p>
<p>Antes do SpringBoot tinhamos desafios com a configuração do projeto: Dependência individual, Verbosidade, Incompatibilidade de versões, Complexidade de gestão, Configurações complexas e repetitivas.</p>
<p>Dado que a maior parte das configurações necessárias para o inicio do projeto são mesmas, por que não iniciar um projeto com todas estas configurações ja definidas?</p>
<p>Essas configurações são definidas através dos Starters: que são descritores de dependências.</p>
<p>O uso desses startes traz alguns benefícios:
<li>Coesão</li>
<li>Versões compatíveis</li>
<li>Otimização do tempo</li>
<li>Configuração simples</li>
<li>Foco no negócio</li>
</p>
<p>Starters mais utilizados: Spring-boot-starter-*
<li>data-jpa: integração ao bando de dados via JPA - Hibernate</li>
<li>data-mongodb: integração com banco de dados MongoDB</li>
<li>web: inclusão do container Tomcat para aplicações REST</li>
<li>web-services: webservices baseados na arquitetura SOAP</li>
<li>batch: implementação de JOBs de processos</li>
<li>test: disponibilização de recursos para testes unitários como JUnit</li>
<li>openfeign: é Client HTTP baseado em interfaces</li>
<li>actuator: gerenciamento de monitoramento da aplicação</li>
</p>

<h2>Primeiros Passos</h2>

<h3>Criar um projeto com initializr</h3>
<p>Acessar start.spring.io e preencher as caracteristicas do projeto:
<li>Project: Maven</li>
<li>Language: Java</li>
<li>Springboot: 3.0.0 (não snapshot)</li>
<li>GroupId(organização): dio</li>
<li>Artifact: primeiros-passos</li>
<li>Name: primeiros-passos </li>
<li>Description: Primeiros passos com Spring Boot</li>
<li>Package name(pacote raiz): dio.springboot</li>
<li>Encapotamento: Tipo JAR</li>
<li>Versão Java: Java17</li>
<li>
	Dependências:
	<li>são caracteristica que serão adicionadas na aplicação</li>
</li>

Após clicar em generate.</p>
<h3>Importando o projeto Maven</h3>
<p>Vai ser baixado no computador uma pasta zipada com o projeto gerado, extrair o conteúdo para a pasta do seu projeto e pronto: um projeto estruturado com Maven e Springboot estará disponivel para trabalhar.</p>

<h3>Conhecendo a estrutura Springboot</h3>

<p>Inicialmente as pastas mais importante dentro do projeto seram a <em>src</em> que contém o container do projeto Springboot, além da pasta <em>test</em> que já possui estrutura para a realização de suas implementações baseadas em TDD, se for de preferências. Temos também um arquivo chamado <em>pom.xml</em> que contém informações do projeto para distribuição inclusão de dependências e outras configurações importantes para o gerenciamento do projeto.</p>
<p>Outro arquivo importante é o <em>application.properties</em> em que todas as configuraçoes e propriedades estarão centralizadas nesse arquivo, sejam interações do banco de dados, portas de servidor (se for trabalhar com web), configuração da aplicação como e-mail da aplicação, configuração de dados de acesso FTP entre outros </p>

<h3>Bean e CommandLineRunner</h3>
<p>Vamos criar uma classe chamada <em>Calculadora.java</em> que terá um unico método somar...

```java
public class Calculadora{
	public int somar(int numero1, int numero2){
		return numero1 + numero2;
	}
}
```

...mas não podemos chamar esse objeto dentro da classe principal da aplicação, pois não estão disponíveis dentro do contexto SpringBoot...

```java
@SpringBootApplication
public class PrimeirosPassosApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeirosPassosApplication.class, args);
	}

}
```

...conforme as convenções de inversão de controle e injeção de dependência. A partir de agora não vamos mais estar realizando o <b>new</b> de nosso objetos e isso será um aspecto de configuração de Beans e Comandos de Inicialização da nossa aplicação. Existem algumas maneiras de realizar essa iteração, uma delas é através do <em>CommandLineRunner</em>, que é um comando disponível pelo SpringBoot através de uma interface para inicializar a aplicação e realizar um comando com os objetos que agora serão disponibilizados pelo container.</p>

<p>Primeiro vamos criar uma classe "MyApp.java" e quero que ela tenha uma ação muito semelhante ao método Main(), para isso implementa a interface "CommandLineRunner" e sobrescreve o método da interface("run").</p>

```java
public class MyApp implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception{

	}
}
```
<p>Depois vamos determinar os objetos que seram os Beans da aplicação e fazemos uma annotation '@Component' para identificar que as classes serão componentes da aplicação... </p>

```java
@Component
public class MyApp implements CommandLineRunner{}
```

```java
@Component
public class Calculadora{}
```
<p>... como precisamos instanciar a calculadora dentro do MyApp fazemos a injeção do componente Calculadora...</p>

```java
public class MyApp implements CommandLineRunner{

	private Calculadora calculadora;

	@Override
	public void run(String... args) throws Exception{

	}
}
```

<p>... e dentro do método run executamos o método somar de Calculadora...</p>

```java

	@Override
	public void run(String... args) throws Exception{
		System.out.println("O Resultado é "+ calculadora.somar(2, 7));	
	}
```
<p>Mas para executar sem erros precisamos instanciar a calculadora sem usar o new, e para isso usamos a annotation '@Autowired'...

```java
@Component
public class MyApp implements CommandLineRunner{

	@Autowired
	private Calculadora calculadora;

	@Override
	public void run(String... args) throws Exception{
		System.out.println("O Resultado é " + calculadora.somar(2, 7));
	}
}
```
... mostrando o resultado no terminal embutido na IDE...

```bash
PS C:\bootcamp_ifood\SpringFramework\DIO-ImersaoSpringFramework>  & 'C:\Users\samue\.vscode\extensions\redhat.java-1.12.0-win32-x64\jre\17.0.4.1-win32-x86_64\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '@C:\Users\samue\AppData\Local\Temp\cp_940c1p221etjjp2plcaa8c776.argfile' 'dio.edu.springboot.PrimeirosPassosApplication' 

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v3.0.0)

2022-11-26T18:33:39.500-03:00  INFO 14396 --- [           main] d.e.s.PrimeirosPassosApplication         : Starting PrimeirosPassosApplication using Java 17.0.4.1 with PID 14396 (C:\bootcamp_ifood\SpringFramework\DIO-ImersaoSpringFramework\primeiros-passos\target\classes started by samue in C:\bootcamp_ifood\SpringFramework\DIO-ImersaoSpringFramework)
2022-11-26T18:33:39.505-03:00  INFO 14396 --- [           main] d.e.s.PrimeirosPassosApplication         : No active profile set, falling back to 1 default profile: "default"
2022-11-26T18:33:40.313-03:00  INFO 14396 --- [           main] d.e.s.PrimeirosPassosApplication         : Started PrimeirosPassosApplication in 1.424 seconds (process running for 2.065)
O resultado é 9
```
</p>


<h2>Beans vs Components</h2>

<li>Quando usar @Bean?</li>
<li>Quando usar @Component?</li>

<p><b>Component</b>: quando tenho acesso ao código fonte. quando digo que ele é um componente posso injetá-lo em qualquer ecossitema de um container do Springboot.</p>
<p><b>Bean</b>: quando é um arquivo de uma biblioteca externa não temos acesso ao código fonte mas eu quer inicializar a construção de um Bean através da estrutura dessa implementação, então anotamos com um '@Bean'.</p>
<p>Caso necessite criar um Bean de um arquivo que não temos acesso ao código podemos declará-lo de duas formas:
<li>1ªforma: declarar dentro da classe principal do springboot

```java
public class SpringPrimeirosPassosApplication{
	public static void public static void main(String[] args) {
		SpringApplication.run(SpringPrimeirosPassosApplication.class, args);

		@Bean
		public Gson gson(){
			return new Gson();
		}
	}
}
```
</li>
<li>2ªforma: se for necessário a criação de vários Beans então convem criar uma classe Beans ou BeanFactory e colocá-los dentro dessa classe. Atenção pois em algumas versões do Spring pede que essa classe seja anotada com a annotation '@Configuration':

```java
@Configuration
public class BeanFactory{
	@Bean
	public Gson gson(){
		return new Gson();
	}
}
```

</li>
</p>

<h2>Scopes - Singleton ou Prototype</h2>

<h3>Quantos irei precisar?</h3>

<p>Singleton: um unico objeto sendo utilizado a cada necessidade da minha aplicação.</p>


```java
@Configuration
public class Beans{
	@Bean
	public Remetente remetente(){
		System.out.println("CRIANDO UM OBJETO REMETENTE");
	}
}
```
<p>Prototype: a cada necessidade terei uma instancia correspondente a essa necessidade. Fazemos a alteração colocando a annotation "Scope". Dessa for a cada iteração cria um objeto Remetente novo.</p>


```java
@Configuration

public class Beans{
	@Bean
	@Scope("prototype")
	public Remetente remetente(){
		System.out.println("CRIANDO UM OBJETO REMETENTE");
	}
}
```

<h2>Properties Values</h2>

<p>Tenho esse sistema de mensagens que envia mensagens de aprovação de cadastro.

```java
@Component
public class SistemaMensagem implements CommandLineRunner{
	private String nome;
	private String email;
	private List<Long> telefones;

	@Override
	public void run(String... args) throws Exception{
		System.out.println("Mensagem enviada por: " + nome );
		System.out.println("Seu cadastro foi aprovado");
	}
}

```

Podemos colocar essa informações dentro do "application.properties". 

```json
nome=Jose da Silva
email=joseSilva@xpto.com
telefones=1165439846,1165489462
```

E como obter essas informações de forma interativa? Simplesmente sobre cada atributo colocamos a annotation "@Value" acompanhada de uma "expression language"...


```java
@Component
public class SistemaMensagem implements CommandLineRunner{
	@Value("${nome}")
	private String nome;
	@Value("${email}")
	private String email;
	@Value("${telefones}")
	private List<Long> telefones;

	@Override
	public void run(String... args) throws Exception{
		System.out.println("Mensagem enviada por: " + nome + email + telefones);
		System.out.println("Seu cadastro foi aprovado");
	}
}

```
... e aí ele busca no application.properties os valores a serem exibidos.


Caso necessite de um valor padrão ou caso o spring não ache o valor declarado no properties, podemos declará-lo diretamente no EL.

```java
@Value("${nome:João da Silva}")
	private String nome;
```

</p>

<h2>Configuration Properties</h2>

<h3>@ConfigurationProperties(prefix)</h3>
<p>A proposta é que tenho um Bean de configuração que todos os seus valores vem do application.properties. 

```json
remetente.nome=Jose da Silva
remetente.email=joseSilva@xpto.com
remetente.telefones=1165439846,1165489462
```

Quando tiver a necessidade que alguns atributos estiverem associados a um contexto, ao invés de explicitar através do @Value, porque nao centralizar essa configuração em um outro Bean? Crio uma classe Remetente(com a annotation @Configuration, pois é uma classe de configuração) e transfiro os atributos de SistemaMensagem para esta classe...

```java
@Configuration
public class Remetente{

	private String nome;
	private String email;
	private List<Long> telefones;

	// getters and setters
}
```

... e declaro o remetente dentro do SistemaMensagem

```java
@Component
public class SistemaMensagem implements CommandLineRunner{
	
	@Autowired
	private Remetente remetente;

	@Override
	public void run(String... args) throws Exception{
		System.out.println("Mensagem enviada por: " + nome + email + telefones);
		System.out.println("Seu cadastro foi aprovado");
	}
}

```

... para que anoto Remetente também como "@ConfigurationProperties" e como parâmetro buscar os dados que tem como prefixo "remetente".
```java
@Configuration]
@ConfigurationProperties(prefix = "remetente")
public class Remetente{

	private String nome;
	private String email;
	private List<Long> telefones;

	// getters and setters 
}
```

</p>

<h2>Conceito ORM e JPA</h2>
<h2>Spring Data JPA</h2>
<h2>Conexão com Postgres</h2>
<h2>JPA Repository</h2>
