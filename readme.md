# Coding Assignment: Queue + Stack Using a Queue (Java)

## Your tasks
1. Implement `ArrayQueue<E>` (circular array queue).
2. Implement `StackUsingQueue<E>` where stack operations are built using ONE queue.

## Rules
- `first()` and `dequeue()` return `null` when empty.
- `top()` and `pop()` return `null` when empty.
- `enqueue()` throws `IllegalStateException` if the queue is full (fixed capacity).
- `push()` throws `IllegalStateException` if the underlying queue is full.

## How to run tests locally
```bash
mvn test
