class Process{
  constructor(nome, prioridade, carga) {
      this.name = nome;
      this.prioridade = prioridade;
      this.carga = carga;
  }

  getNome(){
      return this.nome;
  }

  getPrioridade(){
      this.prioridade;
  }

  getCarga(){
      this.carga;
  }

  setNome(nome){
      this.nome = nome;
  }

  setPrioridade(prioridade){
      this.prioridade = prioridade;
  }

  setCarga(carga){
      this.carga = carga;
  }
}


function setup() {
  createCanvas(720, 400);
  background(0);
  noSmooth();
}


const process1 = new Process();
const process2 = new Process();
const process3 = new Process();

// colocar entradas depois de acessar o site (por html) - dados abaixo aleatorios

process1.setNome("Processo 1");
process2.setNome("Processo 2");
process3.setNome("Processo 3");

process1.setPrioridade(1);
process2.setPrioridade(2);
process3.setPrioridade(3);

process1.setCarga([20,100,20,100]);
process2.setCarga([2,4,-5,-1]);
process3.setCarga([5,2,1,-9]);

const listProcess = { process1, process2, process3 };

function fifo(listProcess){
  
}

function draw() {
  
  let a = process1.getCarga()[0];
  console.log(a);
  
  // line(process1.getCarga()[0], process1.getCarga()[1], process1.getCarga()[2], process1.getCarga()[3]);
}