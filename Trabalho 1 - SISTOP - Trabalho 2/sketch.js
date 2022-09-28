class Process{
  constructor(nome, prioridade, tempo) {
    this.nome = nome;
    this.prioridade = prioridade;
    this.tempo = tempo;
  }

  getNome(){
    return this.nome;
  }

  getPrioridade(){
    return this.prioridade;
  }

  getTempo(){
    return this.tempo;
  }
}

const processos = [];
const maxProcessos = 5;

function createProcess(){
  let nome = document.getElementById("nome").value;
  let prioridade = document.getElementById("prioridade").value;
  let tempo1 = document.getElementById("tempo1").value;
  let tempo2 = document.getElementById("tempo2").value;
  let tempo3 = document.getElementById("tempo3").value;
  let tempo4 = document.getElementById("tempo4").value;
  let tempo5 = document.getElementById("tempo5").value;

  // verificar se o nome é vazio
  if(nome == ""){
    alert("Nome do processo não pode ser vazio");
    return;
  }

  if (prioridade < 1 || prioridade > 5){
    alert("Prioridade deve ser entre 1 a 5");
    return;
  }

  for (let i = 0; i < 5; i++) {
    if (tempo1 < -5 || tempo1 > 5) {
      alert("O tempo deve estar entre -5 a 5");
      return;
    }
  }

  let tempo = [tempo1, tempo2, tempo3, tempo4, tempo5];

  if(processos.length < maxProcessos){
    processos.push(new Process(nome, prioridade, tempo));
  }

  let processosDiv = document.getElementById("processos");
  processosDiv.innerHTML = "";

  for (let i = 0; i < processos.length; i++) {
    let p = processos[i];
    processosDiv.innerHTML += p.getNome() + " " + p.getPrioridade() + " " + p.getTempo() + " <button onclick='excluirProcesso(" + i + ")'>Excluir</button><br>";
  }
}

function excluirProcesso(posicao){
  processos.splice(posicao, 1);
  let processosDiv = document.getElementById("processos");
  processosDiv.innerHTML = "";

  for (let i = 0; i < processos.length; i++) {
    let p = processos[i];
    processosDiv.innerHTML += p.getNome() + " " + p.getPrioridade() + " " + p.getTempo() + " <button onclick='excluirProcesso(" + i + ")'>Excluir</button><br>";
  }
}

function temProcesso(){
  if(processos.length > 0){
    return true;
  } else {
    return false;
  }
}

function setup() {
  createCanvas(800, 400);
  background(0);
  noLoop();
}

function fifo(){
  if(temProcesso()){
    background(0);
    
    stroke(255);
    line(0, 200, 800, 200);
  } else {
    alert("Não há processos para executar");
    background(0);
  }
}

function sjf(){
  if(temProcesso()){
    background(0);


  } else {
    alert("Não há processos para executar");
    background(0);
  }
}

function prioridade(){
  if(temProcesso()){
    background(0);


  } else {    
    alert("Não há processos para executar");
    background(0);
  }
}