export class Process{
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