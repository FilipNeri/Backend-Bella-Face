Backend em Kotlin com Java 17
Este é um projeto de backend em Kotlin usando Spring Boot, com suporte para Java 17. Siga as instruções abaixo para instalar e configurar o ambiente de desenvolvimento.

Pré-requisitos
Antes de começar, certifique-se de ter instalado em sua máquina:

Java Development Kit (JDK) 17
Maven (gerenciador de dependências)
Um ambiente de desenvolvimento integrado (IDE) como IntelliJ IDEA ou Eclipse****

Instalação
Clone o repositório para sua máquina local:

- git clone https://github.com/seuusuario/backend.git
- cd backend
- mvn clean install
- mvn spring-boot:run

Configurações de bancos

caminho: src/main/resources/application.yml
criar banco com as configurações acima:
- Mysql
- Nome do banco wmw

dados iniciais:

INSERT INTO wmw.product
(id, created, description, name, price)
VALUES(1, NULL, 'shampoo', 'Pantene', 10.0);

INSERT INTO wmw.product
(id, created, description, name, price)
VALUES(2, NULL, 'creme facial', 'Boticario', 15.0);

INSERT INTO wmw.product
(id, created, description, name, price)
VALUES(3, NULL, 'anti caspa', 'Clear', 11.5);

INSERT INTO wmw.customer
(id, login, name, password)
VALUES(1, 'filipe', 'Filipe Neri', '12345');
