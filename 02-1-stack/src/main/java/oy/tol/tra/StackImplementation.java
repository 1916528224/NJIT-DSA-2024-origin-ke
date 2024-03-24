package oy.tol.tra;

/**
 * An implementation of the StackInterface.
 * <p>
 * TODO: Students, implement this so that the tests pass.
 * 
 * Note that you need to implement construtor(s) for your concrete
 * StackImplementation, which
 * allocates the internal Object array for the Stack:
 * - a default constructor, calling the StackImplementation(int size) with value
 * of 10.
 * - StackImplementation(int size), which allocates an array of Object's with
 * size.
 * -- remember to maintain the capacity and/or currentIndex when the stack is
 * manipulated.
 */
public class StackImplementation<E> implements StackInterface<E> {

   private Object[] itemArray;
   private int capacity;
   private int currentIndex = -1;
   private static final int DEFAULT_STACK_SIZE = 10;

   /**
    * Allocates a stack with a default capacity.
    * 
    * @throws StackAllocationException
    */
   public StackImplementation() throws StackAllocationException {
      this.itemArray = new Object[DEFAULT_STACK_SIZE];
      this.capacity = DEFAULT_STACK_SIZE;
      this.currentIndex = -1;
      System.out.println("Default constructor called.");
   }

   /**
    * TODO: Implement so that
    * - if the size is less than 2, throw StackAllocationException
    * - if the allocation of the array throws with Java exception,
    * throw StackAllocationException.
    * 
    * @param capacity The capacity of the stack.
    * @throws StackAllocationException If cannot allocate room for the internal
    *                                  array.
    */
   public StackImplementation(int capacity) throws StackAllocationException {
      this.capacity = capacity;
   }

   @Override
   public int capacity() {
      return this.capacity;
   }

   @Override
   public void push(E element) throws StackAllocationException, NullPointerException {
      if (element == null) {
         throw new NullPointerException("Element cannot be null");
      }
      if (this.capacity() < 2) {
         throw new StackAllocationException("Stack capacity is less than 2");
      } else {
         try {
            if (this.itemArray == null) {
               this.itemArray = new Object[capacity];
            }
            if (this.currentIndex + 1 == this.itemArray.length) {
               Object[] dest = new Object[this.capacity() + DEFAULT_STACK_SIZE];
               System.arraycopy(this.itemArray, 0, dest, 0, this.itemArray.length);
               this.itemArray = dest;
               this.capacity += DEFAULT_STACK_SIZE;
            }
            this.itemArray[++this.currentIndex] = element;
         } catch (ArrayIndexOutOfBoundsException e) {
            throw new StackAllocationException("Stack capacity is not enough");
         }
      }
   }

   @SuppressWarnings("unchecked")
   @Override
   public E pop() throws StackIsEmptyException {
      if (this.currentIndex == -1) {
         throw new StackIsEmptyException("Stack is empty");
      } else {
         return (E) this.itemArray[this.currentIndex--];
      }
   }

   @SuppressWarnings("unchecked")
   @Override
   public E peek() throws StackIsEmptyException {
      if (this.currentIndex == -1) {
         throw new StackIsEmptyException("Stack is empty");
      } else {
         return (E) this.itemArray[this.currentIndex];
      }
   }

   @Override
   public int size() {
      return this.currentIndex + 1;
   }

   @Override
   public void clear() {
      this.currentIndex = -1;
   }

   @Override
   public boolean isEmpty() {
      return this.currentIndex == -1;
   }

   @Override
   public String toString() {
      StringBuilder builder = new StringBuilder("[");
      for (var index = 0; index <= currentIndex; index++) {
         builder.append(itemArray[index].toString());
         if (index < currentIndex) {
            builder.append(", ");
         }
      }
      builder.append("]");
      return builder.toString();
   }
}
