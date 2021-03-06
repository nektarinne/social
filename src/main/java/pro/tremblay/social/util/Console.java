package pro.tremblay.social.util;

import java.nio.charset.Charset;
import java.util.Scanner;

public final class Console {

    private final Scanner scanner;

    public Console() {
        scanner = new Scanner(System.in);
    }

    public String readline() {
        return scanner.nextLine();
    }

    public void write(String output) {
        System.out.println(output);
    }
}
