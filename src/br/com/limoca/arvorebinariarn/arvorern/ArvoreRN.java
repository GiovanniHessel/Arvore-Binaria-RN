package br.com.limoca.arvorebinariarn.arvorern;

import br.com.limoca.fila.fila.Fila;

public class ArvoreRN<tipo> {
    private No raiz, nulo;
    int size;

    public ArvoreRN() {
        nulo = new No();
        nulo.cor = Cor.preto;
        raiz = nulo;
        size = 0;
    }
    public void insere(int dado) {
        No ant, p, novo;
        ant = nulo;
        p = raiz;

        while (p != nulo) {
            ant = p;
            if (dado < p.dado) {
                p = p.esq;
            } else {
                p = p.dir;
            }
        }
        novo = new No(dado);
        novo.pai = ant;
        novo.esq = nulo;
        novo.dir = nulo;
        novo.cor = Cor.vermelho;

        if (ant == nulo) {
            raiz = novo;
        } else {
            if (dado < ant.dado) {
                ant.esq = novo;
 
            } else {
                ant.dir = novo;
            }
        }
        restaurarPropriedadeRN(novo);
        size++;
    }
    public void insere(int dado, tipo objeto) {
        No ant, p, novo;
        ant = nulo;
        p = raiz;

        while (p != nulo) {
            ant = p;
            if (dado < p.dado) {
                p = p.esq;
            } else {
                p = p.dir;
            }
        }
        novo = new No(dado, objeto);
        novo.pai = ant;
        novo.esq = nulo;
        novo.dir = nulo;
        novo.cor = Cor.vermelho;

        if (ant == nulo) {
            raiz = novo;
        } else {
            if (dado < ant.dado) {
                ant.esq = novo;
 
            } else {
                ant.dir = novo;
            }
        }
        restaurarPropriedadeRN(novo);
        size++;
    }
    public void remove(int dado) {
        No x = buscar(raiz, dado);
        if (x == nulo) {
            throw new RuntimeException("Dado não existe na arvore, não foi possivel deletar");
            //return false;
        } else if (x == raiz) {
            removeRaiz();
            //return true;
        } else {
            No y;
            if (x.dir == nulo && x.esq == nulo) {
                if (x.pai.dir == x) {
                    x.pai.dir = nulo;
                    x.pai = nulo;
                    //return true;
                } else {
                    x.pai.esq = nulo;
                    x.pai = nulo;
                    //return true;
                }
            } else if (x.dir == nulo && x.esq != nulo) {
                if (x == x.pai.dir) {
                    x.pai.dir = x.esq;
                    x.esq.pai = x.pai;
                    y = x.pai;
                    x.esq = nulo;
                    x.pai = nulo;
                    this.restaurarPropriedadeRN(y);
                } else if (x == x.pai.esq) {
                    x.pai.esq = x.esq;
                    x.esq.pai = x.pai;
                    y = x.pai;
                    x.esq = nulo;
                    x.pai = nulo;
                    this.restaurarPropriedadeRN(y);
                }
                //return true;
            } else if (x.dir != nulo && x.esq == nulo) {
                if (x == x.pai.dir) {
                    x.pai.dir = x.dir;
                    x.dir.pai = x.pai;
                    y = x.pai;
                    x.dir = nulo;
                    x.pai = nulo;
                    this.restaurarPropriedadeRN(y);
                } else if (x == x.pai.esq) {
                    x.pai.esq = x.dir;
                    x.dir.pai = x.pai;
                    y = x.pai;
                    x.dir = nulo;
                    x.pai = nulo;
                    this.restaurarPropriedadeRN(y);
                }
                //return true;
            } else {
                if (x == x.pai.dir) {
                    x.pai.dir = x.dir;
                    x.dir.pai = x.pai;
                    x.dir.esq = x.esq;
                    x.esq.pai = x.dir;
                    y = x.pai;
                    x.dir = nulo;
                    x.esq = nulo;
                    x.pai = nulo;
                    this.restaurarPropriedadeRN(y);
                } else if (x == x.pai.esq) {
                    x.pai.esq = x.esq;
                    x.esq.pai = x.pai;
                    x.esq.dir = x.dir;
                    x.dir.pai = x.esq;
                    y = x.pai;
                    x.dir = nulo;
                    x.esq = nulo;
                    x.pai = nulo;
                    this.restaurarPropriedadeRN(y);
                }
                //return true;
            }
        }
    }
    public int getRaiz() {
        if (raiz == nulo)
            throw new RuntimeException("Arvore Vazia, Não existe Raiz");
        else
            return this.raiz.dado;
    }
    public int getDado(int dado) {
        No x = buscar(raiz, dado);
        if (x == nulo) {
            throw new RuntimeException("Dado não encontrado");
        } else {
            return x.dado;
        }
    }
    public tipo getObjeto(int dado) {
        No x = buscar(raiz, dado);
        if (x == nulo) {
            throw new RuntimeException("Dado não encontrado");
        } else {
            return (tipo) x.objeto;
        }
    }
    public int size() {
        return size;
    }
    public boolean buscar(int dado) {
        No x = buscar(raiz, dado);
        return x == nulo;
    }
    public void emNivel() {
        Fila fila = new Fila();
        emNivel(raiz, fila);
        System.out.println();
    }
    public void emOrdem() {
        emOrdem(raiz);
        System.out.println();
    }
    public void preOrdem() {
        preOrdem(raiz);
        System.out.println();
    }
    public void posOrdem() {
        posOrdem(raiz);
        System.out.println();
    }
    
