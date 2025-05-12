public class ProcessC {
    static String[] childNames = {"ProcessE.java"};

    public static void main(String[] args) {
        System.out.println("Proceso C");
        ChildProcess childProcess = new ChildProcess(childNames);
        childProcess.startChilds();
        childProcess.waitForChilds();
    }
}
