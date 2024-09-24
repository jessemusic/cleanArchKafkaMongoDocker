# Sistema clean architeture

## Introdução:

Este é um modelo de software para o uso do MongoDB para treino em persistência e consumo de banco não relacional.


Projeto Docker, kafka e mongoDB

###############################################
##### Pipeline Gitlab-CI - v1.0           #####
##### MATTEC PROJETOS  - 08/03/2024       #####
##### JESSE PROJETO                       #####
###############################################


**Pipeline de CI/CD**

stages:
  - teste
  - build
  - deploy

executar_teste:
  stage: teste
  before_script:
    - echo "Preparando testes..."
    - chmod +x ./script.sh
  script:
    - ./script.sh
  after_script:
    - echo "Apagando arquivos temporários..."

executar_teste2:
  image: node:19.1
  needs:
    - executar_teste
  stage: teste
  script:
    - echo "Executando mais um teste..."
    - npm version

criar_imagens:
  stage: build
  script:
    - echo "Criando as imagens..."

push_imagens:
  needs:
    - criar_imagens
  stage: build
  script:
    - echo "Realizando upload das imagens..."

kubernetes:
  stage: deploy
  script:
    - echo "Executando deploy..."
Localmente
Clonar o repositório Git.
Construir o projeto:
bash