    private void removeRaiz() {
        No p = nulo;
        if (raiz.esq != nulo) {
            p = raiz.esq;
            while (p.dir != nulo) {
                p = p.dir;
            }
            if (raiz.esq != p) {
                p.esq = raiz.esq;
            }
            p.pai.dir = nulo;
            p.dir = raiz.dir;
            p.pai = raiz.pai;
            p.cor = raiz.cor;

        } else if (raiz.dir != nulo) {
            p = raiz.dir;
            while (p.esq != nulo) {
                p = p.esq;
            }
            p.pai.esq = nulo;
            p.esq = raiz.esq;
            p.dir = raiz.dir;
            p.pai = raiz.pai;
            p.cor = raiz.cor;

        }
        raiz = p;
    }
    private No buscar(No no, int dado) {
        if (no == nulo) {
            return nulo;
        } else {
            if (dado == no.dado) {
                return no;
            } else if (dado < no.dado) {
                return buscar(no.esq, dado);
            } else {                          //if (dado > no.dado)
                return buscar(no.dir, dado);
            }
        }
    }
    private void emNivel(No no, Fila fila){
        if (no != nulo){
            System.out.print(no.dado + " ");
            if (no.esq != nulo ){
                fila.entrar(no.esq);
            }
            if (no.dir != nulo){
                fila.entrar(no.dir);
            }
            if (fila.tamanho() != 0)
                emNivel((No) fila.sair(), fila);
            
        }
    }
    private void emOrdem(No no) {
        if (no != null) {
            emOrdem(no.esq);
            if (no != nulo) {
                System.out.print(no.dado + " ");
            }
            emOrdem(no.dir);
        }

    }
    private void preOrdem(No no) {
        if (no != null) {
            if (no != nulo) {
                System.out.print(no.dado + " ");
            }
            emOrdem(no.esq);
            emOrdem(no.dir);
        }
    }
    private void posOrdem(No no) {
        if (no != null) {
            emOrdem(no.esq);
            emOrdem(no.dir);
            if (no != nulo) {
                System.out.print(no.dado + " ");
            }
        }

    }
    private void restaurarPropriedadeRN(No x) {
        No y;

        while (x.pai.cor == Cor.vermelho) {
            if (x.pai == x.pai.pai.esq) {
                y = x.pai.pai.dir; //Tio
                if (y.cor == Cor.vermelho) {
                    x.pai.cor = Cor.preto;
                    y.cor = Cor.preto;
                    x.pai.pai.cor = Cor.vermelho;
                    x = x.pai.pai;
                } else {
                    if (x == x.pai.dir) {
                        x = x.pai;
                        rotacaoEsq(x);
                    }
                    x.pai.cor = Cor.preto;
                    x.pai.pai.cor = Cor.vermelho;
                    rotacaoDir(x.pai.pai);
                }
            } else if (x.pai == x.pai.pai.dir) {
                y = x.pai.pai.esq; //Tio
                if (y.cor == Cor.vermelho) {
                    x.pai.cor = Cor.preto;
                    y.cor = Cor.preto;
                    x.pai.pai.cor = Cor.vermelho;
                    x = x.pai.pai;
                } else {
                    if (x == x.pai.esq) {
                        x = x.pai;
                        rotacaoDir(x);
                    }
                    x.pai.cor = Cor.preto;
                    x.pai.pai.cor = Cor.vermelho;
                    rotacaoEsq(x.pai.pai);
                }
            }
        }
        raiz.cor = Cor.preto;

    }
    private void rotacaoEsq(No x) {
        No y = x.dir;
        x.dir = y.esq;
        if (y.esq != nulo) {
            y.esq.pai = x;
        }
        y.pai = x.pai;

        if (x.pai == nulo) {
            raiz = y;
        } else {
            if (x == x.pai.esq) {
                x.pai.esq = y;
            } else {
                x.pai.dir = y;
            }
        }
        y.esq = x;
        x.pai = y;
    }
    private void rotacaoDir(No x) {
        No y = x.esq;
        x.esq = y.dir;
        if (y.dir != nulo) {
            y.dir.pai = x;
        }
        y.pai = x.pai;

        if (x.pai == nulo) {
            raiz = y;
        } else {
            if (x == x.pai.dir) {
                x.pai.dir = y;
            } else {
                x.pai.esq = y;
            }
        }
        y.dir = x;
        x.pai = y;
    }
}
