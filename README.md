# Paradigmas_de_programacao_POO

Trabalho elaborado no contexto da UC de Paradigmas de programação.
O paradigma abordado foi POO.
Este trabalho foi realizado em conjunto com mais um colega mas como não tinhamos bases de Git e GitHub a quando da elaboração do mesmo fiz apenas agora o upload.

O projeto tinha de seguir o seguinte enunciado:

Objetivos

Com a realização do trabalho prático, pretende-se que os alunos ponham em prática todos os conhecimentos
adquiridos na utilização do Paradigma de Programação Orientado a Objetos (POO) e a sua implementação na
linguagem de programação Java, demonstrando as suas competências em:
• Conhecer e compreender os conceitos fundamentais associada à POO;
• Conceber e implementar, para problemas concretos, soluções que tenham por base a POO.
• Reconhecer e compreender a semântica e a sintaxe da linguagem Java.
• Reutilizar, alterar e desenvolver código recorrendo à linguagem Java tendo em vista um determinado
problema com regras semânticas específicas.
Considere ainda que:
• Não é permitida a utilização de API’s/conceitos Java que não tenham sido alvo de lecionação no ano letivo
corrente na unidade curricular de Paradigmas de Programação (LEI e LSIRC). Os alunos que pretendam
utilizar API’s adicionais devem atempadamente pedir autorização a um dos docentes da unidade
curricular.
• Não é permitida a utilização de coleções Java predefinidas (Java Collections Framework).
• Os recursos de suporte ao trabalho referenciados no enunciado, são de utilização obrigatória.

Introdução

O Challenge Based Learning (CBL) é uma abordagem de ensino que tem como objetivo fornecer aos alunos a
oportunidade de resolver problemas do mundo real de uma maneira prática e colaborativa. Através do CBL, os
alunos são incentivados a trabalhar em equipa, identificar problemas e procurar soluções criativas.
Uma das principais características do CBL é o papel do facilitador. O facilitador é o responsável por guiar e apoiar
os alunos durante todo o processo de aprendizagem, desde a identificação do problema até a implementação da
solução. O facilitador é um mentor que incentiva os alunos a desenvolver habilidades como pensamento crítico,
resolução de problemas e comunicação.

Além do facilitador, o CBL também envolve a colaboração com parceiros externos. Os parceiros podem ser
empresas, organizações sem fins lucrativos, instituições de ensino superior, entre outros. Os parceiros fornecem
aos alunos informações e recursos valiosos para ajudá-los a entender e resolver o problema em estudo.
O CBL também enfatiza a importância do trabalho em equipa. Os alunos são organizados em equipas para
trabalhar em projetos específicos. Cada equipa é composta por alunos com diferentes habilidades e
conhecimentos, o que ajuda a promover a diversidade e a criatividade.

A cada edição do CBL, vários projetos são lançados. Cada projeto é uma sequência de tarefas que devem ser
submetidas pelos alunos. As tarefas são projetadas para ajudar os alunos a desenvolver habilidades específicas,
como a pesquisa, a análise de dados e a prototipagem. Ao final do projeto, os alunos devem apresentar sua
solução para o problema que identificaram.

Descrição técnica

A API a desenvolver deverá ser capaz de suportar a gestão de edições de CBL (Edition), nomeadamente os seus
projetos (Project), as tarefas associadas (Task) e a submissão de trabalhos (Submission) nas tarefas. Deve ainda
suportar a gestão de participantes (Participant), sejam facilitadores (Facilitator), parceiros (Partner) ou estudantes
(Student).

Como suporte ao desenvolvimento da API, são disponibilizados um conjunto de recursos (ER_Resources.zip), de
utilização obrigatória e que definem os contratos e definem o ponto de partida para o desenvolvimento da API. Os
conteúdos fornecidos são um complemento ao presente enunciado, contendo informação adicional e específica
sobre as particularidades de implementação.

