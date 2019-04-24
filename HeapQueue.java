package exercise4_3_heapqueue;

public class HeapQueue<E> implements IPriorityQueue<E> {

    private Entry<E> data[];
    private int endOfHeap = 0;

// constructor
    public HeapQueue(int maxSize) {
        data = new Entry[maxSize];
    }

    @Override
    public void insert(Entry<E> e) {
        if(this.isFull())
            throw new ArrayIndexOutOfBoundsException("Queue is full! (" + this.endOfHeap +")");
        
        // insert at bottom of the tree
        data[this.endOfHeap] = e;

        bubbleUp();

        // increment heap
        this.endOfHeap++;
    }

    @Override
    public Entry<E> extractMin() {
// if queue is empty
        if(this.isEmpty())
            throw new ArrayIndexOutOfBoundsException("Queue is empty!");
        
        // root element has highest priority
        Entry<E> min = this.data[0];

        // swap last using helper function 
        swap(0, endOfHeap-1);

        // decrement 
        this.endOfHeap--;

        this.siftDown();

        return min;
    }

    @Override
    public boolean isEmpty() {	
        return this.endOfHeap == 0;
    }

    @Override
    public boolean isFull() {	
        return this.endOfHeap == this.data.length;
    }

// helping functions 
// sift down

    private void siftDown() {
        int i = 0;

        // at least one child
        while (i <= (this.endOfHeap / 2) - 1) {
            int left = i * 2 + 1;
            int right = left + 1;

            // left is highest priority 
            int min = left;
            
            // if right child exists, check if higher priority 
            if(right < this.endOfHeap){
                if(this.data[right].getPriority() < this.data[left].getPriority()){
                    min = right;
                }
            }
            
            // swap if current node has higher priority 
            if(this.data[i].getPriority() > this.data[min].getPriority()){
                swap(i, min);
            }
            
            // inspect next sub-tree
            i = min;
        }
    }

// swap

    private void swap(int i1, int i2) {
        Entry<E> tmp = this.data[i1];
        this.data[i1] = this.data[i2];
        this.data[i2] = tmp;
    }

// bubble up elements with higher priority to the top 

    private void bubbleUp() {
        int i = this.endOfHeap;
        int parent = i / 2;

        // while element at i is not root and its parent has lower priority 
        while (i > 0 && this.data[parent].getPriority() > this.data[i].getPriority()) {
            
            swap(i, parent);

            
            i = parent;

         
            parent = i / 2;
        }
    }
}
