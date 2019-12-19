package e05;

public class HT
{
    public static void main(String[] args)
    {
        HashTable table = new HashTable(7);
        Data data;

        data = new Data(7);
        table.insert(data);
        table.dumpTable();

        data = new Data(14);
        table.insert(data);
        table.dumpTable();

        table.delete(21);
        table.dumpTable();

        data = new Data(28);
        table.insert(data);
        table.dumpTable();

        table.isMember(28);
        table.dumpTable();

        data = new Data(49);
        table.insert(data);
        table.dumpTable();
    }
}
class HashTable
{
    //ein geloeschtes Feldelement wird mit dem Wert Integer.MIN-VALUE gekennzeichnet
    final int emptyValue = Integer.MIN_VALUE;
    Data emptyData;

    Data[] dataArray;
    int[] visitCounter;
    int arraySize;

    public HashTable(int size)
    {
        arraySize = size;
        dataArray = new Data[arraySize];
        emptyData = new Data(emptyValue);
        visitCounter = new int[arraySize];
    }

    public int hash(int key)
    {
        return key % arraySize;
    }


    public int quadhash(int startHash, int i)
    {
        int j = 1;
        int m = 4*j +3;
        if(startHash%2 != 0){
            return (startHash + (int)Math.pow(i,2))%m;
        }else{
            int returnValue = (startHash - (int)Math.pow(i,2))%m;
            if(returnValue < 0){
                returnValue = returnValue+arraySize;
            }
            return returnValue;
        }

        // quadratisches Sondieren mit alternierendem Vorzeichen:
        // hi(x) = (h(x) + i2) mod m f�r ungerades i, dh. 1,3,5,..
        // hi(x) = (h(x) - i2) mod m f�r gerades i, dh. 2,4,6,..
        // Wichtig: negative Werte m�ssen auf Feldindizes abgebildet werden!
        // um alle Feldindizes zu erreichen, muss m = 4*j +3 mit m ist Primzahl gewaehlt werden
        // und es muss z.B. gelten, dass negative Hash-Werte auf pos. Werte abgebildet werden
        // hier: arraysize = 7, neg. Wert = -2 --> Abbildung auf Wert 5

        // ...
    }

    public void insert(Data data)
    {
        int key = data.dataValue;
        int hashValue = hash(key);
        int startHash = hashValue;
        int i = 0;

        while(true){
            if(dataArray[hashValue] == null){
                dataArray[hashValue] = data;
                break;
            }else{
                visitCounter[hashValue]++;
                if(dataArray[hashValue].dataValue == emptyValue){
                    dataArray[hashValue] = data;
                    break;
                }
            }
            hashValue = quadhash(startHash,++i);
        }

    }


    public boolean isMember (int key)
    {
        int hashValue = hash(key);
        int startHash = hashValue;
        int hashCounter = 0;


        while ((dataArray[hashValue] != null) && (hashCounter < arraySize))
        {
            visitCounter[hashValue]++;
            if (dataArray[hashValue].dataValue == key)
            {
                System.out.println("Key " + key + " ist an Position " +  hashValue + " enthalten.\n");
                return true;
            }
            hashCounter++;
            hashValue = quadhash(startHash, hashCounter);
        }
        System.out.println("Key " + key + " ist nicht enthalten.\n");

        if (dataArray[hashValue] == null)
        {
            visitCounter[hashValue]++;
        }
        return false;
    }

    public void delete(int key) // warum Data
    {
        int hashValue = hash(key);
        int hashCounter = 0;
        int i = 0;


        while(dataArray[hashValue] != null && hashCounter < arraySize){

            visitCounter[hashValue]++;
            if(dataArray[hashValue].dataValue == key){
                dataArray[hashValue].dataValue = emptyValue;
                return;
            }else{
                hashValue = quadhash(hashValue,++i);
                hashCounter++;
            }
        }
        System.out.println("Key "+key+" nicht enthalten.\n");
    }


    public void dumpTable()
    {
        int value;
        for (int i = 0; i < arraySize; i++)
        {
            if (dataArray[i] != null)
            {
                value = dataArray[i].dataValue;
                if (value == emptyValue)
                {
                    // geloeschtes Feld wird durch 'D' (Deleted) dargestellt
                    System.out.print("D" + ":" + visitCounter[i] +  " ");
                }
                else
                {
                    System.out.print(value + ":" + visitCounter[i] + " ");
                }
            }
            else
            {
                System.out.print("--" + ":" + visitCounter[i] + " ");
            }
        }
        System.out.println( "\n");
    }

  //Ende Klasse HashTable
}

class Data
{
    public int dataValue;

    public Data(int data)
    {
        dataValue = data;
    }
}