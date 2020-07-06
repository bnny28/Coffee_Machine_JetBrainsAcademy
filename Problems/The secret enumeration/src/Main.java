public class Main {

    public static void main(String[] args) {
        int counter = 0;
        Secret[] secrets = Secret.values();

        for (Secret s : secrets) {
            if (s.name().length() > 3 && "STAR".equals(s.name().substring(0, 4))) {
                counter += 1;
            }
        }

        System.out.println(counter);
    }
}

/* At least two constants start with STAR
enum Secret {
    STAR, CRASH, START, // ...
}
*/