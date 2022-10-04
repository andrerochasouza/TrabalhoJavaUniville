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

const processos = [];
const maxProcessos = 5;

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
    } else {
      alert("Número máximo de processos é 5");
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

    stroke(255);
    //    X1  Y1   X2   Y2
    line(100, 50, 100, 350);
    stroke(155);
    line(75, 325, 700, 325);
    
    
    let posicaoX = [];
    let posicaoY = [];

    let qtdProcessos = processos.length;
    
    // Pegando o tempo total dos processos
    let qtdTempoTotal = 0;
    for (let i = 0; i < qtdProcessos; i++) {
      for (let j = 0; j < processos[i].getTempo().length; j++) {
        qtdTempoTotal += parseInt(processos[i].getTempo()[j]);
      }
    }

    // Pegando as posições dos processos
    let positionY = 275 / qtdProcessos;
    for(let i = 0; i < qtdProcessos; i++){
      let letterWidth = textWidth(processos[i].getNome());

      let p = processos[i];

      fill(255);
      //                           X                       Y
      text(p.getNome(), 95 - letterWidth, 60 + (positionY * i));
      posicaoY[i] = 60 + (positionY * i);
    }

    // Pegando as posições dos tempos
    let positionX = 600 / qtdTempoTotal;
    for(let i = 0; i < qtdTempoTotal; i++){
      let letterWidth = textWidth(i + 1);

      fill(255);
      //                X                     Y
      text(i + 1, 100 + (positionX * (i+1)), 350);
      posicaoX[i] = 100 + (positionX * (i+1));
    }

    // Desenhando os blocos quando o processo anterior termina
    let posicaoTempoProcessoAnterior = 0;
    for(let i = 0; i < qtdProcessos; i++){
      let p = processos[i];
      for(let j = 0; j < p.getTempo().length; j++){
        let tempo = p.getTempo()[j];
        fill(255);
        rect(posicaoX[i] - positionX, posicaoY[i] - 10, positionX * (j + 1), posicaoY[i] + posicaoY[i]);
      }
      
      posicaoTempoProcessoAnterior += p.getTempo()
    }


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