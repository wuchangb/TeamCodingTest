package ch1.HashMap;

public class MyHash {

    public Slot[] hashTable;
    public MyHash(int size) {
        this.hashTable = new Slot[size];
    }

    public class Slot {
        String key;
        String value;
        Slot next;
        Slot(String key, String value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hashFunc(String key) {
        return (int)(key.charAt(0)) % this.hashTable.length;
    }

    public boolean saveData(String key, String value) {
        int address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            Slot preSlot = this.hashTable[address];
            while (findSlot != null) {
                if (findSlot.key == key) {
                    findSlot.value = value;
                    return true;
                } else {
                    preSlot = findSlot;
                    findSlot = findSlot.next;
                }
            }
            preSlot.next = new Slot(key, value);
        } else {
            this.hashTable[address] = new Slot(key, value);
        } return true;
    }

    public String getData(String key) {
        int address = this.hashFunc(key);
        if (this.hashTable[address] != null) {
            Slot findSlot = this.hashTable[address];
            while (findSlot != null) {
                if (findSlot.key == key) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }


    public static void main(String[] args) {
        MyHash hash = new MyHash(20);
        hash.saveData("DaveLee", "01022223333");
        hash.saveData("fun-coding", "01033334444");
        hash.saveData("David", "01044445555");
        hash.saveData("Dave", "01055556666");
        System.out.println(hash.getData("David"));
    }
}
