# GoF Structural Patterns Hub

Este projeto demonstra os 7 padrões de projeto estruturais da Gang of Four (GoF), implementados em Java 17 com Maven. Cada padrão está isolado em seu pacote, com classes focadas em uma responsabilidade clara, mantendo uma arquitetura simples e didática para estudo e referência.

## Objetivo

O objetivo deste repositório é apresentar, de forma prática e organizada, como cada padrão estrutural resolve um problema específico de composição, adaptação, extensão e acesso a objetos.

Os padrões abordados são:

- Adapter
- Bridge
- Decorator
- Composite
- Facade
- Flyweight
- Proxy

---

## Estrutura do projeto

```text
gof-structural-hub
├── pom.xml
├── README.md
└── src
    └── main
        └── java
            └── com
                └── gof
                    └── structural
                        ├── adapter
                        │   ├── AdvancedMediaPlayer.java
                        │   ├── AudioPlayer.java
                        │   ├── MediaAdapter.java
                        │   ├── MediaPlayer.java
                        │   ├── Mp4Player.java
                        │   └── VlcPlayer.java
                        ├── bridge
                        │   ├── AdvancedRemote.java
                        │   ├── Device.java
                        │   ├── Radio.java
                        │   ├── RemoteControl.java
                        │   └── Tv.java
                        ├── composite
                        │   ├── CompositeGraphic.java
                        │   ├── Graphic.java
                        │   └── Shape.java
                        ├── decorator
                        │   ├── Coffee.java
                        │   ├── CoffeeDecorator.java
                        │   ├── MilkDecorator.java
                        │   ├── SimpleCoffee.java
                        │   └── SugarDecorator.java
                        ├── facade
                        │   ├── InventoryService.java
                        │   ├── NotificationService.java
                        │   ├── OrderFacade.java
                        │   ├── PaymentService.java
                        │   └── ShippingService.java
                        ├── flyweight
                        │   ├── Forest.java
                        │   ├── Tree.java
                        │   ├── TreeType.java
                        │   └── TreeTypeFactory.java
                        ├── proxy
                        │   ├── Image.java
                        │   ├── ProxyImage.java
                        │   └── RealImage.java
                        └── structuralhub
                            └── Main.java
```

---

## Como executar

No terminal, na raiz do projeto:

```bash
mvn clean package
java -cp target/classes com.gof.structuralhub.Main
```

O programa executa uma demonstração prática de cada padrão no console.

---

## 1) Adapter

### Conceito
O padrão Adapter permite que duas interfaces incompatíveis trabalhem juntas. Ele atua como um adaptador entre uma interface pública esperada e uma implementação existente que não a atende diretamente.

### Problema resolvido
Quando você precisa reutilizar uma classe legada ou uma biblioteca externa, mas a assinatura dela não combina com o restante do sistema.

### Quando usar
- Integração com APIs externas
- Reuso de código legado
- Compatibilização entre serviços com interfaces diferentes

### Exemplo neste projeto
A classe `AudioPlayer` expõe uma interface simples de reprodução (`MediaPlayer`). Quando o cliente solicita `vlc` ou `mp4`, ela usa `MediaAdapter` para adaptar a interface de `AdvancedMediaPlayer` para o uso esperado pelo cliente.

### Vantagens
- Reuso de classes existentes
- Redução de acoplamento
- Introduz compatibilidade sem alterar o código antigo

### Principio de design
Este padrão reduz a incompatibilidade estrutural entre abstrações e implementações, evitando que o código cliente conheça detalhes de implementação específicos.

---

## 2) Bridge

### Conceito
O padrão Bridge separa a abstração da implementação, permitindo que ambas evoluam independentemente.

### Problema resolvido
Quando há uma hierarquia de abstrações e uma hierarquia de implementações que crescem separadamente, o acoplamento pode se tornar complexo e difícil de manter.

### Quando usar
- Sistemas com múltiplas plataformas ou dispositivos
- Quando abstração e implementação devem variar independentemente
- Quando você deseja evitar heranças profundas e rígidas

### Exemplo neste projeto
`RemoteControl` representa a abstração e `Device` representa a implementação. O controle remoto funciona com qualquer dispositivo, como `Tv` e `Radio`, sem acoplar a lógica de controle às classes concretas.

### Vantagens
- Evita explosão de subclasses
- Flexibiliza extensão
- Promove composição em vez de herança excessiva

### Principio de design
O padrão reduz o acoplamento entre interfaces conceituais e detalhes concretos, respeitando o princípio de que abstrações e detalhes devem evoluir separadamente.

---

## 3) Decorator

### Conceito
O padrão Decorator adiciona comportamento ou responsabilidades a um objeto dinamicamente, sem alterar sua estrutura original.

### Problema resolvido
Quando você precisa estender uma classe sem gerar subclasses em cascata ou modificar o código fonte da classe base.

### Quando usar
- Adicionar responsabilidades em tempo de execução
- Combinar recursos de forma incremental
- Evitar herança excessiva

### Exemplo neste projeto
`SimpleCoffee` representa o objeto base. `MilkDecorator` e `SugarDecorator` envolvem a bebida adicionando custo e descrição. A lógica é incremental e transparente para o cliente.

### Vantagens
- Extensão dinâmica
- Sem necessidade de alterar classes existentes
- Permite composição de comportamentos

