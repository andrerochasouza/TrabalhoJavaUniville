class Process{
  constructor(nome, prioridade, tempo) {
      this.name = nome;
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

  let tempo = [tempo1, tempo2, tempo3, tempo4, tempo5];

  if(processos.length < maxProcessos){
      processos.push(new Process(nome, prioridade, tempo));
  }

  console.log(processos);
}


function setup() {
  createCanvas(720, 400);
  background(0);
  noLoop();
}

function fifo(){

}

function sjf(){

}

function prioridade(){

}

function draw() {
  
}

function mousePressed() {
  redraw();
}