Deverá realizar a implementação do código necessário para suportar cada uma das operações definidas nos
contratos. A existência dos contratos não deve ser impeditiva para a implementação de novos contratos,
funcionalidades e/ou novos métodos ou classes. A utilização dos contratos constitui um ponto de partida, cujos
ficheiros não podem ser alterados. Caso não utilize os recursos disponibilizados, todo o trabalho é invalidado.
A criação dos projetos é realizada através de templates nas edições. O template representa um ficheiro JSON com
a informação necessária para criar os projetos e as suas taregas. O seguinte excerto apresenta um exemplo da
forma como a informação se encontra:

{
 "number_of_facilitors": 2,
 "number_of_students": 4,
 "number_of_partners": 16,
 "tasks": [
 {
 "title": "Long list of Stakeholder ",
 "description": "The team's initial goal is to identify up to 15 stakeholder/user groups
relevant to the project topic.",
 "start_at": 0,
 "duration": 14
 },
 {
 "title": "Short list of target groups",
 "description": "Your team should discuss and select four target groups from the long
list of previously identified stakeholder/user groups.",
 "start_at": 0,
 "duration": 14
 },
 (...)
 
O ficheiro contém:
• Número de facilitadores (number_of_facilitors)
• Número de estudantes (number_of_students)
• Número de parceiros (number_of_partners)

Tarefas (tasks), composta por título (title), descrição (description), dia de início a partir da data de início da Edição
(start_at) e a duração em dias (duration)
Para além dos contratos disponibilizados, deve ainda implementar o(s) contrato(s) para suportar os seguintes
comportamentos:

• Deverá ser possível gerir (adicionar, remover e obter) edições de CBL, assim como definir qual a edição
ativa. Apenas deverá existir uma edição atualmente ativa.
• Deverá ser possível adicionar projetos à edição ativa ou a edições inativas.
• Devolver:
o As edições que possuem projetos com submissões em falta em tarefas.
o Os projetos com submissões em falta de uma edição e da edição ativa.
o O número de projetos de uma dada edição.
o O número de edições de CBL existentes;
o Uma representação textual do progresso de um projeto de uma edição (considerando as
submissões realizadas até ao momento);
o Uma representação textual do progresso de uma edição (considerando as submissões realizadas
até ao momento).
• Adicionar submissões a projetos de uma edição ativa apenas por estudantes pertencentes aos projetos
respetivos.

• Cada grupo deve ainda propor e implementar, no mínimo, 3 listagens/relatórios distintas. Estas
listagens/relatórios devem ser relevantes para o domínio. O principal objetivo é avaliar a compreensão do
problema bem como a capacidade do grupo de analisar os dados armazenados. Estas listagens devem ser
claramente identificadas no menu do programa desenvolvido.

• A API deverá suportar a atribuição de notas referentes à autoavaliação e heteroavaliação dos estudantes
associados ao mesmo projeto. Com base nas notas atribuídas deverá ser possível gerar a avaliação final
do estudante tendo por base a média aritmética de todas as notas. Esta funcionalidade é obrigatória
para a avaliação do trabalho.

• Deverá ser possível associar a cada CBL exportadores específicos (CSV, JSON, etc) de todos os dados
geridos pela CBL, devendo existir uma forma de executar todos os exportadores definidos
automaticamente ou individualmente. No desenvolvimento do Menu de suporte à API deverá existir uma
forma de executar os exportadores definidos. Esta funcionalidade é obrigatória para a avaliação do
trabalho.

Deve ainda criar um programa utilizando a API desenvolvida, considerando que a criação do projeto (e informação
associada) deverá ser suportada pela utilização de um template (ficheiro .JSON fornecido).
Teste o mais exaustivamente possível o código que desenvolveu como resposta aos requisitos apresentados.
Recorra a comentários JavaDoc e não só de modo a documentar, o mais exaustivamente possível, o código que
desenvolveu.

Elaboração do trabalho

Este trabalho é realizado em grupo que deverá ser composto por, no máximo, 2 alunos da unidade curricular.
