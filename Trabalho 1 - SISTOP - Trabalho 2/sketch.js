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
    } else if(tempos[i] < -5 || tempos[i] > 5 || tempos[i] == 0){
      alert("Tempo "+ (i + 1) +" deve ser entre -5 a 5 ou diferente de 0");
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

function bloco(tempos, x, y, w, h){
  for (let i = 0; i < tempos.length; i++) {
    if(tempos[i] > 0){
      fill(0, 255, 0);
    } else if(tempos[i] < 0){
      fill(255, 0, 0);
    } else {
      fill(255);
    }
    rect(x, y, w*abs(tempos[i]), h);
    x += w*abs(tempos[i]);
  }
}

function fifo(){
  if(temProcesso()){

    background(0);
    stroke(255);
    line(100, 50, 100, 350);
    stroke(155);
    line(75, 325, 700, 325);

    fill(0, 255, 0);
    rect(10, 350, 20, 20);
    fill(255, 0, 0);
    rect(10, 375, 20, 20);
    fill(255);
    text("Tempo positivo", 35, 365);
    text("Tempo negativo", 35, 390);
  

    let qtdProcessos = processos.length;
    let qtdTempoTotal = 0;

    for (let i = 0; i < processos.length; i++) {
      let p = processos[i];
      let tempos = p.getTempo();
      for (let j = 0; j < tempos.length; j++) {
        qtdTempoTotal += abs(parseInt(tempos[j]));
      }
    }

    let tamX = (600 / qtdTempoTotal);
    let tamY = (275 / qtdProcessos);
    let posicoesX = [];
    let posicoesY = [];
    
    for(let i = 0; i <= qtdTempoTotal; i++){
      posicoesX.push(100 + (tamX * (i + 1)));
    }
    
    for(let i = 0; i < qtdProcessos; i++){
      posicoesY.push(50 + (tamY * i));
    }

    for (let i = 0; i < processos.length; i++) {
      let p = processos[i];
      let nome = p.getNome();
      let letterWidth = textWidth(nome);
      fill(255);
      text(nome, 90 - letterWidth, posicoesY[i] + 10);
    }

    for (let i = 0; i < qtdTempoTotal; i++) {
      fill(255);
      text(i + 1, posicoesX[i], 350);
    }
    
    let somaTempo = 0;
    for (let i = 0; i < processos.length; i++) {
      let p = processos[i];
      let tempos = p.getTempo();
      if(i == 0){
        bloco(tempos, posicoesX[0] - tamX, posicoesY[i], tamX, tamY);
        for (let j = 0; j < tempos.length; j++) {
          somaTempo += abs(parseInt(tempos[j]));
        }
      } else {
        bloco(tempos, posicoesX[somaTempo] - tamX, posicoesY[i], tamX, tamY);
        for (let j = 0; j < tempos.length; j++) {
          somaTempo += abs(parseInt(tempos[j]));
        }
      }
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