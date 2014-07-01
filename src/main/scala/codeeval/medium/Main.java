package codeeval.medium;


/**
 * Created by abhinav on 22/6/14.
 */
public class Main {

    public interface Stack {
        int pop();
        void push(int item);
        boolean isEmpty();
    }

    private static class StackImpl implements Stack {
        private java.util.LinkedList<Integer> list = new java.util.LinkedList<>();

        @Override
        public int pop() {
            if (list.isEmpty()) throw new java.util.NoSuchElementException("cannot pop from an empty list");
            return list.removeLast();
        }

        @Override
        public void push(int item) {
            list.addLast(item);
        }

        @Override
        public boolean isEmpty() {
            return list.size() == 0;
        }
    }

    public static void main (String[] args) {
        try {
            java.io.File file = new java.io.File(args[0]);
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.FileReader(file));
            String line;
            while ((line = in.readLine()) != null) {
                String[] lineArray = line.split("\\s");
                // String[] lineArray = "10 -2 3 4".split(" ");
                if (lineArray.length > 0) {
                    StringBuilder strBuilder = new StringBuilder();
                    for (String s : lineArray) {
                        strBuilder.append(s);
                    }
                    String[] numbers = strBuilder.toString().split(" ");
                    Stack stack = new StackImpl();
                    for (String s : numbers) {
                        if (!s.trim().isEmpty()) {
                            stack.push(Integer.parseInt(s));
                        }
                    }
                    StringBuilder builder = new StringBuilder();
                    int count = 0;
                    while(!stack.isEmpty()) {
                        if (count == 0) {
                            builder.append(stack.pop() + " ");
                            count = 1;
                        } else {
                            count = 0;
                            stack.pop();
                        }
                    }
                    System.out.println(builder.toString().trim());
                }
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
