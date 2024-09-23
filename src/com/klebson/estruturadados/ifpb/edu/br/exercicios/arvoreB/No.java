package com.klebson.estruturadados.ifpb.edu.br.exercicios.arvoreB;

public class No {
    int[] chaves;  
    int ordem;  
    No[] filhos;  
    int numChaves;  
    boolean folha;  

    
    public No(int ordem, boolean folha) {
        this.ordem = ordem;
        this.folha = folha;
        this.chaves = new int[2 * ordem - 1];  
        this.filhos = new No[2 * ordem];  
        this.numChaves = 0;
    }

    
    public void percorrer() {
        int i;
        for (i = 0; i < numChaves; i++) {
            if (!folha) {
                filhos[i].percorrer();
            }
            System.out.print(chaves[i] + " ");
        }
        if (!folha) {
            filhos[i].percorrer();
        }
    }

   
    public No buscar(int chave) {
        int i = 0;
        while (i < numChaves && chave > chaves[i]) {
            i++;
        }
        if (chaves[i] == chave) {
            return this;
        }
        if (folha) {
            return null;
        }
        return filhos[i].buscar(chave);
    }

    
    public void inserirNaoCheio(int chave) {
        int i = numChaves - 1;
        if (folha) {
            while (i >= 0 && chaves[i] > chave) {
                chaves[i + 1] = chaves[i];
                i--;
            }
            chaves[i + 1] = chave;
            numChaves++;
        } else {
            while (i >= 0 && chaves[i] > chave) {
                i--;
            }
            if (filhos[i + 1].numChaves == 2 * ordem - 1) {
                dividirFilho(i + 1, filhos[i + 1]);
                if (chaves[i + 1] < chave) {
                    i++;
                }
            }
            filhos[i + 1].inserirNaoCheio(chave);
        }
    }

    
    public void dividirFilho(int i, No y) {
        No z = new No(y.ordem, y.folha);
        z.numChaves = ordem - 1;
        for (int j = 0; j < ordem - 1; j++) {
            z.chaves[j] = y.chaves[j + ordem];
        }
        if (!y.folha) {
            for (int j = 0; j < ordem; j++) {
                z.filhos[j] = y.filhos[j + ordem];
            }
        }
        y.numChaves = ordem - 1;
        for (int j = numChaves; j >= i + 1; j--) {
            filhos[j + 1] = filhos[j];
        }
        filhos[i + 1] = z;
        for (int j = numChaves - 1; j >= i; j--) {
            chaves[j + 1] = chaves[j];
        }
        chaves[i] = y.chaves[ordem - 1];
        numChaves++;
    }

    
    public void remover(int chave) {
        int idx = buscarChave(chave);

        if (idx < numChaves && chaves[idx] == chave) {
            if (folha) {
                removerDeFolha(idx);
            } else {
                removerDeNaoFolha(idx);
            }
        } else {
            if (folha) {
                System.out.println("A chave " + chave + " não está na árvore.");
                return;
            }

            boolean ultimoFilho = (idx == numChaves);

            if (filhos[idx].numChaves < ordem) {
                preencher(idx);
            }

            if (ultimoFilho && idx > numChaves) {
                filhos[idx - 1].remover(chave);
            } else {
                filhos[idx].remover(chave);
            }
        }
    }

   
    private int buscarChave(int chave) {
        int idx = 0;
        while (idx < numChaves && chaves[idx] < chave) {
            idx++;
        }
        return idx;
    }

   
    private void removerDeFolha(int idx) {
        for (int i = idx + 1; i < numChaves; ++i) {
            chaves[i - 1] = chaves[i];
        }
        numChaves--;
    }

    
    private void removerDeNaoFolha(int idx) {
        int chave = chaves[idx];

        if (filhos[idx].numChaves >= ordem) {
            int pred = obterPredecessor(idx);
            chaves[idx] = pred;
            filhos[idx].remover(pred);
        } else if (filhos[idx + 1].numChaves >= ordem) {
            int suc = obterSucessor(idx);
            chaves[idx] = suc;
            filhos[idx + 1].remover(suc);
        } else {
            fundir(idx);
            filhos[idx].remover(chave);
        }
    }

    
    private int obterPredecessor(int idx) {
        No atual = filhos[idx];
        while (!atual.folha) {
            atual = atual.filhos[atual.numChaves];
        }
        return atual.chaves[atual.numChaves - 1];
    }

    
    private int obterSucessor(int idx) {
        No atual = filhos[idx + 1];
        while (!atual.folha) {
            atual = atual.filhos[0];
        }
        return atual.chaves[0];
    }

    
    private void preencher(int idx) {
        if (idx != 0 && filhos[idx - 1].numChaves >= ordem) {
            pegarEmprestadoAnterior(idx);
        } else if (idx != numChaves && filhos[idx + 1].numChaves >= ordem) {
            pegarEmprestadoProximo(idx);
        } else {
            if (idx != numChaves) {
                fundir(idx);
            } else {
                fundir(idx - 1);
            }
        }
    }

    
    private void pegarEmprestadoAnterior(int idx) {
        No filho = filhos[idx];
        No irmao = filhos[idx - 1];

        for (int i = filho.numChaves - 1; i >= 0; --i) {
            filho.chaves[i + 1] = filho.chaves[i];
        }

        if (!filho.folha) {
            for (int i = filho.numChaves; i >= 0; --i) {
                filho.filhos[i + 1] = filho.filhos[i];
            }
        }

        filho.chaves[0] = chaves[idx - 1];

        if (!filho.folha) {
            filho.filhos[0] = irmao.filhos[irmao.numChaves];
        }

        chaves[idx - 1] = irmao.chaves[irmao.numChaves - 1];

        filho.numChaves++;
        irmao.numChaves--;
    }

    private void pegarEmprestadoProximo(int idx) {
        No filho = filhos[idx];
        No irmao = filhos[idx + 1];

        filho.chaves[filho.numChaves] = chaves[idx];

        if (!filho.folha) {
            filho.filhos[filho.numChaves + 1] = irmao.filhos[0];
        }

        chaves[idx] = irmao.chaves[0];

        for (int i = 1; i < irmao.numChaves; ++i) {
            irmao.chaves[i - 1] = irmao.chaves[i];
        }

        if (!irmao.folha) {
            for (int i = 1; i <= irmao.numChaves; ++i) {
                irmao.filhos[i - 1] = irmao.filhos[i];
            }
        }

        filho.numChaves++;
        irmao.numChaves--;
    }

    
    private void fundir(int idx) {
        No filho = filhos[idx];
        No irmao = filhos[idx + 1];

        filho.chaves[ordem - 1] = chaves[idx];

        for (int i = 0; i < irmao.numChaves; ++i) {
            filho.chaves[i + ordem] = irmao.chaves[i];
        }

        if (!filho.folha) {
            for (int i = 0; i <= irmao.numChaves; ++i) {
                filho.filhos[i + ordem] = irmao.filhos[i];
            }
        }

        for (int i = idx + 1; i < numChaves; ++i) {
            chaves[i - 1] = chaves[i];
        }

        for (int i = idx + 2; i <= numChaves; ++i) {
            filhos[i - 1] = filhos[i];
        }

        filho.numChaves += irmao.numChaves + 1;
        numChaves--;
    }
}
