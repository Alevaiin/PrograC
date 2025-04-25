public class ProcessA {

    static String[] childNames = {"ProcessB.java"};

    public static void main(String[] args) {
        System.out.println("Proceso A");
        ChildProcess childProcess = new ChildProcess(childNames);
        childProcess.startChilds();
        childProcess.waitForChilds();
    }
}