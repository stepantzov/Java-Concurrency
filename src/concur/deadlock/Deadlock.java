package concur.deadlock;

import static java.lang.System.out;

/**
 * Example of a class that often will lead to deadlock adapted from the <em>
 * Java Tutorials</em> "Concurrency" section on "DeadlockOld":
 * http://docs.oracle.com/javase/tutorial/essential/concurrency/deadlock.html.
 */
public class Deadlock {
    static class Friend {
        /**
         * Friend's name.
         */
        private final String name;

        /**
         * Parameterized constructor accepting name for Friend instance.
         *
         * @param newName Name of new Friend instance.
         */
        public Friend(final String newName) {
            this.name = newName;
        }

        /**
         * Provide this instance's name.
         *
         * @return Friend's name.
         */
        public String getName() {
            return this.name;
        }

        /**
         * Bow from friend. Synchronized for thread-safe access.
         *
         * @param bower Friend that is bowing.
         */
        public synchronized void bow(final Friend bower) {
            out.format("%s: %s has bowed to me!%n",
                    this.name, bower.getName());
            bower.bowBack(this);
        }

        /**
         * Bow back to friend who bowed to me. Synchronized for thread-safe access.
         *
         * @param bower Friend who has bowed back to me.
         */
        public synchronized void bowBack(final Friend bower) {
            out.format("%s: %s  has bowed back to me!%n",
                    this.name, bower.getName());
        }
    }

    /**
     * Simple executable function that demonstrates deadlock when two friends
     * are waiting on each other to bow to finish bowing.
     *
     * @param arguments Command-line arguments: none expected.
     */
    public static void main(final String[] arguments) {
        final Friend alphonse = new Friend("Alphonse");
        final Friend gaston = new Friend("Gaston");
        new Thread(new Runnable() {
            public void run() {
                alphonse.bow(gaston);
            }
        }, "Gaston Bowing").start();
        new Thread(new Runnable() {
            public void run() {
                gaston.bow(alphonse);
            }
        }, "Alphonse Bowing").start();
    }
}