### Principio de design
O padrão segue a ideia de composição sobre herança, permitindo que novas responsabilidades sejam adicionadas sem quebrar o comportamento original.

---

## 4) Composite

### Conceito
O padrão Composite trata objetos individuais e composições de objetos de forma uniforme.

### Problema resolvido
Quando uma estrutura hierárquica precisa ser manipulada como se todos os elementos fossem do mesmo tipo, desde folhas até grupos completos.

### Quando usar
- Áreas gráficas
- Estruturas de arquivos e pastas
- Organizações hierárquicas complexas

### Exemplo neste projeto
`Shape` representa um elemento folha; `CompositeGraphic` representa um grupo que contém vários gráficos. Ambos implementam a interface `Graphic`, permitindo que o sistema trate todos eles da mesma forma.

### Vantagens
- Simplicidade na manipulação da árvore
- Facilita a recorrência em estruturas hierárquicas
- Uniformiza operações em folhas e grupos

### Principio de design
Este padrão reduz a necessidade de distinguir entre componentes simples e compostos, promovendo uma interface única para o cliente.

---

## 5) Facade

### Conceito
O padrão Facade fornece uma interface simplificada para um subsistema complexo.

### Problema resolvido
Sub-sistemas grandes ou dependentes frequentemente exigem múltiplos passos, classes e configurações. O cliente não deve conhecer todos esses detalhes.

### Quando usar
- Integração de módulos complexos
- Exposição de APIs simples para uso geral
- Redução de acoplamento entre cliente e subsistema

### Exemplo neste projeto
`OrderFacade` encapsula a lógica de:
- verificação de estoque
- cobrança
- reserva de itens
- agendamento de entrega
- envio de notificação

O cliente só precisa chamar `placeOrder(...)`.

### Vantagens
- Interface mais amigável
- Menos dependências no código cliente
- Isolamento do sistema interno

### Principio de design
O padrão ajuda a separar responsabilidades, reduzir o acoplamento e ocultar a complexidade do subsistema por trás de uma API clara.

---

## 6) Flyweight

### Conceito
O padrão Flyweight usa compartilhamento para suportar grande quantidade de objetos granulares com pouca memória.

### Problema resolvido
Quando muitos objetos possuem estados repetidos e o custo de armazenamento e criação se torna alto.

### Quando usar
- Grandes volumes de instâncias similares
- Aplicações gráficas e jogos
- Representações repetitivas em memória

### Exemplo neste projeto
`TreeType` guarda a parte intrínseca da árvore (nome, cor e textura), enquanto a posição `x` e `y` permanece no objeto `Tree`. A fábrica `TreeTypeFactory` reutiliza tipos compartilhados entre milhares de árvores.

### Vantagens
- Redução de uso de memória
- Reuso de estado comum
- Melhor performance em cenários massivos

### Principio de design
O padrão separa estado intrínseco e extrínseco. O estado intrínseco é compartilhado e o estado extrínseco é passado quando necessário.

---

## 7) Proxy

### Conceito
O padrão Proxy fornece um substituto ou representante de outro objeto, controlando o acesso a ele.

### Problema resolvido
Quando você precisa controlar acesso, lazy loading, autenticação, logging, cache ou proteção ao objeto real.

### Quando usar
- Carregamento lento de recursos pesados
- Controles de acesso
- Acesso remoto ou virtualizado

### Exemplo neste projeto
`ProxyImage` verifica se `RealImage` já foi criado antes. Quando necessário, ele instancia o objeto real e delega a chamada de `display()`. Isso permite carregar a imagem sob demanda e evitar custo desnecessário.

### Vantagens
- Controle sobre acesso ao objeto real
- Carregamento sob demanda
- Transparência para o cliente

### Principio de design
O padrão encapsula o acesso ao objeto real, adicionando uma camada de controle sem alterar o contrato da interface pública.

---

## SOLID e padrões estruturais

Embora cada padrão tenha um foco específico, todos eles se alinham bem com os princípios SOLID:

- SRP (Single Responsibility Principle): cada classe tem uma responsabilidade bem definida
- OCP (Open/Closed Principle): padrões como Decorator e Bridge permitem extensão sem alterar código existente
- LSP (Liskov Substitution Principle): interfaces e hierarquias são polimórficas e substituíveis
- ISP (Interface Segregation Principle): interfaces pequenas e específicas
- DIP (Dependency Inversion Principle): abstrações são dependidas em vez de implementações concretas

---

## Observações de implementação

- Os pacotes foram organizados por padrão.
- As classes seguem nomes claros e sem ambiguidades.
- A solução foi desenhada para fins didáticos, sem exagerar em complexidade.
- O projeto é compatível com Java 17 e Maven.

---

## Conclusão

Os padrões estruturais resolvem problemas ligados à organização da estrutura de classes e objetos. Eles são especialmente úteis quando o sistema precisa crescer sem perder clareza, flexibilidade e manutenibilidade.

Este repositório foi montado para servir como estudo prático de:

- composição e reutilização,
- extensão dinâmica,
- separação de responsabilidades,
- controle de acesso,
- simplificação de interfaces,
- redução de custos de memória e processamento.

---

## Autor

Projeto construído como referência prática para estudo de padrões estruturais em Java.
