package hashtables;
import java.util.ArrayList;

// The node of chains
class SimpleHashTableImp<K, V>
{
    K key;
    V value;

    // Reference to next node
    SimpleHashTableImp<K, V> next;

    // Constructor
    public SimpleHashTableImp(K key, V value)
    {
        this.key = key;
        this.value = value;
    }
}

// This is a class to represent entire hash table
class SimpleHashTable<K, V>
{
    // a bucketArray is used to store array of chains
    private ArrayList<SimpleHashTableImp<K, V>> bucketArray;

    // The current capacity of our arraylist
    private int numBuckets;

    // The current size of our arraylist
    private int size;

    // Simple constructor (Initializes capacity, size and
    // some empty chains.
    public SimpleHashTable()
    {
        bucketArray = new ArrayList<>();
        numBuckets = 10;
        size = 0;

        // Create empty chains
        for (int i = 0; i < numBuckets; i++)
            bucketArray.add(null);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size() == 0; }

    // This implements hash function to find index
    // for a key
    private int getBucketIndex(K key)
    {
        int hashCode = key.hashCode();
        int index = hashCode % numBuckets;
        return index;
    }

    // Method to remove a given key
    public V remove(K key)
    {
        // Apply hash function to find index for given key
        int bucketIndex = getBucketIndex(key);

        // Get head of chain
        SimpleHashTableImp<K, V> head = bucketArray.get(bucketIndex);

        // Search for key in its chain
        SimpleHashTableImp<K, V> prev = null;
        while (head != null)
        {
            // If Key found
            if (head.key.equals(key))
                break;

            // Else keep moving in chain
            prev = head;
            head = head.next;
        }

        // If key was not there
        if (head == null)
            return null;

        // Reduce size
        size--;

        // Remove key
        if (prev != null)
            prev.next = head.next;
        else
            bucketArray.set(bucketIndex, head.next);

        return head.value;
    }

    // Returns value for a key
    public V get(K key)
    {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        SimpleHashTableImp<K, V> head = bucketArray.get(bucketIndex);

        // Search key in chain
        while (head != null)
        {
            if (head.key.equals(key))
                return head.value;
            head = head.next;
        }

        // If key not found
        return null;
    }

    // Adds a key value pair to hash
    public void add(K key, V value)
    {
        // Find head of chain for given key
        int bucketIndex = getBucketIndex(key);
        SimpleHashTableImp<K, V> head = bucketArray.get(bucketIndex);

        // Check if key is already present
        while (head != null)
        {
            if (head.key.equals(key))
            {
                head.value = value;
                return;
            }
            head = head.next;
        }

        // Insert key in chain
        size++;
        head = bucketArray.get(bucketIndex);
        SimpleHashTableImp<K, V> newNode = new SimpleHashTableImp<K, V>(key, value);
        newNode.next = head;
        bucketArray.set(bucketIndex, newNode);

        // If load factor goes beyond threshold, then
        // double hash table size
        if ((1.0*size)/numBuckets >= 0.7)
        {
            ArrayList<SimpleHashTableImp<K, V>> temp = bucketArray;
            bucketArray = new ArrayList<>();
            numBuckets = 2 * numBuckets;
            size = 0;
            for (int i = 0; i < numBuckets; i++)
                bucketArray.add(null);

            for (SimpleHashTableImp<K, V> headNode : temp)
            {
                while (headNode != null)
                {
                    add(headNode.key, headNode.value);
                    headNode = headNode.next;
                }
            }
        }
    }

    // Driver method to test Map class
    public static void main(String[] args)
    {
        SimpleHashTable<String, Integer> simpleHashTable = new SimpleHashTable<>();
        simpleHashTable.add("this",1 );
        simpleHashTable.add("coder",2 );
        simpleHashTable.add("this",4 );
        simpleHashTable.add("hi",5 );
        System.out.println(simpleHashTable.size());
        System.out.println(simpleHashTable.remove("this"));
        System.out.println(simpleHashTable.remove("this"));
        System.out.println(simpleHashTable.size());
        System.out.println(simpleHashTable.isEmpty());
    }
}

