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

function validation(nome, prioridade, tempos){
  if(nome == ""){
    alert("Nome do processo não pode ser vazio");
    return false;
  }

  if (prioridade < 1 || prioridade > 5){
    alert("Prioridade deve ser entre 1 a 5");
    return false;
  }

  for (let i = 0; i < tempos.length; i++) {
    if(tempos[i] == "" || tempos[i] == null){
      alert("Tempo "+ (i + 1) +" não pode ser vazia");
      return false;
    }
  }

  return true;
}

function createProcess(){
  let nome = document.getElementById("nome").value;
  let prioridade = document.getElementById("prioridade").value;
  let tempos = [];
  tempos[0] = document.getElementById("tempo1").value;
  tempos[1] = document.getElementById("tempo2").value;
  tempos[2] = document.getElementById("tempo3").value;
  tempos[3] = document.getElementById("tempo4").value;
  tempos[4] = document.getElementById("tempo5").value;

  if(validation(nome, prioridade, tempos)){
    if(processos.length < maxProcessos){ 
      processos.push(new Process(nome, prioridade, tempos));
    }
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

    let tempo = 0;

    for (let i = 0; i < processos.length; i++) {
      let p = processos[i];
      for (let j = 0; j < p.getTempo().length; j++) {
        if(p.getTempo()[j] < 0){
          tempo += p.getTempo()[j] * -1;
        } else {
          tempo += p.getTempo()[j];
        }
      }
    }

    stroke(255);
    line(100, 50, 100, 350);
    line(75, 325, 700, 325);
    
    

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