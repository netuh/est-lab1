import java.util.Arrays;

public class ListaArray implements EstruturaDeDados{
    private int[] array;
    private int contador;

    public ListaArray() {
        array = new int[1000];
        contador = 0;
    }

    @Override
    public boolean insert(int chave) {
        if (contador < this.array.length) {
            this.array[contador] = chave;
            contador += 1;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean delete(int chave) {
        boolean findNumber = false;

        for (int i=0; i<this.array.length; i++) {
            if (!findNumber) {
                if (this.array[i] == chave) {
                    findNumber = true;

                    this.array[i] = 0;
                    contador -= 1;
                }
            } else {
                int aux = this.array[i];
                this.array[i-1] = aux;
            }
        }
        if (findNumber) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean search(int chave) {
        for (int i=0; i<this.array.length; i++) {
            if (this.array[i] == chave) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int minimum() {
        int minimo = this.array[0];

        for (int i=0; i<this.array.length; i++) {
            if (this.array[i] < minimo) {
                minimo = this.array[i];
            }
        }
        
        return minimo;
    }

    @Override
    public int maximum() {
        int maximo = this.array[0];

        for (int i=0; i<this.array.length; i++) {
            if (this.array[i] > maximo) {
                maximo = this.array[i];
            }
        }
        
        return maximo;
    }

    @Override
    public int sucessor(int chave) {
        for (int i=0; i<this.array.length; i++) {
            if (this.array[i] == chave) {
                return this.array[i] + 1;
            }
        }
        return -1;
    }

    @Override
    public int prodessor(int chave) {
        for (int i=0; i<this.array.length; i++) {
            if (this.array[i] == chave) {
                return this.array[i] - 1;
            }
        }
        return -1;
    }

    public String getArray() {
        return Arrays.toString(this.array);
    }

    public static void main(String[] args) {
        ListaArray r = new ListaArray();
        r.insert(5);
        r.insert(10);
        r.insert(15);
        r.insert(20);
        r.insert(30);
        r.insert(50);
        r.insert(100);
        r.insert(-9);
        System.out.println(r.getArray());
        System.out.println(r.search(15));
        r.delete(5);
        System.out.println(r.getArray());
        r.delete(20);
        System.out.println(r.getArray());
        System.out.println(r.maximum());
        System.out.println(r.minimum());
        System.out.println(r.sucessor(10));
        System.out.println(r.prodessor(30));
    }
}
