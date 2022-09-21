class Process{
    #nome;
    #prioridade;
    #carga;

    constructor(nome, prioridade, carga) {
        this.#name = nome;
        this.#prioridade = prioridade;
        this.#carga = carga;
    }

    getNome(){
        return this.#nome;
    }

    getPrioridade(){
        this.#prioridade;
    }

    getCarga(){
        this.#carga;
    }

    setNome(nome){
        this.#nome = nome;
    }
}