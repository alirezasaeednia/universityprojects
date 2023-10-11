public class MyCircularQueue {

        int[] arr;
        int front=0,end=-1,size=0,count=0;

        public MyCircularQueue(int k) {
            arr=new int[k];
            size=k;
        }

        public boolean enQueue(int value) { //yek meghdar ezafe mikonad va agar movagah bud true

            if(isFull()) return false;

            count++;               //measure current size of array
            end=(end +1) % size;
            arr[end]=value;
            return true;
        }

        public boolean deQueue() { //yek meghdar hazf mikonad va agar movagah bud true

            if(isEmpty()) return false;

            front++;
            front=front%size;
            count--;            //measure current size of array
            return true;
        }

        public int Front() { //Gets the front item from the queue. If the queue is empty, return -1.
            return isEmpty() ? 0 : arr[front];
        }

        public int Rear() { //Gets the last item from the queue. If the queue is empty, return -1.
            return isEmpty() ? 0 : arr[end];
        }

        public boolean isEmpty() {
            return count==0;
        }

        public boolean isFull() {
            return count==size;
        }
    }



